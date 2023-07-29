package iCare;
import iCare.*;
import java.sql.*;
import java.util.Scanner;

public class Main 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		
		// Variable Declarations
		String asciiArt = 
                " 	 __  ___   __   ____  ____ \n" +
                " 	(  )/ __) / _\\ (  _ \\(  __)\n" +
                " 	 )(( (__ /    \\ )   / ) _) \n" +
                " 	(__)\\___)\\_/\\_/(__\\_)(____)\n";
		
		// If check becomes true, the program exits
		boolean check = false;
		// Scanner Object variable
		Scanner sc = new Scanner(System.in);
		
		// Account variables
		Admin a = new Admin();
		Patients p = null;
		Doctor d = null;
		
		// Main Portal 
		while(true)
		{
			System.out.println(asciiArt);
	        System.out.print("\t1. ADMIN	- LOGIN		\n");
	        System.out.print("\t2. PATIENT 	- LOGIN		\n");
	        System.out.print("\t3. DOCTOR 	- LOGIN		\n");
	        System.out.print("\t                   		\n");
	        System.out.print("\t4. PATIENT 	- SIGN-UP	\n");
	        System.out.print("\t                    	\n");
	        System.out.print("\t5. EXIT					\n");
	        System.out.print("\t                    	\n");
	        System.out.print("\tYour Choice: ");
		int choice = sc.nextInt();
		System.out.print("\t                    \n");
		switch (choice)
		{
		
			// START OF ADMIN PORTAL

		    case 1:  
		    {  
		    	// If checkadmin becomes true, The user leaves the Admin's Portal
		    	boolean checkadmin = false;
		    	System.out.println("\tWelcome to Admins' Portal");
		    	String un;
		    	String pd;
		    	System.out.print("\tUsername: ");un = sc.next();
		    	System.out.print("\tPassword: ");pd = sc.next();
		    	if((un.compareTo("root") == 0 && pd.compareTo("123") == 0) || (un.compareTo("admin") == 0 && pd.compareTo("123") == 0 ))
		    	{
		    		while(true)
		    		{
		    			System.out.print("\t                        \n");
		    	        System.out.print("\tSelect Command: 		\n");
		    	        System.out.print("\t                        \n");
		    	        System.out.print("\t1. Doctors List 		\n");
		    	        System.out.print("\t2. Patients List		\n");
		    	        System.out.print("\t3. Add Doctor   		\n");
		    	        System.out.print("\t4. Remove Doctor        \n");
		    	        System.out.print("\t5. Appointment Details  \n");
		    	        System.out.print("\t6. View Feedback        \n");
		    	        System.out.print("\t7. Logout               \n");
		    	        System.out.print("\t                        \n");
		    	        System.out.print("\tYour Choice: ");	
		    			int ch = sc.nextInt();
		    			System.out.print("\t                        \n");
		    			
		    			// START OF SWITCH BLOCK
		    			
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					// Displays the available doctors
		    					a.viewDoctors();
		    					break;
		    				}
		    				case 2:
		    				{
		    					// Displays current patients
		    					a.viewPatients();
		    					break;
		    				}
		    				case 3:
		    				{
		    					// Function to add a new doctor
		    					int Id = a.addDoctor();
		    					d = new Doctor();
		    					d.DoctorRegistration(Id);
		    					break;
		    				}
		    				case 4:
		    				{
		    					// Function to remove a doctor
		    					System.out.print("\tEnter Doctor ID: ");
		    					int id = sc.nextInt();
		    					a.RemoveDoctor(id);
		    					break;
		    				}
		    				case 5:
		    				{
		    					// Display the list of Appointments
		    					a.ViewAppointment();
		    					break;
		    				}
		    				case 6:
		    				{
		    					//TO VIEW FEEDBACK GIVEN BY THE PATIENT//
		    					a.ViewFeedback();
		    					break;
		    				}
		    				case 7:
		    				{
		    					// This Logs the administrator out
		    					checkadmin = true;
		    					break;
		    					
		    				}
		    				default:
		    				{
		    					System.out.println("                               ");
		    					System.out.println("\tPlease choose a valid option.");
		    					System.out.println("                               ");
		    				}
		    			}
		    			if(checkadmin)
		    				break;
		    		}
		    		
		    	}
		    	else
		    	{
		    		System.out.println("                               ");
		    		System.out.println("\tInvalid username or password.");
		    		System.out.println("                               ");
		    	}
		    	break;
		    }
		    
		    // START OF PATIENT PORTAL
		    
		    case 2: 
		    {
		    	// If checkPatient becomes true, The user leaves the Patient Portal
		    	
		    	boolean checkPatient = false;
		    	int flag = 0;
		    	System.out.println("\tWelcome to the Patients' Portal");
		    	
		    	// This where the user logs in
		    	int id;
		    	String pd;
		    	System.out.print("\tID: ");id = sc.nextInt();
		    	System.out.print("\tPassword: ");pd = sc.next();
		    	
		    	// START OF ACCOUNT CHECK
		    	try {
		    		// This is where the program connects to the database and checks whether the ID exists
		    		
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("Select * from Users");
					while(rs.next()) {
						if(rs.getInt(1) == id && rs.getString(2).compareTo("Patient") == 0 && (rs.getString(3).compareTo(pd) == 0 ))
						{
							flag = 1;
						}
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
		    	// END OF ACCOUNT CHECK
		    	// If flag equals 1, It means that the ID of the patient exists
		    	
		    	if(flag == 1)
		    	{
		    		p = new Patients();
		    		while(true)
		    		{
		    	        System.out.print("\t								\n");
		    	        System.out.print("\t1. View Profile					\n");
		    	        System.out.print("\t2. View Doctors					\n");
		    	        System.out.print("\t3. Book Appointments			\n");
		    	        System.out.print("\t4. View Diagnose Reports		\n");
		    	        System.out.print("\t5. View Appointments			\n");
		    	        System.out.print("\t6. View Completed Appointments	\n");
		    	        System.out.print("\t7. Give Feedback                \n");
		    	        System.out.print("\t8. Logout						\n");
		    	        System.out.print("\t								\n");
		    	        System.out.print("\tYour Choice: ");
		    			int ch=sc.nextInt();
		    			System.out.print("\t								\n");
		    			
		    			// START OF SWITCH BLOCK
		    			
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					// This shows the details of the patient
		    					p.ShowPatientDetails(id);
		    					break;
		    				}
		    				case 2:
		    				{
		    					// This shows the doctors that is associated with the patient
		    					p.viewDoctor();
		    					break;
		    				}
		    				case 3:
		    				{
		    					// This function creates an appointment in which the patient can see the doctor
		    					p.BookAppointment(id);
		    					break;
		    				}
		    				case 4:
		    				{
		    					p.ViewReport(id);
		    					break;
		    				}
		    				case 5:
		    				{
		    					// This function views the appointment made for the doctor
		    					p.viewAppointment(id);
		    					break;
		    				}
		    				case 6:
		    				{
		    					// This views the history of appointments made by the patient
		    					p.AppointmentHistory(id);
		    					break;
		    				}
		    				case 7:
		    				{
		    					p.Givefeedback(id);
		    					break;
		    					
		    				}
		    				case 8:
		    				{
		    					// This exits the Patient Portal
		    					checkPatient = true;
		    					break;
		    				}
		    				default:
		    				{
		    					// Exception Handler
		    					System.out.println("\tPlease choose a valid option.");
		    				}
		    			}
		    			if(checkPatient)
		    				break;
		    		}
		    	}
		    	else
	    		{
	    			System.out.println("\tInvalid ID or Password.");
	    		}
		    	break;
		    }
		    
		    // START OF DOCTOR PORTAL
		    
		    case 3:
		    {
		    	// If checkDoctor becomes true, The user leaves the Doctor Portal
		    	boolean checkDoctor = false;
		    	System.out.println("\tWelcome to the Doctor's Portal.");
		    	int flag=0;
		    	
		    	// This where the user logs in
		    	int id;
		    	String pd;
		    	System.out.print("\tDoctor ID: ");id=sc.nextInt();
		    	System.out.print("\tPassword: ");pd=sc.next();
		    	
		    	// START OF ACCOUNT CHECK
		    	try {
		    		// This is where the program connects to the database and checks whether the ID exists
		    		Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("Select * from Users");
					while(rs.next()) {
						if(rs.getInt(1) == id && rs.getString(2).compareTo("Doctor") == 0 && (rs.getString(3).compareTo(pd) == 0 )){
							flag = 1;
						}
					}
				}catch(Exception e){
					System.out.println("\tNot registered.");
				}
		    	
		    	// END OF ACCOUNT CHECK
		    	// If flag equals 1, It means that the ID of the patient exists
		    	if(flag == 1)
		    	{
		    		while(true)
		    		{
		    	        System.out.print("\t						\n");
		    	        System.out.print("\t1. View Doctor Profile	\n");
		    	        System.out.print("\t2. View Appointment		\n");
		    	        System.out.print("\t3. Diagnose Patient		\n");
		    	        System.out.print("\t4. Logout          		\n");
		    	        System.out.print("\t						\n");
		    	        System.out.print("\tYour Choice: ");	
		    			int ch = sc.nextInt();
		    			System.out.print("\t						\n");
		    			
		    			// START OF SWITCH BLOCK
		    			
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					// This shows the doctor's details
		    					d = new Doctor();
		    					d.ShowDoctorDetails(id);
		    					break;
		    				}
		    				case 2:
		    				{
		    					// This views the list of patients that enlisted appointments
		    					d = new Doctor();
		    					d.viewAppointment(id);
		    					break;
		    				}
		    				case 3:
		    				{
		    					// This Diagnoses the Patient that made an appointment
		    					d = new Doctor();
		    					d.DiagnosePatient(id);
		    					break;
		    				}
		    				case 4:
		    				{	
		    					// This exits the user from the Doctor Portal
		    					checkDoctor = true;
		    					break;
		    				}
		    				default:
		    				{
		    					System.out.println("\tSelect an option.");
		    				}
		    			}
		    			// end of switch.
		    			if(checkDoctor)
		    				break;
		    		}
		    		// end of while
		    			break;
		    	}
		    	// end of if
		    	else {
		    		System.out.println("\tInvalid username or password.");
		    	}
		    	break;
		    }
		    
		    // START OF PATIENT REGISTRATION
		    
		    case 4:
		    {
		    	p = new Patients();
		    	int pid = p.addPatient();
		    	System.out.println("\tFill the following details:");
		    	p.PatientRegistration(pid);
		    	break;
		    }
		    case 5:
		    {
		    	System.out.println("\tThanks for visiting us. Have a nice day!");
		    	check = true;
		    	break;
		    }
		    default :
		    {
		    	System.out.println("\tPlease choose a valid option.");
		    }
		}
		//end of switch
		if(check)
			break;
		}
		//end of while loop
	}
}
