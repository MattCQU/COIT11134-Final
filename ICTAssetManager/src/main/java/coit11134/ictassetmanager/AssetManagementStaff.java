/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.ictassetmanager;

/**
 *
 * @author Matt
 */
public class AssetManagementStaff extends StaffRecords{
    
    private String password;
    private boolean canLogin;

    public AssetManagementStaff(String password, boolean canLogin, int staffID, String name, String email, String phoneNumber, boolean archived) {
        super(staffID, name, email, phoneNumber, archived);
        this.password = password;
        this.canLogin = canLogin;
    }

    public AssetManagementStaff() {
    }
    
    

    /**
     * Get the value of canLogin
     *
     * @return the value of canLogin
     */
    public boolean isCanLogin() {
        return canLogin;
    }

    /**
     * Set the value of canLogin
     *
     * @param canLogin new value of canLogin
     */
    public void setCanLogin(boolean canLogin) {
        this.canLogin = canLogin;
    }


    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AssetManagementStaff{");
        sb.append("password=").append(password);
        sb.append(", canLogin=").append(canLogin);
        sb.append('}');
        return sb.toString();
    }

    
    
}
