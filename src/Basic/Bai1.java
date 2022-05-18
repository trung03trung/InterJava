package Basic;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap vao so nguyen n: ");
        int n=sc.nextInt();
        if(n%2!=0){
            int sum=0;
            for(int i=1;i<=n;i+=2)
                sum+=i;
            System.out.println("Tong cac so le la: "+sum);
        }
        else{
            int sum=0;
            for(int i=2;i<=n;i+=2)
                sum+=i;
            System.out.println("Tong cac so chan la: "+sum);
        }
        float sum=0;
        for(int i=1;i<=n;i++)
            sum+=(float)1/i;
        System.out.println("Tong cac so la: "+sum);
    }


}
