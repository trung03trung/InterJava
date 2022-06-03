package StudentGPAManagement.entity;

import java.io.Serializable;

public class GPADetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Subject subject;
    private float mark;
    public GPADetail(){

    }

    public GPADetail(Subject subject, float mark) {
        this.subject = subject;
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "GPADetail{" +
                "subject=" + subject +
                ", mark=" + mark +
                '}';
    }
}
