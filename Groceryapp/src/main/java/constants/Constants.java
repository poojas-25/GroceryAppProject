package constants;

public class Constants {
	//constants used to centralize the fixed values which is used throughout the project
	public static final String TESTDATAFILE = System.getProperty("user.dir")+"/src/test/resources/TestData/DataSheet.xlsx"; //System.getProperty("user.dir")+ will give the system path till project name
	public static final String IMAGEUPLOAD = System.getProperty("user.dir")+"/src/test/resources/Images/images.jpeg";
	public static final String EDITIMAGEUPLOAD = System.getProperty("user.dir")+"/src/test/resources/Images/potatoes.jpeg";
	public static final String LP_VERIFYLOGINWITHVALIDCREDENTIALS = "Home page is not loaded";
    public static final String LP_VERIFYLOGINWITHINVALIDUSERNAME = "Login success with invalid password";
    public static final String LP_VERIFYLOGINWITHINVALIDPASSWORD = "Login success with invalid username";
    public static final String LP_VERIFYLOGINWITHINVALIDCREDENTIALS = "Login success with invalid credentials";
    public static final String CONFIGFILE = System.getProperty("user.dir")+"/src/main/resources/Config.properties"; //CONFIG FILE PATH
    public static final String CATEGORYIMAGE = System.getProperty("user.dir")+"/src/test/resources/Images/Beetroot.jpeg"; 
    public static final String SC_VERIFYADDINGNEWSUBCATEGORYUSINGVALIDDETAILS = "Subcategory is not added successfully";
    public static final String SC_VERIFYEDITINGSUBCATEGORYADDED = "Subcategory is not updated successfully";
    public static final String SC_VERIFYSEARCHINGEXISTINGSUBCATEGORYFROMTHELIST = "Search result not found";
    public static final String AU_VERIFYADDINGNEWUSERWITHVALIDDETAILS = "User not created successfully";
    public static final String LO_VERIFYLOGOUTFUNCTION = "Logout was not successful";
    public static final String MC_VERIFYADDINGANEWCATEGORY = "Not able to add a new category";
    public static final String MC_VERIFYDELETINGACATEGORYADDEDAFTERSEARCHING = "Not able to delete the category added";
    public static final String MCONT_VERIFYEDITINGEXISTINGCONTACT = "Updating contact was not successful";
    public static final String MFT_VERIFYUPDATINGMANAGEFOOTERTEXT = "Update was not successful";
}
