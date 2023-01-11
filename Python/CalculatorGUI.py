#THIS DOES NOT WORK! I NEED TO DEFINE A NEW calc() FUNCTION.

#Creates an empty GUI.
from tkinter import*

def iCalc(source, side):
    storeObj = Frame(source, borderwidth = 1, bd = 4, bg = "powder blue")
    storeObj.pack(side = side, expand = YES, fill = BOTH)
    return storeObj

def button (source, side, text, command = None):
    storeObj = Button(source, text = text, command = command)
    storeObj.pack(side = side, expand = YES, fill = BOTH)
    return storeObj

class app(Frame):
    def __init__(self):
        Frame.__init__(self)
        self.option_add('*Font', 'arial 20 bold')
        self.pack(expand = YES, fill = BOTH)
        self.master.title('Calculator')
#Everything above this comment creates an empty GUI.

        #Creates the text box display for the calculator. You can type anything in it.
        display = StringVar()
        Entry(self, relief = RIDGE, textvariable = display, justify = 'right', bd = 30,
              bg = "powder blue").pack(side = TOP, expand = YES, fill = BOTH)
        
        #Everything above this comment creates the text box display for the calculator.

        #Creates the "CE" and "C" buttons to clear the text box display.
        for clearBut in (["CE"], ["C"]):
            erase = iCalc(self, TOP)
            for ichar in clearBut:
                button(erase, LEFT, ichar, lambda storeObj = display, q = ichar: storeObj.set(''))

        #Everything above this comment creates the "CE" and "C" buttons to clear the text box display.

        #Creates the number/operator buttons.
        for NumBut in ("789/", "456*", "123-", "0.+"):
            FunctionNum = iCalc(self, TOP)
            for char in NumBut:
                button(FunctionNum, LEFT, char, lambda storeObj = display, q = char:
                       storeObj.set(storeObj.get() + q))

        #Everything above this comment creates the number/operator buttons.

        EqualsButton = iCalc(self, TOP)
        for iEquals in "=":
            if iEquals == '=':
                btniEquals = button(EqualsButton, LEFT, iEquals)
                btniEquals.bind('<ButtonRelease-1>', lambda e, s = self, storeObj = display:
                                s.calc(storeObj), '+')
            else:
                btniEquals = button(EqualsButton, LEFT, iEquals,
                    lambda storeObj = display, s = ' %s '%iEquals: storeObj.set(storeObj.get()+s))

if __name__ == '__main__':
    app().mainloop()
