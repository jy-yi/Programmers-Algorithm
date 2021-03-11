package Level1;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 비밀지도
 * @author jy-yi
 *
 * 1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
 * 2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 
 * 	  지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
 * 3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다. 
 * 4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
 */
public class SecretMap {
	public static void main(String[] args) {
//		int n = 5;
//		int[] arr1 = { 9, 20, 28, 18, 11 };
//		int[] arr2 = { 30, 1, 21, 17, 28 };

		int n = 6;
		int[] arr1 = { 46, 33, 33, 22, 31, 50 };
		int[] arr2 = { 27, 56, 19, 14, 14, 10 };

		SecretMap s = new SecretMap();
		String answer[] = s.solution(n, arr1, arr2);

		for (String string : answer) {
			System.out.println(string);
		}

	}

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		String[] map1 = new String[n]; // 지도1
		String[] map2 = new String[n]; // 지도2

		/* 각 배열의 십진수 → 이진수 변환 */
		for (int i = 0; i < n; i++) {
			map1[i] = makeBinary(n, arr1[i]);
			map2[i] = makeBinary(n, arr2[i]);
		}

		for (int i = 0; i < n; i++) {
			String map = "";

			String str1 = map1[i];
			String str2 = map2[i];

			for (int j = 0; j < str1.length(); j++) {
				/* 지도 1과 지도 2에서 모두 공백인 부분 */
				if (str1.charAt(j) == '0' && str2.charAt(j) == '0')
					map += " ";
				else
					map += "#";
			}

			answer[i] = map;

		}

		return answer;
	}

	/**
	 * 입력 받은 수를 이진수로 반환
	 * 
	 * @param length 이진수 길이
	 * @param num    이진수로 변환할 십진수
	 * @return 문자열로 변환한 이진수
	 */
	public String makeBinary(int length, int num) {
		int[] answer = new int[length];
		Queue<Integer> queue = new LinkedList<Integer>();

		/* 이진수로 만들어 큐에 저장 */
		while (num > 0) {
			queue.add(num % 2);
			num /= 2;
		}

		/* 배열에 거꾸로 저장 - 빈 공간은 0으로 채우기 */
		for (int i = answer.length - 1; i >= 0; i--) {
			answer[i] = queue.isEmpty() ? 0 : queue.poll();
		}

		return toString(answer);
	}

	/**
	 * 정수형 배열을 문자열로 반환
	 * 
	 * @param arr 문자열로 변환할 정수 배열
	 * @return
	 */
	public String toString(int[] arr) {
		String str = "";

		for (int i : arr) {
			str += String.valueOf(i);
		}

		return str;
	}

}
