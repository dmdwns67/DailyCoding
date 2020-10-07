import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int x,y;
    static int[][] map;
    static int[] dx={0,1,0,-1}; // 좌하우상
    static int[] dy={-1,0,1,0};
    static List<CCTV> cctvs;
    static int allCount = 0;
    static int monitorCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[y][x];
        cctvs = new ArrayList<CCTV>();

        for(int i=0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < x; j++) {
                int area = Integer.parseInt(st.nextToken());
                if(area == 0) {
                    allCount++;
                } else if(area != 6) {
                    cctvs.add(new CCTV(j,i,area));
                }

                map[i][j] = area;
            }
        }

        backTracking(0, new CCTV[cctvs.size()]);

        System.out.println(monitorCount);

        br.close();
    }

    public static void backTracking(int idx, CCTV[] selectedCctvs) {
        if(idx == cctvs.size()) {
            countUnreachedArea(selectedCctvs, new boolean[y][x]);
        } else {
            CCTV curCctv = cctvs.get(idx);
            for(int i=0; i<4; i++) {
                CCTV c = new CCTV(curCctv.x, curCctv.y, curCctv.type);
                switch(curCctv.type) {
                    case 1:
                        c.addDirection(i);
                        selectedCctvs[idx] = c;
                        backTracking(idx+1, selectedCctvs);
                        break;
                    case 2:
                        if(i>=2) { // 2가지 경우의 수 밖에 없음(상하 / 좌우)
                            return;
                        }
                        c.addDirection(i);
                        c.addDirection(i+2);
                        selectedCctvs[idx] = c;
                        backTracking(idx+1, selectedCctvs);
                        break;
                    case 3:
                        c.addDirection(i);
                        c.addDirection((i+1) % 4);
                        selectedCctvs[idx] = c;
                        backTracking(idx+1, selectedCctvs);
                        break;
                    case 4:
                        c.addDirection(i);
                        c.addDirection((i+1) % 4);
                        c.addDirection((i+2) % 4);
                        selectedCctvs[idx] = c;
                        backTracking(idx+1, selectedCctvs);
                        break;
                    case 5:
                        if(i>=1) { // 1가지 경우의 수 밖에 없음
                            return;
                        }
                        c.addDirection((i));
                        c.addDirection((i+1) % 4);
                        c.addDirection((i+2) % 4);
                        c.addDirection((i+3) % 4);
                        selectedCctvs[idx] = c;
                        backTracking(idx+1, selectedCctvs);
                        break;
                }
            }
        }
    }

    // 사각지대 개수 검사
    public static void countUnreachedArea(CCTV[] selectedCctvs, boolean[][] visited) {
        int count = 0;
        for(int i=0; i<selectedCctvs.length; i++) {
            CCTV c = selectedCctvs[i];
            for(int d=0; d<c.DirectionSize(); d++) {
                int dir = c.directions.get(d);
                int nx = c.x + dx[dir];
                int ny = c.y + dy[dir];
                while((nx >= 0 && nx < x) && (ny >= 0 && ny < y)) {
                    if(map[ny][nx] == 0) {
                        if(!visited[ny][nx]) {
                            visited[ny][nx] = true;
                            count++;
                        }
                    } else if(map[ny][nx] == 6) {
                        break;
                    }
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }
        }
        monitorCount = Math.min(monitorCount, allCount - count);
    }
}

class CCTV {
    int x, y, type;
    List<Integer> directions = new ArrayList<Integer>();

    public CCTV(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;       
    }

    public void addDirection(int dir) {
        directions.add(dir);
    }

    public int DirectionSize() {
        return directions.size();
    }
}