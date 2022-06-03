package StudentGPAManagement.service;

import StudentGPAManagement.entity.Student;
import StudentGPAManagement.file.FileUtil;
import StudentGPAManagement.main.Main;

import java.io.*;

public class StudentService {
   public static final String FILE = "src/StudentGPAManagement/file/student.dat";
   public static void inputNewStudent(){
      Student s=new Student();
      s.inputInfor();
      for(int i=0;i<Main.students.length;i++){
         if(Main.students[i]==null){
            Main.students[i]=s;
            break;
         }
      }
      FileUtil.writeData(Main.students,FILE);

   }
   public static void showAllStudent(){

         for (int i = 0; i < Main.students.length; i++) {
            if (Main.students[i] != null)
               System.out.println(Main.students[i]);


         }

   }

}
