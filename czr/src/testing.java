import javax.swing.JFrame;

public class testing {
	public static void main(String[] args) {
		JFrame frame = new JFrame ("Cipher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		testingPanel panel = new testingPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
		

	}
	
}
