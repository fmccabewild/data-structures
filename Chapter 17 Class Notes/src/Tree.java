import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    private Node root;
    
    static class Node
    {
        public List<Node> children;
        public Object data;
        

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int total = 1;
            for(Node child: this.children)
            {
                total += child.size();
            }
            return total;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return root.size();
    }

    // Additional methods will be added in later sections.

    private static int leafCount(Node root, int total)
    {

        int total = 0;
        if(root.children.size() == 0){
            total += 1;
        }
        else
        {
            for(Node child: root.children)
            {
                total = total + leafCount(child, total);
            }
        }
        return total;
    }

    public int leafCount()
    {
        return Tree.leafCount(this.root, 0);
    }
}
