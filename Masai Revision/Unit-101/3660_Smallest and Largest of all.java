
// Link : https://oj.masaischool.com/contest/3660/problem/1

// Tc=O(N)  Sc=O(1);


import java.util.*;

class Main{
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }
        
        smallestAndLargest(N,arr);
    }
    
    
    private static void smallestAndLargest(int N, int[] arr){
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<N; i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        
        System.out.println(min+"\n"+max);
    }
}