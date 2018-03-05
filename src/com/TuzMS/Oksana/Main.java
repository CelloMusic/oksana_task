package com.TuzMS.Oksana;

public class Main {

	public static void main(String[] args) {
		double[] d = //{1, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0};
			{//cos
					2.00000000,
					1.98768834,
					1.95105652,
					1.89100652,
					1.80901699,
					1.70710678,
					1.58778525,
					1.45399050,
					1.30901699,
					1.15643447,
					1.00000000,
					0.84356553,
					0.69098301,
					0.54600950,
					0.41221475,
					0.29289322,
					0.19098301,
					0.10899348,
					0.04894348,
					0.01231166,
					0.00000000
			};

		Complex[] x = new Complex[d.length];
		for (int i = 0; i < x.length; i++) {
			x[i] = Complex.doubleToComplex(d[i]);
		}
		
		//Nahodim stepen 2
		int N = 0;
		int j = 0;
		boolean b = true;
		while (b) {
			if (x.length == Math.pow(2, ++j)) {
				N = x.length;
				b = false;
			}
			else if (x.length < Math.pow(2, j)) {
				N = (int) Math.pow(2, j);
				b = false;
			}
		}
		
		Complex[] X = new Complex[N];
		X = FFT.prefft(x);
		X = FFT.fft(X);
		//X = FFT.nfft(X);
		/*for (Complex c: X) {
			System.out.println(c.getRe());
		}*/
		Complex[] spektr = new Complex[N / 2];
		for (int i = 0; i < N/2; i++) spektr[i] = X[i]; 
		/*for (Complex c: spektr) {
			System.out.println(c.getRe());
		}*/
		ObratAbel A = new ObratAbel(spektr, d.length, 9);
		for (int i = 0; i < d.length; i++) {
			d[i] = A.Abel(i);
			System.out.println(d[i]);
		}
	}
	
	private static Complex[] zerkalo(Complex[] x) {
		Complex[] X = new Complex[2 * x.length];
		for (int i = 0; i < x.length; i++) {
			X[i + x.length] = X[x.length -1 - i] = x[i];
		}
		return X;
	}

}
