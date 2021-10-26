import java.util.Arrays;

public class pr_lotto {
	// 0,1,2,3,4,5,6 일치할때의 등수
	static int[] rank = { 6, 6, 5, 4, 3, 2, 1 };

	public static void main(String[] args) {
		int[] lottos = { 0, 0, 0, 0, 0, 0 };
		int[] win_nums = { 38, 19, 20, 40, 15, 25 };

		int cnt = 0; // 일치하는 숫자의 수
		int zerocnt = 0; // 알아볼 수 없는 숫자의 수

		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {
				zerocnt++;
			}
			for (int j = 0; j < 6; j++) {
				if (lottos[i] == win_nums[j]) {
					cnt++;
				}
			}
		}

		int[] answer = new int[2];

		answer[1] = rank[cnt]; // 알아볼 수 없는 숫자가 전부 일치X
		answer[0] = rank[zerocnt + cnt]; // 알아볼 수 없는 숫자가 전부 일치O

		System.out.println(Arrays.toString(answer));

	}
}
