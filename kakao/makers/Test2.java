package kakao.makers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * īī�� ����Ŀ�� �鿣�� ���� ��ä
 * @author jy-yi
 *
 * �κ��� �̿��Ͽ� ���� ������ ����ǰ�� ����� ������ ��Ϸ��� �մϴ�. 
 * �κ� �� ��� ��ǰ �� ������ ó���� �� ������, ����ǰ�� ������ ���� �ʿ��� ��ǰ�� �ٸ� �� �ֽ��ϴ�. 
 * �̶�, �κ� r��� �ִ��� �پ��� ����ǰ�� ����� �մϴ�.
 * 
 * ���� ���, �� ����ǰ�� ���� �� ������ ���� ��ǰ�� �ʿ��ϰ�, �� �� �ִ� �κ��� �ִ� �� ���� �����ϰڽ��ϴ�(��ȣ�� 0������ �����մϴ�).
 * 
 * ����ǰ ��ȣ	�ʿ��� ��ǰ ��ȣ
 * 0			0
 * 1			0, 1
 * 2			0, 1
 * 3			0, 2
 * 4			0, 1
 * 5			1, 2
 * 
 * �� �κ��� �̿��� ����ǰ�� ����� ���� ��� ������ �����ϴ�.
 * 
 * ������ ù ��° �κ�	������ �� ��° �κ�	���� �� �ִ� ����ǰ
 * ��ǰ 0�� ó���ϴ� �κ�	��ǰ 1�� ó���ϴ� �κ�	0, 1, 2, 4�� ����ǰ
 * ��ǰ 0�� ó���ϴ� �κ�	��ǰ 2�� ó���ϴ� �κ�	0, 3�� ����ǰ
 * ��ǰ 1�� ó���ϴ� �κ�	��ǰ 2�� ó���ϴ� �κ�	5�� ����ǰ
 * 
 * ����, �ִ��� �پ��� ����ǰ�� ������� ��ǰ 0�� ó���ϴ� �κ��� ��ǰ 1�� ó���ϴ� �κ��� �����ؾ� �մϴ�.
 * 
 * ����ǰ�� ����� �� �ʿ��� ��ǰ�� ���� needs�� �ִ�� ���� ������ �κ� �� r�� �Ű������� �־��� ��, 
 * �ִ� �� ������ ����ǰ�� ���� �� �ִ��� return �ϵ��� solution �Լ��� �ϼ��� �ּ���.
 * 
 */
public class Test2 {
	public static void main(String[] args) {
		int[][] needs = {{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
		
		System.out.println(solution(needs, 2));
	}
	
	public static int solution(int[][] needs, int r) {
        int column = needs[0].length; // ����(��)�� ����
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
        /* value ���� �������� ���� */
        keySet.sort((o1, o2) -> partMap.get(o2) - partMap.get(o1));
        
        /* ���� ���� �ʿ��� ��ǰ�� ó���� �� �ִ� �κ��� r����ŭ ���� */
        for (int i = 0; i < r; i++) {
        	robot.add(keySet.get(i));
		}
        
        int answer = 0;
        
        for (int i = 0; i < needs.length; i++) {
        	boolean isOk = true;
			for (int j = 0; j < needs[i].length; j++) {
				if (needs[i][j] == 1) {
                    // ���� �� ���� ��ǰ�� ���
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
