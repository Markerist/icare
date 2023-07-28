/**********************************************************|Doctor Class|*********************************************************/
package iCare;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Doctor extends Person
{
	int docid;//DoctorID
	String Doctor_Type;//Type of doctor
	String Qualification;//
	int Entry_Charge;
	Scanner sc = new Scanner(System.in);
	/***********************************************************************************************/ 
	public void DoctorRegistration(int docid)
	{
		System.out.println("\tPlease enter the following details:\n");
		this.docid = docid;
		System.out.println("\tDoctor ID: "+docid);
		super.UserInformation();
    	System.out.print("\tQualification: ");
    	Qualification = sc.next();
    	System.out.println("\tPlease pick a Department: \n");
    	System.out.println("\t1. Eyes");
    	System.out.println("\t2. EAR");
    	System.out.println("\t3. Heart");
    	System.out.println("\t4. Bone");
    	System.out.println("\t5. Lungs");
    	System.out.println("\t6. Kidney");
    	System.out.println("\t7. General Physicist");
    	System.out.println("                               ");
    	System.out.print("\tYour choice: ");
    	int ch = sc.nextInt();
    	switch(ch)
		{
			case 1:
			{
				Doctor_Type = "Eyes";
				break;
			}
			case 2:
			{
				Doctor_Type = "Ear";
				break;
			}
			case 3:
			{
				Doctor_Type = "Heart";
				break;
			}
			case 4:
			{
				Doctor_Type = "Bone";
				break;
			}

			case 5:
			{
				Doctor_Type = "Lungs";
				break;
			}
			case 6:
			{
				Doctor_Type = "Kidney";
				break;
			}
			case 7:
			{
				Doctor_Type = "General Physicist";
				break;
			}
			default:
			{
				System.out.println("                               ");
				System.out.println("\tPlease select a valid option.");
				System.out.println("                               ");
			}
				
		}
		Register reg = new Register();
    	reg.doctor_Registration(docid,First_Name,Last_Name,Gender,CN,age,Qualification,Doctor_Type,Email_Address);//change the database
	}
	/***********************************************************************************************/ 
	public void ShowDoctorDetails(int d)//This function Show All Details Of the doctor//
	{
		try {
    		Connection con = ConnectionProvider.getCon();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("Select * from Doctors where DoctorID="+d);
    		while(rs.next())
    		{
    			System.out.println("\tDoctor ID: "+rs.getInt(1));
    			System.out.println("\tName: "+rs.getString(2)+" "+rs.getString(3));
    			System.out.println("\tQualification: "+rs.getString(7));
    			System.out.println("\tDepartment: "+rs.getString(8));
    			System.out.println("\tContact No.: "+rs.getString(5));
    			System.out.println("\tEmail Address: "+rs.getString(9));
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
	}
	/***********************************************************************************************/ 
	public void viewAppointment(int docid)
	{
		int t = 0;
		try {
    		Connection con = ConnectionProvider.getCon();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("Select * from appointments where DoctorID="+docid);
    		while(rs.next())
    		{
	    			t++;
	    			System.out.println("\tAPPOINTMENT NUMBER: "+t);
					System.out.print("\tAppointment ID: "+rs.getInt(1)+"                          \n");
					System.out.print("\tProblem: "+rs.getString(2)+"                       \n");
					System.out.print("\tPatient ID: "+rs.getInt(3)+"                          \n");
					System.out.print("\t																	  \n");	
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		if(t == 0)
			System.out.println("\tYou currently don't have any appointment.");
	}
	/***********************************************************************************************/ 
	int Appointment_checker(int appid,int docid)
	{
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from Appointments where DoctorID="+docid);
			while(rs.next())
			{
				if(rs.getInt(1) == appid)
					return 1;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	/***********************************************************************************************/
	
	public void DiagnosePatient(int id)//Check patient//
	{
		while(true)
		{
			System.out.println("\tPlease enter the Appointment ID of the patient which you want to check.");
			System.out.println("                               ");
	    	System.out.print("\tYour choice: ");
			int appid = sc.nextInt();
			int f = Appointment_checker(appid,id);
			if(f == 1)
			{
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeQuery("Select * from Appointments where AppointmentID="+id);
					int pid = GetPatientID(appid);
					Report rp = new Report();
					rp.DiagnoseReport(pid,appid,id);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
			}
			else
			{
				System.out.println("                       ");
				System.out.println("\tWrong Appointment ID.");
				System.out.println("                       ");
				//boolean leave=false;
				System.out.println("\tPlease enter 1 to exit.");
				System.out.print("\tYour choice: ");
				if(sc.nextInt() == 1)
					break;
				
			}
		}
		
	}
	
	/***********************************************************************************************/ 
	
	private int GetPatientID(int appid)
	{
		int pid = 0;
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Appointments where AppointmentID="+appid);
			while(rs.next())
			{
				pid = rs.getInt(3);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return pid;
	}
	
	 /***********************************************************************************************/ 
	
}
