public class TreeImpl implements Tree {

    NodeImpl root;
    
    /**
	 * Fills the tree with values from given array.
	 * 
	 * @param values new values of the tree
	 */
    @Override
    public void setTree(int[] values) {
        if (values.length == 0) {  // if values is empty root equals to null
            this.root = null;
            return;
        }
        // set tree root
        int middle = values.length / 2;  // it works for both odd and even values.length
        this.root = new NodeImpl(values[middle]);

        if (values.length > 1) {
            this.root.leftNode = createSubTree(0, middle, values);  // creating left subtree
            this.root.rightNode = createSubTree(middle + 1, values.length, values);  // creating right subtree
        }
    }

    /**
    * Recursively fills subtrees.
    * Subtree is represented as a part of the main array.
    *
    * @param start first index of the subtree
    * @param end last index of the subtree
    * @param values main values of the Tree
    *
    * @return new node created or null
    */
    public NodeImpl createSubTree(int start, int end, int[] values) {
        int subMiddle = (start + end) / 2;
        
        if (end - start > 0) {
            NodeImpl tmpNode = new NodeImpl(values[subMiddle]);
            tmpNode.leftNode = createSubTree(start, subMiddle, values);
            tmpNode.rightNode = createSubTree(subMiddle + 1, end, values);
            return tmpNode;
        } else {
            return null;
        }
    }

    /**
	 * @return root of the tree, or null if the tree is empty.
	 */
    @Override
    public Node getRoot() {
        return this.root;
    }

    /**
	 * Tree description looks as follows (for tree created from values [1, 2, 3, 4, 5, 6, 7]):
	 * - 4
	 *  - 2
	 *   - 1
	 *   - 3
	 *  - 6
	 *   - 5
	 *   - 7
	 * 
	 * @return String representation of the tree, or "" for empty tree
	 */
     @Override
    public String toString() {
        String result = "";

        if (this.root == null) {
            return result;
        } else if (this.root.nodeValue == 1) {
            result += "- " + this.root.nodeValue + "\n";
            return result;
        }
        result += "- " + this.root.nodeValue + "\n";  // add root to the result
        String indent = " ";
        //print left subtree
        Node tmpNode = this.root.getLeft();
        if (tmpNode != null) {
            result += indent + toStringSubtree(indent, indent, tmpNode);
        }
        //print right subtree
        tmpNode = this.root.getRight();
        if (tmpNode != null) {

            result += toStringSubtree(indent, indent, tmpNode);
        }

        return result;
    }

    public String toStringSubtree(String currIndent, String currResult, Node currNode) {
        currIndent += " ";
        String subtree = "- " + currNode.getValue() + "\n";
        Node tmpNode = currNode;
        if (tmpNode.getLeft() != null) {
            subtree +=  currIndent + toStringSubtree(currIndent, subtree, tmpNode.getLeft());
        }
        if (tmpNode.getRight() != null){
            subtree += currIndent + toStringSubtree(currIndent, subtree, tmpNode.getRight());
        }
        return subtree;
    }

}
