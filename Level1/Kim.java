package Level1;
/**
 * ���￡�� �輭�� ã��
 * @author jy-yi
 * 
 * String�� �迭 seoul�� element�� "Kim"�� ��ġ x�� ã��, "�輭���� x�� �ִ�"�� String�� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���. 
 * seoul�� "Kim"�� ���� �� ���� ��Ÿ���� �߸��� ���� �ԷµǴ� ���� �����ϴ�.
 */
public class Kim {
	public static void main(String[] args) {
		String[] name = {"Jane", "Kim"};
		
		System.out.println(solution(name));
	}
	
	public static String solution(String[] seoul) {
        
        for (int i = 0; i < seoul.length; i++) {
			if ("Kim".equals(seoul[i])) 
				return "�輭���� " + i + "�� �ִ�";
		}
        
        return null;
        
    }
}
