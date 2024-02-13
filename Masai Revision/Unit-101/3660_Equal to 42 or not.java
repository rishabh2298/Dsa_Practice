
// Link : https://oj.masaischool.com/contest/3660/problem/04

import java.util.*;

class Main{
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }
        
        if(isPresent(N,arr)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    
    private static boolean isPresent(int N, int[] arr){
        
        for(int i=0; i<N; i++){
            if(arr[i] == 42) return true;
        }
        
        return false;
    }
    
}