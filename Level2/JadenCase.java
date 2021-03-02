package Level2;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * JadenCase 문자열 만들기
 * @author jy-yi
 *
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 */
public class JadenCase {
	public static void main(String[] args) {
		System.out.println(solution("2v 3hello m y friend  23HIz "));
		System.out.println(solution("222 333333"));
	}

	public static String solution(String s) {
		String answer = "";
		
		s = s.toLowerCase(); // 모두 소문자로 바꾸기
		String[] tokens = s.split(" "); // 공백을 기준으로 단어 분리

		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];
			
			if ("".equals(str)) { // 공백이 연속으로 입력될 경우
				answer += str;
			} else if (Pattern.matches("^[a-z]*$", str.substring(0, 1))) { // 첫 문자가 영문일 경우
				answer += str.substring(0, 1).toUpperCase() + str.substring(1);
			} else {
				answer += str;
			}
			
			if (i < tokens.length - 1)
				answer += " ";
		}
		
		// 문장 마지막에 공백 있을 경우
		if (" ".equals(s.substring(s.length()-1))) 
			answer += " ";

		return answer;
	}
	
	public static String solution2(String s) {
		String answer = "";

		StringTokenizer st = new StringTokenizer(s, " ");

		while(st.hasMoreElements()) {
			String str = st.nextToken().trim();
			
			answer += str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
			if (st.hasMoreTokens())
				answer += " ";
		}
		return answer;
	}
}
