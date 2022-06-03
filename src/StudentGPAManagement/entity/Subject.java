package StudentGPAManagement.entity;

import StudentGPAManagement.constant.SubjectType;
import TeacherSalaryManagement.entity.Teacher;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements Inputable, Serializable {
    private static final long serialVersionUID = 1L;
    private static int autoID=100;

    private int id;
    private String name;
    private int credit;
    private SubjectType type;

    public Subject() {
    }

    public Subject(int id, String name, int credit, SubjectType type) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public void setID(){
        this.id=autoID++;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public SubjectType getType() {
        return type;
    }

    public void setType(SubjectType type) {
        this.type = type;
    }

    @Override
    public void inputInfor() {
        this.id=Subject.autoID++;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên môn học: ");
        name = sc.nextLine();
        System.out.print("Nhập số đơn vị học trình: ");
        do {

            try {

                credit = Integer.parseInt(sc.next());
                if(credit>0){
                    break;
                }
                System.out.print("Chỉ nhập số nguyên dương, mời nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.println("Chỉ nhập số nguyên vui lòng nhập lại: ");
            }

        } while (true);

        System.out.println("Nhập loại môn là 1 trong các lựa chọn dưới đây");
        System.out.println("1.Đại cương");
        System.out.println("2.Cơ sở ngành");
        System.out.println("3.Chuyên ngành");
        int choice;
        do {
            try {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 3)
                    break;
                System.out.print("Chỉ nhập từ 1 đến 3.Mời nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.println("Chỉ nhập số");
            }

        } while (true);
        switch (choice) {
            case 1:
                this.type = SubjectType.DC;
                break;
            case 2:
                this.type = SubjectType.CSN;
                break;
            case 3:
                this.type = SubjectType.CN;
                break;
        }


    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", type=" + type +
                '}';
    }
}
