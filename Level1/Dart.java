package Level1;
/**
 * 다트 게임
 * @author jy-yi
 *
 * 다트 게임은 총 3번의 기회로 구성된다.
 * 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
 * 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
 * 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
 * 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
 * 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
 * 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
 * Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
 * 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
 * 
 * 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 */
public class Dart {
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}

	public static int solution(String dartResult) {
		int answer = 0;
		int n = 0, index = 0, nowInt = 0;
		int[] score = new int[3]; // 각 단계별 획득 점수

		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);

			/* 점수일 경우 */
			if (Character.isDigit(c)) {
				n = 0;
				if (c == '1' && dartResult.charAt(i + 1) == '0') {
					n = 10;
					i++; // 인덱스 다음으로 증가
				} else {
					n = Character.getNumericValue(c);
				}
				
				nowInt++;
				
			/* 보너스 or 옵션일 경우 */
			} else {
				switch (c) {
				case 'S':
					score[index++] = (int) Math.pow(n, 1);	// 1제곱
					break;
					
				case 'D':
					score[index++] = (int) Math.pow(n, 2);	// 2제곱
					break;
					
				case 'T':
					score[index++] = (int) Math.pow(n, 3);	// 3제곱
					break;
					
				case '*':	// 스타상 :  바로 전에 얻은 점수를 각 2배
					index = index - 2 < 0 ? 0 : index - 2;
					while (index < nowInt) {
						score[index++] *= 2;
					}
					n = 0;
					break;
					
				case '#':	// 아차상 :  해당 점수는 마이너스
					score[index-1] *= -1;	
					n = 0;
					break;
				}
			}
		}
		
		for (int i : score) {
			answer += i;
		}

		return answer;
	}
}
