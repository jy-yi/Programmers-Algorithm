package Level2;

import java.util.Arrays;

/**
 * 최댓값과 최솟값
 * @author jy-yi
 * 
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
 * str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
 *
 */
public class MaxAndMin {
	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4"));
		System.out.println(solution("-1 -2 -3 -4"));
		System.out.println(solution("-1 -1"));
	}
	
	public static String solution(String s) {
		
		String[] array = s.split(" ");
		int[] numbers = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			numbers[i] = Integer.parseInt(array[i]);
		}
		
		Arrays.sort(numbers);
		
        return numbers[0] + " " + numbers[numbers.length-1];
    }
}
