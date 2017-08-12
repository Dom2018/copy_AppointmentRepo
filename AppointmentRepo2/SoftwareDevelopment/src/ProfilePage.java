import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.util.Vector;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfilePage {
	
	private Vector<String> mine;
	private JFrame frame;
	private JTable table;
	private DefaultTableModel tM;
	private Controller cntlr = Controller.getController();
	private JButton btnNewButton_1;
	private JButton delButton;
	private JButton addNotes;
	private JButton btnNewButton_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Login login = new Login();
					login.setVisible(true);
					
					ProfilePage window = new ProfilePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfilePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 811, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Appointment System - [User Name] Profile");
		tM = new DefaultTableModel();
		tM.addColumn("ID");
		tM.addColumn("Time");
		tM.addColumn("Name");
		tM.addColumn("Notes");
		
		Vector<Vector<String>> that = cntlr.getAppointments();
		for(Vector<String> v : that)
			tM.addRow(v);
		
		table = new JTable(tM);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 71, 775, 309);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Add Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddDialogue d = new AddDialogue();
				d.setVisible(true);
			}
		});
		btnNewButton.setBounds(479, 37, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Refresh List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tM.setNumRows(0);
				Vector<Vector<String>> that = cntlr.getAppointments();
				for(Vector<String> v : that)
					tM.addRow(v);
			}
		});
		btnNewButton_1.setBounds(222, 37, 108, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		delButton = new JButton("Delete");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmDelete d = new ConfirmDelete();
				d.setVisible(true);
				if(d.getConfirm()) {
					cntlr.deleteAppointment((String) tM.getValueAt(table.getSelectedRow(), 0));
					tM.removeRow(table.getSelectedRow());
				}
					
				d.dispose();
			}
		});
		delButton.setBounds(696, 37, 89, 23);
		frame.getContentPane().add(delButton);
		
		addNotes = new JButton("Add Notes");
		addNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewNotesDialogue d = new NewNotesDialogue((String) tM.getValueAt(table.getSelectedRow(), 0));
				d.setVisible(true);
			}
		});
		addNotes.setBounds(578, 37, 108, 23);
		frame.getContentPane().add(addNotes);
		
		btnNewButton_2 = new JButton("Detailed View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAppointmentDetail d = new ViewAppointmentDetail((String) tM.getValueAt(table.getSelectedRow(), 0));
				d.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(340, 37, 129, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
