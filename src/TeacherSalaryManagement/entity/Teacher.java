package TeacherSalaryManagement.entity;

import TeacherSalaryManagement.constant.TeacherLevel;

import java.util.Scanner;

public class Teacher extends Person {
    private static int autoID=100;
    private TeacherLevel teacherLevel;

    public Teacher() {
    }

    public Teacher(String name, String address, String phoneNum, TeacherLevel teacherLevel) {
        super(name, address, phoneNum);
        this.id=Teacher.autoID++;
        this.teacherLevel = teacherLevel;
    }

    public TeacherLevel getTeacherLevel() {
        return teacherLevel;
    }

    public void setTeacherLevel(TeacherLevel teacherLevel) {
        this.teacherLevel = teacherLevel;
    }

    @Override
    public void inputInfor() {
        super.inputInfor();
        Scanner sc=new Scanner(System.in);
        this.id=Teacher.autoID++;
        System.out.println("Nhập trình độ giảng viên là 1 trong các lựa chọn dưới đây");
        System.out.println("1. GS-TS");
        System.out.println("2. PGS-TS");
        System.out.println("3. Giảng viên chính");
        System.out.println("4. Thạc sỹ");
        int choice;
        do{
            choice=sc.nextInt();
            if(choice>=1&&choice<=3)
                break;
            System.out.print("Chỉ chọn từ 1 đến 3.Mời nhập lại: ");
        }while (true);
        switch (choice){
            case 1:this.teacherLevel=TeacherLevel.GS_TS;
                    break;
            case 2:this.teacherLevel=TeacherLevel.PGS_TS;
                    break;
            case 3:this.teacherLevel=TeacherLevel.GV_CHINH;
                    break;
            case 4:this.teacherLevel=TeacherLevel.TS;
                    break;
        }

    }

    @Override
    public String toString() {
        return "Teacher{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                "teacherLevel=" + teacherLevel +
                '}';
    }
}
