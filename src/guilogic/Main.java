package guilogic;

public class Main {
	
	public Main(){
		new BottomGui();
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
					new Main();
			}
		});
	}
}
