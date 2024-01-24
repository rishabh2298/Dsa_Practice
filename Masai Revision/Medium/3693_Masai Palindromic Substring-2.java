import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.nextLine().trim();
        
        int maxSize = maxLengthPallindrome(str);
        
        System.out.println(maxSize);
    }
    
    // Tc=O(N^2)    Optimized
    // Sc=O(1)
    
    static int maxLengthPallindrome(String str){
        
        int N = str.length();
        int maxSize = 1;
        
        for(int i=0; i<N; i++){
            // for odd pallindrome
            int low = i-1;
            int high = i+1;
            int count1 = 1;
            
            while(low>=0 && high<N){
                if(str.charAt(low) == str.charAt(high)){
                    count1++;
                    low--;
                    high++;
                }
                else{
                    break;
                }
            }
        
            // for even pallindrome
            low = i-1;
            high = i;
            int count2 = 0;
            
            while(low>=0 && high<N){
                if(str.charAt(low) == str.charAt(high)){
                    count2++;
                    low--;
                    high++;
                }
                else{
                    break;
                }
            }
            maxSize = Math.max(maxSize,Math.max(count1*2-1,count2*2));
        }
        
        return maxSize;
    }
}