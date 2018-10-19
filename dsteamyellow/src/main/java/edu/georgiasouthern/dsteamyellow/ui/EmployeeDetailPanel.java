package edu.georgiasouthern.dsteamyellow.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import edu.georgiasouthern.dsteamyellow.db.DBConnection;
import edu.georgiasouthern.dsteamyellow.db.NorthwindTableDefinitions.Employee;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class EmployeeDetailPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JLabel lblFirstNameData,lblID,lblIDData,lblBirthDate, lblBirthDateData, lblNotes,lblFirstName,lblHireDateData,lblLastNameData,lblHomePhoneData;
	JTextPane textPane;
	public EmployeeDetailPanel() {

		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		lblID = new JLabel("ID:");
		lblIDData = new JLabel("0");
		lblBirthDate = new JLabel("Birth Date:");
		lblBirthDateData = new JLabel("LONGDATEGOESHERE");
		lblNotes = new JLabel("Notes");
		lblFirstNameData = new JLabel("First Name");
		JLabel lblHireDate = new JLabel("Hire Date:");
		lblHireDateData = new JLabel("LONGDATEGOESHERE");
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastNameData = new JLabel("Name");
		JLabel lblAddress = new JLabel("Address:");
		JLabel lblTitle = new JLabel("Title:");
		JLabel lblNone = new JLabel("None");
		JLabel lblCity = new JLabel("City:");
		JLabel lblToc = new JLabel("ToC:");
		JLabel lblRegion = new JLabel("Region:");
		JLabel lblHomePhone = new JLabel("Home Phone:");
		JLabel lblPostalCode = new JLabel("Postal Code:");
		JLabel lblExtension = new JLabel("Extension:");
		JLabel lblCountry = new JLabel("Country:");
		lblHomePhoneData = new JLabel("912-123-345");
		
		add(lblID, "2, 2");
		add(lblIDData, "4, 2");
		add(lblBirthDate, "8, 2");
		add(lblBirthDateData, "10, 2");
		add(lblNotes, "12, 2");
		lblFirstName = new JLabel("First Name:");
		add(lblFirstName, "2, 4");
		add(lblFirstNameData, "4, 4");
		add(lblHireDate, "8, 4");
		add(lblHireDateData, "10, 4");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "12, 4, 1, 11, fill, fill");
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		add(lblLastName, "2, 6");
		add(lblLastNameData, "4, 6");
		add(lblAddress, "8, 6");
		add(lblTitle, "2, 8");
		add(lblNone, "4, 8");
		add(lblCity, "8, 8");
		add(lblToc, "2, 10");
		add(lblRegion, "8, 10");
		add(lblHomePhone, "2, 12");
		
		
		add(lblHomePhoneData, "4, 12");
		add(lblPostalCode, "8, 12");
		add(lblExtension, "2, 14");
		add(lblCountry, "8, 14");
		
	}
	
	public void setEmployee(int eid) {
		Employee e = DBConnection.getInstance().getEmployeeDetails(eid);
		
		lblIDData.setText(Integer.toString(e.getEmployeeID()));
		lblFirstNameData.setText(e.getFirstName());
		lblLastNameData.setText(e.getLastName());
		lblBirthDateData.setText(e.getBirthDate().toString());
		lblHireDateData.setText(e.getHireDate().toString());
		lblHomePhoneData.setText(e.getHomePhone());
		textPane.setText(e.getNotes());
	}

}