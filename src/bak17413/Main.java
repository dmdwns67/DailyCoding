import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack();

		String s = sc.nextLine();
		boolean isReverse = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				printStack(st); 
				isReverse = false;
				System.out.print(s.charAt(i));
			} else if (s.charAt(i) == '>') {
				isReverse = true;
				System.out.print(s.charAt(i));
			} else if (!isReverse) {
				System.out.print(s.charAt(i));
			} else {
				if (s.charAt(i) == ' ') {
					printStack(st);
					System.out.print(s.charAt(i));
				} else {
					st.push(s.charAt(i));
				}
			}

		}

		printStack(st);

        sc.close();
	}


    static void printStack(Stack st) {
		while (!st.empty()) {
			System.out.print(st.peek());
			st.pop();
		}
    }
}