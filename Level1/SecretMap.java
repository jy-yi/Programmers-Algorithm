package Level1;
import java.util.LinkedList;
import java.util.Queue;
/**
 * �������
 * @author jy-yi
 *
 * 1. ������ �� ���� ���̰� n�� ���簢�� �迭 ���·�, �� ĭ�� "����"(" ") �Ǵ� "��"("#") �� ������ �̷���� �ִ�.
 * 2. ��ü ������ �� ���� ������ ���ļ� ���� �� �ִ�. ���� "���� 1"�� "���� 2"��� ����. 
 * 	  ���� 1 �Ǵ� ���� 2 �� ��� �ϳ��� ���� �κ��� ��ü ���������� ���̴�. ���� 1�� ���� 2���� ��� ������ �κ��� ��ü ���������� �����̴�.
 * 3. "���� 1"�� "���� 2"�� ���� ���� �迭�� ��ȣȭ�Ǿ� �ִ�. 
 * 4. ��ȣȭ�� �迭�� ������ �� �����ٿ��� �� �κ��� 1, ���� �κ��� 0���� ��ȣȭ���� �� ������� �������� �ش��ϴ� ���� �迭�̴�.
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

		String[] map1 = new String[n]; // ����1
		String[] map2 = new String[n]; // ����2

		/* �� �迭�� ������ �� ������ ��ȯ */
		for (int i = 0; i < n; i++) {
			map1[i] = makeBinary(n, arr1[i]);
			map2[i] = makeBinary(n, arr2[i]);
		}

		for (int i = 0; i < n; i++) {
			String map = "";

			String str1 = map1[i];
			String str2 = map2[i];

			for (int j = 0; j < str1.length(); j++) {
				/* ���� 1�� ���� 2���� ��� ������ �κ� */
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
	 * �Է� ���� ���� �������� ��ȯ
	 * 
	 * @param length ������ ����
	 * @param num    �������� ��ȯ�� ������
	 * @return ���ڿ��� ��ȯ�� ������
	 */
	public String makeBinary(int length, int num) {
		int[] answer = new int[length];
		Queue<Integer> queue = new LinkedList<Integer>();

		/* �������� ����� ť�� ���� */
		while (num > 0) {
			queue.add(num % 2);
			num /= 2;
		}

		/* �迭�� �Ųٷ� ���� - �� ������ 0���� ä��� */
		for (int i = answer.length - 1; i >= 0; i--) {
			answer[i] = queue.isEmpty() ? 0 : queue.poll();
		}

		return toString(answer);
	}

	/**
	 * ������ �迭�� ���ڿ��� ��ȯ
	 * 
	 * @param arr ���ڿ��� ��ȯ�� ���� �迭
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
