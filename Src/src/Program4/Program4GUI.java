package Program4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
/**
Generates a program to practice math questions using selected methods 
*/
public class Program4GUI extends JFrame{

	private JTextField answerTextField;	//to hold answer
	private JButton answerButton;		//to push when checking answer
	private JButton getQuestionButton;	//to generate a question
	private JRadioButton onesRange;		//to select ones values
	private JRadioButton tensRange;		//to select tens values
	private JRadioButton hundredsRange;	//to select hundreds values
	private JRadioButton negativeYes;	//to include negatives
	private JRadioButton negativeNo;	//to only include positive values
	private JRadioButton addition;		//to choose addition	
	private JRadioButton subtraction;	//to choose subtraction
	private JRadioButton multiply;		//to choose multiplication
	private JRadioButton divide;		//to choose division
	private JLabel questionLabel;		//shows generated question
	private JLabel answerLabel;			//to show correct and incorrect number of answers
	private boolean isNegative;			//holds boolean value for negatives being used
	private int intRange;				//holds value to identify integer range chosen
	private String operationSelected;	//holds string of math operation selected
	private MathQuestion question;		//generates a MathQuestion class
	private int numCorrect;				//holds number of questions correct
	private int numWrong;				//holds number of questions wrong
	
	/**
	 * Constructor
	 */
	
	public Program4GUI(){
		
		//set title of window
		setTitle("Math Practice");
		
		//set size of window
		setSize(800,350);
		
		//set layout of window
		setLayout(new BorderLayout());
		
		//Specify default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create greetingPanel
		JPanel greetingPanel = new JPanel();
		JLabel greeting = new JLabel("Welcome to the Math Practice App");
		greetingPanel.add(greeting);
		
		//create valuesPanel		
		JPanel valuesPanel = new JPanel();
		
		//Create the radio buttons for values
		onesRange = new JRadioButton("0-9");
		tensRange = new JRadioButton("0-99");
		hundredsRange = new JRadioButton("0-999");
			
		//group the valuesRange buttons
		ButtonGroup valuesRange = new ButtonGroup();
			
		valuesRange.add(onesRange);
		valuesRange.add(tensRange);
		valuesRange.add(hundredsRange);

		//add border around panel with title
		valuesPanel.setBorder(BorderFactory.createTitledBorder("Select a Value Range"));
			
		valuesPanel.add(onesRange);
		valuesPanel.add(tensRange);
		valuesPanel.add(hundredsRange);
		
		//create negativePanel
		JPanel negativePanel = new JPanel();
		
		//group the negative or positive choice buttons
		negativeYes = new JRadioButton("Yes");
		negativeNo = new JRadioButton("No");
			
		//group the negatives choice radio buttons
		ButtonGroup negativesIncluded = new ButtonGroup();
		negativesIncluded.add(negativeYes);
		negativesIncluded.add(negativeNo);
			
		//add border and title
		negativePanel.setBorder(BorderFactory.createTitledBorder("Include Negative Values"));
			
		//add buttons to panel
		negativePanel.add(negativeYes);
		negativePanel.add(negativeNo);

		//create label to display question
		questionLabel= new JLabel();
		questionLabel.setFont(new Font("SansSerif", Font.CENTER_BASELINE,24));
		
		//create label to display number correct and incorrect
		answerLabel=new JLabel("Number Correct: 0  Number Wrong: 0");
		answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//create a text field 6 characters wide
		answerTextField= new JTextField(20);
		
		//create an answer button
		answerButton=new JButton("Answer");
		answerButton.addActionListener(new AnswerButtonListener());
		
		//create question button to generate a question
		getQuestionButton=new JButton("Get Question");
		getQuestionButton.addActionListener(new QuestionButtonListener());		
		
		//create a JPanel object to reference
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(25,25));
		panel.setBorder(BorderFactory.createEtchedBorder());
		
		//create question panel
		JPanel questionPanel=new JPanel();
		
		//add components to question panel
		questionPanel.add(getQuestionButton);
		
		//add components to answer panel
		panel.add(answerTextField, BorderLayout.EAST);
		panel.add(questionLabel, BorderLayout.WEST);
		panel.add(answerButton, BorderLayout.SOUTH);
		panel.add(answerLabel, BorderLayout.NORTH);
		
		//create JPanel for math operations reference
		JPanel operationPanel = new JPanel();
		//add border and title to panel
		operationPanel.setBorder(BorderFactory.createTitledBorder("Choose an Operation"));

		
		//create radio buttons for math operations 
		addition = new JRadioButton("add");
		subtraction = new JRadioButton("subtract");
		multiply = new JRadioButton("multiply");
		divide = new JRadioButton("divide");

		//create button group 
		ButtonGroup operations = new ButtonGroup();
		operations.add(addition);
		operations.add(subtraction);
		operations.add(multiply);
		operations.add(divide);
		
		//add components to operations panel
		operationPanel.add(addition);
		operationPanel.add(subtraction);
		operationPanel.add(multiply);
		operationPanel.add(divide);
		
		//create choices panel to hold values, negative, operation, question,and greeting panels
		JPanel choices = new JPanel();
		choices.setLayout(new BorderLayout(25,25));
		choices.add(valuesPanel, BorderLayout.WEST);
		choices.add(negativePanel, BorderLayout.CENTER);
		choices.add(operationPanel, BorderLayout.EAST);
		choices.add(questionPanel, BorderLayout.SOUTH);
		choices.add(greetingPanel, BorderLayout.NORTH);
		
		//add panels to window
		add(choices, BorderLayout.NORTH);
		add(panel, BorderLayout.SOUTH);
		
		//display window
		setVisible(true);	
	}
	
	/*
	 * main method
	 */
	public static void main(String[] args){
		
		new Program4GUI();
	}

	/*
	 * private inner class that handles event when user clicks the Get Question button
	 */
	
	private class QuestionButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			//configure question with values determined from radio select buttons

			if (negativeYes.isSelected())
				isNegative=true;
			else
				isNegative=false;
			
			if (onesRange.isSelected())
				intRange = 10;
			else if(tensRange.isSelected())
				intRange = 100;
			else if(hundredsRange.isSelected())
				intRange = 1000;
			
			if (addition.isSelected())
				operationSelected="addition";
			else if (subtraction.isSelected())
				operationSelected="subtraction";
			else if (multiply.isSelected())
				operationSelected="multiply";
			else if (divide.isSelected())
				operationSelected="divide";
			
			//generates new question using given values
			question = new MathQuestion(intRange,isNegative,operationSelected);
			questionLabel.setText(question.getQuestion());
		}	
	}
	
	/*
	 * private inner class that handles event when the user clicks Answer button
	 */
	private class AnswerButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			//variables to hold user answer and initialize the answer int
			String input;
			int answer=0;
			
			input = answerTextField.getText();	//gets user input
			
			//exception handling for non-integer inputs
			while(input==null){		
				input = answerTextField.getText();
			}
		
			try{		//change input from string to int variable
				answer=Integer.parseInt(input);
				if(answer==question.getAnswer()){	//if user answer correct
					JOptionPane.showMessageDialog(null,"Correct");
				
					numCorrect++;	//increment number correct
				}
				else{	//if user answer incorrect
					JOptionPane.showMessageDialog(null, "Incorrect");
					numWrong++;
				}
			}
			catch(NumberFormatException q){	
				JOptionPane.showMessageDialog(null, "Only integers may be entered into the answer box");

				input=null;
			}
			
			answerLabel.setText("Number Correct: " + numCorrect + "  Number Wrong: " + numWrong);
			
			answerTextField.setText("");	//resets answer text field to empty to allow new user input
		}
	}

}
