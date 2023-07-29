package iCare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Report
{
	// Variable Declaration
	Scanner input = new Scanner(System.in);
	private int RepId;
	private int pid;
	private int appid;
	private int docid;
	private String MedicinePrescribed;
	private String DoctorsComment;

	// This checks the number of reports and based on the answer, makes a new unique ID for the primary key
	private int AutoReportID()
	{
		int repID = 0;
		try{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select MAX(ReportId) as NextUserID from Reports");
			rs.next();
			repID = rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return repID+1;
	}

	// Diagnosing Function
	public void DiagnoseReport(int pid,int appid,int docid)
	{
		RepId = AutoReportID();
		System.out.println("\tReportID: "+RepId);
		this.pid = pid;
		System.out.println("\tPatientID: "+pid);
		this.appid = appid;
		System.out.println("\tAppointment ID: "+appid);
		this.docid = docid;
		System.out.println("\tDoctor ID: "+docid);
		System.out.print("\tPrescribed medicine to patient: ");
		MedicinePrescribed = input.nextLine();
		System.out.print("\tAdditional advice: ");
		DoctorsComment = input.nextLine();
		System.out.print("\tPlease type 1 to generate the report: ");
		int x = input.nextInt();
		if(x == 1)
		{
			GenerateReport();
			ShowReport();
		}
		else
		{
			System.out.println("Invalid details.");	
		}
	}

	// Generates the report and inserts it into the database
	public void GenerateReport()
	{
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO Reports VALUES ('"+RepId+"','"+appid+"','"+pid+"','"+docid+"','"+MedicinePrescribed+"','"+DoctorsComment+"')");
			System.out.println("Report generated successfully.");
			ChangeStatus();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	// Changes the status of appointment from pending to completed
	private void ChangeStatus()
	{
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("UPDATE Appointments SET Appointment_Status='Completed' WHERE AppointmentID="+appid);
		}
		catch(Exception e)
		{
			System.out.println("e.getMessage()");
		}
	}

	// Shows all report that are generated
	public void ShowReport()
	{
		try 
		{
			Connection con = ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Reports");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS"+e.getMessage());}  
	}
}