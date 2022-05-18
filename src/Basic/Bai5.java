package Basic;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=Integer.parseInt(s.substring(i,i+1));

        }
        System.out.println("Tong cac chu so la: "+sum);
    }
}
