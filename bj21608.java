import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj21608 {
	static class count {
		int empty;
		int favorite;
	}

	static class node {
		int x, y;

	}

	static int[][] arr;
	static int N;
	static LinkedList<Integer>[] list;

	// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());

		arr = new int[N + 1][N + 1];
		int cnt = 0;

		list = new LinkedList[N + 1];
		for (int i = 0; i < N; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				int B = Integer.parseInt(st.nextToken());
				list[A].add(B);
			}

			if (cnt == 0) { // 만약 채워진 칸이 하나도 없으면..
				node temp = findmaxblank(); // 최대로 공백이 많은 칸 찾음
				arr[temp.y][temp.x] = A; // 거기에 넣음
				cnt++; // 채워진 칸수 플라쓰
			} else { // 만약 하나이상 채워진 수가 있으면..
				LinkedList<node> flist = findfriends(A); // 넣으려는 수의 친구들을 찾아봄
				if (!flist.isEmpty()) { // 만약 친구들이 하나이상 있으면
					int max = 0;
					int mx = 0, my = 0;
					for (node l : flist) { // 친구들 중 주변 공백 가장 많은곳 찾음
						int tempcnt = countblank(l.x, l.y);
						if (tempcnt > max) {
							max = tempcnt;
							mx = l.x;
							my = l.y;
						}
					}
					arr[my][mx] = A;
					cnt++;
				} else {
					node temp = findmaxblank();
					arr[temp.y][temp.x] = A;
					cnt++;
				}
			}

		}

	}

	static LinkedList<node> findfriends(int input) {
		LinkedList<node> relist = new LinkedList<>();
		for (int l : list[input]) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == l) {
						node temp = new node();
						temp.x = j;
						temp.y = i;
						relist.add(temp);
					}
				}
			}
		}
		return relist;
	}

	static int countblank(int x, int y) {

		int blank = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			if (arr[ny][nx] == 0) {
				blank++;
			}
		}

		return blank;
	}

	static node findmaxblank() {
		int max = 0;
		int mx = 0;
		int my = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; i < N; i++) {
				int temp = countblank(j, i);
				if (max < temp) {
					my = i;
					mx = j;
				}
			}
		}

		node temp = new node();
		temp.x = mx;
		temp.y = my;
		return temp;
	}

	static node istherefav(int input) {
		node temp = new node();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (list[input].contains(arr[i][j])) {
					temp.x = j;
					temp.y = i;
					return temp;
				}
			}
		}
		return null;
	}

	static node findbestplace(int input) {
		node ans = new node();

		int max = 0;
		int mx = 0;
		int my = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}

					for (int l : list[input]) {
						if (arr[ny][nx] == l) {
							cnt++;
						}
					}
				}
				if (max < cnt) {
					max = cnt;
					mx = j;
					my = i;
				}
			}
		}

		ans.x = mx;
		ans.y = my;

		return ans;
	}
}
