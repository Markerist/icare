package iCare;
import iCare.ConnectionProvider;
import java.sql.*;
import java.util.*;
public class Admin extends Person
{
	Scanner sc = new Scanner(System.in);
	
	// This checks the number of doctors and based on the answer, makes a new unique id for the primary key
	private int AutoDoctorID()
	{
		int docid = 0;
		try{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select MAX(UserID) as NextUserID from Users where userType='Doctor'");
			rs.next();
			docid = rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return docid+1;
	}
	
	// This just adds a new doctor based on the AutoDoctorID
	public int addDoctor()
	{
		int DoctorID = AutoDoctorID();
		String password;
		String cpd;
		System.out.println("\tDoctor ID: "+DoctorID);
		System.out.print("\tEnter Password: ");
		password = sc.next();
		while(true)
		{
			System.out.print("\tConfirm Password: ");
			cpd = sc.next();
			if(password.compareTo(cpd) == 0)
					break;
		}
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("insert into Users values('"+DoctorID+"','"+"Doctor"+"','"+password+"')");
			System.out.println("\n\tRegistered successfully.\n");
		}catch(Exception e){
			System.out.println("\tPlease enter data in correct format.");
		}
		return DoctorID;
	}
	
	// This lists all of the doctors
	public void viewDoctors()
	{
		try 
		{
			Connection con = ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Doctors");
			con.close();
		}
		catch(Exception e)
		{ 
			System.out.println("\tEXCEPTION OCCURS");
		}  
	}
	
	// This lists all of the patients
	public void viewPatients()
	{
		try 
		{
			Connection con = ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Patients");
		}
		catch(Exception e)
		{ System.out.println("\tEXCEPTION OCCURS");}  
	}
	
	// This removes a doctor, only the admin can remove a doctor
	public void RemoveDoctor(int id)
	{
		try 
		{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("delete from Doctors where DoctorID = "+id);
			System.out.println("\tDoctor removed successfully.");
		}
		catch(Exception e)
		{ System.out.println("\tEXCEPTION OCCURS "+e.getMessage());}  
	}
	
	public void ViewFeedback() //To view Feedback given by Patients. Admin can view all the feedback details//
	{
		try 
		{ 
			Connection con = ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "feedback");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}	
	}
	
	
	// This views all of the appointments
	public void ViewAppointment()
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Appointments");
		}
		catch(Exception e)
		{ System.out.println("\tEXCEPTION OCCURS");}  
		
	}  
}
