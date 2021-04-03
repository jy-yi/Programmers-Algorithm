package kakao.makers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 카카오 메이커스 백엔드 신입 공채
 * @author jy-yi
 *
 * 로봇을 이용하여 여러 종류의 완제품을 만드는 공장을 운영하려고 합니다. 
 * 로봇 한 대는 부품 한 종류만 처리할 수 있으며, 완제품의 종류에 따라 필요한 부품이 다를 수 있습니다. 
 * 이때, 로봇 r대로 최대한 다양한 완제품을 만들려 합니다.
 * 
 * 예를 들어, 각 완제품을 만들 때 다음과 같은 부품이 필요하고, 살 수 있는 로봇은 최대 두 대라고 가정하겠습니다(번호는 0번부터 시작합니다).
 * 
 * 완제품 번호	필요한 부품 번호
 * 0			0
 * 1			0, 1
 * 2			0, 1
 * 3			0, 2
 * 4			0, 1
 * 5			1, 2
 * 
 * 두 로봇을 이용해 완제품을 만드는 경우는 모두 다음과 같습니다.
 * 
 * 구매할 첫 번째 로봇	구매할 두 번째 로봇	만들 수 있는 완제품
 * 부품 0을 처리하는 로봇	부품 1을 처리하는 로봇	0, 1, 2, 4번 완제품
 * 부품 0을 처리하는 로봇	부품 2를 처리하는 로봇	0, 3번 완제품
 * 부품 1을 처리하는 로봇	부품 2를 처리하는 로봇	5번 완제품
 * 
 * 따라서, 최대한 다양한 완제품을 만들려면 부품 0을 처리하는 로봇과 부품 1을 처리하는 로봇을 구매해야 합니다.
 * 
 * 완제품을 만드는 데 필요한 부품의 정보 needs와 최대로 구매 가능한 로봇 수 r이 매개변수로 주어질 때, 
 * 최대 몇 종류의 완제품을 만들 수 있는지 return 하도록 solution 함수를 완성해 주세요.
 * 
 */
public class Test2 {
	public static void main(String[] args) {
		int[][] needs = {{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
		
		System.out.println(solution(needs, 2));
	}
	
	public static int solution(int[][] needs, int r) {
        int column = needs[0].length; // 가로(열)의 길이
        Map<Integer, Integer> partMap = new HashMap<Integer, Integer>();
		
        for (int i = 0; i < needs.length; i++) {
			for (int j = 0; j < needs[i].length; j++) {
				if (needs[i][j] == 1) {
					partMap.put(j, partMap.getOrDefault(j, 0) + 1);
				}
			}
		}
        
        List<Integer> keySet = new ArrayList<>(partMap.keySet());
        List<Integer> robot = new ArrayList<>();
        /* value 기준 내림차순 정렬 */
        keySet.sort((o1, o2) -> partMap.get(o2) - partMap.get(o1));
        
        /* 가장 많이 필요한 부품을 처리할 수 있는 로봇을 r개만큼 구입 */
        for (int i = 0; i < r; i++) {
        	robot.add(keySet.get(i));
		}
        
        int answer = 0;
        
        for (int i = 0; i < needs.length; i++) {
        	boolean isOk = true;
			for (int j = 0; j < needs[i].length; j++) {
				if (needs[i][j] == 1) {
                    // 만들 수 없는 부품일 경우
					if(!robot.contains(j)) {
						isOk = false;
					}
				}
			}
			if(isOk) answer++;
		}
        
        return answer;
    }
	
}
