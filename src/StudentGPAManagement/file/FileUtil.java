package StudentGPAManagement.file;

import StudentGPAManagement.main.Main;

import java.io.*;

public class FileUtil {
    public static void writeData(Object[] obj,String filename){
        if(DataUtil.isNullOrEmptyArray(obj))
            return;
        try {
            ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(obj);
            output.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static Object readData(String filename){
        try(ObjectInputStream input=new ObjectInputStream(new FileInputStream(filename))) {
            return input.readObject();
        }catch (IOException e){
            System.out.println(e);
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }
        return null;
    }
}
