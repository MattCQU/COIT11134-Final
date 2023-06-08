/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

public class AssetManager extends StaffRecords{
    
    private String password;
    private boolean canLogin;

    public AssetManager (int staffID, String staffName, String staffEmail, String staffPhoneNumber, boolean archived, String password, boolean canLogin) {
        super(staffID, staffName, staffEmail, staffPhoneNumber, archived);
        this.password = password;
        this.canLogin = canLogin;
    }

    public AssetManager() {
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
        sb.append("AssetMannager{");
        sb.append("password=").append(password);
        sb.append(", canLogin=").append(canLogin);
        sb.append('}');
        return sb.toString();
    }

    
   
    public String saveString()
    {
        String modify = super.saveString();
        StringBuilder sb = new StringBuilder(modify);
        
        sb.append("," + password + "," + canLogin);
        
        return sb.toString();
        
    }
}
