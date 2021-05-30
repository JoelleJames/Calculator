// 30.05.2021. Joelle James. First prototype of calculator complete.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField textField;
	
	//global arrays
	JButton[] numberButtons = new JButton [10];
	JButton[] functionButtons = new JButton [11];
	
	JButton addButton, subtrButton, multiButton, divButton;
	JButton equButton, clearButton, backspaceButton;
	JButton decButton, negButton, percentButton, dblZeroButton;
	
	JPanel panel;
	Font myFont = new Font ("CalcFont", Font.BOLD, 30);
	
	//declaring global variables
	double num1=0, num2=0;
	double result=0;
	char operator;
	
	Calculator(){
	
		//calculator size and exit function
		frame = new JFrame ("calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.setLayout(null);
		
		//layout for text field
		textField = new JTextField();
		textField.setBounds(25, 25, 250, 50);
		textField.setFont(myFont);
		textField.setEditable(false);
		
		//creating the button objects with symbols
		addButton = new JButton("+");
		subtrButton = new JButton("-");
		multiButton = new JButton("*");
		divButton = new JButton("/");
		equButton = new JButton("=");
		clearButton = new JButton("c");
		backspaceButton = new JButton("del");
		decButton = new JButton(".");
		negButton = new JButton("+/-");
		percentButton = new JButton("%");
		dblZeroButton = new JButton("00");
		
		//adding buttons to functionButtons array
		functionButtons[0] = addButton;
		functionButtons[1] = subtrButton;
		functionButtons[2] = multiButton;
		functionButtons[3] = divButton;
		functionButtons[4] = equButton;
		functionButtons[5] = clearButton;
		functionButtons[6] = backspaceButton;
		functionButtons[7] = decButton;
		functionButtons[8] = negButton;
		functionButtons[9] = percentButton;
		functionButtons[10] = dblZeroButton;
		
		/*The array for-loops. Currently 11 function buttons and 10 numbers 
		(doubleZero is a function)*/
		for(int i = 0; i<11; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			}
		for(int i = 0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			}
		
		//layout of buttons
		backspaceButton.setBounds(280, 25, 80, 50);
		panel =new JPanel();
		panel.setBounds(25, 100, 335, 300);
		panel.setLayout(new GridLayout(5,4, 10, 10));
		
		//adding buttons for grid layout
		panel.add(functionButtons[5]);
		panel.add(functionButtons[8]);
		panel.add(functionButtons[9]);
		panel.add(functionButtons[0]);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(functionButtons[1]);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(functionButtons[2]);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(functionButtons[3]);
		panel.add(numberButtons[0]);
		panel.add(functionButtons[10]);
		panel.add(functionButtons[7]);
		panel.add(functionButtons[4]);
		
		//backspace is placed next to text field
		frame.add(panel);
		frame.add(backspaceButton);
		frame.add(textField);
		frame.setVisible(true);
	
	}

		// a new calculator object is created when the main program runs
		public static void main(String[] args) {
			Calculator calcObj = new Calculator();
		}

		// Actions for buttons
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i<10; i++) {
				if (e.getSource() == numberButtons[i]) {
					textField.setText(textField.getText().concat(String.valueOf(i)));				
				}
			}
			if (e.getSource() == dblZeroButton) {
				textField.setText(textField.getText().concat("00"));
			}
			if (e.getSource() == decButton) {
				textField.setText(textField.getText().concat("."));	
			}
			if (e.getSource() == addButton) {
				num1 =Double.parseDouble(textField.getText());
				operator = '+';
				textField.setText("");
			}
			if (e.getSource() == subtrButton) {
				num1 =Double.parseDouble(textField.getText());
				operator = '-';
				textField.setText("");
			}
			if (e.getSource() == multiButton) {
				num1 =Double.parseDouble(textField.getText());
				operator = '*';
				textField.setText("");
			}
			if (e.getSource() == divButton) {
				num1 =Double.parseDouble(textField.getText());
				operator = '/';
				textField.setText("");
			}
			if (e.getSource() == percentButton) {
				num1 =Double.parseDouble(textField.getText());
				if(num1 >= -1 && num1 <=1) {
					double temp = Double.parseDouble(textField.getText());
					temp *= 100;
					textField.setText(String.valueOf(temp));
				}
				else{
					double temp2 = Double.parseDouble(textField.getText());	
					temp2 = temp2 / 100;
					textField.setText(String.valueOf(temp2));	
					}
			}
			if (e.getSource() == negButton) {
				double temp = Double.parseDouble(textField.getText());
				temp *= -1;
				textField.setText(String.valueOf(temp));
			}
			if (e.getSource() == clearButton) {
				textField.setText("");
			}
			 
			if (e.getSource() == backspaceButton) {
				String string = textField.getText();
				textField.setText("");
				for(int i=0; i<string.length()-1; i++) {
					textField.setText(textField.getText()+string.charAt(i));	
				}
			}
			
			//using a switch for the operators
			if (e.getSource() == equButton) {
				num2 =Double.parseDouble(textField.getText());
				switch(operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				}
				
			//display result
			textField.setText(String.valueOf(result));
			num1 = result;
			
			}
		}	
}
//end of code
