/*
InOrder = 7 4 8 2 5 9 1 6 10 3

Top View = [7, 4, 2, 1, 3]

Doubly LL = 7 4 8 2 5 9 1 6 10 3

=== Code Execution Successful ===

*/


import java.util.*;

class HelloWorld {
    
    static class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class Pair {
        int hd;
        Node node;
        
        public Pair(int data, Node node){
            this.hd = data;
            this.node = node;
        }
    }
    
    public static void main(String[] args) {
        
        int[] arr = {1,2,4,7,-1,-1,8,-1,-1,5,-1,9,-1,-1,3,6,-1,10,-1,-1,-1};
        
        Node node = buildTree(arr);
        
        System.out.print("InOrder = ");
        inOrder(node);
        System.out.println("\n");
        
        List<Integer> topView = printTopView(node);
        System.out.println("Top View = " + topView.toString() + "\n");
        

        // Tc=O(N) Sc=O(1) using no space
        createDoublyLL(node);
        Node curr = head;
        System.out.print("Doubly LL = ");
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println("\n");
        
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
    
    private static void inOrder(Node node){
        if(node == null){
            return;
        }
        
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    private static List<Integer> printTopView(Node node){
        if(node == null){
            return null;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        
        queue.offer(new Pair(0, node));
        
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node.data);
            }
            
            if(curr.node.left != null){
                queue.offer(new Pair(curr.hd-1, curr.node.left));
            }
            if(curr.node.right != null){
                queue.offer(new Pair(curr.hd+1, curr.node.right));
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    
    static Node head = null;
    static Node prev = null;
    private static void createDoublyLL(Node node){
        if(node == null){
            return;
        }
        
        createDoublyLL(node.left);
        
        if(head == null){
            head = node;
        }
        else{
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        
        createDoublyLL(node.right);
    }
}
