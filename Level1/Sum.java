package Level1;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
/**
 * ���� �迭 numbers�� �־����ϴ�. 
 * numbers���� ���� �ٸ� �ε����� �ִ� �� ���� ���� �̾� ���ؼ� ���� �� �ִ� ��� ���� �迭�� ������������ ��� 
 * return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * @author jy-yi
 *
 */
public class Sum {
	public static void main(String[] args) {
		int[] numbers = {5,0,2,7};
		
		solution(numbers);
	}
	
	public static int[] solution(int[] numbers) {
		// TreeSet : �ߺ��� ������� �ʰ� �⺻������ �������� ���� ������ ����
		Set<Integer> answerSet = new TreeSet<Integer>();
		
		Arrays.sort(numbers); // �Ű������� ���� ������ �迭 ����
		
		/* ���� �ٸ� �ε����� �ִ� �� ���� ���� �̾� ���ϱ� */
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < i; j++) {
				answerSet.add(numbers[i] + numbers[j]);
			}
		}
		
        return answerSet.stream().mapToInt(Integer::intValue).toArray(); // Set to Array
    }
}
