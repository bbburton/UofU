#List Practice

#Create an empty list.
userinfo = []

#Prompts the user to input their name. Stores user input into userinfo list.
userinfo.append(input("Please enter your name: "))

#Prompts the user to input their age. Converts input to an integer.
#Stores user input into userinfo list.
userinfo.append(int(input("Please enter your age: ")))

#Prompts the user to input their first math score. Converts input to a float.
#Stores user input into userinfo list.
userinfo.append(float(input("Please enter your first math test score: ")))

#Prompts the user to input their second math score. Converts input to a float.
#Stores user input into userinfo list.
userinfo.append(float(input("Please enter your second math test score: ")))

#Prompts the user to input their third math score. Converts input to a float.
#Stores user input into userinfo list.
userinfo.append(float(input("Please enter your third math test score: ")))

#Creates a grades variable with only the elements after the first two.
grades = userinfo[2:]

#Sort the grades from worst to best
grades.sort()

#Reverse the order of the list. Then it will be best to worst.
grades.reverse()

#Print the users information they inputed.
print("User's Information")
print("Name: ", userinfo[0])
print("Age: ", userinfo[1])
print("Math scores, best to worst: ")
print(grades)
print("Average score: ", (grades[0] + grades[1] + grades[2])/3)
