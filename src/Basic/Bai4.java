package Basic;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap 2 so: ");
        int a=sc.nextInt();
        int b= sc.nextInt();
        for(int i=a;i<b;i++){
            for(int j=i+1;j<=b;j++){
                if(gcd(i,j)==1)
                    System.out.println(i+" "+j);
            }
        }
    }
    public static long gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);

    }
}
