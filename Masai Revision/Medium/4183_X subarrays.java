import java.util.*;
import java.io.*;

class Main{
    	static class FastReader
  	{
    		BufferedReader br;
    		StringTokenizer st;
    		public FastReader()
    	{
      br = new BufferedReader(new InputStreamReader(System.in));
    	}
    	String next()
    	{
      while (st == null || !st.hasMoreElements()){
        try { st = new StringTokenizer(br.readLine()); }
        catch (IOException e) { e.printStackTrace(); }
      }
      return st.nextToken();
    	}
    	int nextInt() { return Integer.parseInt(next()); }
    	long nextLong() { return Long.parseLong(next()); }
    	double nextDouble(){ return Double.parseDouble(next()); }
    	String nextLine(){
      	String str = "";
      	try { str = br.readLine(); }
      	catch (IOException e) { e.printStackTrace(); }
      	return str;
    	}
  	}
  	
    private static int xSubarrays(int N, int K, int X, int[] arr){
        
        int count = 0;
        
        for(int i=0; i<=N-X; i++){
            for(int j=i; j<X+i; j++){
                if(arr[j] > K)break;
                else if(j==X+i-1) count++;
            }
        }
        
        return count;
        
    }
    
    
    public static void main(String[] args){
        // code here
        
        Scanner scanner = new Scanner(System.in);
        
        int tc = scanner.nextInt();
        
        while(tc > 0){
            
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int X = scanner.nextInt();
            
            scanner.nextLine();
            int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            int ans = xSubarrays(N,K,X,arr);
            
            System.out.println(ans);
            
            tc--;
        }
    }
}