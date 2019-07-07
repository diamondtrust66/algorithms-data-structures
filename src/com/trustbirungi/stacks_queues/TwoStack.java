package com.trustbirungi.stacks_queues;

/**
* @class TwoStack
* @description An implementation of Dijkstra's two-stack algorithm using Jonathan Payne's Stack class which implements
* a LIFO stack
* @author Trust Birungi
* @since JDK8.0
*/

import java.util.Stack;

public class TwoStack {
    public double evaluate(String expression) {
        double lastResult = 0.0;

        Stack<Number> operandStack = new Stack<Number>();

        Stack<Character> operatorStack = new Stack<Character>();

        char[] expressionChars = expression.toCharArray();

        //Loop through the supplied expression and apply the operations for each character
        for (char character: expressionChars) {

            if(character == '(') {

            } else if(Character.isDigit(character)){
                operandStack.push(Character.getNumericValue(character));
            } else if(character == '%' || character == '/' || character == '*' || character == '+' || character == '-')
            {
                operatorStack.push(character);
            } else if(character == ')' && !operandStack.empty() && !operatorStack.empty()) {
                if(operandStack.size() == 1) {
                    System.out.println("\n OperandStack size = 1 and the last value on the stack is "
                            + operandStack.pop() + "\n");
                    return lastResult;
                } else {
                    lastResult = calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop());
                    operandStack.push(lastResult);
                }
            }

        }

        return lastResult;
    }

    //Parse the operator popped from the operatorStack and apply it to the two values popped from the operandStack
    public double calculate(char operator, Number firstValue, Number secondValue) {
        double result = 0.0;
        switch (operator) {
            case '+': result = firstValue.doubleValue() + secondValue.doubleValue();
                break;
            case '-': result =  firstValue.doubleValue() - secondValue.doubleValue();
                break;
            case '*': result = firstValue.doubleValue() * secondValue.doubleValue();
                break;
            case '/': result = firstValue.doubleValue() / secondValue.doubleValue();
                break;
            case '%': result = firstValue.doubleValue() % secondValue.doubleValue();
                break;
        }

        return result;
    }
}
