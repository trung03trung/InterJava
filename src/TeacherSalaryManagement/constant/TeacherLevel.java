package TeacherSalaryManagement.constant;

public enum TeacherLevel {
    GS_TS("GS-TS"),
    PGS_TS("PGS-TS"),
    GV_CHINH("Giảng viên chính"),
    TS("Thạc sỹ");
    public String value;
    TeacherLevel(String value){
        this.value=value;
    }


}
