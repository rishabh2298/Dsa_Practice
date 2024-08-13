// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/*

1 2 4 7 8 5 5 9 3 6 10 
7 4 8 2 5 5 9 1 6 10 3 

=== Code Execution Successful ===

*/

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    
    static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(){
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void main(String[] args) {
        
        int[] arr = {1,2,4,7,-1,-1,8,-1,-1,5,-1,5,-1,9,-1,-1,3,6,-1,10,-1,-1,-1};
        
        Node node = buildTree(arr);
        
        preOrder(node);
        System.out.println();
        
        inOrder(node);
        System.out.println();
        
    }
    
    static int index = -1;
    private static Node buildTree(int[] arr){
        index++;
        if(arr[index] == -1){
            return null;
        }
        
        Node node = new Node(arr[index]);
        node.left = buildTree(arr);
        node.right = buildTree(arr);
        
        return node;
    }
    
    private static void preOrder(Node node){
        if(node == null){
            return;
        }
        
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    private static void inOrder(Node node){
        if(node == null){
            return;
        }
        
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
}