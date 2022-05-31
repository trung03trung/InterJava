package String;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập một câu: ");
        String s=sc.nextLine();
        String[] w=s.split(",*\\s+");
        for(int i=0;i< w.length-1;i++){
            for(int j=i+1;j<w.length;j++){
                if(w[i].compareTo(w[j])>0){
                    String tmp=w[i];
                    w[i]=w[j];
                    w[j]=tmp;
                }
            }
        }
        System.out.println("Các từ theo thứ tự từ điển: ");
        for(int i=0;i<w.length;i++){
            System.out.print(w[i]+" ");

        }
    }
}
