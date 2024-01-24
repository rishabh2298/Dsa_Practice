import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String[] stringArray = scanner.nextLine().trim().split(" ");
        int[] arr = Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
        
        int multi = 1;
        
        for(int i=0; i<arr.length; i++) multi *= arr[i];
        
        System.out.println(multi);
    }
}