package com.TuzMS.Oksana;

public class Bessel {
	//Функция Бесселя
	//Алгоритм взят с ресурса:
	//http://www.ispras.ru/proceedings/docs/2006/10/isp_10_2006_115.pdf
	
	private static int Fact(int n) {
		//Факториал
		int a = 1;
		if (n == 0) return 1;
		else {
			for (int i = 1; i <= n; i++) {
				a *= i;
			}
			return a;
		}
	}
	
	public static double BesselFunc(double x, int n) {
		//Jn(x) сама функция бесселя
		int N = 30; //Количество членов рядя Тейлора
		double J = 1 / (Fact(n)*Math.pow(2, n));
		double j = 1;
		for (int i = N-1; i >= 1; i--) {
			j = 1 - j * (x * x / (4 * i * (n + i)));
		}
		J *= j;
		return J;
	}
	
}
