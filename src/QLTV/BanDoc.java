package QLTV;

import java.util.Scanner;

public class BanDoc extends Person {
    public static final String SV="Sinh vien";
    public static final String HVCH="Hoc vien cao hoc";
    public static final String GV="Giao vien";



    private String loai;

    private static int idAuto=-1;
    public BanDoc(){
        super();
        if(idAuto==-1){
            idAuto=10000;
            ma=idAuto;
            return;
        }
        this.ma=++idAuto;
    }

    public BanDoc(int ma, String hoten, String diachi, String sdt, String loai) {
        this.ma = ma;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.loai = loai;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        hoten=sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi=sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sdt=sc.nextLine();
        System.out.println("Nhap loai ban doc la 1 trong cac lua chon duoi day");
        System.out.println("1. Sinh vien");
        System.out.println("2. Hoc vien cao hoc");
        System.out.println("3. Giao vien");
        int choice=-1;
        do{
            choice=sc.nextInt();
            if(choice>=1&&choice<=3)
                break;
            System.out.println("Chi chon tu 1->3");

        }while (choice>3||choice<1);
        switch (choice){
            case 1:this.loai=BanDoc.SV;
            break;
            case 2:
                this.loai=BanDoc.HVCH;
                break;
            case 3:
                this.loai=BanDoc.GV;
                break;
        }
    }





    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        return "BanDoc{" +
                "ma=" + ma +
                ", hoten='" + hoten + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", loai='" + loai + '\'' +
                '}';
    }
}
