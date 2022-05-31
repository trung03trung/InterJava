package String;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập xâu họ tên: ");
        String s=sc.nextLine();
        String[] w=s.split("\\s+");
        System.out.print(w[w.length-1]+" ");
        System.out.print(w[0]+" ");
        for(int i=1;i< w.length-1;i++)
            System.out.print(w[i]+" ");
    }
}
