package BusDriverManagement.service;

import BusDriverManagement.enity.Division;
import BusDriverManagement.enity.DivisionDetail;
import BusDriverManagement.enity.Driver;
import BusDriverManagement.enity.Route;
import BusDriverManagement.main.Menu;

import java.util.*;
import java.util.stream.Collectors;

public class DivisionService {
    public static final String FILE="src/BusDriverManagement/division.dat";
    public static void inputNewDivision() {
        if (Menu.routes.isEmpty() || Menu.drivers.isEmpty()) {
            System.out.println("Không có dữ liệu lái xe hoặc tuyến!!!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        int driverID;
        System.out.print("Nhập mã lái xe: ");
        do {
            try {
                driverID = Integer.parseInt(sc.next());
                if (searchDriverByID(driverID) != null)
                    break;
                System.out.print("Mã lái xe không tồn tại vui lòng nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("Mã lái xe phải là số nguyên dương vui lòng nhập lại: ");
            }
        } while (true);

        int n;
        System.out.print("Nhập số lượng tuyến muốn thêm: ");
        do {
            try {
                n = Integer.parseInt(sc.next());
                if (n > 0)
                    break;
                System.out.print("Số lượng tuyến phải là số nguyên dương: ");
            } catch (NumberFormatException e) {
                System.out.print("Mã lái xe phải là số nguyên dương vui lòng nhập lại: ");
            }
        } while (true);

        List<DivisionDetail> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            System.out.print("Nhập mã tuyến thứ "+(i+1)+" muốn thêm: ");
            int routeID;
            do {
            try {
                routeID = Integer.parseInt(sc.next());
                if (searchRouteByID(routeID)!=null&&checkSameID(list,routeID))
                    break;
                System.out.print("Mã tuyến không tồn tại hoặc bị trùng vui lòng nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("Mã tuyến phải là số nguyên dương vui lòng nhập lại: ");
            }
             } while (true);
            System.out.print("Nhập số lượt: ");
         int numTurn;
            do {
                try {
                    numTurn = Integer.parseInt(sc.next());
                    if (numTurn>0&&numTurn<=15)
                        break;
                    System.out.print("Số lượt không vượt quá 15 vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Số lượt là số nguyên dương vui lòng nhập lại: ");
                }
            } while (true);
            DivisionDetail d=new DivisionDetail();
            d.setRoutes(searchRouteByID(routeID));
            d.setNumTurn(numTurn);
            list.add(d);
       }
        Division di=new Division();
        di.setDriver(searchDriverByID(driverID));
        di.setDivisionDetails(list);
        Menu.divisions.add(di);
        IOFileService.writeFile(Menu.divisions,FILE);
    }
    private static Driver searchDriverByID(int id){
        for(Driver i:Menu.drivers){
            if(i.getId()==id)
                return i;
        }
        return null;
    }
    private static Route searchRouteByID(int id){
        for(Route i:Menu.routes){
            if(i.getId()==id)
                return i;
        }
        return null;
    }
    private static boolean checkSameID(List<DivisionDetail> list,int id){
        for(DivisionDetail i:list) {
            if (i.getRoutes().getId() == id)
                return false;
        }
        return true;

    }
    public  static void showAllDivision(){
        for (Division i:Menu.divisions)
            System.out.println(i);
    }
    public static void sortByName(){
        Collections.sort(Menu.divisions, new Comparator<Division>() {
            @Override
            public int compare(Division o1, Division o2) {
                return o1.getDriver().getName().compareTo(o2.getDriver().getName());
            }
        });
    }
    public static void sortByNumTurn(){
        Collections.sort(Menu.divisions, new Comparator<Division>() {
            @Override
            public int compare(Division o1, Division o2) {
                int sum1=0,sum2=0;
                for(DivisionDetail i:o1.getDivisionDetails()){
                    sum1+=i.getNumTurn();
                }
                for(DivisionDetail i:o2.getDivisionDetails()){
                    sum2+=i.getNumTurn();
                }

                return sum2>sum1? 0:-1;
            }
        });
    }
    public static void statistic(){

    }
}
