import java.util.*;

class Main{
    
    private static void rotateElements1(int N, long K, int[] arr){
        
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
    
    
    private static void rotateElements2(int N, long K, int[] arr){
        
        int k;
        
        if(K > N){
            k = (int)(K%N);
        }
        else{
            k = (int)K;
        }
        
        
        int[] result = new int[N];
        int j=0;    // for result index
        
        // save 1st half of rotated array
        // so start from N-k because that will become 1st element
        
        for(int i=N-k; i<N; i++){
            result[j++] = arr[i];
        }
            
        // till N-k, cause that will last element, try dry run
        
        for(int i=0; i<N-k && j<N; i++)
            result[j++] = arr[i];
            
        for(int i=0; i<N; i++)
            System.out.print(result[i]+" ");
            
        // to print next line
        System.out.println();
    }
    
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int tc = scanner.nextInt();
        
        for(int i=0; i<tc; i++){
            int N = scanner.nextInt();
            long K = scanner.nextLong();
            
            scanner.nextLine();
            int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            // Tc=O(N * (K%N)) Sc=O(1);
            rotateElements1(N,K,arr);
            
            // Tc=O(N) Sc=O(N);
            rotateElements2(N,K,arr);
            
        }
    }
}