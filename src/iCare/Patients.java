package iCare;
import iCare.ConnectionProvider;
import iCare.Register;
import java.sql.*;

import java.util.Scanner;
public class Patients extends Person
{
	Scanner sc = new Scanner(System.in);
    String BloodGroup ;
    
    // This checks the number of doctors and based on the answer, makes a new unique ID for the primary key
    // This method of patient class generates the ID of patient 
    private int AutoPatientID()
	{
		int id_Patient = 0;
		try{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select MAX(userID) as 'NextPatientID' from Users");
			rs.next();
			id_Patient = rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return id_Patient+1;
	}
    /***********************************************************************************************/
    public int addPatient() 
	{
		int PatientID = AutoPatientID();
		String password;
		String cpd;
		System.out.println("\tHere is your Patient ID: "+PatientID);
		System.out.print("\tEnter Password: ");
		password = sc.next();
		while(true)
		{
			System.out.print("\tConfirm Password: ");
			cpd = sc.next();
			if(password.compareTo(cpd) == 0)
					break;
			else
			{
				System.out.println("\tYour password is incorrect.");
				System.out.println("\tPlease re-enter your password.");
			}
		}
		try
		{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("insert into Users values('"+PatientID+"','"+"Patient"+"','"+password+"')");
			System.out.println("\t                       ");
			System.out.println("\tRegistered succesfully.");
			System.out.println("\t                       ");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return PatientID;
		
	}
    /***********************************************************************************************/
    public void PatientRegistration(int pid) /*This method add details of the patient in the patient table of EHMS database*/
    {
  
    	super.UserInformation();
    	System.out.print("\tBlood Type: ");
    	BloodGroup = sc.next();
    	Register reg = new Register();
    	reg.patient_Registration(pid,First_Name,Last_Name,Gender,CN,age,Email_Address,BloodGroup,Address);
 
    }
    /***********************************************************************************************/ 
    public void ShowPatientDetails(int id)/*This method all details of the patient*/
    {
    	try {
    		Connection con = ConnectionProvider.getCon();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("Select * from Patients where PatientID="+id);
    		while(rs.next())
    		{ 
    			System.out.println("\tPatient ID: "+rs.getInt(1));
    			System.out.println("\tName: "+rs.getString(2)+" "+rs.getString(3));
    			System.out.println("\tBlood Type: "+rs.getString(8));
    			System.out.println("\tAddress: "+rs.getString(9));
    			System.out.println("\tContact Number: "+rs.getString(5));
    			System.out.print("\t                  \n");
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
	}  
    /***********************************************************************************************/
    
    public void viewDoctor()
    {
		try 
		{
			Connection con = ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Doctors");
			con.close();
		}
		catch(Exception e)
		{ 
			System.out.println("\tEXCEPTION OCCURS"+e.getMessage());
		}  
		
    }
    /***********************************************************************************************/  
    public void BookAppointment(int id) 
    {
    	Appointment ap = new Appointment();
    	ap.BookAppointment(id);  
    	
    }
    /***********************************************************************************************/     
    public void viewAppointment(int id) 
    {
    	int t = 0;
		try {
    		Connection con = ConnectionProvider.getCon();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("Select * from  appointments where PatientID="+id);
    		while(rs.next())
    		{
	    			t++;
	    			System.out.println("\tAPPOINTMENT NUMBER: "+t);
					System.out.print("\tAppointment ID: "+rs.getInt(1)+"                          \n");
					System.out.print("\tProblem: "+rs.getString(2)+"                       \n");
					System.out.print("\tPatient ID: "+rs.getInt(3)+"                          \n");
					System.out.print("\tDoctor ID: "+rs.getInt(5)+"                          \n");
					System.out.print("\t																  \n");	
    		}
    		
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		if(t == 0)
		{
			System.out.println("\tYou currently have no appointments.");
			System.out.println("\tEnter 3 to book an appointment.");
		}
    	
    }
    public void AppointmentHistory(int id) 
    {
    	int t = 0;
		try {
    		Connection con = ConnectionProvider.getCon();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("Select * from  Appointments where PatientID="+id);
    		while(rs.next())
    		{
    			if(rs.getString(8).compareTo("Completed") == 0)
    			{
	    			t++;
	    			System.out.println("\tAPPOINTMENT NUMBER: "+t);
					System.out.print("\tAppointment ID: "+rs.getInt(1)+"                          \n");
					System.out.print("\tProblem: "+rs.getString(2)+"                       \n");
					System.out.print("\tPatient ID: "+rs.getInt(3)+"                          \n");
					System.out.print("\tDoctor ID: "+rs.getInt(5)+"                          \n");
					System.out.print("\t																	  \n");	
    			}
    		}
    		
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		if(t==0)
		{
			System.out.println("\tYou have no past appointments.");
		}
    	
    }
    /***********************************************************************************************/  
    public void ViewReport(int id)
    {
    	int checkReport = 0;
    	try {
    		Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Reports where PatientID = "+id);
			while(rs.next())
			{
				System.out.print("\tReport ID: "+rs.getInt(1)+"                          \n");
				System.out.print("\tAppointment ID: "+rs.getInt(2)+"                          \n");
				System.out.print("\tPatient ID: "+rs.getInt(3)+"                          \n");
				System.out.print("\tDoctor ID: "+rs.getInt(4)+"                          \n");
				System.out.print("\tMedicine Prescribed: "+rs.getString(5)+"                       \n");
				System.out.print("\tDoctor's Message: "+rs.getString(6)+"                       \n");
				System.out.print("\t															  		  \n");	
				checkReport++;
			}
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	if(checkReport == 0)
    			System.out.println("\tYou have no report generated.");
    	
    }
    /***********************************************************************************************/ 
    
    public void Givefeedback(int id) /*To give Feedback*/
    {
    	System.out.println("\tPlease fill in the following feedback form:");
    	int pid = id;
    	System.out.println("\tPatient ID: "+pid);
    	System.out.print("\tPlease rate him/her out of 10: ");
    	int points = sc.nextInt();
    	System.out.print("\tDoctor's Approach: ");
    	String Doc_Nature = sc.next();
    	Doc_Nature += sc.nextLine();
    	System.out.print("\tPlease enter your address: ");
    	String Location = sc.next();
    	Location += sc.nextLine();
    	System.out.print("\tHow was your experience?: ");
    	String YourComment = sc.next();
    	YourComment += sc.nextLine();
    	try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO feedback VALUES ('"+pid+"','"+points+"','"+Doc_Nature+"','"+Location+"','"+YourComment+"')");
			System.out.println("                                      \n");
	    	System.out.println("\tThank you for providing your feedback.");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    }
    /***********************************************************************************************/ 

	
}
