package iCare;
import java.util.Date;
import java.util.Scanner;
public class Person 
{
	// Variable Declarations
	protected String First_Name;
	protected String Last_Name;
	protected String Email_Address;
	protected String Gender;
	protected int age;
	protected Date DOB;
	protected String CN;
	protected String city;
	protected String state;
	protected String Country;
	protected String Address;
	protected Date RegistrationDate;
	Scanner sc = new Scanner(System.in);
	protected void UserInformation()
	{
    	
    	System.out.print("\tFirst Name: ");
    	First_Name = sc.next();
    	System.out.print("\tLast Name: ");
    	Last_Name = sc.next();
    	System.out.print("\tEmail Address: ");
    	Email_Address = sc.next();
    	System.out.print("\tGender (M or F): ");
    	Gender = sc.next();
    	System.out.print("\tAge: ");
    	age = sc.nextInt();
    	System.out.print("\tContact Number: ");
    	CN = sc.next();
    	System.out.print("\tCity: ");
    	city = sc.next();
    	System.out.print("\tState: ");
    	state = sc.next();
    	System.out.print("\tCountry: ");
    	Country = sc.next();
    	System.out.print("\tAddress: ");
    	Address = sc.next();
	}
}
