package Level2;

import java.util.Arrays;

/**
 * �ִ񰪰� �ּڰ�
 * @author jy-yi
 * 
 * ���ڿ� s���� �������� ���е� ���ڵ��� ����Ǿ� �ֽ��ϴ�. 
 * str�� ��Ÿ���� ���� �� �ּҰ��� �ִ밪�� ã�� �̸� "(�ּҰ�) (�ִ밪)"������ ���ڿ��� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���.
 * ������� s�� "1 2 3 4"��� "1 4"�� �����ϰ�, "-1 -2 -3 -4"��� "-4 -1"�� �����ϸ� �˴ϴ�.
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
