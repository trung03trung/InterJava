package StudentGPAManagement.entity;

import java.io.Serializable;
import java.util.Arrays;

public class GPA implements Serializable {
   private static final long serialVersionUID = 1L;
    private Student student;
    private GPADetail[] gpaDetails;

    public GPA() {
    }

    public GPA(Student student, GPADetail[] gpaDetails) {
        this.student = student;
        this.gpaDetails = gpaDetails;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public GPADetail[] getGpaDetails() {
        return gpaDetails;
    }

    public void setGpaDetails(GPADetail[] gpaDetails) {
        this.gpaDetails = gpaDetails;
    }

    @Override
    public String toString() {
        return "GPA{" +
                "student=" + student +
                ", gpaDetails=" + Arrays.toString(gpaDetails) +
                '}';
    }
}
