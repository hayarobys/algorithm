package silver2;

import java.util.Scanner;
/*
1
6 6 10
0 1
1 0
1 1
1 2
2 1
3 4
4 4
4 3
4 5
5 4
 */
// 유기농 배추 https://www.acmicpc.net/problem/1012
class Problem_1012 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testCaseCount = Integer.parseInt(sc.nextLine());
			for(int i=0; i<testCaseCount; i++){
				String[] size = sc.nextLine().split(" ");
				int[][] field = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
				int cabbageCount = Integer.parseInt(size[2]);
				for(int k=0; k<cabbageCount; k++){
					String[] location = sc.nextLine().split(" ");
					int x = Integer.parseInt(location[0]);
					int y = Integer.parseInt(location[1]);
					field[x][y] = 1;
				}
				analyze(field);
			}
		}
	}
	
	public static void analyze(final int[][] field) {
		int worm = 0;
		for(int x=0; x<field.length; x++) {
			for(int y=0; y<field[x].length; y++) {
				System.out.println("\n("+x+","+y+") 값: " + field[x][y] + " " + (field[x][y]==1));
				if(field[x][y]==1 && isIsolated(field, x, y)) {
					worm++;
					System.out.println("\n("+x+","+y+") 고립: " + worm);
				}
			}
		}
		System.out.println(worm);
	}
	
	public static boolean isIsolated(final int[][] field, int x, int y) {
		if(y>0 && field[x][y-1]!=0) {System.out.print("상"); return false;} // 상
		if(y<field[x].length-1 && field[x][y+1]!=0) {System.out.print("하"); return false;} // 하
		if(x>0 && field[x-1][y]!=0) {System.out.print("좌"); return false;} // 좌
		if(x<field.length-1 && field[x+1][y]!=0) {System.out.print("우"); return false;} // 우
		return true;
	}
}
