package Level1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 실패율
 * @author jy-yi
 * 
 * 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 
 * 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 
 * 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
 * 
 * 이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 
 * 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 
 * 오렐리를 위해 실패율을 구하는 코드를 완성하라.
 * 
 * 실패율은 다음과 같이 정의한다.
 * 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 * 
 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
 * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
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

		Map<Integer, Integer> stageMap = new HashMap<Integer, Integer>(); // 스테이지별 도전자 수
		Map<Integer, Double> failRateMap = new HashMap<Integer, Double>();// 스테이지별 실패율

		/* 스테이지별 도전자 분포도 저장 */
		for (int i : stages) {
			stageMap.put(i, stageMap.getOrDefault(i, 0) + 1); // 지정된 Key의 값을 반환하고 없을 시에는 defalultValue를 반환
			// 예제 1) [1=1, 2=3, 3=2, 4=1, 6=1]
			// 예제 2) [4=5]
		}

		int user = stages.length; // 도전자 수
		int nowStage = 1; // 현재 스테이지

		while (nowStage <= N + 1) {
			for (Entry<Integer, Integer> e : stageMap.entrySet()) {
				if (e.getKey() == nowStage) {
					failRateMap.put(nowStage, e.getValue() / Double.valueOf(user)); // 현재 스테이지의 실패율 저장
					user -= e.getValue(); // 현재 스테이지 도전 중인 사람은 다음 단계로 이동 불가하므로 도전자 수에서 제외
					break;
				}
			}
			nowStage++; // 다음 단계로 이동
		}
		
		for (int i = 1; i <= N; i++) {
			failRateMap.put(i, failRateMap.getOrDefault(i, 0.0)); // 실패율이 없는 스테이지 처리
		}

		failRateMap.remove(N+1); // 마지막 스테이지까지 클리어 한 사용자 실패율에서 제외
		
		List<Integer> keySetList = new ArrayList<Integer>(failRateMap.keySet());
		Collections.sort(keySetList, (o1, o2) -> (failRateMap.get(o2).compareTo(failRateMap.get(o1)))); // 실패율 내림차순 정렬

		answer = keySetList.stream().mapToInt(i -> i).toArray(); // list to int array

		return answer;
	}
}
