import busio
import digitalio
import board
import usb_hid
import adafruit_mcp3xxx.mcp3008 as MCP

from time import sleep
from adafruit_hid.keyboard import Keyboard
from adafruit_hid.keyboard_layout_us import KeyboardLayoutUS
from adafruit_hid.keycode import Keycode
from adafruit_hid.mouse import Mouse
from adafruit_mcp3xxx.analog_in import AnalogIn


# Global Paramenters
volt_min = 0.0
volt_max = 3.29
step = (volt_max - volt_min) / 12.0
analog_defaults = [0.0, 0.0, 0.0, 0.0]
analog_previous = [0.0, 0.0, 0.0, 0.0]
button_pins = [
    board.GP6,
    board.GP7,
    board.GP8,
    board.GP9,
    board.GP10,
    board.GP11,
    board.GP12,
    board.GP13,
    board.GP14,
    board.GP15,
    board.GP16,
    board.GP18,
    board.GP19,
    board.GP20,
    board.GP21,
    board.GP17,
]

mouse_pins = [board.GP0, board.GP1]
led_pins = [board.GP22, board.GP26, board.GP27, board.GP28]
key_controls = [
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 4, 4, 4],
    [
        Keycode.W,
        Keycode.Q,
        Keycode.S,
        Keycode.B,
        Keycode.A,
        Keycode.X,
        Keycode.D,
        Keycode.Y,
        Keycode.ENTER,
        Keycode.E,
        Keycode.SPACE,
        Keycode.R,
        Keycode.Z,
        Keycode.LEFT_CONTROL,
        Keycode.H,
    ],
    [
        Keycode.A,
        Keycode.B,
        Keycode.C,
        Keycode.D,
        Keycode.E,
        Keycode.F,
        Keycode.G,
        Keycode.TAB,
        Keycode.LEFT_ALT,
        Keycode.CAPS_LOCK,
        Keycode.BACKSPACE,
        Keycode.SPACE,
        Keycode.ENTER,
        Keycode.LEFT_SHIFT,
        Keycode.LEFT_CONTROL,
    ],
    [
        Keycode.H,
        Keycode.I,
        Keycode.J,
        Keycode.K,
        Keycode.L,
        Keycode.M,
        Keycode.N,
        Keycode.TAB,
        Keycode.LEFT_ALT,
        Keycode.CAPS_LOCK,
        Keycode.BACKSPACE,
        Keycode.SPACE,
        Keycode.ENTER,
        Keycode.LEFT_SHIFT,
        Keycode.LEFT_CONTROL,
    ],
    [
        Keycode.O,
        Keycode.P,
        Keycode.Q,
        Keycode.R,
        Keycode.S,
        Keycode.T,
        Keycode.U,
        Keycode.TAB,
        Keycode.LEFT_ALT,
        Keycode.CAPS_LOCK,
        Keycode.BACKSPACE,
        Keycode.SPACE,
        Keycode.ENTER,
        Keycode.LEFT_SHIFT,
        Keycode.LEFT_CONTROL,
    ],
    [
        Keycode.V,
        Keycode.W,
        Keycode.X,
        Keycode.Y,
        Keycode.Z,
        Keycode.W,
        Keycode.X,
        Keycode.TAB,
        Keycode.LEFT_ALT,
        Keycode.CAPS_LOCK,
        Keycode.BACKSPACE,
        Keycode.SPACE,
        Keycode.ENTER,
        Keycode.LEFT_SHIFT,
        Keycode.LEFT_CONTROL,
    ],
    [
        Keycode.ONE,
        Keycode.TWO,
        Keycode.THREE,
        Keycode.FOUR,
        Keycode.FIVE,
        Keycode.SIX,
        Keycode.SEVEN,
        Keycode.EIGHT,
        Keycode.NINE,
        Keycode.ZERO,
        Keycode.UP_ARROW,
        Keycode.DOWN_ARROW,
        Keycode.LEFT_ARROW,
        Keycode.RIGHT_ARROW,
        Keycode.LEFT_CONTROL,
    ],
    [
        Keycode.COMMA,
        Keycode.BACKSLASH,
        Keycode.FORWARD_SLASH,
        Keycode.LEFT_BRACKET,
        Keycode.RIGHT_BRACKET,
        Keycode.PERIOD,
        Keycode.SEMICOLON,
        Keycode.QUOTE,
        Keycode.GRAVE_ACCENT,
        Keycode.EQUALS,
        Keycode.MINUS,
        Keycode.POUND,
        Keycode.PAGE_UP,
        Keycode.PAGE_DOWN,
        Keycode.LEFT_SHIFT,
    ],
    [
        Keycode.APPLICATION,
        Keycode.COMMAND,
        Keycode.DELETE,
        Keycode.END,
        Keycode.ESCAPE,
        Keycode.GUI,
        Keycode.HOME,
        Keycode.INSERT,
        Keycode.OPTION,
        Keycode.PAUSE,
        Keycode.PRINT_SCREEN,
        Keycode.RETURN,
        Keycode.SCROLL_LOCK,
        Keycode.WINDOWS,
        Keycode.LEFT_CONTROL,
    ],
    [
        Keycode.F1,
        Keycode.F2,
        Keycode.F3,
        Keycode.F4,
        Keycode.F5,
        Keycode.F6,
        Keycode.F7,
        Keycode.F8,
        Keycode.F9,
        Keycode.F10,
        Keycode.F11,
        Keycode.F12,
        Keycode.F13,
        Keycode.F14,
        Keycode.LEFT_CONTROL,
    ],
    [
        Keycode.F15,
        Keycode.F16,
        Keycode.F17,
        Keycode.F18,
        Keycode.F19,
        Keycode.F20,
        Keycode.F21,
        Keycode.F22,
        Keycode.F23,
        Keycode.F24,
        Keycode.UP_ARROW,
        Keycode.DOWN_ARROW,
        Keycode.LEFT_ARROW,
        Keycode.RIGHT_ARROW,
        Keycode.LEFT_CONTROL,
    ],
    [
        Keycode.KEYPAD_ONE,
        Keycode.KEYPAD_TWO,
        Keycode.KEYPAD_THREE,
        Keycode.KEYPAD_FOUR,
        Keycode.KEYPAD_FIVE,
        Keycode.KEYPAD_SIX,
        Keycode.KEYPAD_SEVEN,
        Keycode.KEYPAD_EIGHT,
        Keycode.KEYPAD_NINE,
        Keycode.KEYPAD_ZERO,
        Keycode.UP_ARROW,
        Keycode.DOWN_ARROW,
        Keycode.LEFT_ARROW,
        Keycode.RIGHT_ARROW,
        Keycode.LEFT_SHIFT,
    ],
    [
        Keycode.KEYPAD_ASTERISK,
        Keycode.KEYPAD_BACKSLASH,
        Keycode.KEYPAD_ENTER,
        Keycode.KEYPAD_EQUALS,
        Keycode.KEYPAD_FORWARD_SLASH,
        Keycode.KEYPAD_MINUS,
        Keycode.KEYPAD_NUMLOCK,
        Keycode.KEYPAD_PERIOD,
        Keycode.KEYPAD_PLUS,
        Keycode.KEYPAD_ZERO,
        Keycode.UP_ARROW,
        Keycode.DOWN_ARROW,
        Keycode.LEFT_ARROW,
        Keycode.RIGHT_ARROW,
        Keycode.LEFT_SHIFT,
    ],
]
mouse_controls = [
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
    [Mouse.LEFT_BUTTON, Mouse.RIGHT_BUTTON],
]
keyboard_id = 1
mouse_id = 0
analog_id = 6
device = []
buttons = []
mouse_buttons = []
leds = []
gamepad_mode = [0]  # default mode

