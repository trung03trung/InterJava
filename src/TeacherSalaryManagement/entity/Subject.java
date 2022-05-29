package TeacherSalaryManagement.entity;

import java.util.Scanner;

public class Subject implements Inputable {
    private static int autoID=100;

    private int id;
    private String name;
    private int sumLesson;
    private int lesson;
    private int cost;

    public Subject() {
    }

    public Subject(String name, int sumLesson, int lesson, int cost) {
        this.id = Subject.autoID++;
        this.name = name;
        this.sumLesson = sumLesson;
        this.lesson = lesson;
        this.cost = cost;
    }

    public static int getAutoID() {
        return autoID;
    }

    public static void setAutoID(int autoID) {
        Subject.autoID = autoID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumLesson() {
        return sumLesson;
    }

    public void setSumLesson(int sumLesson) {
        this.sumLesson = sumLesson;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public void inputInfor() {
        this.id=Subject.autoID++;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập tên môn học: ");
        name=sc.nextLine();
        System.out.print("Nhập tổng số tiết học: ");
        sumLesson=sc.nextInt();
        System.out.print("Nhập số tiết lý thuyết: ");
        lesson=sc.nextInt();
        System.out.print("Nhập mức kinh phí: ");
        cost=sc.nextInt();

    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sumLesson=" + sumLesson +
                ", lesson=" + lesson +
                ", cost=" + cost +
                '}';
    }

}
