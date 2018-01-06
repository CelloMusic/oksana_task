package com.TuzMS.Oksana;

public class Main {

	public static void main(String[] args) {
		double[] d = {1, 1, 1, 0.995, 0.982, 0.934, 0.843, 0.704,
				0.579, 0.445, 0.13011, 0.223, 0.156, 0.09, 0.034,
				0.008, 0.0001, 0};
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
		Complex[] X = new Complex[N];
		X = FFT.prefft(x);
		X = FFT.fft(X);
		X = FFT.nfft(X);
		for (Complex c: X) {
			System.out.println(c.ampl());
		}

	}

}
