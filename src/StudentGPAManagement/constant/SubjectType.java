package StudentGPAManagement.constant;

public enum SubjectType {
    DC("Đại cương"),
    CSN("Cơ sở ngành"),
    CN("Chuyên ngành");
    public String value;
    SubjectType(String value){
        this.value=value;
    }
}
