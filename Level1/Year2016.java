package Level1;
/**
 * 2016��
 * @author jy-yi
 *
 * 2016�� 1�� 1���� �ݿ����Դϴ�. 
 * 2016�� a�� b���� ���� �����ϱ��? 
 * 
 * �� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
 * 
 * ������ �̸��� �Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT�Դϴ�. 
 * ���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� "TUE"�� ��ȯ�ϼ���.
 */
public class Year2016 {

	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}

	public static String solution(int a, int b) {

		int[] months = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 2016���� �����̹Ƿ� 2���� 29�Ϸ� ����
		String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

		int totalDay = 0;

		// ������ �ϼ� �����ֱ�
		for (int i = 1; i < a; i++) {
			totalDay += months[i - 1];
		}

		totalDay += b - 1; // 1�� 1�Ϻ��� ���������Ƿ� -1 ó��

		return days[(totalDay + 5) % 7]; // 1�� 1���� �ݿ����̹Ƿ� + 5�� �ʱⰪ ����
	}

}
