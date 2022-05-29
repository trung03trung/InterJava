package TeacherSalaryManagement.main;

import TeacherSalaryManagement.constant.TeacherLevel;
import TeacherSalaryManagement.entity.Subject;
import TeacherSalaryManagement.entity.Teacher;
import TeacherSalaryManagement.entity.Teaching;
import TeacherSalaryManagement.service.SubjectService;
import TeacherSalaryManagement.service.TeacherService;
import TeacherSalaryManagement.service.TeachingService;

import java.util.Scanner;

public class Main {
    public static Teacher[] teachers=new Teacher[100];
    public static Subject[] subjects=new Subject[100];
    public static Teaching[] teachings=new Teaching[100];
    public static int index=0;
    public static void main(String[] args) {
        teachers[0]=new Teacher("Le Van Trung","Vĩnh phúc","0123456", TeacherLevel.TS);
        teachers[1]=new Teacher("Tran Thi Ngoc","Hà Nội","0123434", TeacherLevel.GS_TS);
        subjects[0]=new Subject("Toan",35,30,200000);
        subjects[1]=new Subject("Tieng Anh",32,30,210000);
        while (true){
            System.out.println("-------Phần mềm quản lý trả lương cho giảng viên thỉng giảng-------");
            System.out.println("1.Nhập môn học mới");
            System.out.println("2.In ra danh sách môn học");
            System.out.println("3.Nhập giảng viên mới");
            System.out.println("4.In ra danh sách giảng viên");
            System.out.println("5.Nhập và in ra danh sách kê khai giảng dạy");
            System.out.println("6.Sắp xếp danh sách kê khai giảng dạy theo họ tên giảng viên");
            System.out.println("7.Sắp xếp danh sách kê khai giảng dạy theo số tiết giảng dạy mỗi môn");
            System.out.println("8.Tính tiền công cho mỗi giảng viên");
            System.out.println("0.Thoát");
            Scanner sc=new Scanner(System.in);
            int choice= sc.nextInt();

            switch (choice){
                case 0:System.exit(0);
                case 1:
                    SubjectService.inputNewSubject();
                    break;
                case 2:
                    SubjectService.showAllSubject();
                    break;
                case 3:
                    TeacherService.inputNewTeacher();
                    break;
                case 4:
                    TeacherService.showAllTeacher();
                    break;
                case 5:
                    TeachingService.inputNewTeaching();
                    TeachingService.showAllTeaching();
                    break;
                case 6:
                    TeachingService.sortByName();
                    TeachingService.showAllTeaching();
                    break;
                case 7:
                    TeachingService.sortByLesson();
                    TeachingService.showAllTeaching();
                    break;
                case 8:
                    TeachingService.salaryCaculator();
                    break;
                default:
                    System.out.println("Chỉ chọn từ 0 đến 8!!");
                    break;
            }

        }
    }
}
