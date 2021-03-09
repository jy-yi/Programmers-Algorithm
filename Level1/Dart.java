package Level1;
/**
 * ��Ʈ ����
 * @author jy-yi
 *
 * ��Ʈ ������ �� 3���� ��ȸ�� �����ȴ�.
 * �� ��ȸ���� ���� �� �ִ� ������ 0������ 10�������̴�.
 * ������ �Բ� Single(S), Double(D), Triple(T) ������ �����ϰ� �� ���� ��÷ �� �������� 1����, 2����, 3���� (����1 , ����2 , ����3 )���� ���ȴ�.
 * �ɼ����� ��Ÿ��(*) , ������(#)�� �����ϸ� ��Ÿ��(*) ��÷ �� �ش� ������ �ٷ� ���� ���� ������ �� 2��� �����. ������(#) ��÷ �� �ش� ������ ���̳ʽ��ȴ�.
 * ��Ÿ��(*)�� ù ��° ��ȸ������ ���� �� �ִ�. �� ��� ù ��° ��Ÿ��(*)�� ������ 2�谡 �ȴ�. (���� 4�� ����)
 * ��Ÿ��(*)�� ȿ���� �ٸ� ��Ÿ��(*)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ��Ÿ��(*) ������ 4�谡 �ȴ�. (���� 4�� ����)
 * ��Ÿ��(*)�� ȿ���� ������(#)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ������(#)�� ������ -2�谡 �ȴ�. (���� 5�� ����)
 * Single(S), Double(D), Triple(T)�� �������� �ϳ��� �����Ѵ�.
 * ��Ÿ��(*), ������(#)�� �������� �� �� �ϳ��� ������ �� ������, �������� ���� ���� �ִ�.
 * 
 * 0~10�� ������ ���� S, D, T, *, #�� ������ ���ڿ��� �Էµ� �� �������� ��ȯ�ϴ� �Լ��� �ۼ��϶�.
 */
public class Dart {
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}

	public static int solution(String dartResult) {
		int answer = 0;
		int n = 0, index = 0, nowInt = 0;
		int[] score = new int[3]; // �� �ܰ躰 ȹ�� ����

		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);

			/* ������ ��� */
			if (Character.isDigit(c)) {
				n = 0;
				if (c == '1' && dartResult.charAt(i + 1) == '0') {
					n = 10;
					i++; // �ε��� �������� ����
				} else {
					n = Character.getNumericValue(c);
				}
				
				nowInt++;
				
			/* ���ʽ� or �ɼ��� ��� */
			} else {
				switch (c) {
				case 'S':
					score[index++] = (int) Math.pow(n, 1);	// 1����
					break;
					
				case 'D':
					score[index++] = (int) Math.pow(n, 2);	// 2����
					break;
					
				case 'T':
					score[index++] = (int) Math.pow(n, 3);	// 3����
					break;
					
				case '*':	// ��Ÿ�� :  �ٷ� ���� ���� ������ �� 2��
					index = index - 2 < 0 ? 0 : index - 2;
					while (index < nowInt) {
						score[index++] *= 2;
					}
					n = 0;
					break;
					
				case '#':	// ������ :  �ش� ������ ���̳ʽ�
					score[index-1] *= -1;	
					n = 0;
					break;
				}
			}
		}
		
		for (int i : score) {
			answer += i;
		}

		return answer;
	}
}
