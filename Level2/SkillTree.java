package Level2;

import java.util.HashMap;
import java.util.Map;

/**
 * 스킬트리
 * @author jy-yi
 *
 * 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
 * 예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 
 * 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
 * 
 * 위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 
 * 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 
 * 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
 * 
 * 선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 
 * 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
 */
public class SkillTree {
	public static void main(String[] args) {
		SkillTree st = new SkillTree();

		String skill = "BDC";
//		String[] skill_trees = {"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};
		String[] skill_trees = {"AAAABACA"};

		System.out.println(st.solution(skill, skill_trees));
	}

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		Map<String, Integer> skillMap = new HashMap<String, Integer>();

		/* 선행 스킬 순서 */
		for (int i = 0; i < skill.length(); i++) {
			skillMap.put(skill.substring(i, i + 1), i);
		}

		for (String s : skill_trees) {
			boolean[] isAllSkill = new boolean[skillMap.size()];

			Loop1: for (int i = 0; i <= s.length() - 1; i++) {
				String prev = s.substring(i, i + 1); // 비교할 첫번째 스킬

				/* 현재 스킬이 순서에 상관 없이 배울 수 있는 스킬일 경우 */
				if (!skillMap.containsKey(prev)) {
					if (prev.equals(s.substring(s.length() - 1))) {
						answer++;
					}
					continue;
				} else {
					isAllSkill[skillMap.get(prev)] = true;
					for (int j = i + 1; j < s.length(); j++) {
						String next = s.substring(j, j + 1); // 비교할 두번째 스킬

						/* 불가능한 스킬 트리 */
						if (skillMap.containsKey(next) && skillMap.get(prev) > skillMap.get(next)) {
							break Loop1; // 다음 스킬트리1로 탈출
						}
					}

					/* 마지막까지 비교 완료한 경우 */
					if (prev.equals(s.substring(s.length() - 1))) {
						answer++;
						for (int j = 1; j < isAllSkill.length; j++) {
							if (!isAllSkill[j-1] && !isAllSkill[j]) {
								answer--;
								break;
							}
						}
					}
				}
			}
		}

		return answer;
	}
}
