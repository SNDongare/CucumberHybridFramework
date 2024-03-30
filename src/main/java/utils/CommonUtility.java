package utils;

import java.util.Date;

public class CommonUtility {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_TIME=15;
	public static final int EXPLICIT_SHORT_TIME=5;
	public static final int EXPLICIT_MEDIUM_TIME=10;
	public static final int EXPLICIT_LONG_TIME=30;
	

	//This method is used to generate the dynamic email with time stamp
	public static String generateEmailWithTimeStamp() {
        Date date=new Date();
   return "sdongare"+date.toString().replace(" ","_").replace(":", "_")+"@gmail.com"; 
  
	}
	
	
}
