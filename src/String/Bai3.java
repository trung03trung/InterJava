package String;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập chuỗi để chuẩn hóa: ");
        String s=sc.nextLine();
        s=s.trim();

        String[] w=s.split("\\s+");
        String result="";
        for(int i=0;i<w.length;i++){
            result+=(w[i].substring(0,1).toUpperCase()+w[i].substring(1).toLowerCase()+" ");
        }
        System.out.println(result);
    }
}
