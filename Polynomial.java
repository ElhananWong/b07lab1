public class Polynomial {
	double[] coefficients;
	
	public Polynomial() {
		coefficients = new double[] {0};
	}
	
	public Polynomial(double[] coefficients) {
		// deep copy? shallow copy? instructions unclear
		int length = coefficients.length;
		this.coefficients = new double[length];
		for (int i = 0; i < length; ++i) {
			this.coefficients[i] = coefficients[i];
		}
	}
	
	public Polynomial add(Polynomial poly) {
		int degree1 = poly.coefficients.length;
		int degree2 = this.coefficients.length;
		int big_degree = 0;
		if (degree1 > degree2)
			big_degree = degree1;
		else
			big_degree = degree2;
		double[] new_coefficients = new double[big_degree];
		for (int i = 0; i < big_degree; ++i) {
			double poly_num = 0;
			double this_num = 0;
			if (i < poly.coefficients.length)
				poly_num = poly.coefficients[i];
			if (i < this.coefficients.length)
				this_num = this.coefficients[i];
			
			new_coefficients[i] = poly_num + this_num;
		}
		return new Polynomial(new_coefficients);
	}
	
	public double evaluate(double x) {
		double result = 0;
		for (int i = 0; i < coefficients.length; ++i) {
			result += coefficients[i] * Math.pow(x, i);
		}
		return result;
	}
	
	public boolean hasRoot(double x) {
		return evaluate(x) == 0;
	}
}