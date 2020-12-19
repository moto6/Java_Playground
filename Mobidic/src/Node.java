
public class Node {
	
	private int data;
	// private String data;
	private Node leftchild;
	private Node rightchild;
	
	
	Node(int data) {
        this.data = data;
        this.leftchild = null;
        this.rightchild = null;
    }
	
	
	public int get_d() {
        return data;
    }

    public void set_d(int data) {
        this.data = data;
    }

    public void set_leftchild(Node leftnode) {
    	this.leftchild = leftnode;
    }
    
    public Node get_leftchild() {
    	return leftchild;
    }

    public void set_rightchild(Node rightnode) {
    	this.rightchild = rightnode;
    }
    
    public Node get_rightchild() {
    	return rightchild;
    }
    
}
