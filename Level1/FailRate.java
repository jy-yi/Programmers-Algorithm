package Level1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ������
 * @author jy-yi
 * 
 * ���� ���� ������ �������� ū ��ο� ������. 
 * �׳డ ���� ������ ��õ���� �뼺���� �ŵ�����, ���� �ű� ������� ���� �ް��� ���̴�. 
 * ������ �ű� ����ڿ� ���� ����� ���̿� �������� ���̰� �ʹ� ū ���� ��������.
 * 
 * �� ������ ��� �ұ� ��� �� �׳�� �������� ���� �ð��� �÷��� ���̵��� �����ϱ�� �ߴ�. 
 * ���� ���� �����ڶ� ��κ��� ������ ���� ����������, �������� ���ϴ� �κп��� ���⿡ ������ ���Ҵ�. 
 * �������� ���� �������� ���ϴ� �ڵ带 �ϼ��϶�.
 * 
 * �������� ������ ���� �����Ѵ�.
 * ���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
 * 
 * ��ü ���������� ���� N, ������ �̿��ϴ� ����ڰ� ���� �����ִ� ���������� ��ȣ�� ��� �迭 stages�� �Ű������� �־��� ��, 
 * �������� ���� ������������ ������������ ���������� ��ȣ�� ����ִ� �迭�� return �ϵ��� solution �Լ��� �ϼ��϶�.
 *
 */
public class FailRate {
	public static void main(String[] args) {
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] stages2 = { 4, 4, 4, 4, 4 };
		int[] stages3 = { 1, 1, 1 };
		int[] stages4 = { 1,2,2,1,3 };
		int[] stages5 = { 1,2,3 };
		int[] result = solution(5, stages5);

		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];

		Map<Integer, Integer> stageMap = new HashMap<Integer, Integer>(); // ���������� ������ ��
		Map<Integer, Double> failRateMap = new HashMap<Integer, Double>();// ���������� ������

		/* ���������� ������ ������ ���� */
		for (int i : stages) {
			stageMap.put(i, stageMap.getOrDefault(i, 0) + 1); // ������ Key�� ���� ��ȯ�ϰ� ���� �ÿ��� defalultValue�� ��ȯ
			// ���� 1) [1=1, 2=3, 3=2, 4=1, 6=1]
			// ���� 2) [4=5]
		}

		int user = stages.length; // ������ ��
		int nowStage = 1; // ���� ��������

		while (nowStage <= N + 1) {
			for (Entry<Integer, Integer> e : stageMap.entrySet()) {
				if (e.getKey() == nowStage) {
					failRateMap.put(nowStage, e.getValue() / Double.valueOf(user)); // ���� ���������� ������ ����
					user -= e.getValue(); // ���� �������� ���� ���� ����� ���� �ܰ�� �̵� �Ұ��ϹǷ� ������ ������ ����
					break;
				}
			}
			nowStage++; // ���� �ܰ�� �̵�
		}
		
		for (int i = 1; i <= N; i++) {
			failRateMap.put(i, failRateMap.getOrDefault(i, 0.0)); // �������� ���� �������� ó��
		}

		failRateMap.remove(N+1); // ������ ������������ Ŭ���� �� ����� ���������� ����
		
		List<Integer> keySetList = new ArrayList<Integer>(failRateMap.keySet());
		Collections.sort(keySetList, (o1, o2) -> (failRateMap.get(o2).compareTo(failRateMap.get(o1)))); // ������ �������� ����

		answer = keySetList.stream().mapToInt(i -> i).toArray(); // list to int array

		return answer;
	}
}
