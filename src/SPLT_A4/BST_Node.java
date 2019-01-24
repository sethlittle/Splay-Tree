package SPLT_A4;

public class BST_Node {
	public String data;
	public BST_Node left;
	public BST_Node right;
	public BST_Node parent;
	public boolean toInsert;

	BST_Node(String data) {
		this.data = data;
	}

	BST_Node(String data, BST_Node par) {
		this.data = data;
		this.parent = par;
	}

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	public BST_Node containsNode(String s) {

		if (data.compareTo(s) == 0) {
			// change the toInsert to false, this will help to determine when to
			// increment size
			this.toInsert = false;
			return splay(this);
		} else if (data.compareTo(s) > 0 && left != null) {
			return left.containsNode(s);
		} else if (data.compareTo(s) < 0 && right != null) {
			return right.containsNode(s);
		} else {
			// we still want to splay the last node touched if contains is false
			this.toInsert = false;
			return splay(this);
		}

	}

	public BST_Node insertNode(String s) {

		if (data.compareTo(s) == 0) {
			// change the toInsert to false, this will help to determine when to
			// increment size
			this.toInsert = false;
			// if it is there, splay it
			return splay(this);
		} else if (data.compareTo(s) > 0) {
			// string is to the left
			if (left == null) {
				// insert to the left and then splay it
				// pass the string and this as the parent to create the new Node
				left = new BST_Node(s, this);
				// we want to increment size, so toInsert is true
				left.toInsert = true;
				return splay(left);
			} else {
				return left.insertNode(s);
			}
		} else {
			if (right == null) {
				right = new BST_Node(s, this);
				right.toInsert = true;
				return splay(right);
			} else {
				return right.insertNode(s);
			}
		}

	}

	public BST_Node findMin() {
		if (left == null) {
			// splay it when it is found
			this.toInsert = false;
			return splay(this);
		} else {
			return left.findMin();
		}
	}

	public BST_Node findMax() {
		if (right == null) {
			// splay it when it is found
			this.toInsert = false;
			return splay(this);
		} else {
			return right.findMax();
		}
	}

	public int getHeight() {
		int leftH = 0;
		int rightH = 0;

		if (left != null) {
			leftH++;
			leftH = leftH + left.getHeight();
		} else if (right != null) {
			rightH++;
			rightH = rightH + right.getHeight();
		}

		if (leftH >= rightH) {
			return leftH;
		} else {
			return rightH;
		}

		// just used the left instead of passing the left in as a parameter, so
		// dont need to add 1

	}

	private BST_Node splay(BST_Node toSplay) {
		// do a while until toSplay parent is null

		while (toSplay.parent != null) {
			if (toSplay.parent.parent == null) {
				// just one rotation
				if (toSplay.parent.left == toSplay) {
					// use the rRight because we just want the root to be the
					// right subtree's root
					rRight(toSplay);
				} else {
					rLeft(toSplay);
				}
			} else if (toSplay.parent.parent != null) {
				// if there is a grandparent
				if (toSplay.parent.parent.left == toSplay.parent && toSplay.parent.left == toSplay) {
					// zig zig
					rotateRight(toSplay);
					rotateRight(toSplay);
				} else if (toSplay.parent.parent.right == toSplay.parent && toSplay.parent.right == toSplay) {
					// zig zig
					rotateLeft(toSplay);
					rotateLeft(toSplay);
				} else if (toSplay.parent.parent.left == toSplay.parent && toSplay.parent.right == toSplay) {
					// zig zag
					rotateLeft(toSplay);
					rotateRight(toSplay);
				} else if (toSplay.parent.parent.right == toSplay.parent && toSplay.parent.left == toSplay) {
					// zig zag
					rotateRight(toSplay);
					rotateLeft(toSplay);
				}
			}

		}
		return toSplay;
	}

	// helper methods

	private void rotateLeft(BST_Node x) {

		BST_Node p = x.parent;
		BST_Node p2 = p.parent;

		// we have to cycle down to find the minimum, because the parent will
		// need to go to the left of that

		if (x.left != null) {
			BST_Node temp = x;
			BST_Node tempL = x.left;
			while (tempL != null) {
				temp = tempL;
				tempL = tempL.left;
			}

			p.parent = temp;
			temp.left = p;
			p.right = null;

		} else {
			x.left = p;
			p.parent = x;
			p.right = null;
		}

		// this sets the parent of the node splayed, even if it is null
		if (p2 != null) {
			if (p2.right == p) {
				p2.right = x;
			} else {
				p2.left = x;
			}
		}
		x.parent = p2;
	}

	private void rRight(BST_Node x) {
		// just for the zig, the parent is placed immediately to the right of
		// the focus node
		BST_Node p = x.parent;
		if (x.right == null) {
			x.right = p;
			p.parent = x;
			p.left = null;
		} else {
			x.right.parent = p;
			p.left = x.right;
			x.right = p;
			p.parent = x;
		}

		x.parent = null;
	}

	private void rLeft(BST_Node x) {
		// just for zig, the parent (root) is placed immediately to the left of
		// the focus node
		BST_Node p = x.parent;
		if (x.left == null) {
			x.left = p;
			p.parent = x;
			p.right = null;
		} else {
			x.left.parent = p;
			p.right = x.left;
			x.left = p;
			p.parent = x;
		}
		x.parent = null;
	}

	// for zig zig
	private void rotateRight(BST_Node x) {
		BST_Node p = x.parent;
		BST_Node p2 = p.parent;

		// we have to cycle down to find the maximum, because the parent will
		// need to go to the right of that
		if (x.right != null) {
			BST_Node temp = x;
			BST_Node tempR = x.right;
			while (tempR != null) {
				temp = tempR;
				tempR = tempR.right;
			}

			p.parent = temp;
			temp.right = p;
			p.left = null;

		} else {
			x.right = p;
			p.parent = x;
			p.left = null;
		}

		// this sets the parent of the node splayed, even if it is null
		if (p2 != null) {
			if (p2.right == p) {
				p2.right = x;
			} else {
				p2.left = x;
			}
		}
		x.parent = p2;

	}

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}