package Array;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n+3];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int max=0;
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++) {
                if (a[j] > a[j+1]||j==n-1){
                    if(j+1-i>max) {
                        max=j+2-i;
                        max = j+1 - i;
                        index=i;
                    }
                    break;

                }

            }
        }
        System.out.println("Duong chay dai nhat o vi tri so "+index+" voi do dai la "+max);
    }
}
