package pdf;

import java.awt.Font;
import java.io.FileOutputStream;

import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import guilogic.BottomGui;
import guilogic.TopGui;

public class PdfGenerator extends BottomGui{

	private Document document;
	private PdfWriter writer;
	//	private static com.itextpdf.text.Font calibri = new Font("Calibri", Font.BOLD, 16);
	static String var;
	private TopGui top;
	public BottomGui bottom;
	public DefaultTableModel pdfModel;

	public PdfGenerator(){
		try{
			document = new Document(PageSize.A4,  5, 10, 150, 5);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Georgi\\Desktop\\test.pdf");
			writer = PdfWriter.getInstance(document, fos);
			document.open();
			addMetaData(document);
			addTopSection(document);
			document.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/*public static void main(String[] args){
		new PdfGenerator();
	}*/

	private  void addMetaData(Document document){
		document.addTitle("test");
		document.addSubject("");
		document.addKeywords("");
		document.addAuthor("");
		document.addCreator("");
	}

	private  void addTopSection(Document document) throws DocumentException{

		Font calibri = new Font("Calibri", Font.BOLD, 16);
		Rectangle rect = writer.getPageSize();

		float[] columnWidths = {3.5f, 0.2f, 3.5f};
		PdfPTable table = new PdfPTable(columnWidths);
		table.setTotalWidth(1070);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell("Customer Name:  " + top.getTxtCustomerName());
		table.addCell(" ");
		table.addCell("Mobile Number:  ");
		table.addCell("Company Name: ");
		table.addCell(" ");
		table.addCell("Tel No: ");
		table.addCell("Address: 291B Wallisdown Road, Poole, Dorset");
		table.addCell(" ");
		table.addCell("");
		table.addCell("" /* Post Code here */);
		table.addCell(" ");
		table.addCell("");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell("Order No:  ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell("Date: ");
		
		document.add(table);
		addTableSection(document);
	}

	public  void addTableSection(Document document){
		try {
			document.add(pdfTable);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/*public  void addTableSection(Document document, DefaultTableModel model){

		PdfPTable pdfTable = new PdfPTable(model.getColumnCount());

		for (int i = 0; i < model.getColumnCount(); i++){
			pdfTable.addCell(model.getColumnName(i));
		}

		for (int rows = 0; rows < model.getRowCount() - 1; rows++){
			for (int columns = 0; columns <model.getColumnCount(); columns++){
				pdfTable.addCell(model.getValueAt(rows, columns).toString());
			}
		}

		try {
			document.add(pdfTable);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch(NullPointerException e){
			e.printStackTrace();
		} 
	}
	*/
	public DefaultTableModel pdfModel(){
		return pdfModel;
	}

}
