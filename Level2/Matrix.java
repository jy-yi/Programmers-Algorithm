package Level2;
/**
 * 행렬의 곱셈
 * @author jy-yi
 *
 * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 */
public class Matrix {
	public static void main(String[] args) {
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		
		int[][] result = solution(arr1, arr2);
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length]; // 행렬의 곱은 첫번째 행렬의 행 x 두번째 행렬의 열
        
        for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr1[0].length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
        
        return answer;
    }
}
