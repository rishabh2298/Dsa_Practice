import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int ans = 0;
        
        for(int i=0; i<arr.length; i++){
            if(i==0 || i==1){
                ans += arr[i] * 2;
            }
            else if(i==2){
                ans += arr[i] * 3;
            }
            else{
                ans += arr[i] + 4;
            }
        }
        
        System.out.println(ans);
    }
}