package Level2;
import java.util.PriorityQueue;
/**
 * 더 맵게
 * @author jy-yi
 *
 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 * 
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * 
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 */
public class Scoville {
	
	public static void main(String[] args) {
		Scoville s = new Scoville();
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(s.solution(scoville, K));
	}
	
	public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
        
        // 배열 값 큐에 넣기
        for (Integer i : scoville) {
        	pqueue.add(i);
        }
        
        int count = 0;
        while (pqueue.peek() < K) {
        	if (pqueue.size() == 1)
        		return -1;
        	
        	int newScoville = pqueue.poll() + pqueue.poll() * 2;
        	pqueue.add(newScoville);
        	count++;
        }
        
        return count;
        
    }
}
