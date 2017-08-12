
public class Appointment {
	String iD;
	String patName;
	String uName;
	String notes;
	String date;
	
	public Appointment() {}
	
	public Appointment(String iD, String patName, String uName, String notes, String date) {
		this.iD = iD;
		this.patName = patName;
		this.uName = uName;
		this.notes = notes;
		this.date = date;
	}
	
	public void setID(String newID) {
		iD = newID;
	}
	
	public void setPatName(String newPatName) {
		patName = newPatName;
	}
	public void setNotes(String notes) {
		//set Notes when creating new appt 
		this.notes = notes;
	}
	public void addNotes(String newNotes) {
		notes = notes + newNotes;
	}
	public void setDate(String newDate) {
		date = newDate;
	}
	
	public String getID() {
		return iD;
		//Get appoiontment ID (PK from database)
	}
	public String getPatName() {
		return patName;
		//get patient name
	}
	public String getNotes() {
		return notes;
		//get notes 
	}
	public String getDate() {
		return date;
		//get appointment date
	}
}
