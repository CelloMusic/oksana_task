package com.TuzMS.Oksana;

public class FFT {
	//Быстрое преобразование Фурье
	//Алгоритм БПФ был взят с ресурса
	//http://ru.m.wikibooks.nym.su/wiki/Реализации_алгоритмов/Быстрое_преобразование_Фурье
	//Пример, приведённый на языке С#
	
	private static Complex W(int k, int N) {
		if (k % N == 0) return new Complex(1);
		else {
			double arg = -2*Math.PI * k/N;
			return new Complex(Math.cos(arg), Math.sin(arg));
		}
	}
	
	public static Complex[] prefft(Complex[] x) {
		//Так как БПФ требует, чтоб кол-во элементов было кратно стереням 2, 
		//этот метод дописывает необходимое число нулей в конце массива.
		//Данный метод нужно обязательно использовать перед БПФ.
		int N = x.length;
		boolean b = true;
		int i = 0;
		while (b) {
			if (N == Math.pow(2, ++i)) return x;
			else if (N < Math.pow(2, i)) b = false;
		}
		Complex[] X = new Complex[(int) Math.pow(2, i)];
		for (int j = 0; j < Math.pow(2, i); j++) {
			if (j < N) X[j] = x[j];
			else X[j] = Complex.doubleToComplex(0);
		}
		return X;
	}
	
	public static Complex[] fft(Complex[] x) {
		//Сам БПФ
		Complex[] X;
		int N = x.length;
		if (N == 2) {
			X = new Complex[2];
			X[0] = x[0].sum(x[1]);
			X[1] = x[0].sub(x[1]);
		} else {
			Complex[] x_even = new Complex[N / 2];
			Complex[] x_odd = new Complex[N / 2];
			for (int i = 0; i < N/2; i++) {
				x_even[i] = x[2*i];
				x_odd[i] = x[2*i + 1];
			}
			Complex[] X_even = fft(x_even);
			Complex[] X_odd = fft(x_odd);
			X = new Complex[N];
			for (int i = 0; i < N/2; i++) {
				X[i] = X_even[i].sum(W(i, N).mul(X_odd[i]));
				X[i + N/2] = X_even[i].sub(W(i, N).mul(X_odd[i]));
			}
		}
		return X;
	}
	
	public static Complex[] nfft(Complex[] X) {
		//Центрирование массива спектра
		int N = X.length;
		Complex[] X_n = new Complex[N];
		for (int i = 0; i < N; i++) {
			X_n[i] = X[i + N/2];
			X_n[N/2 + i] = X[i];
		}
		return X_n;
	}
	
}
