package lk.viyanga.studms.dto.student;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
public class GuardianDTO {

    private int guardianId;
    private String guardianName;
    private String guardianNIC;
    private String guardianContactNumber;

    @Override
    public String toString() {
        return "GuardianDTO{" +
                "guardianId=" + guardianId +
                ", guardianName='" + guardianName + '\'' +
                ", guardianNIC='" + guardianNIC + '\'' +
                ", guardianContactNumber='" + guardianContactNumber + '\'' +
                '}';
    }

    public int getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(int guardianId) {
        this.guardianId = guardianId;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianNIC() {
        return guardianNIC;
    }

    public void setGuardianNIC(String guardianNIC) {
        this.guardianNIC = guardianNIC;
    }

    public String getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public void setGuardianContactNumber(String guardianContactNumber) {
        this.guardianContactNumber = guardianContactNumber;
    }
}
