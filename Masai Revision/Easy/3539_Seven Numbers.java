import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int left = 0;
        int right = 0;
        
        for(int i=0; i<arr.length; i++){
            if(i<=2){
                left += arr[i];
            }
            else{
                right += arr[i];
            }
        }
        
        System.out.println(left*right);
    }
}