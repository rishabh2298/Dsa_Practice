// Rotate Elemnts

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
    
    
    private static void rotateElements(int N, int[][] mat){
        
        int left = 0;
        int right = N-1;
        int top = 0;
        int bottom = N-1;
        
        int count = 0;
        int prev;
        
        while(count < N*N){
            
            if(top < N/2){
                prev = mat[top+1][left];
            }
            else{
                // if N==odd then middle row should be default;
                prev = mat[top][left];        
            }
            
            for(int j=left; j<=right && count<N*N; j++){
                int temp = mat[top][j];
                mat[top][j] = prev;
                prev = temp;
                count++;
            }
            top++;
            
            for(int i=top; i<=bottom && count<N*N; i++){
                int temp = mat[i][right];
                mat[i][right] = prev;
                prev = temp;
                count++;
            }
            right--;
            
            for(int j=right; j>=left && count<N*N; j--){
                int temp = mat[bottom][j];
                mat[bottom][j] = prev;
                prev = temp;
                count++;
            }
            bottom--;
            
            for(int i=bottom; i>=top && count<N*N; i--){
                int temp = mat[i][left];
                mat[i][left] = prev;
                prev = temp;
                count++;
            }
            left++;
        }
        
        for(int i=0; i<N; i++){
            StringBuilder ans = new StringBuilder();
            for(int j=0; j<N; j++){
                ans.append(mat[i][j]+" ");
            }
            System.out.println(ans.toString());
        }
    }
    
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        scanner.nextLine();
        
        int[][] mat = new int[N][N];
        
        for(int i=0; i<N; i++){
            mat[i] = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        rotateElements(N,mat);
    }
    
}