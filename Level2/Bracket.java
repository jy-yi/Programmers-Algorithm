package Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 올바른 괄호
 * @author jy-yi
 *
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 
 * 
 * 예를 들어
 * "()()" 또는 "(())()" 는 올바른 괄호입니다.
 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 * 
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 
 * 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 */
public class Bracket {
	public static void main(String[] args) {
		Bracket b = new Bracket();
		
		System.out.println(b.solution("()()"));
		System.out.println(b.solution("(())()"));
		System.out.println(b.solution(")()("));
		System.out.println(b.solution("(()("));
	}
	
	boolean solution(String s) {
		
        char[] array = s.toCharArray();
        Queue<Character> bracketQueue = new LinkedList<Character>(); // 괄호 판단할 큐 선언
        
        for (char c : array) {
        	/* 여는 괄호 큐에 저장 */
			if (c == '(') {
				bracketQueue.add(c);
			/* 닫는 괄호 큐에서 삭제 */
			} else {
				// 닫을 '('가 없으면 올바르지 않은 괄호 
				if (bracketQueue.isEmpty()) {
					return false;
				// 정상적으로 괄호 닫힌 경우
				} else {
					bracketQueue.poll();
				}
			}
		}
        
        if (bracketQueue.isEmpty()) return true;
        else return false; // 짝지어지지 않은 괄호가 존재할 경우
        
    }
}
