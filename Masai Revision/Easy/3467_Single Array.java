import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int N = input.nextInt();
        
        input.nextLine();
        String[] arr = input.nextLine().trim().split(" ");
        
        for(int i=0; i<N; i++){
            System.out.print(Integer.parseInt(arr[i])+1+" ");
        }
        System.out.println();
    }
}