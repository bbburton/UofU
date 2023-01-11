#Average word length estimator.

#Prompts user to type in a random sentence. Users input is saved into
#"sentence" variable.
sentence = input("Please enter a sentence: ")

#Finds the number of characters in the users sentence.
total_length = len(sentence)

#Finds the number of spaces in the users sentence.
spaces = sentence.count(" ")

#Finds the number of words in the users sentence by adding the number of
#spaces in the sentence plus one for the final word.
num_words = spaces + 1

#Prints the variable total_length to the screen.
print("The total length of this sentence is: " + str(total_length))

#Prints the variable spaces to the screen.
print("The total number of spaces in this sentence is: " + str(spaces))

#Prints the variable num_words to the screen.
print("The total number of words in this senctence is: " + str(num_words))

#Prints to the screen the average word length in the users sentence. 
print("The average word length for this sentence is: " +
      str((total_length - spaces) / num_words))
