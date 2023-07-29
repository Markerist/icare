package iCare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Appointment 
{
	// Variable Declarations
	private int Apid;
	private int pid;
	private String Problem;
	private int Doctor_id;
	private String Doctor_Name;
	private String Doctor_Type;
	private String Doctor_Qualification;
	private String Appointment_Status="Pending";
	private String payment_status;
	
	// Scanner object
	Scanner sc = new Scanner(System.in);
	
	// This checks the number of doctors and based on the answer, makes a new unique ID for the primary key
	private int AutoAppointmentID()
	{
		int appID = 0;
		try{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select MAX(AppointmentID) from Appointments");
			rs.next();
			appID = rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return appID + 1;
	}
	
	// This adds a new appointment based on the AutoAppointmentID
	public void BookAppointment(int id)

	{
		Apid = AutoAppointmentID();
		System.out.println("\tAppointment ID: "+Apid);
		pid = id;
		System.out.println("\tPatient ID: "+pid);
		System.out.print("\tEnter your problem: ");
		Problem = sc.nextLine();
		
		Doctor_id = ChooseDoctor();
		while(Doctor_id == 0)
		{
			System.out.println("\tPlease choose a valid option.");
			Doctor_id = ChooseDoctor();
		}
		Doctor_Name = GetDoctorName(Doctor_id);
		Doctor_Qualification = GetDoctorQualification(Doctor_id);

		int d;
		System.out.print("\t					\n");
		System.out.println("\tPlease type 1 to confirm.");
		System.out.print("\t					\n");
        System.out.print("\tYour Choice: ");	
		d = sc.nextInt();
		if(d == 1)
		{
			ConfirmAppointment();
		}	
	}
	
	// Function of Choosing a Doctor
	private int ChooseDoctor()
	{
		System.out.print("\t					\n");
		System.out.print("\tPlease select a doctor according to your health issue.");
        System.out.println("\t					\n");
        System.out.print("\t1. Eyes Specialist	\n");
        System.out.print("\t2. EAR Specialist	\n");
        System.out.print("\t3. Heart Specialist	\n");
        System.out.print("\t4. Bones Specialist	\n");
        System.out.print("\t5. Lungs Specialist	\n");
        System.out.print("\t6. Kidney Specialist	\n");
        System.out.print("\t7. General Phsysicist\n");
        System.out.print("\t					\n");
        System.out.print("\tYour Choice: ");	
		int ch = sc.nextInt();
		System.out.print("\t					\n");
		
		// START OF SWITCH BLOCK
		
		switch(ch)
		{
			case 1:
			{
				Doctor_Type = "Eye";
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Doctors where Doctor_Type='Eye'");
					while(rs.next())
					{
						System.out.print("\t					\n");
						System.out.print("\tDoctor ID: "+rs.getInt(1)+"\n");
						System.out.print("\tName: "+rs.getString(2)+" "+rs.getString(3)+"\n");
						System.out.print("\tEmail Address: "+rs.getString(9)+"\n");
						System.out.print("\tQualification: "+rs.getString(7)+"\n");
						System.out.print("\t					\n");
					}
					System.out.println("\tEnter the ID of the Doctor you want to choose.");
			        System.out.println("\t					\n");
					System.out.print("\tYour Choice: ");	
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 2:
			{
				Doctor_Type = "Ear";
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Doctors where Doctor_Type='Ear'");
					while(rs.next())
					{
						System.out.print("\t					\n");
						System.out.print("\tDoctor ID: "+rs.getInt(1)+"\n");
						System.out.print("\tName: "+rs.getString(2)+" "+rs.getString(3)+"\n");
						System.out.print("\tEmail Address: "+rs.getString(9)+"\n");
						System.out.print("\tQualification: "+rs.getString(7)+"\n");
						System.out.print("\t					\n");
					}
					System.out.println("\tEnter the ID of the Doctor you want to choose.");
					System.out.print("\t					\n");
			        System.out.print("\tYour Choice: ");	
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 3:
			{
				Doctor_Type = "Heart";
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Doctors where Doctor_Type='Heart'");
					while(rs.next())
					{
						System.out.print("\tDoctor ID: "+rs.getInt(1)+"                              \n");
						System.out.print("\tName: "+rs.getString(2)+" "+rs.getString(3)+"            \n");
						System.out.print("\tEmail Address: "+rs.getString(9)+"                 \n");
						System.out.print("\tQualification: "+rs.getString(7)+"                       \n");
						System.out.print("\t                                                         \n");	
					}
					System.out.println("\tEnter the ID of the Doctor you want to choose.");
					System.out.print("\t					\n");
			        System.out.print("\tYour Choice: ");	
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 4:
			{
				Doctor_Type = "Bone";
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Doctors where Doctor_Type='Bone'");
					while(rs.next())
					{
						System.out.print("\tDoctor ID: "+rs.getInt(1)+"                             \n");
						System.out.print("\tName: "+rs.getString(2)+" "+rs.getString(3)+"           \n");
						System.out.print("\tEmail Address: "+rs.getString(9)+"                     \n");
						System.out.print("\tQualification: "+rs.getString(7)+"                      \n");
						System.out.print("\t                                                        \n");	
					}
					System.out.println("\tEnter the ID of the Doctor you want to choose.");
					System.out.print("\t					\n");
			        System.out.print("\tYour Choice: ");	
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 5:
			{
				Doctor_Type = "Lungs";
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Doctors where Doctor_Type='Lungs'");
					while(rs.next())
					{
						System.out.print("\tDoctor ID: "+rs.getInt(1)+"                             \n");
						System.out.print("\tName: "+rs.getString(2)+" "+rs.getString(3)+"           \n");
						System.out.print("\tEmail Address: "+rs.getString(9)+"                     \n");
						System.out.print("\tQualification: "+rs.getString(7)+"                      \n");
						System.out.print("\t                                                        \n");	
					}
					System.out.println("\tEnter the ID of the Doctor you want to choose.");
					System.out.print("\t					\n");
			        System.out.print("\tYour Choice: ");	
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 6:
			{
				Doctor_Type = "Kidney";
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Doctors where Doctor_Type='Kidney'");
					while(rs.next())
					{
						System.out.print("\tDoctor ID: "+rs.getInt(1)+"                         	\n");
						System.out.print("\tName: "+rs.getString(2)+" "+rs.getString(3)+"  			\n");
						System.out.print("\tEmail Address: "+rs.getString(9)+"                		\n");
						System.out.print("\tQualification: "+rs.getString(7)+"                      \n");
						System.out.print("\t														\n");	
					}
				}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("\tEnter the ID of the Doctor you want to choose.");
					System.out.print("\t					\n");
			        System.out.print("\tYour Choice: ");	
					int choosedID = sc.nextInt();
					return choosedID;
			}
			case 7:
			{
				Doctor_Type = "General Physicist";
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Doctors where Doctor_Type='General Physicist'");
					while(rs.next())
					{
						System.out.print("\tDoctor ID: "+rs.getInt(1)+"                         	\n");
						System.out.print("\tName: "+rs.getString(2)+" "+rs.getString(3)+"  			\n");
						System.out.print("\tEmail Address: "+rs.getString(9)+"                		\n");
						System.out.print("\tQualification: "+rs.getString(7)+"                      \n");
						System.out.print("\t                                                        \n");	
					}
					System.out.println("\tEnter the ID of the Doctor you want to choose.");
					System.out.print("\t					\n");
			        System.out.print("\tYour Choice: ");	
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			default :
		    {
		    	
		    	return 0;
		    }
		}
	}

 
	// Takes the Doctors' Name
	private String GetDoctorName(int docID)
	{
		String DoctorName = null;
		try
		{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorName = rs.getString(2);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorName;
	}

	// Takes the Doctors' Qualifications
	private String GetDoctorQualification(int docID)
	{
		String DoctorQualification = null;
		try
		{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorQualification = rs.getString(7);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorQualification;
	}

	// Adds all the details to the Appointment Table of the database
	public void ConfirmAppointment()
	{
			try
			{
				Connection con = ConnectionProvider.getCon();
				Statement st = con.createStatement();
				st.executeUpdate("INSERT INTO Appointments VALUES ('"+Apid+"','"+Problem+"','"+pid+"','"+Doctor_Name+"','"+Doctor_id+"','"+Doctor_Type+"','"+Doctor_Qualification+"','"+Appointment_Status+"')");
				System.out.print("\t					\n");
				System.out.println("\tYour appointment has been confirmed.");
			}
			catch(Exception e)
			{
				System.out.println("EXCEPTION OCCURS "+e.getMessage());
			}

	}
}