import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] rooms = new int[N];
        for(int i=0; i<rooms.length; i++) {
            rooms[i] = sc.nextInt();
        }
        int major = sc.nextInt();
        int minor = sc.nextInt();

        long cnt = 0;
        for(int i=0; i<rooms.length; i++){
            cnt++;
            if(rooms[i] <= major) {
                continue;
            } else {
                if((rooms[i]-major) % minor != 0) cnt += (rooms[i]-major) / minor + 1;
                else cnt += (rooms[i]-major) / minor;
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}