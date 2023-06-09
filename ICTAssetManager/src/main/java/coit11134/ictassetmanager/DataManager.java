/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/


package coit11134.ictassetmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class DataManager {
    
    private String staffFileName, assetsFileName, locationsFileName, loanRecordsFileName;
    private ArrayList<StaffRecords> staffList;
    private ArrayList<Asset> assetList;
    private ArrayList<Location> locationsList;
    private ArrayList<LoanRecord> loanList;
    
    //DataManager Constructor 
    public DataManager(String staffFileName, String assetsFileName, String locationsFileName, String loanRecordsFileName)
    {
        this.staffFileName = staffFileName;
        this.assetsFileName = assetsFileName;
        this.locationsFileName = locationsFileName;
        this.loanRecordsFileName = loanRecordsFileName;
        
        this.staffList = new ArrayList<>();
        this.assetList = new ArrayList<>();
        this.locationsList = new ArrayList<>();
        this.loanList = new ArrayList<>();
        
        loadAllFiles();
    }
    
    //Method to load all required files
    private void loadAllFiles()
    {
        readStaffFromFile();
        readAssetFromFile();
        readLocationFromFile();
        readLoanRecordFromFile();
        
    }
    
    //Method to read staff from file, build the boject and add it to the staff ArrayList
    private void readStaffFromFile()
    {
        String line = "";
        
        File file = new File(staffFileName);
        
        if(!file.exists())
        {
            return;
        }
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader (staffFileName));
            while((line = reader.readLine()) != null)
            {
                String[] s = line.split(",");
                if(s.length == 5)
                {
                    String stringStaffID = s[0].trim();
                    String name = s[1].trim();
                    String email = s[2].trim();
                    String phoneNumber = s[3].trim();
                    String stringArchived = s[4].trim();
                    
                    int staffID = Integer.parseInt(stringStaffID);
                    boolean archived = Boolean.parseBoolean(stringArchived);
                    
                    StaffRecords staff = new StaffRecords(staffID, name, email, phoneNumber,archived);
                    staffList.add(staff);
                }
                
                if(s.length == 7)
                {
                    int staffID = Integer.parseInt(s[0].trim());
                    String name = s[1].trim();
                    String email = s[2].trim();
                    String phoneNumber = s[3].trim();
                    boolean archived = Boolean.parseBoolean(s[4].trim());
                    String password = s[5].trim();
                    boolean canLogin = Boolean.parseBoolean(s[6].trim());
                    
                    AssetManager staff = new AssetManager(staffID, name, email, phoneNumber,archived, password, canLogin);
                    staffList.add(staff);
                }
            }
            reader.close();
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
    }
    
    //Method to read Assets from file, build the object then add to the assets arrayList
    public void readAssetFromFile()
    {
        String line = "";
        File file = new File(assetsFileName);
        
        if(!file.exists())
        {
            return;
        }
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(assetsFileName));
            while((line = reader.readLine()) != null)
            {
                String[] a = line.split(",");
                if(a.length == 10)
                {
                    int assetID = Integer.parseInt(a[0].trim()); 
                    String itemType = a[1].trim();
                    String make = a[2].trim();
                    String model = a[3].trim();
                    String serialNumber = a[4].trim();
                    LocalDate dueTestDate = LocalDate.parse(a[5].trim());
                    LocalDate warrantyEndDate = LocalDate.parse(a[6].trim());
                    LocalDate purchaseDate = LocalDate.parse(a[7].trim());
                    double purchasePrice = Double.parseDouble(a[8].trim());
                    boolean archived = Boolean.parseBoolean(a[9].trim());

                    
                    
                    Asset asset = new Asset( itemType,  make,  model,  serialNumber,  assetID,  dueTestDate,  warrantyEndDate,  purchaseDate,  purchasePrice,  archived);
                    assetList.add(asset);
                }
                            
            }
            reader.close();
            
        }catch(IOException e)
        {
            App.customAlert(e.getMessage());
        }
    }
    
    //Method to read Locations from file, build the object then add to the Locations arrayList
    public void readLocationFromFile()
    {
        String line = "";
        File file = new File(locationsFileName);
        
        if(!file.exists())
        {
            return;
        }
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(locationsFileName));
            while ((line = reader.readLine()) != null)
            {
                String[] l = line.split(",");
                if(l.length == 3)
                {
                    int locationID = Integer.parseInt(l[0].trim());
                    String locationName = l[1].trim();
                    boolean archived = Boolean.parseBoolean(l[2].trim());
                    
                    Location location = new Location(locationName, locationID, archived);
                    locationsList.add(location);
                }
            }
            reader.close();
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
    }
    
    
    //Method to read Loans from file, build the object then add to the Loans arrayList
    public void readLoanRecordFromFile()
    {
        String line = "";
        File file = new File(loanRecordsFileName);
        
        if(!file.exists())
        {
            return;
        }
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(loanRecordsFileName));
            while ((line = reader.readLine()) != null)
            {
                String[] l = line.split(",");
                if(l.length == 6 )
                {
                    int loanID = Integer.parseInt(l[0].trim());
                    StaffRecords staffMember = searchStaffByID(l[1]);
                    Asset asset = searchAssetByID(l[2]);
                    Location location = searchLocationByID(l[3]);
                    LocalDate loanDate = LocalDate.parse(l[4].trim());
                    LocalDate returnDate = LocalDate.parse(l[5].trim());
                    
                    
                    LoanRecord loan = new LoanRecord(staffMember,  asset,  location,  loanDate,  returnDate,  loanID);
                    loanList.add(loan);
                }
                
            }
            reader.close();
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
    }
    
    //Method to use a sting ID to search the Staff ArrayList for the correct staffmember and returns the staff object
    public StaffRecords searchStaffByID(String stringStaffID)
    {
        try{
        
            int staffID = Integer.parseInt(stringStaffID.trim());
            
            for(StaffRecords staff : staffList)
            {
                if(staff.getStaffID() == staffID)
                {
                    return staff;
                }
            }
        } catch(Exception e)
        {
            App.customAlert(e.getMessage());
            return null;
        }
        return null;
    }
    
    
    //Method to use a string ID to search the Assets ArrayList for the correct asset and returns the asset object
    public Asset searchAssetByID(String stringAssetID)
    {
        try
        {
            int assetID = Integer.parseInt(stringAssetID.trim());
            
            for(Asset asset : assetList)
            {
                if(asset.getAssetID() == assetID)
                {
                    return asset;
                }
            }
        }catch(Exception e)
        {
            
            App.customAlert(e.getMessage());
            return null;
        }
        return null;
    }
    
    
    //Method to use a string ID to search the Locations ArrayList for the correct location and returns the Location object
    public Location searchLocationByID(String stringLocationID)
    {
        try
        {
            int locationID = Integer.parseInt(stringLocationID.trim());
            
            for(Location location : locationsList)
            {
                if(location.getLocationID() == locationID)
                {
                    return location;
                }
            }
        }catch(Exception e)
        {
            
            App.customAlert(e.getMessage());
            return null;
        }
        return null;
    }
    
    
   //Method to use a sting ID to search the Loan ArrayList for the correct Loan and returns the Loan object 
    public LoanRecord searchLoanByID(String stringLoanID)
    {
        try
        {
            int loanID = Integer.parseInt(stringLoanID.trim());
            
            for(LoanRecord loan : loanList)
            {
                if(loan.getLoanID() == loanID)
                {
                    return loan;
                }
            }
        }catch(Exception e)
        {
            
            App.customAlert(e.getMessage());
            return null;
        }
        return null;
    }
    
    //Method to use a sting ID to search the Loan ArrayList for the correct Asset and returns the Loan object
    public LoanRecord searchLoanByAsset(String stringAssetID)
    {
        try
        {
            int AssetID = Integer.parseInt(stringAssetID.trim());
            
            for(LoanRecord loan : loanList)
            {
                if(loan.getAsset().getAssetID() == AssetID)
                {
                    return loan;
                }
            }
        }catch(Exception e)
        {
            
            App.customAlert(e.getMessage());
            return null;
        }
        return null;
    }
    
    
    //Method that uses the Asset saveString to save the Asset arraylist to file
    public void saveAssetToFile()
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(assetsFileName));
            
            for(Asset a : assetList)
            {
                String assetString = a.saveString();
                writer.write(assetString);
                writer.newLine();
            }
            writer.close();
            System.out.println("Assets saved to file.");
            
        }catch(IOException e)
        {
            App.customAlert(e.getMessage());
        }
    }
    
    //Method that uses the Location saveString to save the Location arraylist to file
    public void saveLocationsToFile()
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(locationsFileName));
            
            for(Location l : locationsList)
            {
                String locationString = l.saveString();
                writer.write(locationString);
                writer.newLine();
            }
            writer.close();
            System.out.println("Locations saved to file.");
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
        
    }
    
    
    //Method that uses the Loans saveString to save the Loan arraylist to file
    public void saveLoansToFile()
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(loanRecordsFileName));
            
            for(LoanRecord l : loanList)
            {
                String loanString = l.saveString();
                writer.write(loanString);
                writer.newLine();
            }
            writer.close();
            System.out.println("Loans saved to file.");
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
        
    }
    
    
    //Method that uses the Staff saveString to save the Staff arraylist to file
    public void saveStaffToFile()
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(staffFileName));
            
            for(StaffRecords s : staffList)
            {
                String StaffString = s.saveString();
                writer.write(StaffString);
                writer.newLine();
            }
            writer.close();
            System.out.println("Staff saved to file.");
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
        
    }
    
    //method that finds the largest ID number in the Staff File and returns the next int
    public int getNextStaffID()
    {
        String line = "";
        int highest = 0;
        int finalID = -1;
        
        File file = new File(staffFileName);
        if(!file.exists())
        {
            App.customAlert("Staff File Does Not Exist");
        }
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(staffFileName));
            while((line = reader.readLine()) != null)
            {
                String[] s = line.split(",");
                if(s.length == 5 || s.length == 7)
                {
                    String currentID = s[0].trim();
                    int numID = Integer.parseInt(currentID);
                    
                    if(numID > highest)
                    {
                        highest = numID;
                    }
                }
            }
            highest++;
            finalID = highest;
            reader.close();
            
        }catch(IOException e)
        {
            App.customAlert(e.getLocalizedMessage());
        }
        
        return finalID;
    }
    
    //method that finds the largest ID number in the Locations File and returns the next int
    public int getNextLocationID()
    {
        String line = "";
        int highest = 0;
        int finalID = -1;
        
        File file = new File(locationsFileName);
        if(!file.exists())
        {
            App.customAlert("Locations File Does Not Exist");
        }
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(locationsFileName));
            while((line = reader.readLine()) != null)
            {
                String[] l = line.split(",");
                if(l.length == 3)
                {
                    String currentID = l[0].trim();
                    int numID = Integer.parseInt(currentID);
                    
                    if(numID > highest)
                    {
                        highest = numID;
                    }
                }
            }
            highest++;
            finalID = highest;
            reader.close();
            
        }catch(IOException e)
        {
            App.customAlert(e.getLocalizedMessage());
        }
        
        return finalID;
    }
    
    
    //method that finds the largest ID number in the Loan File and returns the next int
    public int getNextLoanID()
    {
        String line = "";
        int highest = 0;
        int finalID = -1;
        
        File file = new File(loanRecordsFileName);
        if(!file.exists())
        {
            App.customAlert("Loans File Does Not Exist");
        }
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(loanRecordsFileName));
            while((line = reader.readLine()) != null)
            {
                String[] l = line.split(",");
                if(l.length == 6)
                {
                    String currentID = l[0].trim();
                    int numID = Integer.parseInt(currentID);
                    
                    if(numID > highest)
                    {
                        highest = numID;
                    }
                }
            }
            highest++;
            finalID = highest;
            reader.close();
            
        }catch(IOException e)
        {
            App.customAlert(e.getLocalizedMessage());
        }
        
        return finalID;
    }
    
    //method that finds the largest ID number in the Assets File and returns the next int
    public int getNextAssetID()
    {
        String line = "";
        int highest = 0;
        int finalID = -1;
        
        File file = new File(assetsFileName);
        if(!file.exists())
        {
            App.customAlert("Loans File Does Not Exist");
        }
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(assetsFileName));
            while((line = reader.readLine()) != null)
            {
                String[] a = line.split(",");
                if(a.length == 10)
                {
                    String currentID = a[0].trim();
                    int numID = Integer.parseInt(currentID);
                    
                    if(numID > highest)
                    {
                        highest = numID;
                    }
                }
            }
            highest++;
            finalID = highest;
            reader.close();
            
        }catch(IOException e)
        {
            App.customAlert(e.getLocalizedMessage());
        }
        
        return finalID;
    }
    
    //Adds the StaffRecords to the staffList ArrayList
    public void addStaffRecord (StaffRecords staff)
    {
        staffList.add(staff);
    }
    
    //Adds the Location to the locationsList ArrayList
    public void addLocation (Location location )
    {
        locationsList.add(location);
    }
    
    //Adds the Asset to the AssetList ArrayList
    public void addAsset (Asset asset)
    {
        assetList.add(asset);
    } 
    
    //Adds the Loan to the loanList ArrayList
    public void addLoan(LoanRecord loan)
    {
        loanList.add(loan);
    }
    
    
    //Method that searches through the assetList for assets whos test and tag due date is before the date entered.
    public ArrayList<Asset> taggingReport(LocalDate date)
    {
        ArrayList<Asset> overDue = new ArrayList<>();
        
        try
        {
            for(Asset asset : assetList)
            {
                if(asset.getDueTestDate().isBefore(date))
                {
                    overDue.add(asset);
                }
            }       
        }catch(Exception e)
        {
            
            App.customAlert(e.getMessage());
            return null;
        }
        return overDue;
    }
    
    
    //method the returns a list of AssetManagers from the stafflist
    public AssetManager[] getAllAssetManagers()
    {
        ArrayList<AssetManager> managerList = new ArrayList<AssetManager>();
        
        for(StaffRecords members : staffList)
        {
            if(members instanceof AssetManager)
            {
                managerList.add((AssetManager) members);
            }
        }
        
        AssetManager[] managers = new AssetManager[managerList.size()];
        managers = managerList.toArray(managers);
        
        return managers;
    }
    
    //method returns all assets as an array
    public Asset[] getAllAssets()
    {
        Asset[] asset = new Asset[assetList.size()];
        asset = assetList.toArray(asset);
        return asset;
    }
    
    //method that returns all staff as an array
    public StaffRecords[] getAllStaffRecords()
    {
        StaffRecords[] staff = new StaffRecords[staffList.size()];
        staff = staffList.toArray(staff);
        return staff;
    }
    
    //method that returns all locations as an array
    public Location[] getAllLocations()
    {
        Location[] location = new Location[locationsList.size()];
        location = locationsList.toArray(location);
        return location;
    }
    
    //method that returns all loans as an array
    public LoanRecord[] getAllLoanRecords()
    {
        LoanRecord[] loan = new LoanRecord[loanList.size()];
        loan = loanList.toArray(loan);
        return loan;
    }
}
