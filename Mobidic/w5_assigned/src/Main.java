import java.util.*;
import java.util.Scanner;


public class Main {
	//static final String s[] = {"one","two","three",
		//"four","five","six","seven","eight","nine"};
	
	static public void main(String args[]) {
		//Scanner sc = new Scanner(System.in);
		
		
		
		Btree bt = new Btree();
		bt.root = new Node(1);
        
        Node temp,cur;
        cur = bt.root;
        
        temp = new Node(2);
        cur.set_leftchild(temp);

        temp = new Node(3);
        cur.set_rightchild(temp);
        
        
        cur = cur.get_leftchild();
        temp = new Node(4);
        cur.set_leftchild(temp);
        
        cur = cur.get_leftchild();
        temp = new Node(5);
        cur.set_leftchild(temp);
        
        temp = new Node(6);
        cur.set_rightchild(temp);
	
        
        System.out.print("BFS! \n");
        bt.bfs(bt.root);
        System.out.print("\n\nDFS! \n");
        bt.dfs(bt.root);

		
	}
	
	static void createBTree() {
		
	}
	
}