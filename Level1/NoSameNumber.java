package Level1;
import java.util.Stack;
/**
 * ���� ���ڴ� �Ⱦ�
 * @author jy-yi
 * 
 * �迭 arr�� �־����ϴ�. �迭 arr�� �� ���Ҵ� ���� 0���� 9������ �̷���� �ֽ��ϴ�. 
 * �̶�, �迭 arr���� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� �����Ϸ��� �մϴ�. 
 * ��, ���ŵ� �� ���� ������ ��ȯ�� ���� �迭 arr�� ���ҵ��� ������ �����ؾ� �մϴ�. 
 * 
 * ���� ���,
 * arr = [1, 1, 3, 3, 0, 1, 1] �̸� [1, 3, 0, 1] �� return �մϴ�.
 * arr = [4, 4, 4, 3, 3] �̸� [4, 3] �� return �մϴ�.
 * 
 * �迭 arr���� ���������� ��Ÿ���� ���ڴ� �����ϰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���.
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
        	// �迭�� �������� ��� ���ÿ� ����
        	if (i == arr.length - 1) {
        		stack.push(arr[i]);
        		break;
        	}
        	
    		stack.push(arr[i]); // ���� �� ���ÿ� ����
			if (arr[i] == arr[i+1]) {
				stack.pop(); // ���� �ε��� ���� ���� ��� ���ÿ��� ����
			}
		}
        
        int[] answer = new int[stack.size()];
        /* �迭 ���������� ���� �� ä���ֱ� (LIFO �Ӽ�) */
        for (int i = answer.length - 1; i >= 0; i--) {
			answer[i] = stack.pop();
		}
        return answer;
    }

}
