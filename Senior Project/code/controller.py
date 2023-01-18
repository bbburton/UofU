import busio
import RPi.GPIO as GPIO
import digitalio
import board
import adafruit_mcp3xxx.mcp3008 as MCP

from adafruit_mcp3xxx.analog_in import AnalogIn
from time import sleep

GPIO.setmode(GPIO.BCM)

buttons = [26,13,20,5,19,6,21,16,12,25,18,14,7,24,23,15,3,2]
controls = ["D-UP","D-DOWN","D-RIGHT","D-LEFT","A","B","X","Y","START","SELECT","LB","LT","RB","RT","XBOX","SHIFT","LEFT-JOYSTICK BUTTON","RIGHT-JOYSTICK BUTTON"]

for x in range(len(buttons)):
    GPIO.setup(buttons[x], GPIO.IN, pull_up_down = GPIO.PUD_UP)

# create the spi bus
spi = busio.SPI(clock=board.SCK, MISO=board.MISO, MOSI=board.MOSI)
# create the chip select
cs = digitalio.DigitalInOut(board.D5)
# create mcp object
mcp = MCP.MCP3008(spi,cs)
# create analog input channels on pins 3, 4, 6, and 7
r_y = AnalogIn(mcp, MCP.P3)
r_x = AnalogIn(mcp, MCP.P4)
l_y = AnalogIn(mcp, MCP.P6)
l_x = AnalogIn(mcp, MCP.P7)

try:
    while True:
        out = ""
        for x in range(len(buttons)):
            if GPIO.input(buttons[x]) == 0:
                out = out + controls[x] + " "
        out = out + "R_X: " + str(r_x.voltage) + " "
        out = out + "R_Y: " + str(r_y.voltage) + " "
        out = out + "L_X: " + str(l_x.voltage) + " "
        out = out + "L_Y: " + str(l_y.voltage) + " "
        print(out)
        sleep(0.15)
finally:
    GPIO.cleanup()
