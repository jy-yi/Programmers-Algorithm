package Level1;

import java.util.Arrays;
/**
 * �ζ��� �ְ� ������ ���� ����
 * @author jy-yi
 * 
 * �ζǸ� ������ �ο�� ��÷ ��ȣ ��ǥ���� �м�����ϰ� �־����ϴ�.
 * ������, �ο��� ������ �ζǿ� ������ �Ͽ�, �Ϻ� ��ȣ�� �˾ƺ� �� ���� �Ǿ����ϴ�.
 * ��÷ ��ȣ ��ǥ ��, �ο�� �ڽ��� �����ߴ� �ζǷ� ��÷�� �����ߴ� �ְ� ������ ���� ������ �˾ƺ��� �;������ϴ�.
 * 
 * �ο찡 ������ �ζ� ��ȣ�� ���� �迭 lottos, ��÷ ��ȣ�� ���� �迭 win_nums�� �Ű������� �־����ϴ�.
 * �̶�, ��÷ ������ �ְ� ������ ���� ������ ���ʴ�� �迭�� ��Ƽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 *
 */
public class Lotto {
	public static void main(String[] args) {
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		
		int[] answer = solution(lottos, win_nums);
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int match = 0;
        int zeroCount = 0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        for (int i = 0; i < lottos.length; i++) {
        	// �˾ƺ� �� ���� ��ȣ
        	if (lottos[i] == 0) {
        		zeroCount++;
        		continue;
        	}
        	
			for (int j = 0; j < win_nums.length; j++) {
				if (lottos[i] == win_nums[j]) {
					match++;
					break;
				}
			}
		}
        
        answer[0] = getRank(match + zeroCount);	// �˾ƺ� �� ���� ��ȣ�� ��� ��÷ ��ȣ�� ��ġ�� ���
        answer[1] = getRank(match);	// �˾ƺ� �� ���� ��ȣ�� ��� ��÷ ��ȣ�� ����ġ�� ���
        
        return answer;
    }
	
	/**
	 * ��ġ ������ ���� ���� ��ȯ
	 * @param n ��ġ�� �ζ� ��ȣ ����
	 * @return	�ش� ����
	 */
	public static int getRank(int n) {
		
		switch (n) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}
}
