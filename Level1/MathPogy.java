package Level1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 모의고사
 * @author jy-yi
 *
 * 수포자는 수학을 포기한 사람의 준말입니다. 
 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * 
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */
public class MathPogy {

	public static void main(String[] args) {
		int[] answers1 = { 1, 2, 3, 4, 5 };
		int[] answers2 = { 1, 3, 2, 4, 2 };

		int[] result = solution(answers2);

		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] answers) {
		int[] person1 = { 1, 2, 3, 4, 5 };
		int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] result = new int[3];

		for (int i = 0; i < answers.length; i++) {
			int now = answers[i]; // 현재 문제 답

			/* 정답 확인 */
			if (now == person1[i % person1.length]) result[0]++;
			if (now == person2[i % person2.length]) result[1]++;
			if (now == person3[i % person3.length]) result[2]++;

		}
		
		int max = result[0];
		
		/* 점수 최대값 탐색 */
		for (int i : result) {
			if (i >= max) {
				max = i;
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		/* 가장 많이 맞힌 사람 리스트 */
		for (int i = 0; i < result.length; i++) {
			if (result[i] == max) {
				list.add(i+1);
			}
		}
		
		Collections.sort(list); // 오름차순 정렬

		return list.stream().mapToInt(Integer::intValue).toArray(); // list to array
	}

}
