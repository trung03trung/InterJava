package BusDriverManagement.main;



import BusDriverManagement.enity.Division;
import BusDriverManagement.enity.Driver;
import BusDriverManagement.enity.Route;
import BusDriverManagement.service.DivisionService;
import BusDriverManagement.service.DriverService;
import BusDriverManagement.service.IOFileService;
import BusDriverManagement.service.RouteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static List<Driver> drivers;
    public static List<Route> routes;
    public static List<Division> divisions=new ArrayList<>();
    public static void main(String[] args) {
        initailize();
        while (true) {
            System.out.println("-------Phần mềm quản lý điểm sinh viên-------");
            System.out.println("1.Nhập lái xe mới");
            System.out.println("2.In ra danh sách lái xe");
            System.out.println("3.Nhập tuyến mới");
            System.out.println("4.In ra danh sách tuyến");
            System.out.println("5.Nhập và in ra danh sách phân công cho mỗi lái xe");
            System.out.println("6.Sắp xếp danh sách phân công theo họ tên lái xe");
            System.out.println("7.Sắp xếp danh sách phân công theo số lượng tuyến");
            System.out.println("8.Thống kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe");
            System.out.println("0.Thoát");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    DriverService.inputNewDriver();
                    break;
                case 2:
                    DriverService.showAllDriver();
                    break;
                case 3:
                    RouteService.inputNewRoute();
                    break;
                case 4:
                    RouteService.showAllRoute();
                    break;
                case 5:
                    DivisionService.inputNewDivision();
                    DivisionService.showAllDivision();
                    break;
                case 6:
                    DivisionService.sortByName();
                    DivisionService.showAllDivision();
                    break;
                case 7:
                    DivisionService.sortByNumTurn();
                    DivisionService.sortByNumTurn();
                    break;


                default:
                    System.out.println("Chỉ chọn từ 0 đến 8!!");
                    break;
            }

        }
    }
    private static void initailize(){
        if(IOFileService.readFile(DriverService.FILE)!=null) {
            drivers = IOFileService.readFile(DriverService.FILE);
            for(Driver i:drivers)
                i.setID();
        }

        else
            drivers=new ArrayList<>();
        if(IOFileService.readFile(RouteService.FILE)!=null) {
            routes = IOFileService.readFile(RouteService.FILE);
            for(Route i:routes)
                i.setId();
        }
        else
            routes=new ArrayList<>();
        if(IOFileService.readFile(DivisionService.FILE)!=null)
            divisions=IOFileService.readFile(DivisionService.FILE);
        else
            divisions=new ArrayList<>();

    }
}
