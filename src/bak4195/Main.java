import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[][] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            int F = Integer.parseInt(br.readLine());
            root = new int[F*2][2]; // F*2 for the case when every name is different

            for(int j=0; j<root.length; j++){
                root[j][0] = j; // parent node
                root[j][1] = 1; // size of tree
            }

            HashMap<String, Integer> network = new HashMap<String, Integer>();
            
            for(int j=0; j<F; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                if(!network.containsKey(name1)){
                    network.put(name1, network.size());
                }
                if(!network.containsKey(name2)){
                    network.put(name2, network.size());
                }
                
                int size = union(network.get(name1), network.get(name2));
                System.out.println(size);
            }
        }

        br.close();
    }

    public static int union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 != root2){
            root[root2][0] = root1; // root1 is new root node of root2 tree
            return root[root1][1] += root[root2][1];
        }

        return root[root1][1];
    }

    public static int find(int node){
        if(node == root[node][0]){
            return node;
        } 
        root[node][0] = find(root[node][0]);
        return root[node][0];
    }
}