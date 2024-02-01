import java.util.*;

class Main{
    
    private static void ageOfEmpires(int N, int[] arr){
        
        Arrays.sort(arr);
        
        int sum = 0;
        
        for(int i=0; i<2*N; i+=2){
            sum += arr[i];
        }
        
        // System.out.println(Arrays.toString(arr));
        System.out.println(sum);
    }
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        scanner.nextLine();
        
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        ageOfEmpires(N,arr);
    }
}