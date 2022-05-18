package Basic;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap so n: ");
        int n=sc.nextInt();
        int count=0;

        System.out.print("Cac uoc so cua "+n+" la: ");
        for(int i=1;i<=n;i++){
            if(n%i==0) {
                System.out.print(i+" ");
                count+=1;
            }
        }
        System.out.println();
        System.out.println("Tong uoc so cua "+n+" la :"+count);
    }

}
