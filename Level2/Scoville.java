package Level2;
import java.util.PriorityQueue;
/**
 * �� �ʰ�
 * @author jy-yi
 *
 * �ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. 
 * ��� ������ ���ں� ������ K �̻����� ����� ���� Leo�� ���ں� ������ ���� ���� �� ���� ������ �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.
 * 
 * ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
 * 
 * Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
 * Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, 
 * ��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
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
        
        // �迭 �� ť�� �ֱ�
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
