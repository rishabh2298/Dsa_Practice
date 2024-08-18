/*

1 2 4 7 8 5 9 3 6 10

1
2 3
4 5 6
7 8 9 10

Height of Tree = 4

1 2 4 7

1 3 6 10

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
        
        preOrder(node);
        System.out.println("\n");
        
        printAllLevel(node);
        System.out.println('\n');
        
        int height = heightOfTree(node);
        System.out.println("Height of Tree = " + height + "\n");
        
        int[] leftView = new int[height];
        Arrays.fill(leftView, Integer.MIN_VALUE);
        
        printLeftView(node, leftView, 0);
        for(Integer value : leftView){
            System.out.print(value + " ");
        }
        System.out.println("\n");
        
        int[] rightView = new int[height];
        Arrays.fill(rightView, Integer.MIN_VALUE);
        
        printRightView(node, rightView, 0);
        for(Integer value : rightView){
            System.out.print(value + " ");
        }
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
    
    private static void printAllLevel(Node node){
        if(node == null){
            System.out.println("Node is empty");
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(node);
        queue.add(null);
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr == null){
                if(queue.isEmpty()){
                    return;
                }
                else{
                    queue.add(null);
                    System.out.println();
                    continue;
                }
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
    
    private static int heightOfTree(Node node){
        if(node == null){
            return 0;
        }
        
        return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
    }
    
    private static void printLeftView(Node node, int[] leftView, int level){
        if(node == null){
            return;
        }
        
        if(leftView[level] == Integer.MIN_VALUE){
            leftView[level] = node.data;
        }
        
        printLeftView(node.left, leftView, level+1);
        printLeftView(node.right, leftView, level+1);
    }
    
    private static void printRightView(Node node, int[] rightView, int level){
        if(node == null){
            return;
        }
        
        if(rightView[level] == Integer.MIN_VALUE){
            rightView[level] = node.data;
        }
        
        printRightView(node.right, rightView, level+1);
        printRightView(node.left, rightView, level+1);
    }
}
