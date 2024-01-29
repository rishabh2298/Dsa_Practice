import java.util.*;

class Main{
    
    private static boolean checkBoth(int N, char[][] mat){
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(mat[i][j] != mat[i][N-1-j] || mat[i][j] != mat[N-1-i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    private static boolean checkHorizontal(int N, char[][] mat){
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(mat[i][j] != mat[N-1-i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    private static boolean checkVertical(int N, char[][] mat){
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(mat[i][j] != mat[i][N-1-j]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int tc = scanner.nextInt();
        
        for(int i=0; i<tc; i++){
            
            int N = scanner.nextInt();
            scanner.nextLine();
            
            char[][] mat = new char[N][N];
            
            for(int j=0; j<N; j++){
                mat[j] = scanner.nextLine().trim().toCharArray();
            }
            
            if(checkBoth(N,mat)){
                System.out.println("BOTH");
            }
            else if(checkHorizontal(N,mat)){
                System.out.println("HORIZONTAL");
            }
            else if(checkVertical(N,mat)){
                System.out.println("VERTICAL");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    
}