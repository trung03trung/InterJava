package StudentGPAManagement.main;

import StudentGPAManagement.entity.GPA;
import StudentGPAManagement.entity.Student;
import StudentGPAManagement.entity.Subject;
import StudentGPAManagement.file.DataUtil;
import StudentGPAManagement.file.FileUtil;
import StudentGPAManagement.service.GPAService;
import StudentGPAManagement.service.StudentService;
import StudentGPAManagement.service.SubjectService;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {
    public static Student[] students;
    public static Subject[] subjects=new Subject[100];
    public static GPA[] gpa=new GPA[100];
    public static final String FILE = "src/StudentGPAManagement/file/student.dat";
    public static void main(String[] args) {
        initializeData();
        while (true){
            System.out.println("-------Phần mềm quản lý điểm sinh viên-------");
            System.out.println("1.Nhập sinh viên mới");
            System.out.println("2.In ra danh sách sinh viên");
            System.out.println("3.Nhập môn học mới");
            System.out.println("4.In ra danh sách môn học");
            System.out.println("5.Nhập và in ra danh sách bảng điểm của mỗi sinh viên");
            System.out.println("6.Sắp xếp danh sách bảng điểm theo họ tên sinh viên");
            System.out.println("7.Tính điểm tổng kết cho mỗi sinh viên");
            System.out.println("0.Thoát");
            Scanner sc=new Scanner(System.in);
            int choice= sc.nextInt();
            if(choice==0)
                break;
            switch (choice){
                case 1:
                    StudentService.inputNewStudent();

                    break;
                case 2:
                    StudentService.showAllStudent();
                    break;
                case 3:
                    SubjectService.inputNewSubject();
                break;
                case 4:SubjectService.showAllSubject();
                break;
                case 5:
                    GPAService.inputNewGPA();
                    GPAService.showAllGPA();
                    break;
                case 6:
                    GPAService.sortGPAByName();
                    GPAService.showAllGPA();
                    break;
                case 7:
                    GPAService.calculateGPA();
                    break;
                default:
                    System.out.println("Chỉ chọn từ 0 đến 8!!");
                    break;
            }

        }
    }
    public static void initializeData(){
           Object studentFile=FileUtil.readData(FILE);
            if(DataUtil.isNullOrEmpty(studentFile)){
            Main.students=new Student[100];
            }
            else{
                Main.students=(Student[]) studentFile;
                for(int i=0;i<Main.students.length;i++){
                    if (Main.students[i]==null)
                        break;
                    else
                        Main.students[i].setID();
                }
            }
        Object subjectFile=FileUtil.readData(SubjectService.FILE);
        if(DataUtil.isNullOrEmpty(subjectFile)){
            Main.subjects=new Subject[100];
        }
        else{
            Main.subjects=(Subject[]) subjectFile;
            for(int i=0;i<Main.students.length;i++){
                if (Main.subjects[i]==null)
                    break;
                else
                    Main.subjects[i].setID();
            }
        }
        Object gpaFile=FileUtil.readData(GPAService.FILE);
        if(DataUtil.isNullOrEmpty(gpaFile)){
            Main.gpa=new GPA[100];
        }
        else{
            Main.gpa=(GPA[]) gpaFile ;

        }


    }
}
