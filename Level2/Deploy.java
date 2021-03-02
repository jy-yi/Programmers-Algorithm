package Level2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 기능 개발
 * @author jy-yi
 * 
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 * 
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 
 * 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때, 
 * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 *
 */
public class Deploy {
	public static void main(String[] args) {
//		int[] progresses = {93, 30, 55}; 
//		int[] speeds = {1, 30, 5};
		int[] progresses = {95, 90, 99, 99, 80, 99}; 
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		solution(progresses, speeds);
		
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        
        int[] restList = new int[progresses.length];
        Queue<Integer> workQueue = new LinkedList<Integer>();
        List<Integer> answerList = new ArrayList<Integer>();
        
        /* 남은 작업의 개수 */
        for (int i = 0; i < progresses.length; i++) {
        	restList[i] = 100 - progresses[i];
		}
        
        /* 배포 가능일 */
        for (int i = 0; i < restList.length; i++) {
        	int workDays = restList[i] / speeds[i];
        	workQueue.add(restList[i] % speeds[i] == 0 ? workDays : workDays + 1); // 작업개수 / 작업 속도가 홀수일 경우 하루 더 소요됨			
		}
        
        int prev = workQueue.poll(); 	 // 첫번째 작업을 큐에서 반환 후 삭제
        int count = 1;
        
        while(!workQueue.isEmpty()) {
        	int curr = workQueue.poll(); // 이후 작업 현황
        	
        	/* 이전 기능이 아직 완성되지 않은 상태 */
        	if (prev >= curr) {
        		count++;
        	} else {
        		answerList.add(count);
        		count = 1; 		// 카운트 초기화
        		prev = curr;	// 다시 비교를 위해 현재 작업을 비교대상으로 치환
        	}
        }
        
        answerList.add(count);
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
        
        return answer;
    }
}
