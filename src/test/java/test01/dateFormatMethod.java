package test01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateFormatMethod {
	
//Method for Date, Month & Year selection 
	protected static String getDate(long a, String of) {
		 
		String s = "";
		switch (of) {
		case "D":
			s = new SimpleDateFormat("dd").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "M":
			s = new SimpleDateFormat("M").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "Y":
			s = new SimpleDateFormat("YYYY").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24 )));
			break;
		case "m":
			s = new SimpleDateFormat("mm").format(new Date().getTime() + (a * (1000 * 60 )));
			break;
		case "H":
			s = new SimpleDateFormat("hh").format(new Date().getTime() + (a * (1000 * 60 * 60 )));
			break;
 
		default:
			System.out.println("please select valid input");
			break;
		}
		return s;
	}
	
	
//Method for random phone number generation 	
//	public String randomPhone() {
//		return " 12345" + Random("N", 5);
//	}

//Method for random email generation 
//	public static String Random(String type, int size) {
//		String Return = "";
//		switch (type) {
//		case "AN":
//			Return = RandomStringUtils.randomAlphanumeric(size);
//			break;// pX4Mv3KsJU
//		case "A":
//			Return = RandomStringUtils.randomAlphabetic(size);
//			break;// ZLTRqGyuXk
//		case "R":
//			Return = RandomStringUtils.random(size);
//			break;// 嚰险걻鯨贚䵧縓
//		case "N":
//			Return = RandomStringUtils.randomNumeric(size);
//			break;// 3511779161
//		default:
//			break;
//		}
//		return Return;
//	}

	//Main method to selection of date/phone/email 
	public static void main(String[] args) {
//			System.out.println(""+ getDate(600, "Y"));
		
//		System.out.println(Random("N", 1000));
	}
	
	
	//*[@id="add-new-lead-form"]/div[3]/div/div/div/div[1] --> click
	

}
