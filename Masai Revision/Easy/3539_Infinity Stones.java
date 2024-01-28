import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int sum = 0;
        
        for(int i=0; i<arr.length; i++){
            if(i==1 || i==4 || i==5){
                sum += arr[i]*2;
            }
            else if(i==2 || i==3){
                sum += arr[i]*3;
            }
            else{
                sum += arr[i];
            }
        }
        
        System.out.println(sum);
    }
}