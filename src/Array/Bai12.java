package Array;

import java.util.Scanner;

public class Bai12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n+2][n+2];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                a[i][j]=sc.nextInt();
        int[][] b=new int[n+2][n+2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                b[n-j-1][i]=a[i][j];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(b[i][j]+" ");
            System.out.println();
        }
    }
}
