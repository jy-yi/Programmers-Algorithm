package Level1;

/**
 * ���� ���� ���ϱ�
 * @author jy-yi
 * 
 * 0���� 9������ ���� �� �Ϻΰ� ����ִ� �迭 numbers�� �Ű������� �־����ϴ�. 
 * numbers���� ã�� �� ���� 0���� 9������ ���ڸ� ��� ã�� ���� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 *
 */
public class AddingNotExistNum {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,6,7,8,0};
//		int[] numbers = {5,8,4,0,6,7,9};
		System.out.println(solution(numbers));
	}
	
    public static int solution(int[] numbers) {
        int sum = 0;
        
        for (int i = 0; i < numbers.length; i++) {
        	sum += numbers[i];
		}
        
        return 45 - sum;
    }
}
