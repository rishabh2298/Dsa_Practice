import java.util.*;

class Main{
    
    private static void rotateElements(int N, long K, int[] arr){
        
        int k;
        if(K > N){
            k = (int)(K%N);
        }
        else{
            k = (int)K;
        }
        
        for(int i=0; i<k; i++){
            int temp = arr[N-1];
            for(int j=N-2; j>=0; j--){
                arr[j+1] = arr[j];
            }
            arr[0] = temp;
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(int i=0; i<N; i++) 
            ans.append(arr[i]+" ");
        
        System.out.println(ans.toString());
    }
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int tc = scanner.nextInt();
        
        for(int i=0; i<tc; i++){
            int N = scanner.nextInt();
            long K = scanner.nextLong();
            
            scanner.nextLine();
            int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            rotateElements(N,K,arr);
        }
    }
}