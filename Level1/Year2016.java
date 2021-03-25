package Level1;
/**
 * 2016년
 * @author jy-yi
 *
 * 2016년 1월 1일은 금요일입니다. 
 * 2016년 a월 b일은 무슨 요일일까요? 
 * 
 * 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
 * 
 * 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다. 
 * 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
 */
public class Year2016 {

	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}

	public static String solution(int a, int b) {

		int[] months = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 2016년은 윤년이므로 2월은 29일로 설정
		String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

		int totalDay = 0;

		// 월마다 일수 더해주기
		for (int i = 1; i < a; i++) {
			totalDay += months[i - 1];
		}

		totalDay += b - 1; // 1월 1일부터 시작했으므로 -1 처리

		return days[(totalDay + 5) % 7]; // 1월 1일이 금요일이므로 + 5로 초기값 설정
	}

}
