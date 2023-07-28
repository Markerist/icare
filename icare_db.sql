/* iCare Database **/
create database iCare_db;
use iCare_db;
/* Users Table */
create table Users(
	userID int,
    userType varchar(100),
	Password varchar(100),
	primary key(userID,userType)
);
select * from Users;
insert into Users ( userID , userType, Password)
values
(1,'Patient','One'),
(2,'Patient','Two'),
(3,'Patient','Three'),
(4,'Patient','Four'),
(5,'Patient','Five'),
(6,'Patient','Six'),
(7,'Patient','Seven'),
(8,'Patient','Eight'),
(9,'Patient','Nine'),
(10,'Patient','Ten'),
(11,'Patient','Eleven'),
(12,'Patient','Twelve'),
(13,'Patient','Thirteen'),
(14,'Patient','Fourteen'),
(15,'Patient','Fifteen'),
(16,'Patient','Sixteen'),
(17,'Patient','Seventeen'),
(18,'Patient','Eighteen'),
(19,'Patient','Nineteen'),
(20,'Patient','Twenty'),
(1,'Doctor','One'),
(2,'Doctor','Two'),
(3,'Doctor','Three'),
(4,'Doctor','Four'),
(5,'Doctor','Five'),
(6,'Doctor','Six'),
(7,'Doctor','Seven'),
(8,'Doctor','Eight'),
(9,'Doctor','Nine'),
(10,'Doctor','Ten'),
(11,'Doctor','Eleven'),
(12,'Doctor','Twelve'),
(13,'Doctor','Thirteen'),
(14,'Doctor','Fourteen'),
(15,'Doctor','Fifteen'),
(16,'Doctor','Sixteen'),
(17,'Doctor','Seventeen'),
(18,'Doctor','Eighteen'),
(19,'Doctor','Nineteen'),
(20,'Doctor','Twenty');
/* Patients Table */
create table Patients(
	PatientID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(5),
    ContactNumber varchar(11),
    Age int ,
    EmailID varchar(30),
    BloodGroup varchar(5),
    Address varchar(50),
	primary key(PatientID)
);
insert into Patients ( PatientID, First_Name, Last_Name, Gender, ContactNumber, Age, EmailId, BloodGroup, Address)
values
(1,"Juan","Reyes","M","9828698648",28,"juan24Reyes@gmail.com","B+","Pasig City, Metro Manila"),
(2,"Maria","Cruz","M","9858688788",30,"maria54cruz@gmail.com","B+","Quezon City, Metro Manila"),
(3,"Pedro","Santos","M","9667479292",34,"peterSantos1703@gmail.com","A+","Taguig, Philippines"),
(4,"Sofia","Garcia","F","8005629518",28,"SofiaGarcia@gmail.com","B-","PlotNo. 104 Mandaluyong,Manila"),
(5,"Michael","Fernandez","M","9828652524",18,"MicahelF02@gmail.com","AB+","Davao City,Philippines"),
(6,"Rachel","Ramirez","M","9279264253",42,"santinoshara8@gmail.com","B-","Iloilo City, Iloilo"),
(7,"Marygin","DelaCruz","F","8005263213",32,"Mamamarygin@gmail.com","A-","Cebu City, Cebu"),
(8,"Sancho","Lopez","M","8214358648",46,"Sancho000@gmail.com","O+","Makati City, Metro Manila"),
(9,"Glen","Villanueva","F","9825426363",15,"VillanuevaGlen78@gmail.com","AB+","Baguio City, Benguet"),
(10,"Angie","Castro","M","9828565642",28,"AngiepainCastro@gmail.com","AB-","Pasay City, Metro Manila"),
(11,"Ranil","Ramos","M","8052674312",68,"LgeeRanil@gmail.com","O+","General Santos City, South Cotabato"),
(12,"Rodrigo","Torres","F","9797465823",18,"Rodrigotorres423@gmail.com","A+","Lapu-Lapu City, Cebu"),
(13,"Vanessa","Gonzales","F","7073165498",24,"Purpleyam556@gmail.com","AB-","Zamboanga City, Zamboanga del Sur"),
(14,"Rosario","Debil","F","8302567823",56,"rosariodebil@gmail.com","B-","Parañaque City, Metro Manila"),
(15,"Cloud","Martines","M","9886756678",36,"Ulapmartines@gmail.com.com","AB+","Marikina City, Metro Manila"),
(16,"Jose","Rivas","M","8308576312",24,"JoseRivas11@gmail.com","A+","Antipolo City, Rizal"),
(17,"Elena","Aquino","M","7782385721",42,"Elenagandal456@gmail.com","B+"," San Juan City, Metro Manila"),
(18,"Lourdes","Marcos","F","8857283942",32,"LourdesMarcosl100@gmail.com","A-","Bacolod City, Negros Occidental"),
(19,"Manuel","delaRosa","M","9815215367",12,"PapiManuell100@gmail.com","B-","Cagayan de Oro City, Misamis Oriental"),
(20,"Beatriz","Duterte","F","8358032156",27,"Beaduts124@gmail.com","O+","Davao City, Davao del Sur");
select * from Patients;
/* Doctor Table */
create table Doctors(
	DoctorID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(10),
    ContactNumber varchar(11),
    Age int ,
    Qualification varchar(50),
    Doctor_Type varchar(50),
    Email_Id varchar(30),
    primary key(DoctorID)
);
insert into Doctors (DoctorID, First_Name, Last_Name, Gender, ContactNumber, Age, Qualification, Doctor_Type, Email_Id)
values
(1, "Ramon", "Santos", "M", "9243668213", 32, "MD", "Ear", "ramonsantos@gmail.com"),
(2, "Victor", "Gomez", "M", "9382674321", 42, "BDS", "Lungs", "victorgomez@gmail.com"),
(3, "Arnold", "Alvarez", "M", "8213264251", 47, "BHMS", "Eye", "arnoldalvarez@gmail.com"),
(4, "Luz", "Dela Cruz", "F", "7782934712", 27, "MD", "Kidney", "luzdelacruz@gmail.com"),
(5, "Maria", "Santos", "F", "9982675837", 33, "MD", "Heart", "mariasantos@gmail.com"),
(6, "Emilio", "Fernandez", "M", "9788855387", 58, "MBBS", "Lungs", "emiliofernandez@gmail.com"),
(7, "Andrea", "Kapunan", "F", "9985671358", 36, "BAMS", "General Physicist", "andreakapunan@gmail.com"),
(8, "Antonio", "Aguinaldo", "M", "8763505789", 25, "PhD", "Kidney", "antonioaguinaldo@gmail.com"),
(9, "Pedro", "Gomez", "M", "7855671213", 52, "MBBS", "Heart", "pedrogomez@gmail.com"),
(10, "Rosalinda", "Javier", "F", "8005628135", 68, "BDS", "Lungs", "rosalindajavier@gmail.com"),
(11, "Diego", "Santos", "M", "9505745565", 38, "MS", "General_Physician", "diegosantos@gmail.com"),
(12, "Juan", "Yap", "M", "9460812415", 47, "BAMS", "Eye", "juanyap@gmail.com"),
(13, "Hector", "Chua", "M", "9855762432", 54, "PhD", "Ear", "hectorchua@gmail.com"),
(14, "Salvacion", "Perez", "F", "9651404283", 63, "BHMS", "Bone", "salvacionperez@gmail.com"),
(15, "Manuel", "Santos", "M", "9887635723", 69, "BUMS", "Bone", "manuelsantos@gmail.com"),
(16, "Felix", "Gomez", "M", "9988735721", 29, "BDS", "Ear", "felixgomez@gmail.com"),
(17, "Carlos", "Manalo", "M", "7082172315", 35, "MBBS", "Heart", "carlosmanalo@gmail.com"),
(18, "Felicia", "Ramos", "F", "9652385745", 39, "MD", "Kidney", "feliciaramos@gmail.com"),
(19, "Rina", "Santos", "F", "8857638923", 24, "BDS", "Lungs", "rinasantos@gmail.com"),
(20, "Gabriel", "Tolentino", "M", "8112857382", 40, "MBBS", "Heart", "gabrieltolentino@gmail.com");
select * from Doctors;
/* Appointments Table */
create table Appointments
(
	AppointmentID int,
    Problem varchar(50),
	PatientId int,
    DoctorName varchar(20),
    DoctorID int,
    DoctorType varchar(20),
    Qualification varchar(20),
    Appointment_Status varchar(30),
	primary key (AppointmentID),
    CONSTRAINT FK_p FOREIGN KEY (patientId)REFERENCES Patients(PatientID),
    CONSTRAINT FK_docid FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
    ON DELETE CASCADE
	ON UPDATE CASCADE
);
SELECT * FROM Appointments;
/* Reports Table */
create table Reports
(
	ReportID int,
    appointmentID int,
    patientID int,
    DoctorID int,
    MedicinePrescribed varchar(200),
    DoctorComment varchar(200),
    primary key (ReportID),
    CONSTRAINT FK_apid FOREIGN KEY (appointmentID) REFERENCES Appointments(AppointmentID)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);
select * from Reports;
/* Feedback Table */
create table feedback
(
	PatientID int,
    points int,
    Doc_Nature varchar(200),
    Location varchar(200),
    PatientComment varchar(1000),
    CONSTRAINT FK_pid FOREIGN KEY (PatientID) REFERENCES Patients(PatientID)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);
select * from feedback;