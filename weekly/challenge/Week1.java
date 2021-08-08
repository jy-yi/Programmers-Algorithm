package weekly.challenge;

public class Week1 {
	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}

	public static long solution(int price, int money, int count) {
		long fee = 0;
		long now = price;

		for (int i = 0; i < count; i++) {
			fee += now;
			now += price;
		}

		return fee - money > 0 ? fee - money : 0;
	}
}