# gamepad modes:
#   0 = command mode
#   1 = gamepad with 1 analog device
#   2 = gamepad with 2 analog devices
#   3 - ? = kyeboard & mouse
#   4 =
#   5 =
#   6 =


def convert_voltage(voltage_raw):
    return voltage_raw * (volt_max + 0.01)


def get_movement_modifier(voltage):
    return round((voltage - volt_min) / step) - 20  # returns a value between -19 & 20


def update_leds(leds, mode):
    reset_leds(leds)
    binary_mode = bin(mode)[2:]
    if len(binary_mode) == 1:
        binary_mode = "000" + binary_mode
    elif len(binary_mode) < 3:
        binary_mode = "00" + binary_mode
    elif len(binary_mode) < 4:
        binary_mode = "0" + binary_mode
    print("mode:")
    print(mode)
    binout = ""
    print(binary_mode)
    for x in range(len(binary_mode)):
        #print(binary_mode[x])
        binout = binout + binary_mode[x]
        if binary_mode[x] == "1":
            leds[x].value = 1
        else:
            leds[x].value = 0
    print(binout)


def reset_leds(leds):
    for x in range(len(leds)):
        leds[x].value = 0


def update_mouse_movement(device_components, previous_inputs):
    # iterate through the analog inputs and update the mouse movement
    analog_inputs = device_components[analog_id]
    for x in range(len(analog_inputs)):
        converted_voltage = convert_voltage(analog_inputs[x].voltage)
        movement_modifier = get_movement_modifier(converted_voltage)
        if movement_modifier is -1:
            movement_modifier = 0
        if movement_modifier is 1:
            movement_modifier = 0
        previous_inputs[x] = movement_modifier
        if x == 0:
            #print(movement_modifier)
            device_components[mouse_id].move(x=movement_modifier)
        if x == 1:
            #print(movement_modifier)
            device_components[mouse_id].move(y=-movement_modifier)


