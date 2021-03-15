package Level2;
/**
 * 다음 큰 숫자
 * @author jy-yi
 *
 * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
 * 
 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 * 
 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
 * 
 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
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
	 * 이진수 1의 개수 구하는 메소드
	 * @param s 이진수
	 * @return 이진수의 1의 개수
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
