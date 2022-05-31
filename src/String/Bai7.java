package String;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập xâu s1: ");
        String s1=sc.nextLine();
        System.out.print("Nhập xâu s2: ");
        String s2=sc.nextLine();

        while(s1.indexOf(s2)!=-1){
            s1=s1.replaceAll(s2,"") ;
        }
        System.out.println(s1);
    }
}
