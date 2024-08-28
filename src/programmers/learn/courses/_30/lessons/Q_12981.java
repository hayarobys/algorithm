package programmers.learn.courses._30.lessons;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q_12981 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Answer_12981().solution(
				3
				, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}
		)));
		
		System.out.println(Arrays.toString(new Answer_12981().solution(
				2
				, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}
		)));
	}
}

class Answer_12981 {
    public int[] solution(int n, String[] words) {
        int[] arr = new int[n];
        Set<String> wordSet = new HashSet<>();
        for(int i=0; i<words.length; i++) {
        	arr[i%n]++;
        	if(	!wordSet.add(words[i])
        		||
        		(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))
        	) {
        		return new int[] {i%n+1, arr[i%n]};
        	}
        }
        return new int[] {0,0};
    }
}