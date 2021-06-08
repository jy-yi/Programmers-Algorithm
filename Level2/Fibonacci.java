package Level2;
/**
 * �Ǻ���ġ ��
 * @author jy-yi
 * 
 * 2 �̻��� n�� �ԷµǾ��� ��, n��° �Ǻ���ġ ���� 1234567���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��� �ּ���.
 *
 */
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(5));
	}

	public static int solution(int n) {
//		return fibonacci(n) % 1234567;
		
		int answer[] = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			if (i == 0) answer[i] = 0;
			else if (i == 1) answer[i] = 1;
			else {
				int sum = answer[i-2] + answer[i-1];
				answer[i] = sum % 1234567;
			}
		}
		
		return answer[n];
	}

	public static int fibonacci(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return (fibonacci(n - 2) + fibonacci(n - 1)) % 1234567;
	}
	
	public static int fibonacci2(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return (fibonacci(n - 2) + fibonacci(n - 1)) % 1234567;
	}
}
