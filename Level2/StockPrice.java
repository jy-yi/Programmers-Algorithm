package Level2;
/**
 * �ֽ� ����
 * @author jy-yi
 *
 * �� ������ ��ϵ� �ֽİ����� ��� �迭 prices�� �Ű������� �־��� ��, 
 * ������ �������� ���� �Ⱓ�� �� �������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 */
public class StockPrice {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };

		int[] result = solution(prices);

		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			int now = prices[i]; // ���� ������ �ֽ� ����
			int count = 0;
			
			/* ���� �������� �� */
			for (int j = i+1; j < prices.length; j++) {
				
				count++;
				
				/* �ֽ� ������ �������� �ʾ��� ��� */
				if (prices[j] >= now) continue;
				else break;
			}
			answer[i] = count;
		}

		return answer;
	}
}
