
// Sample Input
// 4
// good

// Sampe Output
// 0
// good


import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();
        char[] arr = scanner.nextLine().trim().toCharArray();
        
        if(N == 0){
            System.out.println(0);
        }
        else{
            int i=0;
            while(i<N-1){
                if(arr[i] == arr[i+1]){
                    arr[i] = '@';
                    i++;
                }
                else{
                    i+=2;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<N; i++){
            if(arr[i] == '@'){
                continue;
            }
            result.append(arr[i]);
        }
        
        System.out.println(arr.length - result.length());
        System.out.println(result.toString());
    }
}