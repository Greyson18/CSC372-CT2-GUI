import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class BirthDateFrame extends JFrame implements ActionListener{
	private JButton calcButton;        //Triggers age calculation
	private JLabel birthLabel;         //Label for date of birth input
	private JLabel ageLabel;           //Label for age of user
	private JTextField ageField;       //Displays age of user
	private JTextField birthField;     //Displays users date of birth
	
	//Constructor to create GUI components and adds them to GridBagLayout
	BirthDateFrame(){
		GridBagConstraints layoutConst = null;
		
		//Set's the frame's title
		setTitle("Age Calculator");
		
		//Create labels
		birthLabel = new JLabel("Insert year you were born (YYYY-MM-DD): ");
		ageLabel = new JLabel("Your age will appear here: ");
		
		//Creates button and action listener
		calcButton = new JButton("Calculate");
		calcButton.addActionListener((ActionListener) this);
		
		//Create user age field
		ageField = new JTextField(15);
		ageField.setEditable(false);
		
		//Create date of birth field
		birthField = new JTextField(15);
		birthField.setEditable(true);
		
		setLayout(new GridBagLayout());
		
		//Specifying the components location on the grid
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 10, 1);
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		add (birthLabel, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 1, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		add (birthField, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 5, 10, 10);
		layoutConst.gridx = 2;
		layoutConst.gridy = 0;
		add (calcButton, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 0, 1, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		add (ageLabel, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(1, 0, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 2;
		add (ageField, layoutConst);
	}
	
	//Method is called when an event occurs
	@Override
	public void actionPerformed (ActionEvent event) {
		//Method to calculate inserted date of birth against current date
		try {
			LocalDate birth = LocalDate.parse(birthField.getText());
			LocalDate now = LocalDate.now();
			Period period = Period.between(birth, now);
			ageField.setText("Your are " + period.getYears() + " years old.");
		}
		//Catches wrong format input and display's an error message
		catch (Exception ex) {
			ageField.setText("Enter a valid date of birth.");
		}
		}
	
	public class BirthDate {

		//Creates a BirthDateFrame and makes it visible
		public static void main(String[] args) {
			//Creates the frame and its components
			BirthDateFrame myFrame = new BirthDateFrame();
			
			myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			myFrame.pack();
			myFrame.setVisible(true);
		}
	}
}

