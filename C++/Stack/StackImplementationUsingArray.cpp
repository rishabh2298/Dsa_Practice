#include <iostream>
using namespace std;

class Stack{
    
    public :
    int top;
    int *arr;
    int size;
    
    public :
    Stack(int size){
        this -> size = size;
        this -> top = -1;
        this -> arr = new int[size];
    }
    
    
    void push(int data){
        if(this -> top == size-1){
            cout << "Stack is Overflow" << endl;
        }
        else{
            top++;
            arr[top] = data;
        }
    }
    
    int pop(){
       if(this->top == -1){
           cout << "Stack is Underflow" << endl;
           return -1;
       }
        
       int value = this->arr[top];
       arr[top] = 0;
       top--;
       
       return value;
    }
    
    void printStack(){
        for(int i=this->top; i>=0; i--){
            cout << arr[i] << " ";
        }
        cout << endl;
    }
    
    
    int peek(){
        if(this->top == -1){
            cout << "Stack is Empty";
            return -1;   
        }
        
        return this->arr[top];
    }
    
    
    bool isEmpty(){
        return this->top == -1;
    }
    
    
    int sizeOfStack(){
        int length = sizeof(this->arr)/sizeof(this->arr[0]);
        return length;
    }
    
};

int main() {
    // Write C++ code here
    std::cout << "Hello world!" << endl << endl;
    
    Stack st(8);
    
    st.isEmpty()==1 ? cout << "Stack is Empty" << endl : cout << "Stack is Not Empty" << endl;
    
    st.push(10);
    st.push(11);
    st.push(12);
    st.push(13);
    st.push(15);
    st.push(16);
    st.push(17);
    st.push(18);
    
    st.printStack();
    
    cout << "Peek element = " << st.peek();
    
    st.isEmpty()==0 ? cout << "Stack is Not Empty" << endl : cout << "Stack is Empty" << endl;
    
    cout << "Size of Stack = " << st.sizeOfStack();
    
    cout << "Your poped element = " << st.pop() << endl;
    cout << "Your poped element = " << st.pop() << endl;
    cout << "Your poped element = " << st.pop() << endl;
    
    st.printStack();
    
    st.isEmpty()==1 ? cout << "Stack is Empty" << endl : cout << "Stack is Not Empty" << endl;
    
    cout << "Size of Stack = " << st.sizeOfStack();
    
    return 0;
}