/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

/**
 *
 * @author gram15
 */
public class Staff {
    
    //Variables    
    private int staffID;    
    private String staffName;
    private String staffEmail;
    private String staffPhoneNumber;
    private boolean archived;
    
    
    
    public Staff(int staffID, String staffName, String staffEmail, String staffPhoneNumber, boolean archived) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.staffPhoneNumber = staffPhoneNumber;
        this.archived = archived;
    }
    
    
    
    public Staff() {
    }

    
    /**
     * Get the value of archived
     *
     * @return the value of archived
     */
    public boolean getArchived() {
        return archived;
    }

    /**
     * Set the value of archived
     *
     * @param archived new value of archived
     */
    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    /**
     * Get the value of staffID
     *
     * @return the value of staffID
     */
    public int getStaffID() {
        return staffID;
    }

    /**
     * Set the value of staffID
     *
     * @param staffID new value of staffID
     */
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    /**
     * Get the value of staffName
     *
     * @return the value of staffName
     */
    public String getStaffName() {
        return staffName;
    }
    
    /**
     * Set the value of staffName
     *
     * @param staffName new value of staffName
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * Get the value of staffEmail
     *
     * @return the value of staffEmail
     */
    public String getStaffEmail() {
        return staffEmail;
    }
    
    /**
     * Set the value of staffEmail
     *
     * @param staffEmail new value of staffEmail
     */
    public void setStaffEmail(String email) {
        this.staffEmail = staffEmail;
    }    

    
    /**
     * Get the value of staffphoneNumber
     *
     * @return the value of staffphoneNumber
     */
    public String getStaffPhoneNumber() {
        return staffPhoneNumber;
    }
    
    /**
     * Set the value of staffPhoneNumber
     *
     * @param staffPhoneNumber new value of staffPhoneNumber
     */
    public void setStaffPhoneNumber(String staffPhoneNumber) {
        this.staffPhoneNumber = staffPhoneNumber;
    }    

    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Staff{");
        sb.append(",\nstaffID=").append(staffID);
        sb.append(",\name=").append(staffName);
        sb.append(",\nemail=").append(staffEmail);
        sb.append(",\nphoneNumber=").append(staffPhoneNumber);
        sb.append(",\narchived=").append(archived);
        sb.append('}');
        return sb.toString();
    }

    

    public String saveString()
    {
        return staffID + "," + staffName + "," + staffEmail + "," + staffPhoneNumber + "," + archived;
    }
    
}
