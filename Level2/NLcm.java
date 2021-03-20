package Level2;

import java.util.Arrays;
/**
 * N개의 최소공배수
 * @author jy-yi
 *
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 
 * 예를 들어 2와 7의 최소공배수는 14가 됩니다. 
 * 
 * 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. 
 * 
 * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 */
public class NLcm {
	public static void main(String[] args) {
		NLcm nLcm = new NLcm();
		
		int[] arr = {2,6,8,14};
		int[] arr2 = {1,2,3};
		
		System.out.println(nLcm.solution(arr));
		System.out.println(nLcm.solution(arr2));
	}
	
	public int solution(int[] arr) {
        
        Arrays.sort(arr);
        
        int lcd = getLCM(arr[0], arr[1]);
        
        for (int i = 2; i < arr.length; i++) {
        	lcd = getLCM(arr[i], lcd);
        }
        
        return lcd;
    }
	
	public int getGCD(int n, int m) {
		if (n % m == 0)
			return m;
		else
			return getGCD(m, n % m);
	}

	public int getLCM(int n, int m) {
		return n * m / getGCD(n, m);
	}
}
