// 1st solution

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        String[] arr = input.nextLine().trim().split(" ");
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    
        System.out.println();
    }
}


// 2nd solution

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println(input.nextLine().trim());
    }
}