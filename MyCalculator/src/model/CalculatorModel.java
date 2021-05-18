package model;


public class CalculatorModel {
	
	private double result;
	private double number1;
	private double number2;
	

	public boolean checkMaximalDouble(double number) {
		return number <= Double.MAX_VALUE;
	}
	
	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double getNumber1() {
		return number1;
	}

	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	public double add(double number1, double number2) {
		return number1 + number2;
	}
	
	public double subtract(double number1, double number2) {
		return number1 - number2;
	}
	
	public double multiply(double number1, double number2) {
		return number1 * number2;
	}
	
	public double divide(double number1, double number2) {
		return number1 / number2;
	}
	
	public double percent(double number1) {
		return number1 / 100;
	}
	
	public double squareNumber(double number1) {
		return Math.pow(number1, 2);
	}
	
	public double useExponentAtNumber(double number1, double number2) {
		return Math.pow(number1, number2);
	}
	
	public double extractRoot(double number1) {
		return Math.sqrt(number1);
	}
	
	

}
