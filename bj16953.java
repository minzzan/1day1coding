import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int temp = B;
		int cnt = 0;
		while (temp != 0) {
			if (temp == A) {
				System.out.println(cnt + 1);
				return;
			}
			cnt++;
			if (temp % 2 == 0) {
				temp = temp / 2;
			} else if (temp % 10 == 1) {
				temp = (temp - 1) / 10;
			} else {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(-1);
	}
}
