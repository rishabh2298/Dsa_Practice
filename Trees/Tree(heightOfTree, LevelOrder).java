/*
Height of Tree = 4

Level 1 = 1
Level 2 = 2 3
Level 3 = 4 5 6
Level 4 = 7 8 9 10
1
2 3
4 5 6
7 8 9 10

=== Code Execution Successful ===
*/

import java.util.*;

class HelloWorld {
    
    static class Node{
        int data;
        Node left;
        Node right;
        
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
        
        // Tc=O(N^2) , Sc=O(H)
        for(int i=1; i<=height; i++){
            System.out.print("Level " + i + " = ");
            printLevel(node, i);
            System.out.println();
        }
        
        // Tc=O(N) , Sc=O(H)
        printAllLevel(node);
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
    
    private static void printLevel(Node node , int level){
        if(node == null){
            return;
        }
        
        if(level == 1){
            System.out.print(node.data + " ");
        }
        
        if(level > 1){
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }
    
    private static void printAllLevel(Node node){
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(node);
        queue.add(null);
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr == null){
                if(queue.isEmpty()){
                    break;
                }
                else{
                    queue.add(null);
                    System.out.println();
                }
                continue;
            }
            
            System.out.print(curr.data + " ");
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
    }
}

