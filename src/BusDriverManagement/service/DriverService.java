package BusDriverManagement.service;

import BusDriverManagement.enity.Driver;
import BusDriverManagement.main.Menu;
import StudentGPAManagement.service.GPAService;
import StudentGPAManagement.service.StudentService;
import StudentGPAManagement.service.SubjectService;

import java.util.Scanner;

public class DriverService {
    public static final String FILE="src/BusDriverManagement/driver.dat";
   public static void inputNewDriver(){
       Driver d=new Driver();
       d.inputInfor();
       Menu.drivers.add(d);
       IOFileService.writeFile(Menu.drivers,FILE);
   }
   public static void showAllDriver(){
       for(Driver i:Menu.drivers)
           System.out.println(i);
   }
}
