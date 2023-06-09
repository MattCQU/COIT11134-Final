/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/


package coit11134.ictassetmanager;

import java.time.LocalDate;

public class Asset {
    
    private String itemType;
    private String make;
    private String model;
    private String serialNumber;
    private int assetID;
    private LocalDate dueTestDate;
    private LocalDate warrantyEndDate;
    private LocalDate purchaseDate;
    private double purchasePrice;
    private boolean archived;
    
    
    //Asset parameterised Constructor
    public Asset(String itemType, String make, String model, String serialNumber, int assetID, LocalDate dueTestDate, LocalDate warrantyEndDate, LocalDate purchaseDate, double purchasePrice, boolean archived) 
    {
        this.itemType = itemType;
        this.make = make;
        this.model = model;
        this.serialNumber = serialNumber;
        this.assetID = assetID;
        this.dueTestDate = dueTestDate;
        this.warrantyEndDate = warrantyEndDate;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.archived = archived;
    }
    
    //Aesst Constructor
    public Asset() 
    {
        
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
     * Get the value of purchasePrice
     *
     * @return the value of purchasePrice
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Set the value of purchasePrice
     *
     * @param purchasePrice new value of purchasePrice
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    
    
    
    /**
     * Get the value of purchaseDate
     *
     * @return the value of purchaseDate
     */
    public LocalDate getPurchaseDate()
    {
        return purchaseDate;
    }
    
    /**
     * Set the value of purchaseDate
     *
     * @param purchaseDate new value of purchaseDate
     */
    public void setPurchaseDate(LocalDate purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }
    
    /**
     * Get the value of warrantyEndDate
     *
     * @return the value of warrantyEndDate
     */
    public LocalDate getWarrantyEndDate()
    {
        return warrantyEndDate;
    }
    
    /**
     * Set the value of warrantyEndDate
     *
     * @param warrantyEndDate new value of warrantyEndDate
     */
    public void setWarrantyEndDate(LocalDate warrantyEndDate)
    {
        this.warrantyEndDate = warrantyEndDate;
    }
    
    /**
     * Get the value of dueTestDate
     *
     * @return the value of dueTestDate
     */
    public LocalDate getDueTestDate()
    {
        return dueTestDate;
    }
    
    /**
     * Set the value of dueTestDate
     *
     * @param dueTestDate new value of dueTestDate
     */
    public void setDueTestDate(LocalDate dueTestDate)
    {
        this.dueTestDate = dueTestDate;
    }
    
    /**
     * Get the value of assetID
     *
     * @return the value of assetID
     */
    public int getAssetID() {
        return assetID;
    }

    /**
     * Set the value of assetID
     *
     * @param assetID new value of assetID
     */
    public void setAssetID(int assetID) {
        this.assetID = assetID;
    }


    /**
     * Get the value of serialNumber
     *
     * @return the value of serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Set the value of serialNumber
     *
     * @param serialNumber new value of serialNumber
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    
    /**
     * Get the value of model
     *
     * @return the value of model
     */
    public String getModel() {
        return model;
    }

    /**
     * Set the value of model
     *
     * @param model new value of model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Get the value of make
     *
     * @return the value of make
     */
    public String getMake() {
        return make;
    }

    /**
     * Set the value of make
     *
     * @param make new value of make
     */
    public void setMake(String make) {
        this.make = make;
    }

    
    
    /**
     * Get the value of itemType
     *
     * @return the value of itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * Set the value of itemType
     *
     * @param itemType new value of itemType
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("AssetID=").append(assetID);
        sb.append(", Asset=").append(itemType);
        sb.append(", Make=").append(make);
        sb.append(", Model=").append(model);
        sb.append(", Serial Number=").append(serialNumber);
        sb.append(", Test Due Date=").append(dueTestDate);
        sb.append(", Warranty End Date=").append(warrantyEndDate);
        sb.append(", Purchase Date=").append(purchaseDate);
        sb.append(", Price=").append(purchasePrice);
        sb.append(", Archived=").append(archived);
 
        return sb.toString();
    }
    
    //String format for file saving.
    public String saveString()
    {
        String save = assetID + ", " + itemType + ", " + make + ", " + model + ", " + serialNumber + ", " + dueTestDate + ", " + warrantyEndDate 
                + ", " + purchaseDate + ", " + purchasePrice + ", " + archived;
        return save;
    }
    
    
    // String used for displaying overdue test and tag assets
    public String overDueString()
    {
        return assetID + ", " + dueTestDate + ", " + itemType + ", " + make + ", " + model + ", " + serialNumber;
    }

    
}
