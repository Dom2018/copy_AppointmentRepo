package sourceCode;
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
	
	public Vector<String> getAppointment(String ID) {
		for(Appointment appt : appointments) {
			if(appt.getID().equals(ID)) {
				Vector<String> vS = new Vector<String>();
				vS.add(appt.getID());
				vS.add(appt.getDate());
				vS.add(appt.getPatName());
				vS.add(appt.getNotes());
				return vS;
			}			
		}
		return null;
	}
	
	public void setNewNotes(String newNotes, String ID) {
		for(Appointment appt : appointments) {
			if(appt.getID().equals(ID)) {
				appt.addNotes(newNotes);
			}
		}
	}
	
	public void removeAppointment(String ID) {
		for(Appointment appt : appointments) {
			if(appt.getID().equals(ID)) {
				appointments.removeElement(appt);
			}
		}
	}
	
	public Vector<Appointment> getAppointments() {
		return appointments;
	}
	
	public String getID() {
		return iD;
	}
}
