import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, Node> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new HashMap<String, Node>();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.put(data, new Node(data, left, right));
        }

        preOrder(tree.get("A"));
        System.out.println();
        inOrder(tree.get("A"));
        System.out.println();
        postOrder(tree.get("A"));

        br.close();
    }

    public static void preOrder(Node node){
        System.out.print(node.data);
        if(!node.left.equals(".")){
            preOrder(tree.get(node.left));
        }
        if(!node.right.equals(".")){
            preOrder(tree.get(node.right));
        }
    }

    public static void inOrder(Node node){
        if(!node.left.equals(".")){
            inOrder(tree.get(node.left));
        }
        System.out.print(node.data);
        if(!node.right.equals(".")){
            inOrder(tree.get(node.right));
        }
    }

    public static void postOrder(Node node){
        if(!node.left.equals(".")){
            postOrder(tree.get(node.left));
        }
        if(!node.right.equals(".")){
            postOrder(tree.get(node.right));
        }
        System.out.print(node.data);
    }
}

class Node {
    String data; 
    String left;
    String right;

    public Node(String data, String left, String right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}