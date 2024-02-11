// Parity Sorting

import java.util.*;

class Main{
    
    private static void paritySorting(int N, int[] arr){
        
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        
        for(int i=0; i<N; i++){
            if(arr[i]%2 == 1){
                odd.append(arr[i]+" ");
            }
            else{
                even.append(arr[i]+" ");
            }
        }
        
        System.out.println(odd.toString()+""+even.toString());
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();
        
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        paritySorting(N,arr);
    }
}
