package Level2;
/**
 * �ﰢ ������
 * @author jy-yi
 * 
 * ���� n�� �Ű������� �־����ϴ�. 
 * ���� �׸��� ���� �غ��� ���̿� ���̰� n�� �ﰢ������ �� �� ���������� �ݽð� �������� ������ ä��⸦ ������ ��, 
 * ù ����� ������ ����� ��� ������� ��ģ ���ο� �迭�� return �ϵ��� 
 * solution �Լ��� �ϼ����ּ���.
 *
 */
public class TriangleSnail {
	public static void main(String[] args) {
		int[] array = solution(5);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int n) {
		/* ���̰� n�� �ﰢ�� ���� */
		int[][] triangle = new int[n][];
		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = new int[i + 1];
		}

		int x = -1, y = 0;
		int index = 1;

		for (int i = 0; i < triangle.length; i++) {
			for (int j = i; j < triangle.length; j++) {
				if (i % 3 == 0) {
					x++;
				} else if (i % 3 == 1) {
					y++;
				} else {
					x--;
					y--;
				}
				triangle[x][y] = index++; 
			}
		}

		int[] answer = new int[(n * (n + 1)) / 2];
		int k = 0;
		
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				answer[k++] = triangle[i][j];
			}
		}

		return answer;
	}
}
