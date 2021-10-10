
import java.util.PriorityQueue;

public class pr_spicy {
	public static void main(String[] args) {
		int[] scoville = new int[] { 1, 2, 3 };
		int K = 11;

		PriorityQueue<Integer> list = new PriorityQueue<Integer>();

		for (int i = 0; i < scoville.length; i++) {
			list.add(scoville[i]);
		}

		int result = 0;
		while (true) {
			if (list.size() < 2) {
				System.out.println(-1);
				return;
			}
			int newscb = list.poll() + list.poll() * 2; // 작은거 두개 뽑음
//			System.out.println(newscb);
			list.offer(newscb); // 큐에 추가
			result++; // 횟수 1회 추가

			if (list.peek() >= K) {
				System.out.println(result);
				return;
			}
		}
	}
}
