package iCare;
import iCare.*;
import java.sql.*;

public class Register 
{

	// Registration Function for Patients
	public void patient_Registration(int pid, String fn, String ln, String G, String cn, int age, String Eid, String BloodGroup, String Address)
	{
		try 
		{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO Patients VALUES ('"+pid+"','"+fn+"','"+ln+"','"+G+"','"+cn+"','"+age+"','"+Eid+"','"+BloodGroup+"','"+Address+"')");
			System.out.println("                               ");
			System.out.println("\tRegistered succesfully.");
			System.out.println("                               ");
		}
		catch(Exception e)
		{ System.out.println(e.getMessage());} 

	}
	
	// Registration Function for Doctors
	public void doctor_Registration(int docid, String fn, String ln, String G, String cn, int age, String Q, String dt, String ed)
	{
		try 
		{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO Doctors VALUES ('"+docid+"','"+fn+"','"+ln+"','"+G+"','"+cn+"','"+age+"','"+Q+"','"+dt+"','"+ed+"')");
			System.out.println("                               ");
			System.out.println("\tDoctor added successfully.");
			System.out.println("                               ");
		}
		catch(Exception e)
		{ System.out.println(e.getMessage());}  
	}
}
