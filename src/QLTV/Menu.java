package QLTV;

import java.util.Locale;
import java.util.Scanner;

public class Menu {
   private static BanDoc[] b=new BanDoc[100];
   private static Sach[] s=new Sach[100];
   private static QLMuonSach[] ql=new QLMuonSach[100];
   private static Scanner sc=new Scanner(System.in);
   private static int indexql=0;
    public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);

            int indexb=0;
            int indexs=0;
            BanDoc b3=new BanDoc();
            b3.setHoten("Le Van Trung");
            b3.setDiachi("Vinh phuc");
            b3.setSdt("1234567");
            b3.setLoai("Sinh vien");
            b[indexb++]=b3;
        BanDoc b4=new BanDoc();
        b4.setHoten("Nguyen Tien Dai");
        b4.setDiachi("Phu Tho");
        b4.setSdt("1234567");
        b4.setLoai("Sinh vien");
        b[indexb++]=b4;
        Sach s3=new Sach();
        s3.setTensach("OOP");
        s3.setTacgia("Trung");
        s3.setChuyennganh("CNTT");
        s3.setNamsx("2019");
        s[indexs++]=s3;
        Sach s4=new Sach();
        s4.setTensach("Kinh doanh");
        s4.setTacgia("Truong");
        s4.setChuyennganh("KT");
        s4.setNamsx("2020");
        s[indexs++]=s4;

            while(true){
                System.out.println("------MENU-------");
                System.out.println("1. nhap ban doc");
                System.out.println("2. Nhap sach ");
                System.out.println("3. In ra ds ban doc");
                System.out.println("4. In ra ds sach");
                System.out.println("5. Lap phieu muon");
                System.out.println("6. Sap xep theo ten ban doc");
                System.out.println("7. Sap xep theo so luong sach duoc muon giam dan");
                System.out.println("8. Tim kiem muon sac theo ten ban doc");
                System.out.println("0. Thoat");
                System.out.println("-----------------");
                System.out.print("Ban chon (0->10):");
                int chon=sc.nextInt();
                switch (chon){
                    case 0:System.out.println("BYE!!!");
                        System.exit(0);
                    case 1:BanDoc bd=new BanDoc();
                            bd.nhap();
                            b[indexb]=bd;
                            indexb++;
                            break;
                    case 2:Sach sa=new Sach();
                            sa.nhapsach();
                            s[indexs]=sa;
                            indexs++;
                            break;
                    case 3:
                        System.out.println("Ds ban doc");
                        for(int i=0;i<indexb;i++)
                            System.out.println(b[i].toString());
                        break;
                    case 4:
                        System.out.println("Ds sach");
                        for(int i=0;i<indexs;i++)
                            System.out.println(s[i].toString());
                        break;
                    case 5:
                        creatRent();
                        xuatQLMS();
                        break;
                    case 6:
                        sxtheoTenBD();
                        xuatQLMS();
                        break;
                    case 7:
                        sxTheoSL();
                        xuatQLMS();
                        break;
                    case 8:
                        searchByName();
                        break;

                    default:
                        System.out.println("Chi chon tu 0->8");
                        break;
                }

            }

    }
    private static boolean checkData() {
        boolean coDuLieuBD = false;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {
                coDuLieuBD = true;
                break;
            }
        }
        boolean coDuLieuSach = false;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                coDuLieuSach = true;
                break;
            }
        }
        return coDuLieuBD && coDuLieuSach;
    }
    public  static BanDoc searchBdByid(int ma){
        for(int i=0;i< b.length;i++){
            if(b[i]!=null) {
                if (b[i].getMa() == ma)
                    return b[i];
            }
        }
        return null ;
    }
    public static Sach searchSachByid(int ma) {
        for (int i = 0; i < s.length; i++) {
            if (b[i] != null) {
                if (s[i].getMa() == ma)
                    return s[i];
            }
        }

        return null;
    }
    private static boolean ktraTrungma(int ma,MuonSach[] ms){
        for(int i=0;i< ms.length;i++){
            if(ms[i]!=null) {
                if (ma == ms[i].getSach().getMa())
                    return false;
            }

        }
        return true;
    }
    public static void creatRent(){
        QLMuonSach q=new QLMuonSach();
        if(!checkData()){
            System.out.println("Chua co du lieu ban doc va sach");
            return;
        }

        Scanner sc=new Scanner(System.in);
        int mabd;
        BanDoc b1;
        do{
            System.out.print("Nhap ma ban doc muon them: ");
            mabd=sc.nextInt();
             b1=searchBdByid(mabd);
            if(b1!=null)
                break;
            System.out.println("Ma ban doc khong ton tai.Moi nhap lai!!!");

        }while(true);
        q.setBanDoc(b1);

        int n;
        do{
            System.out.print("Nhap so luong dau sach muon muon: ");
            n=sc.nextInt();
            if(n<=5)
                break;
            System.out.println("So luong dau sach phai nho hon 5");

        }while (true);
        MuonSach[] ms=new MuonSach[n];

        for(int i=0;i<n;i++){

            int masach;
            do {
                System.out.print("Nhap ma sach thu "+(i+1)+" muon them: ");
                masach=sc.nextInt();
                if(searchSachByid(masach)!=null&&ktraTrungma(masach,ms))
                    break;
                System.out.println("Ma sach khong ton tai hoac bi trung.Moi nhap lai");
            }while (true);
            Sach s=searchSachByid(masach);
            MuonSach m=new MuonSach();
            m.setSach(s);
            int sl;
            do {
                System.out.print("Nhap so luong sach: ");
                sl=sc.nextInt();
                if(sl<=3)
                    break;
                System.out.println("So luong sach khong duoc lon hon 3");
            }while (true);

            m.setSoluong(sl);
            ms[i]=m;

        }
        q.setMuonSach(ms);
        ql[indexql]=q;
        indexql++;

    }
    public static void xuatQLMS(){
        for(int i=0;i<ql.length;i++){
            if(ql[i]!=null){
                System.out.println("Ban doc "+ql[i].getBanDoc().getHoten()+" da muon cac sach: ");
                for(int j=0;j<ql[i].getMuonSach().length;j++){
                    System.out.println(ql[i].getMuonSach()[j].getSach().getTensach()+"  So luong: "+ql[i].getMuonSach()[j].getSoluong());
                }
            }
        }

    }
    public static void sxtheoTenBD(){
        boolean checkData=false;
        for(int i=0;i<ql.length;i++){
            if(ql[i]!=null){
                checkData=true;
                break;
            }
        }
        if(!checkData){
            System.out.println("Chua co du lieu ve phieu muon nao,vui long tao phieu muon truoc khi nhap!!!");
            return;
        }
        for(int i=0;i<indexql-1;i++){
            for(int j=i+1;j<indexql;j++){
                if(ql[i].getBanDoc().getHoten().compareTo(ql[j].getBanDoc().getHoten())>0){
                    QLMuonSach tmp=ql[i];
                    ql[i]=ql[j];
                    ql[j]=tmp;
                }
            }
        }
    }
    public static int getTongSl(QLMuonSach ql){
        int sum=0;
        for(int i=0;i<ql.muonSach.length;i++){
           MuonSach ms=ql.getMuonSach()[i];
            if(ms!=null){
                sum+=ms.getSoluong();
            }
        }
        return sum;
    }
    public static void sxTheoSL(){
        boolean checkData=false;
        for(int i=0;i<ql.length;i++){
            if(ql[i]!=null){
                checkData=true;
                break;
            }
        }
        if(!checkData){
            System.out.println("Chua co du lieu ve phieu muon nao,vui long tao phieu muon truoc khi nhap!!!");
            return;
        }
        for(int i=0;i<indexql-1;i++){
            for(int j=i+1;j<indexql;j++){
                if(getTongSl(ql[i])<getTongSl(ql[j])){
                    QLMuonSach tmp=ql[i];
                    ql[i]=ql[j];
                    ql[j]=tmp;
                }
            }
        }
    }
    public static void searchByName(){
        System.out.print("Nhap ten ban doc muon tim kiem: ");
        Scanner sc=new Scanner(System.in);
        String keyword=sc.nextLine();
        boolean c=false;
        for(int i=0;i<indexql;i++){
            if(ql[i].getBanDoc().getHoten().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(ql[i]);
                c=true;
            }

        }
        if(c==false)
            System.out.println("Khong tim thay ban doc nao!!!");
    }
}
