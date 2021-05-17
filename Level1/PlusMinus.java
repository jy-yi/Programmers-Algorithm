package Level1;
/**
 * ���� ���ϱ�
 * @author jy-yi
 * 
 * � �������� �ֽ��ϴ�. 
 * �� �������� ������ ���ʴ�� ���� ���� �迭 absolutes�� �� �������� ��ȣ�� ���ʴ�� ���� �Ҹ��� �迭 signs�� �Ű������� �־����ϴ�. 
 * ���� �������� ���� ���Ͽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 *
 */
public class PlusMinus {
	public static void main(String[] args) {
		int[] absolutes = { 4, 7, 12 };
		boolean[] signs = { true, false, true };

		System.out.println(solution(absolutes, signs));
	}

	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		
		for (int i = 0; i < absolutes.length; i++) {
			if (signs[i]) {
				answer += absolutes[i];
			} else {
				answer += absolutes[i] * -1;
			}
		}
		
		return answer;
	}
}
