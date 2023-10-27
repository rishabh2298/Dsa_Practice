package Dsa_Practice.Stack;

import java.util.Arrays;
import java.util.Scanner;

public class StackImplementationUsingArray {

    static class MyStack {

        int top;
        int[] arr;

        public MyStack(int size) {
            this.top = -1;
            this.arr = new int[size];
        }

        void push(int data) {

            if (this.top == this.arr.length) {
                System.out.println("Stack Overflow");
                return;
            }

            this.top++;
            this.arr[top] = data;
        }

        int pop() {

            if (this.top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }

            int value = this.arr[top];
            this.arr[top] = 0;

            top--;

            return value;
        }

        int size() {
            return this.top + 1;
        }

        boolean isEmpty() {

            if (this.top == -1) {
                return true;
            }

            return false;

        }

        void printStack() {
            StringBuilder result = new StringBuilder();

            if (this.arr[0] == 0) {
                System.out.println("Stack is Empty... Please add element first..");
            } else {
                for (int i = this.arr.length - 1; i >= 0; i--) {
                    if (this.arr[i] != 0) {
                        result.append("| " + this.arr[i] + " |\n");
                    }
                }
                System.out.println(result);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        System.out.println("Enter your option :-");
        System.out.println("1. Add element to Stack");
        System.out.println("2. Remove element from Stack");
        System.out.println("3. Get Size of Stack");
        System.out.println("4. Stack Empty or Not");
        System.out.println("5. Print the Stack");
        System.out.println("6. Exit");

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your option :-");
        int choice = input.nextInt();

        MyStack stack = new MyStack(10);

        while (true) {

            switch (choice) {

                case 1: {

                    System.out.println("Enter elemen to add");
                    int data = input.nextInt();
                    stack.push(data);

                }
                    ;

                    break;

                case 2: {

                    int value = stack.pop();

                    if (value == -1) {
                        System.out.println("Stack is Empty...");
                    } else {
                        System.out.println("Your top element of stack = " + value);
                    }
                }

                    break;

                case 3: {
                    System.out.println("Size of stack = " + stack.size());
                }

                    break;

                case 4: {
                    if (stack.isEmpty()) {
                        System.out.println("Yes stack is empty");
                    } else {
                        System.out.println("Stack is not empty");
                    }
                }

                    break;

                case 5: {
                    stack.printStack();
                }

                default: {
                    System.out.println("Thanks for using my stack");
                    break;
                }

            }

            System.out.println("Enter your option :-");
            choice = input.nextInt();

        }

    }

}
