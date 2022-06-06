package BusDriverManagement.service;

import BusDriverManagement.main.Menu;

import java.io.*;
import java.util.List;

public class IOFileService {
    public static <T> void  writeFile(List<T> list,String file){
        try {
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream(file));
            o.writeObject(list);
            o.close();
        }catch (IOException e){
            System.out.println(e);
        }

    }
    public static <T> List<T> readFile(String file){
        try (ObjectInputStream o=new ObjectInputStream(new FileInputStream(file))){
            return (List<T>) o.readObject();
        }catch (IOException e){
            System.out.println(e);
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }
        return null;
    }
}
