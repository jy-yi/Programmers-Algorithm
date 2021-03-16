package Level2;
/**
 * 주식 가격
 * @author jy-yi
 *
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
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
			int now = prices[i]; // 비교할 시점의 주식 가격
			int count = 0;
			
			/* 다음 시점부터 비교 */
			for (int j = i+1; j < prices.length; j++) {
				
				count++;
				
				/* 주식 가격이 떨어지지 않았을 경우 */
				if (prices[j] >= now) continue;
				else break;
			}
			answer[i] = count;
		}

		return answer;
	}
}
