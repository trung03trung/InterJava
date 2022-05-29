package TeacherSalaryManagement.service;

import TeacherSalaryManagement.entity.Subject;
import TeacherSalaryManagement.entity.Teacher;
import TeacherSalaryManagement.entity.Teaching;
import TeacherSalaryManagement.entity.TeachingDetail;
import TeacherSalaryManagement.main.Main;

import java.util.Scanner;

public class TeachingService {
    public static void inputNewTeaching(){
        if(!checkData()){
            System.out.println("Chưa có dữ liệu sách hoặc giáo viên");
            return;
        }
        Scanner sc=new Scanner(System.in);
        int teacherID;
        do {
            System.out.print("Nhập mã giảng viên: ");
            teacherID=sc.nextInt();
            if(searchTeacherByID(teacherID)!=null)
                break;
            System.out.println("Mã giảng viên không tồn tại.Mời nhập lại!!");
        }while (true);
        System.out.print("Nhập số lượng môn học muốn thêm: ");
        int n=sc.nextInt();
        TeachingDetail[] teachingDetails=new TeachingDetail[n];
        for(int i=0;i<n;i++){
            int subjectID;
            do {
                System.out.print("Nhập mã môn học thứ "+(i+1)+" muốn thêm: ");
                subjectID=sc.nextInt();
                if(checkSameID(teachingDetails,subjectID)&&searchSubjectByID(subjectID)!=null)
                    break;
                System.out.println("Mã môn học bị trùng hoặc không tồn tại mã môn học.Mời nhập lại!!");

            }while (true);
            int numClass;
            do{
                System.out.print("Nhập số lớp giảng dạy: ");
                numClass=sc.nextInt();
                if(numClass<=3&&countLesson(teachingDetails)+(numClass*searchSubjectByID(subjectID).getLesson())<=200)
                    break;
                System.out.println("Số lớp không được lớn hơn 3 và không được quá 200 tiết học!!");
            }while (true);
            TeachingDetail t=new TeachingDetail(searchSubjectByID(subjectID),numClass);
            teachingDetails[i]=t;

        }
        for(int i=0;i<Main.teachings.length;i++){
            if(Main.teachings[i]==null){
                Main.teachings[i]=new Teaching(searchTeacherByID(teacherID),teachingDetails);
                break;
            }
        }

    }
    private static boolean checkData(){
        boolean checkTeacher=false;
        boolean checkSubject=false;
        for(int i=0;i<Main.teachers.length;i++){
            if(Main.teachers[i]!=null) {
                checkTeacher = true;
                break;
            }
        }
        for(int i=0;i<Main.subjects.length;i++){
            if(Main.subjects[i]!=null) {
                checkSubject = true;
                break;
            }
        }
        return checkSubject&&checkTeacher;
    }
    private static boolean checkDataTeaching(){

        for(int i=0;i<Main.teachings.length;i++){
            if(Main.teachings[i]!=null){
                return true;
            }
        }
        return false;
    }
    private static Teacher searchTeacherByID(int id){
        for(int i=0;i<Main.teachers.length;i++){
            if(Main.teachers[i]!=null) {
                if (Main.teachers[i].getId() == id)
                    return Main.teachers[i];
            }
        }
        return null;
    }
    private static Subject searchSubjectByID(int id){
        for(int i=0;i<Main.subjects.length;i++){
            if(Main.subjects[i]!=null) {
                if (Main.subjects[i].getId() == id)
                    return Main.subjects[i];
            }
        }
        return null;
    }
    private static boolean checkSameID(TeachingDetail[] td,int id){
        for(int i=0;i<td.length;i++){
            if(td[i]!=null){
                if(td[i].getSubject().getId()==id)
                    return false;
            }
        }
        return true;
    }
    private static int countLesson(TeachingDetail[] td){
        int count=0;
        for(int i=0;i< td.length;i++){
            if(td[i]!=null)
                count+=(td[i].getSubject().getLesson()*td[i].getNumClass());

        }
        return count;
    }

    public static void showAllTeaching(){
        for(int i=0;i<Main.teachings.length;i++){
            if(Main.teachings[i]!=null)
                System.out.println(Main.teachings[i]);
        }
    }
    public static void sortByName(){
        if(!checkDataTeaching()){
            System.out.println("Chưa có dữ liệu giảng dạy");
            return;
        }
        for(int i=0;i<Main.teachings.length-1;i++){
            Teaching ti=Main.teachings[i];
            if(ti!=null){
                for(int j=i+1;j<Main.teachings.length;j++){
                    Teaching tj=Main.teachings[j];
                    if(tj!=null) {
                        if (ti.getTeacher().getName().compareTo(tj.getTeacher().getName()) > 0) {
                            Teaching tmp = ti;
                            Main.teachings[i] = Main.teachings[j];
                            Main.teachings[j] = ti;
                        }
                    }
                }

            }
        }
    }
    public static void sortByLesson(){
        if(!checkDataTeaching()){
            System.out.println("Chưa có dữ liệu giảng dạy");
            return;
        }
        for(int i=0;i<Main.teachings.length-1;i++){
            Teaching ti=Main.teachings[i];
            if(ti!=null){
                for(int j=i+1;j<Main.teachings.length;j++){
                    Teaching tj=Main.teachings[j];
                    if(tj!=null) {
                        if (countLesson(ti.getTeachingDetails())<countLesson(tj.getTeachingDetails())) {
                            Teaching tmp = ti;
                            Main.teachings[i] = Main.teachings[j];
                            Main.teachings[j] = ti;
                        }
                    }
                }

            }
        }
    }
    public static void salaryCaculator(){
        if(!checkDataTeaching()){
            System.out.println("Chưa có dữ liệu giảng dạy");
            return;
        }

        for(int i=0;i<Main.teachings.length;i++){
            double salary=0;
            Teaching ti=Main.teachings[i];
            if(ti!=null) {
                for (int j = 0; j < ti.getTeachingDetails().length; j++) {
                    TeachingDetail td = ti.getTeachingDetails()[j];
                    if(td!=null) {
                        int p = td.getSubject().getSumLesson() - td.getSubject().getLesson();
                        double costp =  td.getSubject().getCost() * (7.0 / 10.0);
                        salary += td.getNumClass() * (td.getSubject().getLesson() * td.getSubject().getCost()+p*costp);
                    }
                }
                System.out.println("Giảng viên "+ti.getTeacher().getName()+" có tiền lương là: "+salary);
            }

        }
    }

}
