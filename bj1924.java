package practice;

import java.util.Scanner;

public class bj1924 {
	public static void main(String[] args) {

		String[] week = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		int day = 0;
		for (int i = 0; i < x; i++) {
			day += month[i];
		}
		day += y;

		System.out.println(week[day % 7]);

	}
}
