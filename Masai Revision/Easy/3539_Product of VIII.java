import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String[] arr = scanner.nextLine().trim().split(" ");
        
        int product = 1;
        
        for(int i=0; i<arr.length; i++){
            product *= Integer.parseInt(arr[i]);
        }
        
        System.out.println(product);
    }
}