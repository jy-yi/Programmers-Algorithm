package Level1;
import java.util.Stack;
/**
 * 같은 숫자는 싫어
 * @author jy-yi
 * 
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 
 * 
 * 예를 들면,
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 * 
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 *
 */
public class NoSameNumber {
	public static void main(String[] args) {

//		int []arr = {1,1,3,3,0,1,1};
		int []arr = {4,4,4,3,3};
		
		int[] result = solution(arr);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
        	// 배열의 마지막일 경우 스택에 삽입
        	if (i == arr.length - 1) {
        		stack.push(arr[i]);
        		break;
        	}
        	
    		stack.push(arr[i]); // 현재 값 스택에 삽입
			if (arr[i] == arr[i+1]) {
				stack.pop(); // 다음 인덱스 값과 같을 경우 스택에서 삭제
			}
		}
        
        int[] answer = new int[stack.size()];
        /* 배열 마지막부터 스택 값 채워넣기 (LIFO 속성) */
        for (int i = answer.length - 1; i >= 0; i--) {
			answer[i] = stack.pop();
		}
        return answer;
    }

}
