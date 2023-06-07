/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/


package coit11134.ictassetmanager;

import java.time.LocalDate;

public class Asset {
    
    private String assetDescription;
    private String make;
    private String model;
    private String serialNumber;
    private int assetID;
    private LocalDate dueTestDate;
    private LocalDate warrantyEndDate;
    private LocalDate purchaseDate;
    private double purchasePrice;
    private String status;

    public Asset(String assetDescription, String make, String model, String serialNumber, int assetID, LocalDate dueTestDate, LocalDate warrantyEndDate, LocalDate purchaseDate, double purchasePrice, String status) 
    {
        this.assetDescription = assetDescription;
        this.make = make;
        this.model = model;
        this.serialNumber = serialNumber;
        this.assetID = assetID;
        this.dueTestDate = dueTestDate;
        this.warrantyEndDate = warrantyEndDate;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.status = status;
    }

    public Asset() 
    {
        
    }
    
    
    
    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(String status) {
        this.status = status;
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
     * Get the value of assetDescription
     *
     * @return the value of assetDescription
     */
    public String getAssetDescription() {
        return assetDescription;
    }

    /**
     * Set the value of assetDescription
     *
     * @param assetDescription new value of assetDescription
     */
    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asset{");
        sb.append("assetDescription=").append(assetDescription);
        sb.append(", make=").append(make);
        sb.append(", model=").append(model);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", assetID=").append(assetID);
        sb.append(", dueTestDate=").append(dueTestDate);
        sb.append(", warrantyEndDate=").append(warrantyEndDate);
        sb.append(", purchaseDate=").append(purchaseDate);
        sb.append(", purchasePrice=").append(purchasePrice);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
