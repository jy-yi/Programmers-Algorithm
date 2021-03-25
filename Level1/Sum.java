package Level1;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
/**
 * 정수 배열 numbers가 주어집니다. 
 * numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 
 * return 하도록 solution 함수를 완성해주세요.
 * @author jy-yi
 *
 */
public class Sum {
	public static void main(String[] args) {
		int[] numbers = {5,0,2,7};
		
		solution(numbers);
	}
	
	public static int[] solution(int[] numbers) {
		// TreeSet : 중복을 허용하지 않고 기본적으로 오름차순 으로 데이터 정렬
		Set<Integer> answerSet = new TreeSet<Integer>();
		
		Arrays.sort(numbers); // 매개변수로 받은 정수형 배열 정렬
		
		/* 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더하기 */
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < i; j++) {
				answerSet.add(numbers[i] + numbers[j]);
			}
		}
		
        return answerSet.stream().mapToInt(Integer::intValue).toArray(); // Set to Array
    }
}
