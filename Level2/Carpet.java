package Level2;
/**
 * ī��
 * @author jy-yi
 *
 * Leo�� ī���� �緯 ���ٰ� �߾ӿ��� ��������� ĥ���� �ְ� �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.
 * Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� ������� �������� ��ĥ�� ������ ������ ���������, ��ü ī���� ũ��� ������� ���߽��ϴ�.
 * 
 * Leo�� �� ī�꿡�� ���� ������ �� brown, ����� ������ �� yellow�� �Ű������� �־��� �� 
 * ī���� ����, ���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */
public class Carpet {
	public static void main(String[] args) {
		int[] array = solution(10, 2);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int area = brown + yellow; // ��ü ���� ����

		for (int i = 1; i <= area; i++) {
			int row = i; 			// ����
			int col = area / row; 	// ����

			// ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ���.
			if (row > col)
				continue;

			if ((row - 2) * (col - 2) == yellow) {
				answer[0] = col;
				answer[1] = row;
				return answer;
			}

		}

		return answer;
	}
}
