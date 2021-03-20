package Level2;

import java.util.Arrays;
/**
 * N���� �ּҰ����
 * @author jy-yi
 *
 * �� ���� �ּҰ����(Least Common Multiple)�� �Էµ� �� ���� ��� �� ������ �Ǵ� ���� ���� ���ڸ� �ǹ��մϴ�. 
 * ���� ��� 2�� 7�� �ּҰ������ 14�� �˴ϴ�. 
 * 
 * ���Ǹ� Ȯ���ؼ�, n���� ���� �ּҰ������ n ���� ������ ��� �� ������ �Ǵ� ���� ���� ���ڰ� �˴ϴ�. 
 * 
 * n���� ���ڸ� ���� �迭 arr�� �ԷµǾ��� �� �� ������ �ּҰ������ ��ȯ�ϴ� �Լ�, solution�� �ϼ��� �ּ���.
 */
public class NLcm {
	public static void main(String[] args) {
		NLcm nLcm = new NLcm();
		
		int[] arr = {2,6,8,14};
		int[] arr2 = {1,2,3};
		
		System.out.println(nLcm.solution(arr));
		System.out.println(nLcm.solution(arr2));
	}
	
	public int solution(int[] arr) {
        
        Arrays.sort(arr);
        
        int lcd = getLCM(arr[0], arr[1]);
        
        for (int i = 2; i < arr.length; i++) {
        	lcd = getLCM(arr[i], lcd);
        }
        
        return lcd;
    }
	
	public int getGCD(int n, int m) {
		if (n % m == 0)
			return m;
		else
			return getGCD(m, n % m);
	}

	public int getLCM(int n, int m) {
		return n * m / getGCD(n, m);
	}
}
