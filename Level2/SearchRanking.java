package Level2;

public class SearchRanking {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", 
						  "python frontend senior chicken 210",
						  "python frontend senior chicken 150", 
						  "cpp backend senior pizza 260", 
						  "java backend junior chicken 80",
						  "python backend senior chicken 50" };
		String[] query = {"java and backend and junior and pizza 100",
						  "python and frontend and senior and chicken 200",
						  "cpp and - and senior and pizza 250",
						  "- and backend and senior and - 150",
						  "- and - and - and chicken 100",
						  "- and - and - and - 150"};
		
		int[] array = solution(info, query);
		
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		
		for (int i = 0; i < query.length; i++) {
			String q = query[i];
			
			/* 0 : 개발 언어
			 * 1 : 직군
			 * 2 : 경력
			 * 3 : 소울 푸드
			 * 4 : 점수 */
			String[] split = q.split(" and | "); // 조건 분리
			int count = 0;
			
			for (int j = 0; j < info.length; j++) {
				String infomation = info[j];
				boolean isOk = false;
				for (int k = 0; k < split.length-1; k++) {
					if ("-".equals(split[k])) {
						isOk = true;
						continue;
					} 
					if (infomation.contains(split[k])) {
						isOk = true;
					} else {
						isOk = false;
						break;
					}
				}
				if (isOk) {
					String score = infomation.split(" ")[4];
					if (Integer.parseInt(score) >= Integer.parseInt(split[4])) {
						count++;
					}
				}
			}
			
			answer[i] = count;
		}
		
		return answer;
	}
}
