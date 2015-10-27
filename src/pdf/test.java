package pdf;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class test {
  public static void main(String[] argv) throws Exception {
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    model.addColumn("Col1");
    model.addRow(new Object[] { "r1" });
    model.addRow(new Object[] { "r2" });
    model.addRow(new Object[] { "r3" });
    
    // Get all the table data
    Vector data = model.getDataVector();

    JFrame f = new JFrame();
    f.setSize(300, 300);
    f.add(new JScrollPane(table));
    f.setVisible(true);
  }
}