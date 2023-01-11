#Age Checker: Are you old enough to see this film?

#Asks user to input their name.
name = input("Please enter your name: ")

#Asks user to input their age. We then convert the age to an integer.
age = int(input("Please enter your age: "))

if(age >= 15 and age < 150):
    print("You are all good " + name + ". Enjoy Ghost Stories!")
elif(age < 0 or age > 150):
    print("You're lying!")
else:
    print("Sorry " + name + ". You aren't old enough to see Ghost Stories!")
