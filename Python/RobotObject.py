#Robot Class/Object
class Robot:
    
    def introduce_self(self):
        print("My name is " + self.name) #this in Java
        
    def __init__(self, name, color, weight):
        self.name = name
        self.color = color
        self.weight = weight
