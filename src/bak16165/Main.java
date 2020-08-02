import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 걸그룹 수
        int M = sc.nextInt(); // 문제 수 

        String[] grpName = new String[N];
        ArrayList<String>[] memName = new ArrayList[N];
        for(int i=0; i<N; i++){
            memName[i] = new ArrayList<String>();
        }

        for(int i=0; i<N; i++){
            grpName[i] = sc.next();
            int tmp = sc.nextInt();
            for(int j=0; j<tmp; j++){
                memName[i].add(sc.next());
            }
        }

        for(ArrayList arr : memName){
            Collections.sort(arr);
        }

        for(int i=0; i<M; i++){
            String str = sc.next();
            int gbn = sc.nextInt();
            if(gbn == 1) {
                for(int j=0; j<N; j++){
                    if(memName[j].contains(str)){
                        System.out.println(grpName[j]);
                        break;
                    };
                }
            } else {
                for(int j=0; j<N; j++){
                    if(grpName[j].equals(str)){
                        for(String name : memName[j]){
                            System.out.println(name);
                        }
                        break;
                    }
                }
            }
        }

        sc.close();
    }
}