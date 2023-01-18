/* 
 * Authors: Brian Burton, Matthew Hunsaker, Kashish Singh
 * Project: Project T.A.N.K
 * The main function and a few helper functions for the final project
 */

#include <stdio.h>
#include <stdlib.h>
#include "main.h"
#include "stm32f0xx.h"

/* STM board pin legend:
 * PC6 == right side forward && red LED 
 * PC7 == right side reverse && blue LED
 * PC8 == left side forward && orange LED
 * PC9 == left side reverse && green LED
 * 
 * Turn right == PC6 && PC9
 * Turn left  == PC7 && PC8
 */

/*
 * Global Variables
 */
// Timer and Distance variables -----------------------------------------------------------
// This variable will be used to keep track of how long the vehicle has been travelling
// in a single direction.
volatile uint8_t distance_timer = 0;
// This variable keeps track of which direction the vehicle is currently travelling. 
// 0 == forward 1 == reverse.
volatile uint8_t direction = 0;
// This variable is used in the calculation of when to change direction. Whatever value
// it is set to is the time in seconds when the motor will change the direction it is 
// turning the wheels. 
volatile uint8_t distance_change_time = 3;

// Start Button Variables -----------------------------------------------------------------
// This variable is used to sync the two STM boards by not starting the bulk of the code 
// until the button is pressed. 0 == stop 1 == start 
volatile uint8_t start_stop = 0;
volatile uint32_t debouncer;

/*
 * Miscellaneous Core Functions and Helper Functions
 */
void SystemClock_Config(void);

/*
 * This function will configure and enable TIM2 to count at a frequency at 4Hz.
 * This means that the TIM2 interrupt will trigger every 0.25 seconds. If a 
 * variable, the distance_counter in this case, is iterated every time the 
 * iterrupt occurs then when the variable equals 240 a minute has passed.
 */
void TIM2_init(void) {
	// Enable the TIM2 peripheral in RCC
	RCC->APB1ENR |= RCC_APB1ENR_TIM2EN;
	// Configure TIM2 to 4Hz
	// Reset the ARR and PSC
	TIM2->ARR = 0xFFFFFFFF;
	TIM2->PSC = 0x0000;
	// 4Hz = 4000 = 0xFA0
	TIM2->ARR = 0xFA0;
	// 4Hz = 499 = 0x1F3
	TIM2->PSC = 0x1F3;
	// Reset the counter
	TIM2->CNT = 0x00000000;
	// Enable thd update interrupt, UIE, in the DIER register
	TIM2->DIER |= (1 << 0);
	// Enable the handler with NVIC
	NVIC_EnableIRQ(TIM2_IRQn);
	//NVIC_SetPriority(TIM2_IRQn,1);
	TIM2->CR1 |= (1 << 0);
}

/*
 * This function will configure and enable TIM3 to count at a frequency at 4Hz.
 */
void TIM3_init(void) {
	// Enable the TIM2 peripheral in RCC
	RCC->APB1ENR |= RCC_APB1ENR_TIM3EN;
	// Configure TIM2 to 4Hz
	// Reset the ARR and PSC
	TIM3->ARR = 0xFFFFFFFF;
	TIM3->PSC = 0x0000;
	// 4Hz = 4000 = 0xFA0
	TIM3->ARR = 0x32;
	// 4Hz = 499 = 0x1F3
	TIM3->PSC = 0x1F3;
	// Reset the counter
	TIM3->CNT = 0x00000000;
	// Enable thd update interrupt, UIE, in the DIER register
	TIM3->DIER |= (1 << 0);
	// Enable the handler with NVIC
	NVIC_EnableIRQ(TIM3_IRQn);
	//NVIC_SetPriority(TIM3_IRQn,1);
	TIM3->CR1 |= (1 << 0);
}

/*
 * This function initializes the LEDs
 */
void LED_init(void) {
	// Initialize PC6, PC7, PC8, PC9 for the LEDs
	// Initialize the LEDs.
	// Set PC6 - PC9 to output mode.
	GPIOC->MODER |= (1 << 12) | (1 << 14) | (1 << 16) | (1 << 18);
}

/*
 * This function initializes GPIO pin PA0 to use as a button.
 */
