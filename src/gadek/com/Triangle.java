package gadek.com;

import java.util.Arrays;
import java.util.Scanner;

import javax.naming.InvalidNameException;

public class Triangle {

		private double[] number;
		
		public Triangle( double a, double b, double c) {
			this.number = new double[] {a,b,c};
		}
		
		public Triangle( ) {
		}
		
		public double area() {
			Arrays.sort(number);
			if(isTrangle())
			return (number[0]*number[1])/2;
			else return -1;
		}
		
		public boolean isTrangle() {
			return number[0] + number[1] > number[2] & 
					number[2] + number[1] > number[0] & 
					number[0] + number[2] > number[1];
		}
		
		public Double Equilateral() {
			return (Math.pow(number[0],2)* Math.sqrt(3))/4;
		}
		
		//bad
		public void readPositiveInt() throws InvalidNameException {
			String[] textTab= new String[3];
			Scanner sc = new Scanner(System.in);
			try {
			 textTab = sc.nextLine().split(" ");
			 sc.close();
			 number = new double[] {Double.parseDouble(textTab[0]),Double.parseDouble(textTab[1]),Double.parseDouble(textTab[2])};
			}
			catch (NumberFormatException e){ 
				System.out.println("Bad format! Try again");
				readPositiveInt();
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Enter tree digits");
	            readPositiveInt();
			}
			
		}

}
