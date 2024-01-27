import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int ans = 0;
        
        for(int i=0; i<arr.length; i++){
            ans += arr[i] * 2;
        }
        
        System.out.println(ans);
    }
}