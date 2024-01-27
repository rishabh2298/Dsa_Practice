import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int multi = 1;
        
        for(Integer value : arr){
            multi *= value;
        }
        
        System.out.println(multi);
    }
}