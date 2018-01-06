package com.TuzMS.Oksana;

public class Complex {
	//Класс комплексных чисел
	private double re; //Вещественная часть числа
	private double im; //Мнимая часть числа
	
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	public Complex(double re) {
		this.re = re;
	}
		
	public Complex sopr() {
		return new Complex(re, -im);
	}
	public Complex sum(Complex c) {
		//Прибавить к этому числу с
		return new Complex(re + c.re, im + c.im);
	}
	public Complex sub(Complex c) {
		//Вычесть из этого числа с
		return new Complex(re - c.re, im - c.im);
	}
	public Complex mul(Complex c) {
		//Домножить это число на с
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}
	public Complex mul(double b) {
		//Домножить это число на b (double)
		return new Complex(re * b, im * b);
	}
	public Complex div(Complex c) {
		//Поделить это число на с
		return this.mul(c.sopr()).mul(1 / (c.re * c.re + c.im * c.im));
	}
	
}
