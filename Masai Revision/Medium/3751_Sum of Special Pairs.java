import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        scanner.nextLine();
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int sum = 0;
        
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(isPrime(j-i)){
                    sum += Math.abs(arr[i] - arr[j]);
                }
            }
        }
        
        System.out.println(sum);
    }
    
    private static boolean isPrime(int N){
        if(N == 2) return true;
        if(N < 2) return false;
        
        for(int i=2; i<N; i++){
            if(N%i==0) return false;
        }
        
        return true;
    }
}