def update_buttons(device_components, buttons, device_id, device_controls, mode):
    for x in range(len(buttons)):
        if device_id is mouse_id:
            if buttons[x].value is False:
                device_components[device_id].click(device_controls[x])
                sleep(0.5)

        else:
            if buttons[x].value:
                if x == 15:
                    print("command mode")
                    mode[0] = 0
                    # update_leds(leds, mode[0])
                elif mode[0] == 0:
                    print("mode:")
                    print(device_controls[x])
                    mode[0] = device_controls[x]
                    # update_leds(leds, mode[0])
                else:
                    device_components[device_id].press(device_controls[x])
            else:
                if (mode[0] == 0) is False:
                    if x < 15:
                        device_components[device_id].release(device_controls[x])


def setup_buttons(button_pins):
    buttons = []

    for x in range(len(button_pins)):
        button = digitalio.DigitalInOut(button_pins[x])
        button.direction = digitalio.Direction.INPUT
        button.pull = digitalio.Pull.DOWN
        buttons.append(button)

    return buttons


def setup_leds(led_pins):
    leds = []

    for x in range(len(led_pins)):
        led = digitalio.DigitalInOut(led_pins[x])
        led.direction = digitalio.Direction.OUTPUT
        leds.append(led)
    return leds


def setup_device(device_components, defaults, previous):
    # MCP3008 pins: SPI0SCK = GP2 SPI0RX/DOUT/MISO = GP4
    #               SPI0TX/DIN/MOSI = GP3 SPI0CS = GP5
    # Joystick Button Pins: GP0 GP1
    # Button Pins: GP6 - 21

    mouse1 = Mouse(usb_hid.devices)
    device_components.append(mouse1)
    keyboard = Keyboard(usb_hid.devices)
    device_components.append(keyboard)
    # may not need the keyboard layout
    keyboard_layout = KeyboardLayoutUS(keyboard)
    device_components.append(keyboard_layout)

    # setting up the mcp3008
    # setting up the spi
    spi = busio.SPI(clock=board.GP2, MISO=board.GP4, MOSI=board.GP3)
    device_components.append(spi)

    # setting up the chip select
    chip_select = digitalio.DigitalInOut(board.GP5)
    device_components.append(chip_select)

    # create the mcp
    mcp = MCP.MCP3008(spi, chip_select)
    device_components.append(mcp)

    # create analog inputs on channels 3,4,6,7
    # channel 7 = right stick x
    # channel 6 = right stick y
    # channel 4 = left stick x
    # channel 3 = left stick y
    ri_x = AnalogIn(mcp, MCP.P7)
    ri_y = AnalogIn(mcp, MCP.P6)
    lt_x = AnalogIn(mcp, MCP.P4)
    lt_y = AnalogIn(mcp, MCP.P3)
    inputs = [ri_x, ri_y, lt_x, lt_y]

    for x in range(len(inputs)):
        default = inputs[x].voltage
        defaults[x] = default
        previous[x] = get_movement_modifier(convert_voltage(default))

    device_components.append(inputs)


# Set up the device components
setup_device(device, analog_defaults, analog_previous)

# Set up the keyboard buttons, mouse buttons, and leds
buttons = setup_buttons(button_pins)
mouse_buttons = setup_buttons(mouse_pins)
leds = setup_leds(led_pins)

sleep(1)

print(gamepad_mode)

# base value of lt_x is approx. 1.69
# base value of lt_y is approx. 1.71
while True:
    current_keyboard = key_controls[gamepad_mode[0]]
    current_mouse = mouse_controls[gamepad_mode[0]]

    # Update leds
    update_leds(leds, gamepad_mode[0])

    # Update the mouse
    update_mouse_movement(device, analog_previous)
    update_buttons(device, mouse_buttons, mouse_id, current_mouse, gamepad_mode)

    # Update the keyboard
    update_buttons(device, buttons, keyboard_id, current_keyboard, gamepad_mode)
