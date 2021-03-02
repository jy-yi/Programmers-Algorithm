package Level1;
import java.util.stream.IntStream;

public class KeyPad {
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		int[] numbers2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		int[] numbers3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		KeyPad k = new KeyPad();

		System.out.println(k.solution(numbers, "right"));
		System.out.println(k.solution(numbers2, "left"));
		System.out.println(k.solution(numbers3, "right"));
	}

	public String solution(int[] numbers, String hand) {
		String answer = "";

		int[] left = { 1, 4, 7 }; // 왼쪽 열
		int[] right = { 3, 6, 9 }; // 오른쪽 열

		int LHand = 10, RHand = 12; // 왼손 오른손의 현재 위치

		for (int key : numbers) {
			int k = key; // 람다 표현식은 로컬 변수 변경 불가하므로 변수 선언
			
			/* 왼손이 눌러야 할 왼쪽 열 1, 4, 7 */
			if (IntStream.of(left).anyMatch(i -> i == k)) {
				answer += "L";
				LHand = key;
			/* 오른손이 눌러야 할 오른쪽 열 3, 6, 9 */
			} else if (IntStream.of(right).anyMatch(i -> i == k)) {
				answer += "R";
				RHand = key;
			/* 가운데 열 */
			} else {

				if (key == 0)
					key += 11;

				int leftDistance = (Math.abs(key - LHand)) / 3 + (Math.abs(key - LHand)) % 3;
				int rightDistance = (Math.abs(key - RHand)) / 3 + (Math.abs(key - RHand)) % 3;
				
				/* 오른손이 더 가까울 경우 */
				if (leftDistance > rightDistance) {
					answer += "R";
					RHand = key;
				/* 왼손이 더 가까울 경우 */
				} else if (leftDistance < rightDistance) {
					answer += "L";
					LHand = key;
				/* 두 엄지손가락의 거리가 같을 경우 */
				} else {
					if (hand.toUpperCase().startsWith("L")) {
						answer += "L";
						LHand = key;
					} else {
						answer += "R";
						RHand = key;
					}
				}
			}
		}

		return answer;
	}

}
