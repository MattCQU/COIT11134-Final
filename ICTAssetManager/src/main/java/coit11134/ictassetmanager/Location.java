/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/
package coit11134.ictassetmanager;

public class Location {
    
    //Variables
    private String locationName;
    private int locationID;
    private boolean archived;
    
    
    
    public Location(String locationName, int locationID, boolean archived) {
        this.locationName = locationName;
        this.locationID = locationID;
        this.archived = archived;
    }
    
    
    
    public Location() {
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
     * Get the value of locationID
     *
     * @return the value of locationID
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * Set the value of locationID
     *
     * @param locationID new value of locationID
     */
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    /**
     * Get the value of locationName
     *
     * @return the value of locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * Set the value of locationName
     *
     * @param locationName new value of locationName
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Location{");
        sb.append("locationName=").append(locationName);
        sb.append(", locationID=").append(locationID);
        sb.append(", archived=").append(archived);
        sb.append('}');
        return sb.toString();
    }

    

    public String saveString()
    {
        return locationID + "," + locationName + "," + archived;
    }
    
    
}
