import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// InOrder , save width value of each level
public class Main {
    static HashMap<Integer, Node> tree;
    static int[] minLevel;
    static int[] maxLevel;
    static int levelDepth;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new HashMap<Integer, Node>();
        minLevel = new int[N+1];
        maxLevel = new int[N+1];

        // Init tree and min/max level
        minLevel[0] = N;
        maxLevel[0] = 0;
        for(int i=1; i<N+1; i++){
            tree.put(i, new Node(i, -1, -1));
            minLevel[i] = N;
            maxLevel[i] = 0;
        }

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree.get(data).left = left;
            tree.get(data).right = right;
            if(left != -1) tree.get(left).parent = data;
            if(right != -1) tree.get(right).parent = data;
        }

        int root = -1;
        for(int i=1; i<N+1; i++){
            if(tree.get(i).parent == -1){
                root = i;
            }
        }

        // InOrder
        levelDepth = 1;
        x = 1;
        inOrder(tree.get(root), 1);

        // cal result
        int resultLevel = 1;
        int resultWidth = maxLevel[1] - minLevel[1] + 1;
        for(int i=2; i<levelDepth+1; i++){
            int width = maxLevel[i] - minLevel[i] + 1;
            if(resultWidth < width){
                resultLevel = i;
                resultWidth = width;
            }
        }

        System.out.println(resultLevel + " " + resultWidth);

        br.close();
    }

    public static void inOrder(Node node, int level){
        levelDepth = Math.max(levelDepth, level);
        if(node.left != -1){
            inOrder(tree.get(node.left), level+1);
        }

        minLevel[level] = Math.min(minLevel[level], x);
        maxLevel[level] = Math.max(maxLevel[level], x);
        x++;

        if(node.right != -1){
            inOrder(tree.get(node.right), level+1);
        }
    }

}

class Node {
    int parent;
    int data;
    int left;
    int right;

    public Node (int data, int left, int right){
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = -1;
    }
}