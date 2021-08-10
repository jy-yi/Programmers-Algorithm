package Level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 숫자 문자열과 영단어
 * @author jy-yi
 * 
 * 네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
 * 
 * 1478 → "one4seveneight"
 * 234567 → "23four5six7"
 * 10203 → "1zerotwozero3"
 * 
 * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. 
 * s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
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
