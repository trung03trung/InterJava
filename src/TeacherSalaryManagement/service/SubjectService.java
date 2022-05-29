package TeacherSalaryManagement.service;

import TeacherSalaryManagement.entity.Subject;
import TeacherSalaryManagement.main.Main;

public class SubjectService {
    public static void inputNewSubject(){
        Subject s=new Subject();
        s.inputInfor();
        for(int i=0;i<Main.subjects.length;i++){
            if(Main.subjects[i]==null){
                Main.subjects[i]=s;
                return;
            }
        }
    }
    public static void showAllSubject(){
        for(int i=0;i<Main.subjects.length;i++){
            if(Main.subjects[i]!=null){
                System.out.println(Main.subjects[i]);
            }
        }
    }
}
