/*

Height of Tree = 4
Max Node = 10

*/

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
        
        int[] arr = {1,2,4,7,-1,-1,8,-1,-1,5,-1,9,-1,-1,3,6,-1,10,-1,-1,-1};
        
        Node node = buildTree(arr);
        
        int height = heightOfTree(node);
        System.out.println("Height of Tree = " + height);
        
        int value = maxNode(node);
        System.out.println("Max Node = " + value);
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
    
    private static int heightOfTree(Node node){
        if(node == null){
            return 0;
        }
        
        return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
    }
    
    private static int maxNode(Node node){
        if(node == null){
            return 0;
        }
        
        return Math.max(node.data, 
                Math.max(maxNode(node.left), maxNode(node.right)));
    }
}