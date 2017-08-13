package sourceCode;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class AddDialogue extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6529370734135490951L;
	private final JPanel contentPanel = new JPanel();
	private JTextField pNameBox;

	public AddDialogue() {
		setTitle("Appointment System - Add Appointment");
		setModal(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Controller cntlr = Controller.getController();
		setBounds(100, 100, 568, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		pNameBox = new JTextField();
		pNameBox.setColumns(10);
		
		JTextArea aNotesBox = new JTextArea();
		
		JComboBox<String> yearDrop = new JComboBox<String>();
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		yearDrop.addItem("Year");
		for(int i = 0; i <= 10; i++) {
			yearDrop.addItem(String.valueOf(year++));
		}
		
		JComboBox<String> monthDrop = new JComboBox<String>();
		monthDrop.addItem("Mon");
		monthDrop.addItem("Jan");
		monthDrop.addItem("Feb");
		monthDrop.addItem("Mar");
		monthDrop.addItem("Apr");
		monthDrop.addItem("May");
		monthDrop.addItem("Jun");
		monthDrop.addItem("Jul");
		monthDrop.addItem("Aug");
		monthDrop.addItem("Sep");
		monthDrop.addItem("Oct");
		monthDrop.addItem("Nov");
		monthDrop.addItem("Dec");
		
		JComboBox<String> dayDrop = new JComboBox<String>();
		dayDrop.addItem("Dy");

		monthDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String month = (String) monthDrop.getSelectedItem();
				dayDrop.removeAllItems();
				if(month == "Mon") {
					dayDrop.addItem("Dy");
				}else if(month == "Feb") {
					for(int i = 1; i <= 28; i++) {
						dayDrop.addItem(String.valueOf(i));
					}
				}else if(month == "Apr" || month == "Jun" || month == "Sep" || month =="Nov") {
					for(int i = 1; i <= 30; i++) {
						dayDrop.addItem(String.valueOf(i));
					}
				}else {
					for(int i = 1; i <= 31; i++) {
						dayDrop.addItem(String.valueOf(i));
					}
				}
					
			}
		});
		
		JComboBox<String> timeStartDrop = new JComboBox<String>();
		timeStartDrop.addItem("Time");
		for(int i = 8; i < 17; i += 1) {
			timeStartDrop.addItem(("00" + String.valueOf(i)).substring(String.valueOf(i).length()) + ":00");
		}
		
		JLabel lblNewLabel = new JLabel("Patient Name:");
		
		JLabel lblNewLabel_1 = new JLabel("Time and Date:");
		
		JLabel lblNewLabel_2 = new JLabel("Preliminary Notes:");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(pNameBox, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
									.addGap(18))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(timeStartDrop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dayDrop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(monthDrop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(yearDrop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(aNotesBox, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(pNameBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearDrop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthDrop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayDrop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(timeStartDrop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(aNotesBox, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Vector<String> v = new Vector<String>();
						String pName = pNameBox.getText().trim();
						String notes = aNotesBox.getText();
						String time = (String) timeStartDrop.getSelectedItem();
						String day = (String) dayDrop.getSelectedItem();
						String month = (String) monthDrop.getSelectedItem();
						String year = (String) yearDrop.getSelectedItem();
						
						String date = day + " " + month + " " + year + " at " + time;
							
						if(pName.length() > 0 && notes.length() > 0 && !time.equals("Time") && !day.equals("Dy") && !month.equals("Mon") && !year.equals("Year")) {
							v.add(date);
							v.add(pName);
							v.add(notes);
							cntlr.addNewAppointment(v);
							
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
