package Level1;

import java.util.Stack;
/**
 * 크레인 인형뽑기 게임
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
		
		Stack<Integer> bucket = new Stack<Integer>(); // 인형을 쌓을 바구니
		
		for (int move : moves) {
			for (int i = 0; i < board.length; i++) {
				/* 인형이 없는 곳 */
				if (board[i][move-1] == 0) {
					continue;
				} else {
					/* 같은 모양의 인형 두 개 바구니에 연속해서 쌓이게 되는 경우 */
					if (!bucket.isEmpty() && board[i][move-1] == bucket.peek()) {
						answer += 2;  // 인형은 쌍으로 두개씩 사라짐
						bucket.pop(); // 바구니에서 삭제
					} else {
						bucket.add(board[i][move-1]);
					}
					board[i][move-1] = 0; // 인형 뽑기
										
					break;
				}
			}
		}
		
		return answer;
	}
}
