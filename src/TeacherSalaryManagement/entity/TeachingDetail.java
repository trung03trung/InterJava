package TeacherSalaryManagement.entity;

public class TeachingDetail {
    private Subject subject;
    private int numClass;

    public TeachingDetail() {
    }

    public TeachingDetail(Subject subject, int numClass) {
        this.subject = subject;
        this.numClass = numClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getNumClass() {
        return numClass;
    }

    public void setNumClass(int numClass) {
        this.numClass = numClass;
    }

    @Override
    public String toString() {
        return "TeachingDetail{" +
                "subject=" + subject +
                ", numClass=" + numClass +
                '}';
    }
}
