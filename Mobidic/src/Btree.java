import java.util.*;
//import Node.java;


public class Btree {
	
	public Node root;
	//public List<Integer> bfsList = new ArrayList<>();
	//public List<Integer> dfsList = new ArrayList<>();
	
	
	
	
	public void bfs(Node start_node) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(start_node);
        while (!q.isEmpty()) {
            Node next = q.poll();
            System.out.print(next.get_d() + " ");
            //bfsList.add(n.get_leftchild());
            if (next.get_leftchild() != null) {
                q.add(next.get_leftchild());
            }
            if (next.get_rightchild() != null) {
                q.add(next.get_rightchild());
            }
        }
    }
	
	
	public void dfs(Node start_node) {
		
		preod(start_node); //Preorder Traversal
		//해설 : DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.
		
		//inord(start_node); //Inorder Traversal
		
		//posto(start_node); //Postorder Traversal
		
		return;
	}

	private void preod(Node cur_node) {
		if(cur_node != null) {
			System.out.print(cur_node.get_d() +" ");
			preod(cur_node.get_leftchild());
			preod(cur_node.get_rightchild());
		}
	}
	private void inord(Node cur_node) {
		if(cur_node != null) {
			inord(cur_node.get_leftchild());
			System.out.print(cur_node.get_d() +" ");
			inord(cur_node.get_rightchild());
		}
	}
	private void posto(Node cur_node) {
		if(cur_node != null) {
			posto(cur_node.get_leftchild());
			posto(cur_node.get_rightchild());
			System.out.print(cur_node.get_d() +" ");
		}
	}
	
}
