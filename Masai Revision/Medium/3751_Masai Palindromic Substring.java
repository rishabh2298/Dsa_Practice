import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.nextLine().trim();
        
        int ans = 0;
        
        for(int i=0; i<str.length(); i++){
            int k=i;
            int count = 0;
            for(int j=str.length()-1; j>=i; j--){
                if(str.charAt(k) == str.charAt(j)){
                    count++;
                    k++;
                }
                else if(k>i) break;
            }
            ans = Math.max(ans,count);
        }
        
        System.out.println(ans);
    }
}