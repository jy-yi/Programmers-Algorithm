package Level2;
/**
 * ���� ū ����
 * @author jy-yi
 *
 * �ڿ��� n�� �־����� ��, n�� ���� ū ���ڴ� ������ ���� ���� �մϴ�.
 * 
 * ���� 1. n�� ���� ū ���ڴ� n���� ū �ڿ��� �Դϴ�.
 * ���� 2. n�� ���� ū ���ڿ� n�� 2������ ��ȯ���� �� 1�� ������ �����ϴ�.
 * ���� 3. n�� ���� ū ���ڴ� ���� 1, 2�� �����ϴ� �� �� ���� ���� �� �Դϴ�.
 * 
 * ���� �� 78(1001110)�� ���� ū ���ڴ� 83(1010011)�Դϴ�.
 * 
 * �ڿ��� n�� �Ű������� �־��� ��, n�� ���� ū ���ڸ� return �ϴ� solution �Լ��� �ϼ����ּ���.
 */
public class NextBiggerNum {
	public static void main(String[] args) {
		NextBiggerNum n = new NextBiggerNum();
		System.out.println(n.solution(78));
		System.out.println(n.solution(15));
	}
	
	public int solution(int n) {
        int answer = 0;
        
        String nBinary = Integer.toBinaryString(n);
        int oneCount = getOneCount(nBinary);
        
        while (true) {
        	int tmp = ++n;
        	String binary = Integer.toBinaryString(tmp);
        	
        	if (oneCount == getOneCount(binary)) {
        		answer = tmp;
        		break;
        	}
        }
        
        return answer;
    }
	
	/**
	 * ������ 1�� ���� ���ϴ� �޼ҵ�
	 * @param s ������
	 * @return �������� 1�� ����
	 */
	public int getOneCount (String s) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				count++;
		}
		
		return count;
	}
}
