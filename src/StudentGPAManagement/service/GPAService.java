package StudentGPAManagement.service;

import StudentGPAManagement.entity.GPA;
import StudentGPAManagement.entity.GPADetail;
import StudentGPAManagement.entity.Student;
import StudentGPAManagement.entity.Subject;
import StudentGPAManagement.file.FileUtil;
import StudentGPAManagement.main.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GPAService {
    public static final String FILE = "src/StudentGPAManagement/file/gpa.dat";
    public static void inputNewGPA(){
        Scanner sc=new Scanner(System.in);
        if(!checkData()){
            System.out.println("Chưa có dữ liệu sinh viên hoặc môn học!!");
            return;
        }
        System.out.print("Nhập mã sinh viên muốn thêm: ");
        int studentID;
        do {
            try {


                studentID = Integer.parseInt(sc.next());
                if (searchStudentByID(studentID) != null)
                    break;
                System.out.print("Mã sinh viên không tồn tại vui lòng nhập lại: ");
            }catch (NumberFormatException e){
                System.out.print("Mã sinh viên phải là số vui lòng nhập lại: ");
            }
        }while (true);
        int n;
        System.out.print("Nhập số lượng môn học muốn thêm: ");
        do{
            try {
                n = Integer.parseInt(sc.next());
                if (n > 0)
                    break;
                System.out.print("Số lượng môn học phải là số nguyên dương vui lòng nhập lại: ");
            }catch (NumberFormatException e){
                System.out.print("Số lượng môn học phải là số nguyên dương vui lòng nhập lại: ");
            }
        }while (true);
        GPADetail[] gpaDetails=new GPADetail[n];
        for(int i=0;i<n;i++) {
            System.out.print("Nhập mã môn học thứ " + (i + 1) + " : ");
            int subjectID;
            do {
                try {


                    subjectID = Integer.parseInt(sc.next());
                    if (searchSubjectByID(subjectID) != null && checkSameSubject(gpaDetails, subjectID))
                        break;
                    System.out.print("Mã môn học không tồn tại hoặc bị trùng vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Mã môn phải là số nguyên dương vui lòng nhập lại: ");
                }
            } while (true);

            float mark;
            System.out.print("Nhập điểm số của môn học thứ " + (i + 1) + " : ");
            do {
                try {
                    mark = Float.parseFloat(sc.next());
                    if (mark >= 0&&mark<=10)
                        break;
                    System.out.print("Điểm số phải là số dương vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Điểm số phải là số dương vui lòng nhập lại: ");
                }
            }while (true);
            GPADetail g=new GPADetail();
            g.setSubject(searchSubjectByID(subjectID));
            g.setMark(mark);
            gpaDetails[i]=g;

        }
        for(int i=0;i<Main.gpa.length;i++) {
            if (Main.gpa[i] == null) {
                GPA gp=new GPA(searchStudentByID(studentID),gpaDetails);
                Main.gpa[i]=gp;
                break;
            }
        }
        FileUtil.writeData(Main.gpa,FILE);



    }
    private static boolean checkData(){
        boolean checkStudent=false;
        boolean checkSubject=false;
        for(int i=0;i< Main.students.length;i++){
            if(Main.students[i]!=null){
                checkStudent=true;
                break;
            }
        }
        for(int i=0;i<Main.subjects.length;i++){
            if(Main.subjects[i]!=null){
                checkSubject=true;
                break;
            }
        }
        return checkStudent&&checkSubject;
    }
    private static Student searchStudentByID(int id){
        for(int i=0;i<Main.students.length;i++){
                if(Main.students[i]!=null){
                    if(Main.students[i].getId()==id)
                        return Main.students[i];
                }
        }
        return null;
    }
    private static Subject searchSubjectByID(int id){
        for(int i=0;i<Main.subjects.length;i++){
            if(Main.subjects[i]!=null){
                if(Main.subjects[i].getId()==id)
                    return Main.subjects[i];
            }
        }
        return null;
    }
    private static boolean checkSameSubject(GPADetail[] subjects, int id){
        for(int i=0;i<subjects.length;i++){
            if(subjects[i]!=null) {
                if (subjects[i].getSubject().getId() == id)
                    return false;
            }
        }
        return true;
    }
    public static void showAllGPA(){
        for(int i=0;i<Main.gpa.length;i++){
            if(Main.gpa[i]!=null)
                System.out.println(Main.gpa[i]);
        }
    }
    public static void sortGPAByName(){
        for(int i=0;i<Main.gpa.length-1;i++){
           GPA gi=Main.gpa[i];
            if(gi!=null){
                for (int j=i+1;j<Main.gpa.length;j++){
                    GPA gj=Main.gpa[j];
                    if(gj!=null){
                        if(gi.getStudent().getName().compareTo(gj.getStudent().getName())>0){
                            GPA tmp=gi;
                            Main.gpa[i]=gj;
                            Main.gpa[j]=tmp;
                        }
                    }
                }
            }
        }
        FileUtil.writeData(Main.gpa,FILE);
    }
    public static void calculateGPA(){
        for(int i=0;i<Main.gpa.length;i++){
            if(Main.gpa[i]!=null){
                float gpa=0;
                int credit=0;
                for(int j=0;j<Main.gpa[i].getGpaDetails().length;j++){
                    credit+=(Main.gpa[i].getGpaDetails()[j].getSubject().getCredit());
                    gpa+=(Main.gpa[i].getGpaDetails()[j].getMark()*Main.gpa[i].getGpaDetails()[j].getSubject().getCredit());

                }
                System.out.println("Sinh vien "+Main.gpa[i].getStudent().getName()+" có gpa là: "+((float)gpa/credit));
            }
        }
    }

}
