import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj1755 {

	// 영어로 변환 or 숫자로 변환 시 사용할 배열
	static String[] en = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) throws IOException { // in.readLine에서 발생하는 에러 throw 처리
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // 입력을 token으로 나눠줌
		int M = Integer.parseInt(st.nextToken()); // 시작 숫자 M 입력
		int N = Integer.parseInt(st.nextToken()); // 끝 숫자 N 입력

		LinkedList<String> list = new LinkedList<>(); // 영어로 변환해서 넣을 리스트
		LinkedList<Integer> list2 = new LinkedList<>(); // 최종 출력할 숫자를 넣을 리스트

		for (int i = M; i <= N; i++) { // 시작숫자 M 부터 끝숫자 N 까지 반복
			int ten = i / 10; // 십의자리 숫자 저장
			int one = i % 10; // 일의자리 숫자 저장
			if (ten == 0) { // 만약 십의자리 숫자가 0이라면 => 주어진 수는 한자리 수
				list.add(en[one]); // 영어로 변환하여 list에 추가
				continue; // 반복문 통과
			}
			list.add(en[ten] + " " + en[one]); // 아니라면(주어진 수가 십의 자리) 리스트에 영어로 변환하여 추가
		}

		list.sort(null); // 사전순으로 정렬

		while(!list.isEmpty()) { // 리스트가 비어있을 때까지
			String temp = list.poll(); // 리스트의 첫번째 요소 추출
			if (temp.contains(" ")) { // 만약 리스트에 " "가 있다면 => 두자리 수
				st = new StringTokenizer(temp); // " "를 기준으로 십의자리와 일의자리를 구분
				String t1 = st.nextToken(); // 십의자리 영어 저장
				String t2 = st.nextToken(); // 일의자리 영어 저장
				int ten = findnum(t1); // 십의자리 숫자로 변환
				int one = findnum(t2); // 일의자리 숫자로 변환
				list2.add(ten*10 + one); // 정상적인 integer형(숫자)형태로 변환하여 리스트에 추가
			} else { // 아니라면 (일의 자리 수)
				list2.add(findnum(temp)); // 바로 숫자로 변환하여 리스트에 추가 
			}
		}

		while (!list2.isEmpty()) { // 출력을 위한 리스트가 비어있을 때까지
			for (int i = 0; i < 10; i++) { // 한줄에 10개씩 출력하기 위함
				if (list2.isEmpty()) { // 10개를 다 출력하지 않았을때 null이 출력되는것을 막기위해 한번 더 체크
					return; // 리스트가 비어있으면 종료
				}
				System.out.print(list2.poll() + " "); // 리스트의 첫번째 요소 추출, 출력
			}
			System.out.println(); // 줄바꿈
		}
	}

	static int findnum(String input) { // 영어를 숫자로 변환하기 위한 함수
		for (int i = 0; i <= 9; i++) { // 숫자 0~9
			if (input.equals(en[i])) { // 만약 입력된 문자열이 배열속 요소와 일치한다면 / 영어를 발견한다면
				return i; // 그때의 인덱스값 (숫자)를 반환
			}
		}
		return 0; // 위에 해당되지 않을 경우 
	}
}
