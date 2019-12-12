# readme
The Ex1 project is a continuation of the Ex0 project. On the basis of the first project, the Ex1 project was expanded.

# Main classes:
1. ComplexFunction
2. Function_Gui
3. Monom
4. Polynom
In the following lines, I will elaborate mainly about ComplexFunction and Function_Gui classes. I will explain which cases are valid and elaborate on the abnormal cases in some functions. 

# ComplexFunction class: 
Complex function is built by two functions and an operation.

List of functions:
ComplexFunction, initFromString, copy, f, equals, getOp, left, right, plus, mul, max, min, div.

Special cases:
Function Name: Equals- checking if two functions are equals.
For checking if two functions equals directly, you might check for infinity numbers. Because this option impassible, we check for 8 numbers. There are more details on gitub (issues).  
# Function_GUI class:
The class's purpose is to create the graph. we used in stdDraw function.

List of functions:
Add, addAll, clear, contains, containsAll, isEmpty, iterator, remove, removeAll, retainAll, size, toArray, initFromFile, saveToFile, drawFunctions.
# Monom class:
In mathematics, a monomial is, roughly speaking, a polynomial which has only one term.

List of functions:
Monom, get_coefficient, get_power, derivative, f, isZero, add, multipy, toString, equals, set_coefficient, set_power, getNewZeroMonom, initFromString, copy.

Conditions for proper monom:
* The first letter could be a number or "x" or "-". 
* In case that "x" is not the first letter, Before "x", must be a number. 
* After "x", could nothing or "^". 
* After "^", must be a number. 
* The character "." could be only between numbers. 
* Brackets cannot be used.
* "x" cannot appear as power.
* To write only a number, cannot appear an number in the power.
*  In case that the user writes "X", the program will change it to "x".
*  The coefficient is a real number. 
*  The power  must be an Integer number.

Examples of an incorrect Monom: 
       1.     (3x)^2x      
       2.     2^3
       3.     2x^3.5
Examples of an correct Monom: 
       1.	    3x^2
       2.   	8
       3.   	2.5x^3

Function Name: Add- Add between monomies
In case that the powers are equals, the function will work. Else, There is an error.



# Polynom class: 
polynomial is an expression consisting of variables (also called indeterminates) and coefficients.

List of functions:
Polynom, f, add, substract, multiply, equals, isZero, root, copy, derivative, toString, area, Iterator, initFromString.
Conditions for proper polynomial:
* All the condition of the monom.
* Between monomies, There can only be add and subtraction(no multiplication or division).


Examples of an incorrect Polynom: 
    1.   3.x^2          
    2.   (4x+3)
    3.    3x*5x

Examples of an correct Polynom: 
    1.   3.6x^2          
    2.   4x+3
    3.   2x^3+5x

Function Name: equals- Checking if two polynomials are equal
In case that one of the polynoms is "null", An error appears.


