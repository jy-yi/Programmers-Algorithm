package Level2;
/**
 * 삼각 달팽이
 * @author jy-yi
 * 
 * 정수 n이 매개변수로 주어집니다. 
 * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 
 * 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 
 * solution 함수를 완성해주세요.
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
		/* 높이가 n인 삼각형 생성 */
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
