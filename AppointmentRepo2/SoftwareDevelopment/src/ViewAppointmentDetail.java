import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class ViewAppointmentDetail extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField pNameBox;
	private JTextField dateBox;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			AddDialogue dialog = new AddDialogue();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public ViewAppointmentDetail(String id) {
		setTitle("Appointment System - Add Appointment");
		setModal(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Controller cntlr = Controller.getController();
		Vector<String> appt = cntlr.getAppointment(id);
		setBounds(100, 100, 832, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		pNameBox = new JTextField();
		pNameBox.setEditable(false);
		pNameBox.setColumns(10);
		pNameBox.setText(appt.get(2));
		
		dateBox = new JTextField();
		dateBox.setEditable(false);
		dateBox.setColumns(10);
		dateBox.setText(appt.get(1));
		
		JTextArea aNotesBox = new JTextArea();
		aNotesBox.setEditable(false);
		
		String notes = appt.get(3);
		
		for(String s : notes.split("\\^")) {
			aNotesBox.append(s + "\n\n");
		}
		
		
		
		JLabel lblNewLabel = new JLabel("Patient Name:");
		
		JLabel lblNewLabel_1 = new JLabel("Time and Date:");
		
		JLabel lblNewLabel_2 = new JLabel("Notes");
		
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel)
									.addComponent(pNameBox, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
								.addGap(238)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(dateBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1))
								.addGap(13))
							.addComponent(lblNewLabel_2))
						.addComponent(aNotesBox, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(pNameBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(aNotesBox, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
