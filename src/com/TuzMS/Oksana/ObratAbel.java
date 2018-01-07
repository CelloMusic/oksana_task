package com.TuzMS.Oksana;

public class ObratAbel {
	//Обратное преобразование Абеля
	private Complex[] C; //Коэффициенты Фурье спектра
	private int R; //Радиус плазмы (нужно будет заменить int на double)
	private int n; //Количесво учитываемых гармоник
	
	public ObratAbel(Complex[] C, int R, int n) {
		this.C = C;
		this.R = R;
		this.n = n;
	}
	
	private double Abel_i(double r) {
		double I1r = 0;
		for (int i = 1; i <= this.n; i++) {
			double k = Math.PI * i / this.R;
			I1r += this.C[i].getRe() * k * Bessel.BesselFunc(k * r, 0) / 4;
		}
		return I1r;
	}
	
	public double Abel(double r) {
		double J1r = Abel_i(r);
		double A = Math.sqrt(Math.pow(this.C[0].getRe() / (2 * Math.PI * J1r), 2) + this.R * this.R);
		double J0r = this.C[0].getRe() / (2 * Math.PI * Math.sqrt(A*A - this.R*this.R));
		return J0r + J1r;
	}
	
}
