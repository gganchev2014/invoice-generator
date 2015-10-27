package guilogic;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validator {
	
	
	public void validatePopupAdd(JTextField field1, JTextField field2, JButton button){
		 if (field2.equals("") && !field1.getText().isEmpty()){
				JOptionPane.showMessageDialog(button, "Please Fill All the details!");
			}
		if(field2.getText().isEmpty() && field1.getText().isEmpty()){
			JOptionPane.showMessageDialog(button, "Please Fill All the details!");
			
		}else if(!field1.getText().matches("[0-9]+")){
			JOptionPane.showMessageDialog(button, "Please enter a price!");}
		
//		}else if (field1.getText().matches("[0-9]+") && field2.getText().isEmpty()){
	//		JOptionPane.showMessageDialog(button, "Please Fill All the details!");
		//}
		
	}
	
	public void validatePostCode(JTextField field, JButton button){
		
		if(!field.getText().matches("^(GIR ?0AA|[A-PR-UWYZ]([0-9]{1,2}|([A-HK-Y][0-9]([0-9ABEHMNPRV-Y])?)|[0-9][A-HJKPS-UW]) ?[0-9][ABD-HJLNP-UW-Z]{2})$")){
			JOptionPane.showMessageDialog(button, "Please type a valid UK Post Code!");
		}
	}
}