void button_init(void) {
	
	// Initialize PA0 to use the external button.
	GPIOA->MODER &= ~((1 << 0) | (1 << 1));
	GPIOA->OSPEEDR &= ~((1 << 0) | (1 << 1));
	GPIOA->PUPDR &= ~((1 << 0) | (1 << 1));
	GPIOA->PUPDR |= (1 << 1);
	TIM3_init();
}

/*
 * The handler for TIM2
 */
void TIM2_IRQHandler(void) {
	if (distance_timer >= 240)
		distance_timer = 0;
	else 
		distance_timer++;
	TIM2->SR &= ~(0x0001);
}

/*
 * The handler for TIM3. Performs the debouncing of the button.
 */
void TIM3_IRQHandler(void) {
	debouncer <<= 1;
	if(GPIOA->IDR & (1 << 0))
		debouncer |= 0x1;
	if(debouncer == 0x7FFFFFFF)
		start_stop = ~start_stop;
	if(start_stop == 0) {	
		// Turn off the TIM2 timer.
		TIM2->CR1 &= ~(0xFFFE);
		// Turn off the LEDs when done.
		GPIOC->BSRR |= (1 << 22) | (1 << 23) | (1 << 24) | (1 << 25);
		// Reset the value of the distance_timer
		distance_timer = 0;
	} 
	TIM3->SR &= ~(0x0001);
}

/*
 * Initializes the motor system.
 */
void GPIO_init(void) {
	// Enable peripheral clock to GPIOA
	RCC->AHBENR |= RCC_AHBENR_GPIOAEN;
	// Enable GPIOC in RCC and make sure they are set
	// to the reset value
	RCC->AHBENR |= RCC_AHBENR_GPIOCEN;
	GPIOC->MODER = 0x00000000;
	GPIOC->OTYPER = 0x00000000;
	GPIOC->OSPEEDR = 0x00000000;
	GPIOC->PUPDR = 0x00000000;
	GPIOC->ODR = 0x00000000;
	// Enable GPIOB in RCC and make sure they are set
	// to the reset value
	RCC->AHBENR |= RCC_AHBENR_GPIOBEN;
	GPIOB->MODER = 0x00000000;
	GPIOB->PUPDR = 0x00000000;
	GPIOB->OTYPER = 0x00000000;
	GPIOB->OSPEEDR = 0x00000000;
	GPIOB->ODR = 0x00000000;
}

/*
 * This function causes the vehicle to move forward. This function is tested 
 * using the LEDs.
 */
void move_forward(void) {
	TIM2_init();
	while(distance_change_time > (distance_timer / 4)) {
		// Turn on the red & orange LEDs while moving forward.
		GPIOC->BSRR |= (1 << 6) | (1 << 8);
	}
	// Turn off the TIM2 timer.
	TIM2->CR1 &= ~(0xFFFE);
	// Turn off the LEDs when done.
	GPIOC->BSRR |= (1 << 22) | (1 << 23) | (1 << 24) | (1 << 25);
	// Reset the value of the distance_timer
	distance_timer = 0;
}

/*
 * This function causes the vehicle to move backward. This function is tested
 * using the LEDs.
 */
void move_reverse(void) {
	TIM2_init();
	while(distance_change_time > (distance_timer / 4)) {
		// Turn on the blue & green LEDs while moving forward.
		GPIOC->BSRR |= (1 << 7) | (1 << 9);
	}
	// Turn off the TIM2 timer.
	TIM2->CR1 &= ~(0xFFFE);
	// Turn off the LEDs when done.
	GPIOC->BSRR |= (1 << 22) | (1 << 23) | (1 << 24) | (1 << 25);
	// Reset the value of the distance_timer
	distance_timer = 0;
}

/*
 * This function causes the vehicle to turn right. This function is tested 
 * using the LEDs.
 */
void turn_right(void) {
	TIM2_init();
	while(distance_change_time > (distance_timer / 4)) {
		// Turn on the red & green LEDs while moving forward.
		GPIOC->BSRR |= (1 << 6) | (1 << 9);
	}
	// Turn off the TIM2 timer.
	TIM2->CR1 &= ~(0xFFFE);
	// Turn off the LEDs when done.
	GPIOC->BSRR |= (1 << 22) | (1 << 23) | (1 << 24) | (1 << 25);
	// Reset the value of the distance_timer
	distance_timer = 0;
}

