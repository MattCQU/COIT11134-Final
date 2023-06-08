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
    private String name;
    private String email;
    private String phoneNumber;
    private boolean archived;
    
    
    
    public Staff(int staffID, String name, String email, String phoneNumber, boolean archived) {
        this.staffID = staffID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }    

    
    /**
     * Get the value of phoneNumber
     *
     * @return the value of phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Set the value of phoneNumber
     *
     * @param phoneNumber new value of phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }    

    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Staff{");
        sb.append(",\nstaffID=").append(staffID);
        sb.append(",\name=").append(name);
        sb.append(",\nemail=").append(email);
        sb.append(",\nphoneNumber=").append(phoneNumber);
        sb.append(",\narchived=").append(archived);
        sb.append('}');
        return sb.toString();
    }

    

    public String saveString()
    {
        return staffID + "," + name + "," + email + "," + phoneNumber + "," + archived;
    }
    
}
