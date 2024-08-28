package programmers.learn.courses._30.lessons;

public class Q_12977 {

	public static void main(String[] args) {
		System.out.println(new Answer_12977().solution(
				new int[] { 1, 2, 3, 4 }
		));
		System.out.println(new Answer_12977().solution(
				new int[] { 1, 2, 7, 6, 4 }
		));
	}
}

class Answer_12977 {
	public int solution(int[] nums) {
		int answer = 0;
		for(int i=0; i<nums.length-2; i++) {
			for(int j=i+1; j<nums.length-1; j++) {
				for(int k=j+1; k<nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					boolean isSosu = true;
					for(int d=sum-1; d>1; d--) {
						if(sum%d==0) {
							isSosu = false;
							break;
						}
					}
					if(isSosu) answer++;
				}
			}
		}
		return answer;
	}
}