/*
 * This function causes the vehicle to turn left. This function is tested 
 * using the LEDs.
 */
void turn_left(void) {
	TIM2_init();
	while(distance_change_time > (distance_timer / 4)) {
		// Turn on the blue & orange LEDs while moving forward.
		GPIOC->BSRR |= (1 << 7) | (1 << 8);
	}
	// Turn off the TIM2 timer.
	TIM2->CR1 &= ~(0xFFFE);
	// Turn off the LEDs when done.
	GPIOC->BSRR |= (1 << 22) | (1 << 23) | (1 << 24) | (1 << 25);
	// Reset the value of the distance_timer
	distance_timer = 0;
}

/*
 * Main program
 */
int main(int argc, char* argv[]) {
	HAL_Init();
	GPIO_init();
	LED_init();
	button_init();

	while(1) {
		if(start_stop != 0) {	
			move_forward();
			move_reverse();
			turn_right();
			turn_left();
			start_stop = 0;
		} else {
			// Turn off the TIM2 timer.
			TIM2->CR1 &= ~(0xFFFE);
			// Turn off the LEDs when done.
			GPIOC->BSRR |= (1 << 22) | (1 << 23) | (1 << 24) | (1 << 25);
			// Reset the value of the distance_timer
			distance_timer = 0;
		}
	}
}

/**
  * @brief System Clock Configuration
  * @retval None
  */
void SystemClock_Config(void)
{
  RCC_OscInitTypeDef RCC_OscInitStruct = {0};
  RCC_ClkInitTypeDef RCC_ClkInitStruct = {0};

  /** Initializes the RCC Oscillators according to the specified parameters
  * in the RCC_OscInitTypeDef structure.
  */
  RCC_OscInitStruct.OscillatorType = RCC_OSCILLATORTYPE_HSI;
  RCC_OscInitStruct.HSIState = RCC_HSI_ON;
  RCC_OscInitStruct.HSICalibrationValue = RCC_HSICALIBRATION_DEFAULT;
  RCC_OscInitStruct.PLL.PLLState = RCC_PLL_NONE;
  if (HAL_RCC_OscConfig(&RCC_OscInitStruct) != HAL_OK)
  {
    Error_Handler();
  }
  /** Initializes the CPU, AHB and APB buses clocks
  */
  RCC_ClkInitStruct.ClockType = RCC_CLOCKTYPE_HCLK|RCC_CLOCKTYPE_SYSCLK
                              |RCC_CLOCKTYPE_PCLK1;
  RCC_ClkInitStruct.SYSCLKSource = RCC_SYSCLKSOURCE_HSI;
  RCC_ClkInitStruct.AHBCLKDivider = RCC_SYSCLK_DIV1;
  RCC_ClkInitStruct.APB1CLKDivider = RCC_HCLK_DIV1;

  if (HAL_RCC_ClockConfig(&RCC_ClkInitStruct, FLASH_LATENCY_0) != HAL_OK)
  {
    Error_Handler();
  }
}

/* USER CODE BEGIN 4 */

/* USER CODE END 4 */

/**
  * @brief  This function is executed in case of error occurrence.
  * @retval None
  */
void Error_Handler(void)
{
  /* USER CODE BEGIN Error_Handler_Debug */
  /* User can add his own implementation to report the HAL error return state */
  __disable_irq();
  while (1)
  {
  }
  /* USER CODE END Error_Handler_Debug */
}

#ifdef  USE_FULL_ASSERT
/**
  * @brief  Reports the name of the source file and the source line number
  *         where the assert_param error has occurred.
  * @param  file: pointer to the source file name
  * @param  line: assert_param error line source number
  * @retval None
  */
void assert_failed(uint8_t *file, uint32_t line)
{
  /* USER CODE BEGIN 6 */
  /* User can add his own implementation to report the file name and line number,
     ex: printf("Wrong parameters value: file %s on line %d\r\n", file, line) */
  /* USER CODE END 6 */
}
#endif /* USE_FULL_ASSERT */

