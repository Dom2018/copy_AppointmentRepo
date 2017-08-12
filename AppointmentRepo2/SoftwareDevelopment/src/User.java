import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class User {
	Vector<Appointment> appointments;
	String iD;
	String name;
	String uName;
	String password;
	
	public User(String ID, String name, String pass, String uName) {
		iD = ID;
		this.name = name;
		password = pass;
		appointments = new Vector<Appointment>(); 
		this.uName = uName;
	}
	
	public void addAppointment(String ID, String date, String patName, String notes) {
		//call parameterised appointment constructor with the above variables from the database and the "name" variable from this class
		//as the uName for the constructor
			Appointment ap = new Appointment(ID, patName, uName, notes, date);
			appointments.add(ap);
	}
	
	public Appointment getAppointment(String ID) {
		for(Appointment appt : appointments) {
			if(appt.getID().equals(ID))
				return appt;			
		}
		return null;
	}
	
	public Vector<Appointment> getAppointments() {
		return appointments;
	}
	
	public String getID() {
		return iD;
	}
}
