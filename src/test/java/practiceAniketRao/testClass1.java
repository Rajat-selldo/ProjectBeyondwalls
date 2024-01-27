package practiceAniketRao;

public class testClass1 {
	public static void main(String[] args) {
		
	//1. 
		System.out.println("-------------------------------------");
		long FindNumberofCount = 1223233456567789087L;
		FindNoOfCount(FindNumberofCount);
	//2. 	
		System.out.println("-------------------------------------");
		String givenStr = "sdksdhfb@bsdvkhbj@kbsdvhjb@hbsdhsbj";
		int specialCharLength = CalculateSpecialCharachterInString(givenStr);
		System.out.println("No of special characters in given String are: " + specialCharLength);
	//3. 
		System.out.println("-------------------------------------");
		long FindOddNumberCount = 1223233456567789087L;
        int oddCount = countOddDigits(FindOddNumberCount);
        System.out.println("Number of odd digits: " + oddCount);
    //4. 
		System.out.println("-------------------------------------");
        long FindEvenNumberCount = 1223233456567789087L;
        int evenCount = countEvenDigits(FindEvenNumberCount);
        System.out.println("Number of Even digits: " + evenCount);

		System.out.println("-------------------------------------");

	}

	public static void FindNoOfCount(long FindNumberofCount) {
// FindNumberOfCount 
		System.out.println("Program to FindNumberOfCount - ");
		//long FindNumberofCount = 1223233456567789087L;
		int length = Long.toString(FindNumberofCount).length();

		int count = 0;
		long tempNo = FindNumberofCount;

		while (tempNo != 0) {
			tempNo /= 10;
			count++;
		}

		String f = "1223233456567789087L";
		int b = f.length();
		System.out.println("Length of String using String.lenth method: " + b);

		System.out.println("Count of given number is : " + count);
		System.out.println("Length of a given value is : " + length);
	}
	
	public static int CalculateSpecialCharachterInString(String str) {
// CalculateSpecialCharachterInString 
		String[] specialChars = str.split("[a-zA-Z0-9]+");
		return specialChars.length - 1;
		
	}
	
	public static int countOddDigits(long number) {
// Number of Odd Digits 		
        String numberStr = Long.toString(number);
        int count = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            char digitChar = numberStr.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            
            if (digit % 2 != 0) {
                count++;
            }
        }

        return count;
    }
	
	public static int countEvenDigits(long number) {
// Number of Even Digits 		
        String numberStr = Long.toString(number);
        int count = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            char digitChar = numberStr.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            
            if (digit % 2 == 0) {
                count++;
            }
        }

        return count;
    }

}
