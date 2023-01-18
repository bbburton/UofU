import RPi.GPIO as GPIO
from time import sleep

GPIO.setmode(GPIO.BCM)

pins = [2,3,4,17,27,22,10,9,11,5,6,13,19,26]
controls = ["D-UP","D-DOWN","D-RIGHT","D-LEFT","A","B","X","Y","START","SELECT","LB","LT","RB","RT"]

for x in pins:
    GPIO.setup(x, GPIO.IN, pull_up_down = GPIO.PUD_UP)

try:
    while True:
        for i in range(len(pins)):
            if GPIO.input(pins[i]) == 0:
                print(controls[i])
        sleep(.15)
finally:
    GPIO.cleanup()
