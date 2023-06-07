/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/


package coit11134.ictassetmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DataManager {
    
    private String staffFileName, assetsFileName, locationsFileName, loanRecordsFileName;
    private ArrayList<StaffRecords> staffList;
    private ArrayList<Asset> assetList;
    private ArrayList<Location> locationsList;
    private ArrayList<LoanRecord> loanList;
    
    
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
    
    private void loadAllFiles()
    {
        loadStaffFromFile();
    }
    
    private void loadStaffFromFile()
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
                    String stringStaffID = s[0].trim();
                    String name = s[1].trim();
                    String email = s[2].trim();
                    String phoneNumber = s[3].trim();
                    String stringArchived = s[4].trim();
                    String password = s[5].trim();
                    String stringCanLogin = s[6].trim();
                    
                    int staffID = Integer.parseInt(stringStaffID);
                    boolean archived = Boolean.parseBoolean(stringArchived);
                    boolean canLogin = Boolean.parseBoolean(stringCanLogin);
                    
                    AssetManagementStaff staff = new AssetManagementStaff(staffID, name, email, phoneNumber,archived, password, canLogin);
                    staffList.add(staff);
                }
            }
            reader.close();
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
    }
    
    
}
