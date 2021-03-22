package Level1;

import java.util.Stack;
/**
 * ũ���� �����̱� ����
 * @author jy-yi
 *
 */
public class CraneDoll {
	public static void main(String[] args) {
		CraneDoll cd = new CraneDoll();

		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		
		System.out.println(cd.solution(board, moves));
	}

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		Stack<Integer> bucket = new Stack<Integer>(); // ������ ���� �ٱ���
		
		for (int move : moves) {
			for (int i = 0; i < board.length; i++) {
				/* ������ ���� �� */
				if (board[i][move-1] == 0) {
					continue;
				} else {
					/* ���� ����� ���� �� �� �ٱ��Ͽ� �����ؼ� ���̰� �Ǵ� ��� */
					if (!bucket.isEmpty() && board[i][move-1] == bucket.peek()) {
						answer += 2;  // ������ ������ �ΰ��� �����
						bucket.pop(); // �ٱ��Ͽ��� ����
					} else {
						bucket.add(board[i][move-1]);
					}
					board[i][move-1] = 0; // ���� �̱�
										
					break;
				}
			}
		}
		
		return answer;
	}
}
