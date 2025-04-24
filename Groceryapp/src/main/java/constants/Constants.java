package constants;

public class Constants {
	//constants used to centralize the fixed values which is used throughout the project
	public static final String TESTDATAFILE = System.getProperty("user.dir")+"/src/test/resources/TestData/DataSheet.xlsx"; //System.getProperty("user.dir")+ will give the system path till project name
	public static final String IMAGEUPLOAD = System.getProperty("user.dir")+"/src/test/resources/Images/images.jpeg";
	public static final String LP_VERIFYLOGINWITHVALIDCREDENTIALS = "Home page is not loaded";
    public static final String LP_VERIFYLOGINWITHINVALIDUSERNAME = "Login success with invalid password";
    public static final String LP_VERIFYLOGINWITHINVALIDPASSWORD = "Login success with invalid username";
    public static final String LP_VERIFYLOGINWITHINVALIDCREDENTIALS = "Login success with invalid credentials";
    public static final String CONFIGFILE = System.getProperty("user.dir")+"/src/main/resources/Config.properties"; //CONFIG FILE PATH
    public static final String CATEGORYIMAGE = System.getProperty("user.dir")+"/src/test/resources/Images/Beetroot.jpeg"; 
}
