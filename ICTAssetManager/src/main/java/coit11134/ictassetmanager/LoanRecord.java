/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/


package coit11134.ictassetmanager;

import java.time.LocalDate;

public class LoanRecord {
    
    private StaffRecords staffMember;
    private Asset asset;
    private Location location;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private int loanID;

    public LoanRecord(StaffRecords staffMember, Asset asset, Location location, LocalDate loanDate, LocalDate returnDate, int loanID) 
    {
        this.staffMember = staffMember;
        this.asset = asset;
        this.location = location;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.loanID = loanID;
    }

    
    public LoanRecord() 
    {
        
    }
    
    
    /**
     * Get the value of loanID
     *
     * @return the value of loanID
     */
    public int getLoanID() {
        return loanID;
    }

    /**
     * Set the value of loanID
     *
     * @param loanID new value of loanID
     */
    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public StaffRecords getStaffMember() {
        return staffMember;
    }

    public void setStaffMember(StaffRecords staffMember) {
        this.staffMember = staffMember;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoanRecord{");
        sb.append("staffMember=").append(staffMember);
        sb.append(", asset=").append(asset);
        sb.append(", location=").append(location);
        sb.append(", loanDate=").append(loanDate);
        sb.append(", returnDate=").append(returnDate);
        sb.append(", loanID=").append(loanID);
        sb.append('}');
        return sb.toString();
    }
    
    
    public String saveString()
    {
        String staffID = String.valueOf(staffMember.getStaffID());
        String assetID = String.valueOf(asset.getAssetID());
        String locationID = String.valueOf(location.getLocationID());
        
        return loanID + "," + staffID  + "," + assetID + "," + locationID + "," + loanDate + "," + returnDate;
    }
    
}
