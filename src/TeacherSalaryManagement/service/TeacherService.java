package TeacherSalaryManagement.service;

import TeacherSalaryManagement.entity.Teacher;
import TeacherSalaryManagement.main.Main;

public class TeacherService {
    public static void inputNewTeacher(){
        Teacher t=new Teacher();
        t.inputInfor();
        for(int i=0;i< Main.teachers.length;i++){
            if(Main.teachers[i]==null){
                Main.teachers[i]=t;
                return;
            }
        }
    }
    public static void showAllTeacher(){
        for(int i=0;i<Main.teachers.length;i++){
            if(Main.teachers[i]!=null){
                System.out.println(Main.teachers[i]);
            }
        }
    }

}
