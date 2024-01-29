import java.util.*;

class Main{
    
    private static void solution(int N, int[] arr){
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        if(N < 6){
            System.out.println("Not Possible");
            System.out.println("Not Possible");
        }
        else{
            StringBuilder ans1 = new StringBuilder();
            
            int pointer = 0;
            for(int i=0; i<N-1; i++){
                if(pointer == 3) break;
                if(arr[i] == arr[i+1]){
                    continue;
                }
                else{
                    ans1.append(arr[i]+" ");
                }
                pointer++;
            }
            
            int[] arr2 = new int[3];
            int j=0;
            
            for(int i=N-1; i>=0; i--){
                if(pointer == 0) break;
                if(arr[i] == arr[i-1]){
                    continue;
                }
                else{
                    arr2[j++] = arr[i];
                }
                pointer--;
            }
            
            StringBuilder ans2 = new StringBuilder();
            
            for(int i=2; i>=0; i--) ans2.append(arr2[i]+" ");
            
            System.out.println(ans1.toString());
            System.out.println(ans2.toString());
        }
    }
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        scanner.nextLine();
        
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        solution(N,arr);
    }
}