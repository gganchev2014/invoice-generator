package guilogic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pdf.PdfGenerator;

public class BottomGui {

	private JFrame popUpFrame;
	private JLabel quantityValue;
	private JTextField txtDescription, txtPrice; 
	JButton buttonAdd;

	private int quantity = 1;
	private int count = 0;
	public DefaultTableModel model;
	public JTable table;
	TopGui top = new TopGui();
	Validator validate = new Validator();
	private JButton buttonPrint;
	List<String> data = new ArrayList<String>();
	PdfGenerator pdf;

	public BottomGui(){
		buildTableForm();
		buildPopupFrame();
	}


	private void buildTableForm(){
		JPanel panel = new JPanel();
		panel.setBounds(-3, 220 , 900, 900);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setOpaque(true);
		top.getFrame().getContentPane().add(panel);
		panel.setLayout(null);

		/* Table settings */
		model = new DefaultTableModel();
		model.addColumn("Item");
		model.addColumn("Description");
		model.addColumn("Quantity");
		model.addColumn("Unit Price");
		model.addColumn("Amount");
		table = new JTable(model);
		table.setModel(model);
		JPanel jPanel = new JPanel(new GridLayout(5, 3));
		jPanel.setOpaque(true);
		jPanel.setBounds(20, 70 , 750, 1500);
		table.setPreferredScrollableViewportSize(new Dimension(100, 600));			 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);									 
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(470);
		table.setRowHeight(30);

		/* Add Row button */
		JButton buttonAddRow = new JButton("Add");
		buttonAddRow.setBounds(8, 15, 98, 35);
		buttonAddRow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				popUpFrame.setVisible(true);
				txtDescription.setText("");
				txtPrice.setText("");
				quantity = 1;
				quantityValue.setText("1");
			}
		});
		panel.add(buttonAddRow);

		/* Delete button */
		JButton buttonDel = new JButton("delete");
		buttonDel.setBounds(128, 15, 98, 35);
		panel.add(buttonDel);
		buttonDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1){
					model.removeRow(selectedRow);
				}
			}
		});

		/* Button Print */
		buttonPrint = new JButton("Print");
		buttonPrint.setBounds(8,400 , 98, 35);
		panel.add(buttonPrint);

		buttonPrint.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new PdfGenerator();
			}

		});


		jPanel.add(new JScrollPane(table));
		panel.add(jPanel);
		panel.setVisible(true);
		top.getFrame().getContentPane().add(panel);
	}

	private void buildPopupFrame(){
		popUpFrame = new JFrame();
		popUpFrame.setResizable(false);
		popUpFrame.setBounds(100, 100, 300, 300);

		JPanel panel = new JPanel();
		panel.setBounds(0,0,120,20);
		panel.setVisible(true);
		panel.setLayout(null);
		popUpFrame.getContentPane().add(panel);

		/* Description Label */
		JLabel lblDesc = new JLabel("Item Description");
		lblDesc.setBounds(10, 11, 180, 20);
		lblDesc.setFont(new Font("Calibri", Font.BOLD, 16));
		panel.add(lblDesc);

		/* Description Text Field */
		txtDescription = new JTextField();
		txtDescription.setBounds(10, 35, 260, 25);
		txtDescription.setFont(new Font("Calibri", Font.PLAIN, 14));
		panel.add(txtDescription);

		/* Quantity Label */
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(10, 84, 120, 20);
		lblQuantity.setFont(new Font("Calibri", Font.BOLD, 16));
		panel.add(lblQuantity);

		/* Quantity Read Value */
		quantityValue = new JLabel("1");
		quantityValue.setBounds(100, 70, 50, 50);
		quantityValue.setFont(new Font("Calibri", Font.BOLD, 20));
		panel.add(quantityValue);

		/* Price Label*/
		JLabel lblPrice = new JLabel("Unit Price: £");
		lblPrice.setBounds(10, 130, 120, 50);
		lblPrice.setFont(new Font("Calibri", Font.BOLD, 16));
		panel.add(lblPrice);

		/* Price Textfield */
		txtPrice = new JTextField();
		txtPrice.setBounds(130, 143, 90, 25);
		panel.add(txtPrice);		

		/* Button + */
		JButton buttonPlus = new JButton("p");
		buttonPlus.setBounds(130, 80, 32,32);
		buttonPlus.setFont(new Font("Calibri", Font.BOLD, 2));
		panel.add(buttonPlus);

		/* Button - */
		JButton buttonMinus = new JButton("m");
		buttonMinus.setBounds(180, 80, 32,32);
		panel.add(buttonMinus);

		/* Button Add */
		buttonAdd = new JButton("Add");
		buttonAdd.setBounds(217, 195, 65,65);
		panel.add(buttonAdd);

		buttonAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					count++;
					String descStr = txtDescription.getText();
					String quantityStr = quantityValue.getText();
					String priceStr = txtPrice.getText();
					double priceInt = Double.parseDouble(priceStr);
					int quantityInt = Integer.parseInt(quantityStr);
					Double amount = quantityInt * priceInt;
					model.addRow(new Object[]{count,descStr,quantityStr,priceStr, amount});
					popUpFrame.dispose();
				}catch(NumberFormatException b){
					validate.validatePopupAdd(txtPrice, txtDescription, buttonAdd);
				}
			}
		});

		buttonPlus.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				quantity++;
				quantityValue.setText(""+quantity);
			}
		});

		buttonMinus.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(quantity>1){
					quantity--;
					quantityValue.setText(""+quantity);
				}
			}
		});
	}

	public JButton getButtonAdd() {
		return buttonAdd;
	}


	public JTextField getTxtDescription() {
		return txtDescription;
	}


	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public DefaultTableModel getModel(){
		return model;
	}
	public  JTable getTable(){
		return table;
	}
	
	public List<String> getData(){
		return data;
	}

}
