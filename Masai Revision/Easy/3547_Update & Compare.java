import java.util.*;

class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        
        if(num1 > num2){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        num1 += num3;
        
        if(num1 > num2){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}