package weekly.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Week2 {
	public static void main(String[] args) {
		int[][] scores = { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 }, { 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } };
		
		Week2 week2 = new Week2();
		
		System.out.println(week2.solution(scores));
	}

	public String solution(int[][] scores) {
		String answer = "";
		
		
		for (int i = 0; i < scores.length; i++) {
			int max = -1, min = 101;
			int sum = 0, count = 0;
			List<Integer> list = Arrays.stream(scores[i]).boxed().collect(Collectors.toList());
			System.out.println(list);
			for (int j = 0; j < list.size(); j++) {
				int now = list.get(j);
				sum += now;
				count++;
				
				/* 최대값 구하기 */
				if (scores[i][j] > max) {
					max = now;
				}
				
				/* 최소값 구하기 */
				if (min > now) {
					min = now;
				}
				
			}
			
			if (list.get(i) == max) {
				sum -= list.get(i);
				count--;
			}
			
			if (list.get(i) == min) {
				sum -= list.get(i);
				count--;
			}
			
			System.out.println(max + " " + min);
			System.out.println(sum +  " " + count);
			System.out.println("평균 : " + sum/count);
			System.out.println("-------------------");
		}
		
		
		
		return answer;
	}
	
	public String getGrade (int score) {
		if (score >= 90) {
			return "A";
		} else if (score >= 80) {
			return "B";
		} else if (score >= 70) {
			return "C";
		} else if (score >= 50) {
			return "D";
		} else {
			return "F";
		}
	}
}
