package gadek.com;

/*
 * complex number
 * 
 */
public class Complex {

	private double re;
	private double im;
	public Complex(double x) {
		re=x;
		im =0.0;
	}
	public Complex(double r , double i) {
		re = i;
		im = i;
	}
	
	public Complex addition( Complex c) {
		return new Complex(re + c.re,im+c.im);
	}
	public Complex substraction( Complex c) {
		return new Complex(re - c.re,im - c.im);
	}
	public Complex multiplication( Complex c) {
		return new Complex(re * c.re - im*c.im,re* c.im + im *c.re);
	}
	public Complex division( Complex c) {
		return new Complex((re * c.re + im * c.im)/(Math.pow(c.re,2) + Math.pow(im,2)),
				(im*c.re - re*c.im)/(Math.pow(c.re, 2)+Math.pow(im, 2)));
	}
	@Override
	public String toString() {
		return "(" + re + "+" + im + "i)";
	}
}
