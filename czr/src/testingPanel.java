import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class testingPanel extends JPanel{
	private JLabel inputLabel0, inputLabel,inputLabel2, outputLabel, resultLabel;
	private JTextField userText, number;
	private JRadioButton decrypt, encrypt;
	
	public testingPanel() {
		//All of the labels have different sizes and fonts
		
		inputLabel0 = new JLabel("Welcome to the Cipher Program!");
		inputLabel0.setFont(new Font ("Serif", Font.ITALIC, 20));
		
		inputLabel = new JLabel ("Enter your message:");
		inputLabel.setFont(new Font ("Serif", Font.PLAIN, 18));

		
		inputLabel2 = new JLabel ("            Shift:");
		inputLabel2.setFont(new Font ("Serif", Font.PLAIN, 18));

		
		outputLabel = new JLabel ("The coded message is:");
		outputLabel.setFont(new Font ("Serif", Font.PLAIN, 18));
		
		resultLabel = new JLabel ("...");
		resultLabel.setFont(new Font ("Serif", Font.PLAIN, 18));
		
		userText = new JTextField(20);
		userText.addActionListener(new TempListener());
		
		number = new JTextField(5);
		number.addActionListener(new TempListener());
		
		decrypt = new JRadioButton("Decrypt");
		decrypt.setForeground(Color.BLUE);
		decrypt.setFont(new Font ("Serif", Font.BOLD, 15));
		decrypt.setBackground(Color.lightGray);

		encrypt = new JRadioButton("Encrypt");
		encrypt.setForeground(Color.RED);
		encrypt.setFont(new Font ("Serif", Font.BOLD, 15));
		encrypt.setBackground(Color.lightGray);
	
		//Uses a button group because the user can either encrypt or decrypt not both
		
		ButtonGroup group = new ButtonGroup();
		group.add(encrypt);
		group.add(decrypt);
		
		//Listens to the choice made by the user
		TempListener listener = new TempListener();
		encrypt.addActionListener(listener);
		decrypt.addActionListener(listener);

		
		add(inputLabel0);
		add(inputLabel);
		add(inputLabel2);
		add(userText);
		add(number);
		add(encrypt);
		add(decrypt);
		add(outputLabel);
        add(resultLabel);

		
		setPreferredSize(new Dimension(360,150));
		setBackground(Color.lightGray);
	}
	
	private class TempListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			
			String inputText, outputText;
			int Cipher;
			Object source = event.getSource();
			
			//takes user's text and shift key
			String text = userText.getText();
			String num = number.getText();
			
			inputText = text.toLowerCase();
			Cipher = Integer.parseInt(num);
		
			
			//if encrypt is chosen then an Encryption object is created with the inputs needed and calls the encryption method 
			if (source == encrypt) {
			Encryption E1 = new Encryption(Cipher,inputText);
			outputText = E1.Encrypt();
			resultLabel.setFont(new Font ("Serif", Font.PLAIN, 17));
			resultLabel.setText(outputText);
			}
			
			//if decrypt is chosen then a Decryption object is created with the inputs needed and calls the decryption method 
			else if (source == decrypt) {
				Decryption D1 = new Decryption(Cipher, inputText);
				outputText = D1.Decrypt();

				resultLabel.setFont(new Font ("Serif", Font.PLAIN, 17));
				
				resultLabel.setText(outputText);
			}
			
		}
		
		
	}

}


	

