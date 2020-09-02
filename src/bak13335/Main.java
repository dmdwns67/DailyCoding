import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,W,L;
    static int[] truck;
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 트럭 수
		W = sc.nextInt(); // 다리 길이
		L = sc.nextInt(); // 다리가 버틸 수 있는 무게
        
        truck = new int[N];
        for (int i = 0; i < N; i++) {
			truck[i] = sc.nextInt();
        }
        
        int answer = simulation();
        
        System.out.println(answer);

        sc.close();
    }
    
    public static int simulation() {
        int time = 0;
        int curWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

		for (int i = 0; i < N; i++) { 
			while (true) {
				if (bridge.isEmpty()) {
                    // 1. 다리에 트럭 없는 경우
                    bridge.add(truck[i]);
                    curWeight += truck[i];
                    time++;  
					break;
				} else if (bridge.size() == W) {
                    // 2. 다리에 공간이 없는 경우
					curWeight -= bridge.poll();
				} else { 
                    // 3. 다리에 다른 트럭이 있는 경우
					if (curWeight + truck[i] > L) { // 다리에 있는 트럭의 무게 + 현재 트럭 무게가 다리가 버틸 수 있는 무게 보다 크다면,
						bridge.add(0); // bridge 사이즈만 늘려서, 기존 트럭 poll 시켜야됨.
						time++;
					} else { // 다리가 현재 트럭 무게도 견딜 수 있다면
						bridge.add(truck[i]);
                        curWeight += truck[i];
                        time++;
						break;
					}
				}
			}
        }

        return time + W; // 마지막 트럭이 올라간 후 통과하기까지 걸리는 시간이 W
    }
}