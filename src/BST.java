/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author Yuxiao Hu(19321099)
 *
 *************************************************************************/

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST
    
    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
        
    }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     *  Search BST for given key.
     *  Does there exist a key-value pair with given key?
     *
     *  @param key the search key
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Tree height.
     *
     * Asymptotic worst-case running time using Theta notation: Theta(N)
     * Becasue we have to compare every node's left and right subtree's height and
     * add it to the total count, we have to traversal all the node in the bst,
     * in each height() call, only two comparisons are executed,
     * so theta(2) * theta(N)= theta(2N) = theta(N)
     * 	
     * 	
     *
     * @return the number of links from the root to the deepest leaf.
     *
     * Example 1: for an empty tree this should return -1.
     * Example 2: for a tree with only one node it should return 0.
     * Example 3: for the following tree it should return 2.
     *   B
     *  / \
     * A   C
     *      \
     *       D
     */
    public int height() {
      return height(root);
    }
    
    private int height(Node x) {
    	if(x== null) {
    		return -1;
    	}else if(x.N == 1) {
    		return 0;
    	}else {
    		return 1+Math.max( height(x.left),height(x.right));
    	}
    }

    
    public Key select(int n) {
    	if( isEmpty()) {
    		return null;
    	}
    	if (n < 0 || n >= size()) {
    		return null;
    	}
    	Node x = select(root, n);
    	return x.key;
    }
    	
    private Node select(Node x, int n) {
    	/*if (x == null) {
    		return null;
    	}*/
    	int t = size(x.left);
    	if (t > n) {
    		return select(x.left, n);
    	}else if (t < n) {
    		return select(x.right, n-t-1);
    	}else {
    		return x;
    	}
    	
    }
    
    /**
     * Median key.
     * If the tree has N keys k1 < k2 < k3 < ... < kN, then their median key 
     * is the element at position (N+1)/2 (where "/" here is integer division)
     *
     * @return the median key, or null if the tree is empty.
     */
    public Key median() { 
    	return median(root);
      }
    private Key median(Node x) {
    	if (isEmpty()) return null;
        //TODO fill in the correct implementation. The running time should be Theta(h), where h is the height of the tree.
        int median_index = (x.N - 1) / 2 ;
        Key key = select(median_index);
        
        return key;
    }

    /**
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear before the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesized.
     */
    public String printKeysInOrder() {
    	return printKeysInOrder(root);
    }
    
    private String printKeysInOrder(Node x) {
      if (isEmpty()) {
    	  return "()";
      }
      if(x == null) {
    	  return "()";
      }else {

    	  return  "(" +printKeysInOrder(x.left) + x.key  +printKeysInOrder(x.right) + ")";
      }
    }
    
    /**
     * Pretty Printing the tree. Each node is on one line -- see assignment for details.
     *
     * @return a multi-line string with the pretty ascii picture of the tree.
     */
    public String prettyPrintKeys() {
    	return prettyPrint(root,"");
    }
    
    private String prettyPrint(Node x, String prefix) {
    	if(x == null) {
    		String str = prefix + "-null\n"; 
    		return str;
    	}else{
    		String str = prefix + "-" + x.key + "\n";
    		String prefix_left = prefix + " " + "|";
    		String prefix_right = prefix_left.substring(0, prefix_left.length()-1) + " ";	
    		return str + prettyPrint(x.left, prefix_left) + prettyPrint(x.right, prefix_right);
    	}
    }

    /**
     * Deteles a key from a tree (if the key is in the tree).
     * Note that this method works symmetrically from the Hibbard deletion:
     * If the node to be deleted has two child nodes, then it needs to be
     * replaced with its predecessor (not its successor) node.
     *
     * @param key the key to delete
     */
    public void delete(Key key) {
    	//TODO fill in the correct implementation.
    	delete(root,key);	
    }
    
    public Node getKey(Key key) {
    	return getKey(root,key);
    }
    
    private Node getKey(Node x, Key key) {
    	if ( isEmpty()) {
    		return null;
    	}
    	
    	int cmp = key.compareTo(x.key);
    	if(cmp == 0) {
    		return x;
    	}else if(cmp > 0) {
    		return getKey(x.right,key);
    	}else {
    		return getKey(x.left,key);
    	}
    	
    }
    
    public Node getParent(Key key) {
    	return getParent(root,key);
    }
    
    private Node getParent(Node x, Key key) {
    	if( isEmpty()) {
    		return null;
    	}
    	
    		
    	int cmp = key.compareTo(x.key);
    	if( cmp == 0) {
    		return null;
    	}else if( cmp < 0) {
    		int cmp_left = key.compareTo((x.left).key);
    		if(cmp_left == 0) {
    			return x;
    		}else {
    			return getParent(x.left, key);
    		}
    	}else {
    		int cmp_right = key.compareTo(x.right.key);
    		if(cmp_right == 0) {
    			return x;
    		}else {
    			return getParent(x.right, key);
    		}
    	}
  	
    }
    
    private void delete(Node x, Key key) {
    	if( isEmpty() ) {
    		return;
    	}
	
    	if (!contains(key)) {
    		return;
    	}
	
        Node temp = getKey(key);
        if(temp == root) {
        	if( size() == 1) {
        		root = null;
        		return;
        	}else if(root.right == null){
        		root = root.left;
        		return;
        	}else if(root.left == null) {
        		root = root.right; 
        		return;
        	}else {
        		Node imm_smaller = root.left;
            	while(imm_smaller.right != null) {
            		imm_smaller = imm_smaller.right;
            	}
            	Node parent = getParent(imm_smaller.key);
            	root.val = imm_smaller.val;
            	root.key = imm_smaller.key;
            	
            	if(parent == root) {
            		parent.left = imm_smaller.left;
            		return;
            	}         	
            	parent.right = imm_smaller.left;
            	return;
        	
        	}
        }
        if(temp.left== null && temp.right == null) {
        	Node parent = getParent(temp.key);
        	int cmp = key.compareTo(parent.key);
        	if(cmp > 0) {
        		parent.right = null;
        	}else{
        		parent.left=null;
        	} 	
        	
        	while(parent != null) {
        		parent.N--;
        		parent = getParent(parent.key);
        	}
        	
        	return;
        }else if(temp.left == null || temp.right == null) {
        	Node parent = getParent(temp.key);
        	
        	int cmp = key.compareTo(parent.key);
        	if(temp.left == null) {
        		if(cmp > 0) {
        			parent.right= temp.right;
        		}else {
        			parent.left = temp.right;
        		}
        	}else {
        		if(cmp > 0) {
        			parent.right = temp.left;
        		}else {
        			parent.left = temp.left;
        		}
        	}
        	
        	while(parent != null) {
        		parent.N--;
        		parent = getParent(parent.key);
        	}
        	
        	return;
        }else {
        	Node imm_smaller = temp.left;
        	while(imm_smaller.right != null) {
        		imm_smaller = imm_smaller.right;
        	}

        	Node parent = getParent(imm_smaller.key);
        	if(parent == temp) {
        		parent.key = imm_smaller.key;
        		parent.val = imm_smaller.val;
        		parent.left = null;
        	}else {
        		temp.key = imm_smaller.key;
        		temp.val = imm_smaller.val;     		
        		
        		parent.right = imm_smaller.left;
        	
        	}
        	
        	while(parent != null) {
            	parent.N--;
            	parent = getParent(parent.key);
            }
        	
        	return;
        }
    	
    }
}