import java.util.LinkedList;
import java.util.Queue;

public class pr_bridge {
	static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> queue = new LinkedList<Integer>();

		int temp = 0; // 현재 다리 위에 있는 트럭 무게
		int sec = 0;

		for (int i = 0; i < truck_weights.length; i++) {
			while (true) {
				if (queue.isEmpty()) {
					queue.offer(truck_weights[i]); // 다리에 추가
					temp = temp + truck_weights[i]; // 다리 무게 추가
					sec++; // 1초 증가
					break;
				}
				if (queue.size() == bridge_length) { // 다리에 차가 꽉찼음
					temp = temp - queue.poll(); // 앞에 차 빼줌
				}
				if (temp + truck_weights[i] > weight) { // 다리위에 있는 트럭 무게가 다리하중보다 높으면
					queue.offer(0); // 다리에 0을 추가 .. 0이라는 자동차를 추가한 느낌
					sec++; // 1초 증가
				} else {
					temp = temp + truck_weights[i]; // 트럭 무게 추가
					queue.offer(truck_weights[i]); // 트럭 다리에 추가
					sec++; // 1초 증가
					break;
				}
			}
		}

		return sec + bridge_length; // 시간 더하기 나머지 다리에 남아있는 친구들만큼 초 증가
	}
}
