package Program4;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * the MathQuestion class allows user to select values either positive or negative to generate questions
 */
public class MathQuestion {
	   		
	Random random = new Random();
    private boolean isNegative=true;
    private int intRange;		//holds integer range
    private String operationSelected;	//holds operation being chosen
    private int value1;			//holds value1
    private int value2;			//holds value2
    private String operation;	
    
    /*
     * Constructor
     * @param valRange integer to represent integer range selected
     * @param negativeVals boolean to say whether choose to use negative values
     * @param opSelect String to capture which math operation was selected
     */
    public MathQuestion(int valRange, boolean negativeVals, String opSelect){
    	
    	intRange=valRange;
    	isNegative=negativeVals;
    	operationSelected=opSelect;
    	
    }
    
    /*
     * getValue() method generates random int value based on available values chosen for question
     * @return value 
     */
    private int getValue() {
    	int value = 0;		//initialize value int
		
    	if (isNegative==false){		//if negatives are excluded
			if (intRange == 10)		//if ones range is selected
				value = random.nextInt(10);		//generate value from 0-9
			else if (intRange==100)	//if tens range is selected
				value = random.nextInt(100);	//generate value from 0-99
			else if (intRange==1000)	//if hundreds range is selected 
				value = random.nextInt(1000);	//generate value from 0-999
		}
		else if (isNegative==true){		//if negatives are included
			if (intRange==10)	
				value = random.nextInt(19) - 9;	//generate value from -9 to 9
			else if (intRange==100)	
				value = random.nextInt(199)-99;	//generate value from -99 to 99
			else if (intRange==1000)	
				value = random.nextInt(1999)-999;	//generate value form -999 to 999
		}
    	return value;
    }
    
    /*
     * setValue1() method uses getValue() to set value1 with random value from choices made
     */
    private void setValue1(){
    	value1=getValue();
    	
    }
    
    /*
     * setValue2() method uses getValue() to set value2 with random value from choices made
     */
    private void setValue2(){
    	value2=getValue();
    }
    
    /*
     * setOperation() method uses getOperation() to set operation value based on choice selected
     */
    private void setOperation(){
    	operation=getOperation();
    }
    
    /*
     * getOperation() method uses operation selected to create a string using + - / x
     * @return op
     */
    private String getOperation(){
    	String op="";	//initializes String op variable
    	if (operationSelected=="addition")
    		op=" + ";
    	else if (operationSelected=="subtraction")
    				op=" - ";
    	else if (operationSelected=="multiply")
    		op=" x ";
    	else if (operationSelected=="divide")
    			op=" / ";
    	
    	return op;
    }
    
    /*
     * setQuestion() method sets value1, value2, and operation using respective set methods
     */
    private void setQuestion(){
    	setValue1();
    	setValue2();
    	setOperation();
    	
    	while(value1<value2 && !isNegative)		//prevents subtraction creating negatives if negatives not included
    		setValue1();
    	while(value2==0 && operation==" / ")	//prevents division by zero
    		setValue2();
    	
    }
    
    /*
     * getQuestion() method returns String showing generated question using setQuestion() method
     * @return question
     */
    public String getQuestion(){
    	setQuestion();
    	
    	String question = "           " + value1 + operation + value2 + " =   ";
    	
    	return question;
    }
    
    /*
     * getAnswer() method uses value1,value2,and operation to find answer to question
     * @return answer1
     */
   public int getAnswer(){
    	int answer1 = 0;	//initializes answer1 int
		
    	if(operation==" + ")
    		answer1 = value1 + value2;
    	else if(operation==" - ")
    		answer1 = value1-value2;
    	else if(operation==" x ")
    		answer1=value1*value2;
    	else if(operation==" / ")	
    		answer1=value1/value2;
		
		return answer1;
    }
   

}



