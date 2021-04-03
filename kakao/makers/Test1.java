package kakao.makers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * īī�� ����Ŀ�� �鿣�� ���� ��ä
 * @author jy-yi
 *  
 * ���� �� �ִ� ��ǰ ��ȣ�� �����ִ� ��ǰ���� ������� ���� �ϳ��� ������ �ֽ��ϴ�. 
 * ������� ���� �ް� ���� ��ǰ�� �ִµ�, �ڽ��� ������ �ִ� ��ǰ���� ��ȣ�� �ڽ��� �ް� ���� ��ǰ�� ��ȣ�� �ƴ϶�� �ٸ� ����� ��ȯ�� �� �ֽ��ϴ�. 
 * �̶�, ������ �ʴ� ��ǰ�� �޴� ��� ���� �ּҷ� �ؾ� �մϴ�.
 * 
 * ���� ��� ��ǰ���� ���� ����� 5���̰�, 
 * ù ��° ������� ������ �ִ� ��ǰ�ǿ� ���� ��ȣ�� [4, 5, 3, 2, 1], �� ����� �ް� �;� �ϴ� ��ǰ ��ȣ�� ������� [2, 4, 4, 5, 1]��� �ϰڽ��ϴ�.
 * 
 * �� ��� �ټ� ��° ����� ������ �ִ� ��ǰ�ǿ� ���� ��ȣ(1��)�� �ް� ���� ��ǰ ��ȣ(1��)�� ��ġ�ϱ� ������ �ٸ� ����� ��ȯ���� �ʾƵ� �˴ϴ�.
 * 
 * ��, ù ��°, �� ��°, �� ��° ����� ��� �Ʒ��� ���� ��ǰ���� ��ȯ�ϸ� ���� �ް� ���� ��ǰ�� ��ȣ�� ���� ��ǰ���� ���� �� �ֽ��ϴ�.
 * 
 * ù ��° ����� �� ��° ����� ��ȣ�� ��ȯ�մϴ�. (4�� �� 2��)
 * �ٽ�, �� ��° ����� �� ��° ����� ��ȣ�� ��ȯ�մϴ�. (5�� �� 4��)
 * ���� �� ����� ������ �ִ� ��ǰ�ǿ� ���� ��ȣ�� �Ʒ��� �����ϴ�.
 * 
 * [2, 4, 3, 5, 1]
 * �� ��° ����� 4�� ��ǰ�� �ް� ������, �� ��ȯ�� ����� �����ϴ�. 
 * ���� ���ϴ� ��ǰ�� ���� �� ���� ����� �ּ� 1���� �˴ϴ�.
 * 
 * ������� ������ �ִ� ��ǰ�ǿ� ���� ��ȣ�� ������� ����ִ� �迭 gift_cards�� �� ����� �ް� �;� �ϴ� ��ǰ ��ȣ�� ������� ����ִ� �迭 wants�� �Ű������� �־��� ��, 
 * ���ϴ� ��ǰ�� ���� ���ϴ� ����� �ּڰ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 *
 */
public class Test1 {
	public static void main(String[] args) {
		int[] gift_cards = {5, 4, 5, 4, 5};
		int[] wants = {1, 2, 3, 5, 4};
		
		System.out.println(solution(gift_cards, wants));
	}
	
	public static int solution(int[] gift_cards, int[] wants) {
        
        Arrays.sort(gift_cards);
        Arrays.sort(wants);
        
        // int array to list
        List<Integer> wantList = Arrays.stream(wants).boxed().collect(Collectors.toList());
        
        /* ���ĵ� �迭�̹Ƿ� �տ������� ��ġ�ϴ� ī�� �ϳ��� �Ұ� */
        for (int i = 0; i < gift_cards.length; i++) {
        	int card = gift_cards[i];
			if (wantList.contains(card)) {
				wantList.remove(wantList.get(wantList.indexOf(card)));
			}
		}
        
        return wantList.size();
    }
}
