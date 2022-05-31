package String;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập xâu ký tự: ");
        String s=sc.nextLine();
        String[] w=s.split("\\s+");
        int[] count=new int[w.length];
        for(int i=0;i<w.length;i++)
            count[i]=w[i].length();
        int index=0,max=count[0],index2=-1;
        for(int i=1;i< w.length;i++){
            if(max<count[i]){
                max=count[i];
                index=i;
            }
        }
        for(int i=0;i<w.length;i++){
            if(max==count[i]&&i!=index)
                index2=i;
        }
        if(index2==-1){
            System.out.println("Từ có độ dài dài nhất là từ: "+w[index]+"\nở vị trí: "+(index+1));
        }
        else{
            if(w[index].compareTo(w[index2])>0)
                System.out.println("Từ có độ dài dài nhất là từ: "+w[index2]+"\nở vị trí: "+(index2+1));
            else{
                System.out.println("Từ có độ dài dài nhất là từ: "+w[index]+"\nở vị trí: "+(index+1));
            }
        }
    }
}
