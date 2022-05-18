package Basic;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap 2 so nguyen: ");
        int a= sc.nextInt();
        int b= sc.nextInt();
        System.out.println("UCLN: "+gcd(a,b));
        System.out.println("BCC: "+lcm(a,b));
    }
    public static long gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);

    }
    public static long lcm(int a,int b){
        return (a/gcd(a,b))*b;
    }
}
