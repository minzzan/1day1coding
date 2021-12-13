import java.util.Scanner;

public class bj1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] inputs = input.split("-");
		int[] inputfilter = new int[inputs.length];

		for (int i = 0; i < inputs.length; i++) {
			String[] temp = inputs[i].split("\\+");
			for (int j = 0; j < temp.length; j++) {
				inputfilter[i] += Integer.parseInt(temp[j]);
			}
		}

		int result = inputfilter[0];
		for (int i = 1; i < inputfilter.length; i++) {
			result -= inputfilter[i];
		}
		System.out.println(result);
	}
}
