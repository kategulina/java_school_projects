public class NodeImpl implements Node {
    Node leftNode;
    Node rightNode;
    int nodeValue;

    NodeImpl(int nodeValue) {
        this.nodeValue = nodeValue;
        this.leftNode = null;
        this.rightNode = null;
    }
    
    /**
	 * @return left child of this node, or null
	 */
    @Override
    public Node getLeft() {
        return this.leftNode;
    }

    /**
	 * @return right child of this node, or null
	 */
    @Override
    public Node getRight() {
        return this.rightNode;
    }

    /**
	 * @return value of this node
	 */
    @Override
    public int getValue() {
        return this.nodeValue;
    }
}
