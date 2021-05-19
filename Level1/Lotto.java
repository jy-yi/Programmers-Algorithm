package Level1;

import java.util.Arrays;
/**
 * 로또의 최고 순위와 최저 순위
 * @author jy-yi
 * 
 * 로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다.
 * 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다.
 * 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어졌습니다.
 * 
 * 민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
 * 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 *
 */
public class Lotto {
	public static void main(String[] args) {
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		
		int[] answer = solution(lottos, win_nums);
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int match = 0;
        int zeroCount = 0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        for (int i = 0; i < lottos.length; i++) {
        	// 알아볼 수 없는 번호
        	if (lottos[i] == 0) {
        		zeroCount++;
        		continue;
        	}
        	
			for (int j = 0; j < win_nums.length; j++) {
				if (lottos[i] == win_nums[j]) {
					match++;
					break;
				}
			}
		}
        
        answer[0] = getRank(match + zeroCount);	// 알아볼 수 없는 번호가 모두 당첨 번호와 일치할 경우
        answer[1] = getRank(match);	// 알아볼 수 없는 번호가 모두 당첨 번호와 불일치할 경우
        
        return answer;
    }
	
	/**
	 * 일치 개수에 따른 순위 반환
	 * @param n 일치한 로또 번호 개수
	 * @return	해당 순위
	 */
	public static int getRank(int n) {
		
		switch (n) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}
}
