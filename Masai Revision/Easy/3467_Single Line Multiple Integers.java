import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        String[] arr = input.nextLine().trim().split(" ");
        
        for(int i=0; i<arr.length; i++){
            System.out.println(Integer.parseInt(arr[i]) + 1);
        }
    }
    
}