package Level2;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * JadenCase ���ڿ� �����
 * @author jy-yi
 *
 * JadenCase�� ��� �ܾ��� ù ���ڰ� �빮���̰�, �� ���� ���ĺ��� �ҹ����� ���ڿ��Դϴ�. 
 * ���ڿ� s�� �־����� ��, s�� JadenCase�� �ٲ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
 */
public class JadenCase {
	public static void main(String[] args) {
		System.out.println(solution("2v 3hello m y friend  23HIz "));
		System.out.println(solution("222 333333"));
	}

	public static String solution(String s) {
		String answer = "";
		
		s = s.toLowerCase(); // ��� �ҹ��ڷ� �ٲٱ�
		String[] tokens = s.split(" "); // ������ �������� �ܾ� �и�

		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];
			
			if ("".equals(str)) { // ������ �������� �Էµ� ���
				answer += str;
			} else if (Pattern.matches("^[a-z]*$", str.substring(0, 1))) { // ù ���ڰ� ������ ���
				answer += str.substring(0, 1).toUpperCase() + str.substring(1);
			} else {
				answer += str;
			}
			
			if (i < tokens.length - 1)
				answer += " ";
		}
		
		// ���� �������� ���� ���� ���
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
