package StudentGPAManagement.service;

import StudentGPAManagement.entity.Subject;
import StudentGPAManagement.file.FileUtil;
import StudentGPAManagement.main.Main;

public class SubjectService {
    public static final String FILE="src/StudentGPAManagement/file/subject.dat";
    public static void inputNewSubject(){
        Subject s=new Subject();
        s.inputInfor();
        for(int i=0;i< Main.subjects.length;i++){
            if(Main.subjects[i]==null){
                Main.subjects[i]=s;
                break;
            }
        }
        FileUtil.writeData(Main.subjects,FILE);
    }
    public static void showAllSubject(){
        for(int i=0;i<Main.subjects.length;i++){
            if(Main.subjects[i]!=null)
                System.out.println(Main.subjects[i]);
        }
    }
}
