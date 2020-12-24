package silver3;

import java.util.Scanner;

// 피보나치 함수 https://www.acmicpc.net/problem/1003
class Problem_1003 {
	private static int[] memory = new int[41];
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int count = Integer.parseInt(sc.nextLine());
			for(int i=0; i<count; i++){
				int n = Integer.parseInt(sc.nextLine());
				if(n==0) {
					System.out.println("1 0");
				}else if(n==1){
					System.out.println("0 1");
				}else{
					System.out.println(Problem_1003.fibonacci(n-1) + " " + Problem_1003.fibonacci(n));
				}
			}
		}
	}
	
	public static int fibonacci(int n){
		if(n==0) {
			Problem_1003.memory[n]=0;
			return 0;
		}else if(n==1){
			Problem_1003.memory[n]=1;
			return 1;
		}
		
		if(memory[n] != 0) {
			return memory[n];
		}else {
			memory[n] = fibonacci(n-1) + fibonacci(n-2);
			return memory[n];
		}
	}
}
