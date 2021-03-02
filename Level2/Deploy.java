package Level2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ��� ����
 * @author jy-yi
 * 
 * ���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.
 * ��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, 
 * �̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.
 * 
 * ���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� 
 * �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� ��, 
 * �� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
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
        
        /* ���� �۾��� ���� */
        for (int i = 0; i < progresses.length; i++) {
        	restList[i] = 100 - progresses[i];
		}
        
        /* ���� ������ */
        for (int i = 0; i < restList.length; i++) {
        	int workDays = restList[i] / speeds[i];
        	workQueue.add(restList[i] % speeds[i] == 0 ? workDays : workDays + 1); // �۾����� / �۾� �ӵ��� Ȧ���� ��� �Ϸ� �� �ҿ��			
		}
        
        int prev = workQueue.poll(); 	 // ù��° �۾��� ť���� ��ȯ �� ����
        int count = 1;
        
        while(!workQueue.isEmpty()) {
        	int curr = workQueue.poll(); // ���� �۾� ��Ȳ
        	
        	/* ���� ����� ���� �ϼ����� ���� ���� */
        	if (prev >= curr) {
        		count++;
        	} else {
        		answerList.add(count);
        		count = 1; 		// ī��Ʈ �ʱ�ȭ
        		prev = curr;	// �ٽ� �񱳸� ���� ���� �۾��� �񱳴������ ġȯ
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
