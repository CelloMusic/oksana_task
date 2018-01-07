package com.TuzMS.Oksana;

public class Main {

	public static void main(String[] args) {
		double[] d = {1, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3,
				0.2, 0.1, 0};
		Complex[] x = new Complex[d.length];
		for (int i = 0; i < x.length; i++) {
			x[i] = Complex.doubleToComplex(d[i]);
		}
		int N = 0;
		int j = 0;
		boolean b = true;
		while (b) {
			if (x.length == Math.pow(2, ++j)) N = x.length;
			else if (x.length < Math.pow(2, j)) {
				N = (int) Math.pow(2, j);
				b = false;
			}
		}
		Complex[] X = new Complex[2 * N];
		X = zerkalo(FFT.prefft(x));
		X = FFT.fft(X);
		X = FFT.nfft(X);
		Complex[] spektr = new Complex[N];
		for (int i = 0; i < N; i++) spektr[i] = X[i + N]; 
		/*for (Complex c: spektr) {
			System.out.println(c.getRe());
		}*/
		ObratAbel A = new ObratAbel(spektr, d.length, 10);
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
