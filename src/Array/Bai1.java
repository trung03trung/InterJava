package Array;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n+3];
        for(int i=0;i<n;i++)
            a[i]= sc.nextInt();
        boolean c=true;
        for(int i=0;i<=n/2;i++){
            if(a[i]!=a[n-1-i]){
                c=false;
                break;
            }
        }
        if(c)
            System.out.println("Mang doi xung");
        else
            System.out.println("Khong phai mang doi xung");
    }
}
