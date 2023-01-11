#Greeting Program

#Prompts user to type in their name. Users input is saved into "name" variable.
name = input("Enter your name: ")

#Computer responds to user by saying "Hello" with the users inputed name. 
print("Hello " + name)

#Prompts user to type in their age. Users input is saved into "age" variable
#in the form of an integer instead of a String.
age = int(input("Please enter your age: "))

#Prompts user to type in the current year. Users input is saved into
#"current_year" variable in the form of an integer instead of a String.
current_year = int(input("What is the current year? "))

#Calculates the estimated birth year of the user.
birth_year = current_year - age

#Tells the user their estimated birth year. Since variable birth_year is
#an integer, we have to convert it to a String with str(). 
print("You were born in " + str(birth_year) + "!")
