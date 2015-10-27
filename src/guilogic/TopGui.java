package guilogic;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import guilogic.DateLabelFormatter;

public class TopGui {
	private JFrame frame;
	private JLabel lblCustomerName, lblCompanyName, lblAddress, lblPostCode, lblMobileNo, lblTelNo, lblOrderNo, lblDate;
	private JTextField txtCustomerName, txtCompanyName, txtAddress, txtPostCode, txtMobileNo, txtTelNo, txtOrderNo;
	
	public TopGui(){
		buildFrameAndHeader();
		buildInputForm();
	}
	
	private void buildFrameAndHeader(){
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("The Tyre Bay");
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		/* Header Panel*/
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 64);
		frame.getContentPane().add(panel);

		/* Header Label */
		JLabel lblHead = new JLabel("Header");
		lblHead.setFont(new Font("Verdana", Font.BOLD, 28));
		panel.add(lblHead);
	}

	private void buildInputForm(){
		JPanel panel = new JPanel();
		panel.setBounds(-3, 65, 900, 165);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		/* Customer Name */
		lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(10, 11, 120, 20);
		lblCustomerName.setAlignmentX(0.0f);
		lblCustomerName.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblCustomerName.setVerticalAlignment(SwingConstants.TOP);
		lblCustomerName.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblCustomerName);

		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(135, 8, 147, 20);
		panel.add(txtCustomerName);
		txtCustomerName.setColumns(10);

		/* Company Name */
		lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setBounds(10, 44, 120, 14);
		panel.add(lblCompanyName);

		txtCompanyName = new JTextField();
		txtCompanyName.setBounds(135, 38, 147, 20);
		panel.add(txtCompanyName);
		txtCompanyName.setColumns(10);

		/* Address */
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 95, 120, 14);
		panel.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(90, 94, 190, 20);
		panel.add(txtAddress);
		txtAddress.setColumns(10);

		/* Post Code */
		lblPostCode = new JLabel("Post Code:");
		lblPostCode.setBounds(10, 130, 120, 14);
		panel.add(lblPostCode);

		txtPostCode = new JTextField();
		txtPostCode.setBounds(90, 128, 90, 20 );
		panel.add(txtPostCode);
		txtPostCode.setColumns(10);

		/* Mobile No */
		lblMobileNo = new JLabel("Mobile Number:");
		lblMobileNo.setBounds(359, 6, 120, 20);
		panel.add(lblMobileNo);

		txtMobileNo  = new JTextField();
		txtMobileNo.setBounds(479, 7, 120, 20);
		panel.add(txtMobileNo);
		txtMobileNo.setColumns(10);

		/* Tel No */
		lblTelNo = new JLabel("Tel No:");
		lblTelNo.setBounds(359, 37, 60, 20);
		panel.add(lblTelNo);

		txtTelNo = new JTextField();
		txtTelNo.setBounds(479, 37, 120, 20);
		panel.add(txtTelNo);
		txtTelNo.setColumns(10);

		/* Date Label */
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(359,  94, 60, 20);
		panel.add(lblDate);

		/*  Date Picker */
		UtilDateModel dateModel = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month" );
		p.put("text.year", "Year");

		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
		datePanel.setBackground(Color.WHITE);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(479,  94, 120, 50);
		panel.add(datePicker);
		panel.setVisible(true);
	}

	
	public JFrame getFrame() {
		return frame;
	}
	public JTextField getTxtCustomerName() {
		return txtCustomerName;
	}
	public JTextField getTxtCompanyName() {
		return txtCompanyName;
	}
	public JTextField getTxtAddress() {
		return txtAddress;
	}		
	public JTextField getTxtPostCode() {
		return txtPostCode;
	}
	public JTextField getTxtMobileNo() {
		return txtMobileNo;
	}
	public JTextField getTxtTelNo() {
		return txtTelNo;
	}
	public JTextField getTxtOrderNo() {
		return txtOrderNo;
	}
}
