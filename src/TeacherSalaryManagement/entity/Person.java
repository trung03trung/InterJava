package TeacherSalaryManagement.entity;

import java.util.Scanner;

public class Person implements Inputable {
    protected int id;
    protected String name;
    protected String address;
    protected String phoneNum;

    public Person() {
    }

    public Person( String name, String address, String phoneNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public void inputInfor() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập họ tên của giảng viên: ");
        name=sc.nextLine();
        System.out.print("Nhập địa chỉ của giảng viên: ");
        address=sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        phoneNum=sc.nextLine();
    }
}
