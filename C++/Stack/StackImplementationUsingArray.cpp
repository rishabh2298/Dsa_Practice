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
            cout << "Stack is Overloaded" << endl;
        }
        else{
            top++;
            arr[top] = data;
        }
    }
    
    void pop(){
        
    }
    
    void printStack(){
        for(int i=this->top; i>=0; i--){
            cout << arr[i] << " ";
        }
        cout << endl;
    }
    
};

int main() {
    // Write C++ code here
    std::cout << "Hello world!" << endl << endl;
    
    Stack st(10);
    
    st.push(10);
    st.push(11);
    st.printStack();

    return 0;
}