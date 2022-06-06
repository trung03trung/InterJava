package BusDriverManagement.service;

import BusDriverManagement.enity.Route;
import BusDriverManagement.main.Menu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RouteService {
    public static final String FILE="src/BusDriverManagement/route.dat";
    public static void inputNewRoute(){
        Route r=new Route();
        r.inputInfor();
        Menu.routes.add(r);
        IOFileService.writeFile(Menu.routes,FILE);
    }
    public static void showAllRoute(){
        for(Route i:Menu.routes)
            System.out.println(i);
    }
}
