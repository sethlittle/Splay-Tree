package SPLT_A4;

public class SPLT implements SPLT_Interface {
	private BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
		root = null;
	}

	public BST_Node getRoot() { // please keep this in here! I need your root
								// node to test your tree!
		return root;
	}

	@Override
	public boolean insert(String s) {

		if (empty()) {
			// this just adds the root
			root = new BST_Node(s, null);
			size++;
			return true;
		} else {
			// this inserts a node and then makes the root that node, and then
			// increments the size if it is labeled as toInsert, and then
			// changes that back to false
			BST_Node inserted = root.insertNode(s);
			root = inserted;
			if (root.toInsert != false) {
				size++;
				root.toInsert = false;
				return true;
			} else {
				return false;
			}
		}

	}

	@Override
	public void remove(String s) {
		// if size is 1, we just remove the root and make the left and right
		// null, and the size 0
		if (size == 1) {
			root.left = null;
			root.right = null;
			root.parent = null;
			root = null;
			size = 0;
			return;
		}

		// first we splay it by calling contains

		if (contains(s)) {
			SPLT tempR = new SPLT();
			SPLT tempL = new SPLT();

			// 4 cases
			// 1 - when there is no node left of the root
			// 2 - when there is no node right of the root
			// 3 - when there is only a root (no left and no right)
			// 4 - when the root has both a left and a right node

			if (root.right != null && root.left == null) {
				// sets the right node to the root and decrements size
				tempR.root = root.right;
				tempR.size = this.size;
				size--;
				root = tempR.root;
				root.parent = null;
			} else if (root.left != null && root.right == null) {
				// sets the left node to the root and decrements size
				tempL.root = root.left;
				tempL.size = this.size;
				size--;
				root = tempL.root;
				root.parent = null;
			} else if (root.left == null && root.right == null) {
				// deletes the root
				root.parent = null;
				root = null;
				size = 0;
				return;
			} else {
				// uses the findMax on the left node and then adds the right
				// node to the right of the splayed max of the left tree
				tempR.root = root.right;

				tempL.root = root.left;
				tempL.size = this.size;
				tempL.root.findMax();
				root = tempL.root;
				root.parent = null;
				tempL.root.right = tempR.root;
				if (tempR.root != null) {
					tempR.root.parent = root;
				}
				size--;
			}

		}
	}

	@Override
	public String findMin() {
		if (size == 0) {
			// nothing to find
			return null;
		} else if (size == 1) {
			// the root would be the only thing
			return root.getData();
		}
		// sets the root equal to the node splayed
		root = root.findMin();
		return root.getData();
	}

	@Override
	public String findMax() {
		if (size == 0) {
			// nothing to find
			return null;
		} else if (size == 1) {
			// the root would be the only thing
			return root.getData();
		}
		// sets the root equal to the node splayed
		root = root.findMax();
		return root.getData();
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public boolean contains(String s) {

		if (size == 0) {
			return false;
		} else {
			// splays the node and then changes the root to that node accessed
			BST_Node accessed = root.containsNode(s);
			root = accessed;
			if (root.getData().compareTo(s) == 0) {
				// this checks to see if the node splayed is equal to the string
				// we are looking for
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		if (size == 0) {
			// no height
			return -1;
		} else if (size == 1) {
			// height must be 0
			return 0;
		} else {
			return root.getHeight();
		}
	}

}