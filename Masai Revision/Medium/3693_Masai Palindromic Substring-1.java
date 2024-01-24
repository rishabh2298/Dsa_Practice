import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        char[] str = scanner.nextLine().trim().toCharArray();
        
        int maxSize = 0;
        
        for(int i=0; i<str.length; i++){
            int k=i;
            int count=0;
            for(int j=str.length-1; j>=i; j--){
                if(str[k] == str[j]){
                    k++;
                    count++;
                }
                else if(k>i) break;
            }
            maxSize = Math.max(maxSize,count);
        }
        
        System.out.println(maxSize);
    }
}