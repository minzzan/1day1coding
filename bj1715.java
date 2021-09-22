import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj1715 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 테스트케이스 개수
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			queue.add(Integer.parseInt(in.readLine()));
		}

		int sum = 0;
//		System.out.println(queue.toString());
		while (!queue.isEmpty()) {
			int a1 = queue.poll();
			if (queue.isEmpty()) {
				break;
			}
			sum += a1;
			int a2 = queue.poll();
			sum += a2;
			queue.add(a1 + a2);
//			System.out.println(queue.toString());
		}
		System.out.println(sum);
	}
}
