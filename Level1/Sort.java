package Level1;

import java.util.Arrays;
/**
 * 
 * @author jy-yi
 *
 * ���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, 
 * �� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ� �մϴ�. 
 * 
 * ���� ��� strings�� ["sun", "bed", "car"]�̰� n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� "u", "e", "a"�� strings�� �����մϴ�.
 */
public class Sort {
	public static void main(String[] args) {
		String[] strings = {"abce", "abcd", "cdx"};
		
		String[] result = solution(strings, 2);
		for (String string : result) {
			System.out.println(string);
		}
	}
	
	public static String[] solution(String[] strings, int n) {
		
        String[] answer = new String[strings.length];
        
        for (int i = 0; i < strings.length; i++) {
			answer[i] = strings[i].charAt(n) + strings[i];
		}
        
        Arrays.sort(answer);
        
        for (int i = 0; i < answer.length; i++) {
			answer[i] = answer[i].substring(1);
		}
        
        return answer;
    }
	
}
