package Array;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n+3];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.print("Nhap so X: ");
        int x=sc.nextInt();
        int min=99999,index=0;
        for(int i=0;i<n;i++){
            if(ngto(a[i])&&Math.abs(a[i]-x)<min){
                min=Math.abs(a[i]-x);
                index=i;

            }
        }
        System.out.println("Vi tri so  nguyen to co gia tri gan "+x +" nhat: "+index);

    }
    public static boolean ngto(int n){
        if(n<2)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
