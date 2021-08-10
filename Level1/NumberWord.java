package Level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ���� ���ڿ��� ���ܾ�
 * @author jy-yi
 * 
 * �׿��� ���ε��� ���ڳ��̸� �ϰ� �ֽ��ϴ�. �׿��� ���ε����� ���ڸ� �ǳ� �� �Ϻ� �ڸ����� ���ܾ�� �ٲ� ī�带 �ǳ��ָ� ���ε��� ���� ���ڸ� ã�� �����Դϴ�.
 * ������ ������ �Ϻ� �ڸ����� ���ܾ�� �ٲٴ� �����Դϴ�.
 * 
 * 1478 �� "one4seveneight"
 * 234567 �� "23four5six7"
 * 10203 �� "1zerotwozero3"
 * 
 * �̷��� ������ �Ϻ� �ڸ����� ���ܾ�� �ٲ�����ų�, Ȥ�� �ٲ��� �ʰ� �״���� ���ڿ� s�� �Ű������� �־����ϴ�. 
 * s�� �ǹ��ϴ� ���� ���ڸ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 *
 */
public class NumberWord {
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("23four5six7"));
		System.out.println(solution("2three45sixseven"));
		System.out.println(solution("123"));
	}
	
	public static int solution(String s) {
        
        Map<String, String> numberMap = new HashMap<String, String>();
        numberMap.put("zero", "0");
        numberMap.put("one", "1");
        numberMap.put("two", "2");
        numberMap.put("three", "3");
        numberMap.put("four", "4");
        numberMap.put("five", "5");
        numberMap.put("six", "6");
        numberMap.put("seven", "7");
        numberMap.put("eight", "8");
        numberMap.put("nine", "9");
        
        List<String> numberList = new ArrayList<String>(numberMap.keySet());
        
        for (int i = 0; i < numberList.size(); i++) {
			s = s.replaceAll(numberList.get(i), numberMap.get(numberList.get(i)));
		}
        
        return Integer.parseInt(s);
    }
}
