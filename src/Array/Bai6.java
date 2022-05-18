package Array;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n= sc.nextInt();
        float[] a=new float[n+5];
        System.out.print("Nhap mang: ");
        for(int i=0;i<n;i++)
            a[i]=sc.nextFloat();
        for(int i = 0; i<n-1; i++){
            for(int j = 0; j< n-i-1; j++){
                if(a[j] > a[j+1]){
                    float temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.print("Nhap so x: ");
        float x=sc.nextFloat();
        int index=0;
        int c=0;
        for(int i=0;i<n-1;i++){
            if(a[i]<=x&&a[i+1]>=x){
                c=1;
                index=i+1;
            }
        }
        if(c==1){
            for(int i = 0;i<index; i++){
                System.out.print(a[i]+ " ");
            }
            System.out.print(x +" ");

            for(int i = index;i<n; i++){
                System.out.print(a[i]+ " ");
            }
        }
        else if(x<a[0]){
            System.out.print(x+ " ");
            for(int i = 0; i<n; i++){
                System.out.print(a[i] +" ");
            }
        }
        else {
            for(int i = 0; i<n; i++){
                System.out.print(a[i] +" ");
            }
            System.out.print(x);
        }
    }
}
