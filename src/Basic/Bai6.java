package Basic;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap vao so n: ");
        int n=sc.nextInt();
        System.out.print(n+"=");
        for(int i=2;i<=Math.sqrt(n);i++){
            while(n%i==0){
                System.out.print(i+"x");
                n/=i;
            }
        }
        if(n>=2)
            System.out.print(n);
    }
}
