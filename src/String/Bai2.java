package String;

import java.util.Locale;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập vào xâu ký tự: ");
        String s=sc.next();
        String tmp="";
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                tmp+=s.substring(i,i+1).toUpperCase();
            }
            else
                tmp+=s.substring(i,i+1).toLowerCase();
        }
        System.out.println("Kết quả: "+tmp);
    }
}
