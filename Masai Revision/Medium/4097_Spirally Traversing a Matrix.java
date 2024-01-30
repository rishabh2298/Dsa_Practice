import java.util.*;

class Main{
    
    private static void spiralMatrix(int N, int[][] mat){
        
        int left = 0;
        int right = N-1;
        int top = 0;
        int bottom = N-1;
        int count = 0;
        StringBuilder ans = new StringBuilder();
        
        while(count < N*N){
            
            // left to right
            for(int j=left; j<=right && count<N*N; j++){
                ans.append(mat[top][j]+" ");
                count++;
            }
            top++;
            
            // top to bottom
            for(int i=top; i<=bottom && count<N*N; i++){
                ans.append(mat[i][right]+" ");
                count++;
            }
            right--;
            
            // right to left
            for(int j=right; j>=left && count<N*N; j--){
                ans.append(mat[bottom][j]+" ");
                count++;
            }
            bottom--;
            
            // bottom to top
            for(int i=bottom; i>=top && count<N*N; i--){
                ans.append(mat[i][left]+" ");
                count++;
            }
            left++;
            
        }
        
        System.out.println(ans.toString());
    }
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        int[][] mat = new int[N][N];
        
        scanner.nextLine();
        for(int i=0; i<N; i++){
            mat[i] = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        spiralMatrix(N,mat);
    }
}