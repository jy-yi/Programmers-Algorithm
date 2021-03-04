package Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �ùٸ� ��ȣ
 * @author jy-yi
 *
 * ��ȣ�� �ٸ��� ¦�������ٴ� ���� '(' ���ڷ� �������� �ݵ�� ¦��� ')' ���ڷ� ������ �Ѵٴ� ���Դϴ�. 
 * 
 * ���� ���
 * "()()" �Ǵ� "(())()" �� �ùٸ� ��ȣ�Դϴ�.
 * ")()(" �Ǵ� "(()(" �� �ùٸ��� ���� ��ȣ�Դϴ�.
 * 
 * '(' �Ǵ� ')' �θ� �̷���� ���ڿ� s�� �־����� ��, 
 * ���ڿ� s�� �ùٸ� ��ȣ�̸� true�� return �ϰ�, �ùٸ��� ���� ��ȣ�̸� false�� return �ϴ� solution �Լ��� �ϼ��� �ּ���.
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
        Queue<Character> bracketQueue = new LinkedList<Character>(); // ��ȣ �Ǵ��� ť ����
        
        for (char c : array) {
        	/* ���� ��ȣ ť�� ���� */
			if (c == '(') {
				bracketQueue.add(c);
			/* �ݴ� ��ȣ ť���� ���� */
			} else {
				// ���� '('�� ������ �ùٸ��� ���� ��ȣ 
				if (bracketQueue.isEmpty()) {
					return false;
				// ���������� ��ȣ ���� ���
				} else {
					bracketQueue.poll();
				}
			}
		}
        
        if (bracketQueue.isEmpty()) return true;
        else return false; // ¦�������� ���� ��ȣ�� ������ ���
        
    }
}
