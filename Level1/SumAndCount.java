package Level1;
/**
 * ����� ������ ����
 * @author jy-yi
 * 
 * �� ���� left�� right�� �Ű������� �־����ϴ�. 
 * left���� right������ ��� ���� �߿���, ����� ������ ¦���� ���� ���ϰ�, ����� ������ Ȧ���� ���� �� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 *
 */
public class SumAndCount {
	public static void main(String[] args) {
		System.out.println(solution(13,  17));
		System.out.println(solution(24,  27));
	}
	
	public static int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
			if (getDivisorCount(i) % 2 == 0) {
				answer += i;
			} else {
				answer -= i;
			}
		}
        
        return answer;
    }
	
	/**
	 * ����� ���� ��ȯ �Լ�
	 * @param n ��
	 * @return
	 */
	public static int getDivisorCount (int n) {
		int count = 0;
		
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) count++;
		}
		
		return count;
	}
}
