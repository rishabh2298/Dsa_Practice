/*

1 2 4 7 8 5 9 3 6 10

Bottom View = [7, 4, 8, 6, 10]

*/


import java.util.*;

class HelloWorld {
    
    static class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class Pair {
        int hd;
        Node node;
        
        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,-1,-1,8,-1,-1,5,-1,9,-1,-1,3,6,-1,10,-1,-1,-1};
        
        Node node = buildTree(arr);
        
        preOrder(node);
        System.out.println("\n");
        
        List<Integer> topView = printTopView(node);
        System.out.println("Top View = " + topView.toString() + "\n");
        
        List<Integer> bottomView = printBottomView(node);
        System.out.println("Bottom View = " + bottomView.toString() + "\n");
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
    
    
    private static List<Integer> printBottomView(Node node) {
        if(node == null){
            return null;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        
        queue.add(new Pair(0, node));
        
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            
            map.put(curr.hd, curr.node.data);
            
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
}