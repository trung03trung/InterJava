package StudentGPAManagement.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int autoId=10000;
    private String classes;

    public Student() {
    }
    public void setID(){
        this.id=autoId++;
    }
    public Student(int id, String name, String address, String phoneNum, String classes) {
        super(id, name, address, phoneNum);
        this.classes = classes;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public void inputInfor() {
        Scanner sc=new Scanner(System.in);
        this.id=Student.autoId++;
        super.inputInfor();
        System.out.print("Nhập tên lớp: ");
        this.classes=sc.nextLine();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
