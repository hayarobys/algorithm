package baekjoon.silver1;

import java.util.Scanner;

// Fly me to the Alpha Centauri https://www.acmicpc.net/problem/1011
// https://proofwiki.org/wiki/1%2B2%2B...%2Bn%2B(n-1)%2B...%2B1_%3D_n%5E2
// 1+2+3+...+(n-1)+n+(n-1)+...+3+2+1
// 2((n-1)n/2)+n
// n^2 ~= d
// n ~= sqrt(d)
class Problem_1011 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testCaseCount = Integer.parseInt(sc.nextLine());
			for(int i=0; i<testCaseCount; i++){
				String[] location = sc.nextLine().split(" ");
				// 입력값으로 2의 31승 (int형 최대값)까지 들어오므로, 연산을 위해 long타입 사용
				long distance = Integer.parseInt(location[1]) - Integer.parseInt(location[0]); // 3	2
				double sqrtDistance = Math.sqrt(distance); // 1.732	1.414
				long minimumWarpDistance = (long)Math.floor(sqrtDistance); // 1	1
				long maximumWarpDistance = (long)Math.ceil(sqrtDistance); // 2	2
				
				long warpCount = 0;
				if(minimumWarpDistance == maximumWarpDistance){
					warpCount = maximumWarpDistance*2-1;
				}else if(((Math.pow(minimumWarpDistance, 2) + 1) + Math.pow(maximumWarpDistance, 2)) / 2 <= distance){
					warpCount = maximumWarpDistance*2-1;
				}else{
					warpCount = minimumWarpDistance*2;
				}
				System.out.println(warpCount);
			}
		}
	}
}