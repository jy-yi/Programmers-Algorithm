package Level1;

/**
 * ���� ��ȣ
 * @author jy-yi
 *
 * � ������ �� ���ĺ��� ������ �Ÿ���ŭ �о �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ ����� ���� ��ȣ��� �մϴ�. 
 * ���� ��� "AB"�� 1��ŭ �и� "BC"�� �ǰ�, 3��ŭ �и� "DE"�� �˴ϴ�. 
 * "z"�� 1��ŭ �и� "a"�� �˴ϴ�. 
 * 
 * ���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�, solution�� �ϼ��� ������.
 */
public class Sizor {
	public static void main(String[] args) {
		System.out.println(solution("Aa Zz", 25));
	}

	public static String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			int temp = 0;

			if (c == ' ') {
				answer += ' ';
			} else if (c <= 90) {
				temp = (c - 65 + n) % 26;
				answer += (char) (temp + 65);
			} else {
				temp = (c - 97 + n) % 26;
				answer += (char) (temp + 97);
			}
		}

		return answer;
	}
}
