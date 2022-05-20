package QLTV;

import java.util.Scanner;

public class Sach {
    private int ma;
    private String tensach;
    private String tacgia;
    private String chuyennganh;
    private String namsx;
    private static int idAuto=-1;
    public Sach(){
        if(idAuto==-1){
            idAuto=10000;
            ma=idAuto;
            return;
        }
        this.ma=++idAuto;
    }

    public Sach(int ma, String tensach, String tacgia, String chuyennganh, String namsx) {
        this.ma = ma;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.chuyennganh = chuyennganh;
        this.namsx = namsx;

    }
    public void nhapsach(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ten sach: ");
        tensach=sc.nextLine();
        System.out.print("Nhap tac gia: ");
        tacgia=sc.nextLine();
        System.out.print("Nhap chuyen nganh: ");
        chuyennganh=sc.nextLine();
        System.out.print("Nhap nam san xuat: ");
        namsx=sc.nextLine();

    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public String getNamsx() {
        return namsx;
    }

    public void setNamsx(String namsx) {
        this.namsx = namsx;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "ma=" + ma +
                ", tensach='" + tensach + '\'' +
                ", tacgia='" + tacgia + '\'' +
                ", chuyennganh='" + chuyennganh + '\'' +
                ", namsx='" + namsx + '\'' +
                '}';
    }
}
