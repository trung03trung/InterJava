package String;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số có 6 chữ số: ");
        String s=sc.next();
        StringBuilder sb=new StringBuilder(s);
        StringBuilder sb1=new StringBuilder(s);
        sb1.reverse();
        if(sb.compareTo(sb1)==0){
            System.out.println(s+" là số thuận nghịch");
        }
        else
            System.out.println(s+" không là số thuận nghịch");
    }
}
