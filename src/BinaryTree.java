
public class BinaryTree {

    private TreeNode root;

    public BinaryTree (){
        this.root = null;
    }
    public BinaryTree ( TreeNode T ){
        this.root = T;
    }
    public void setRoot ( TreeNode T ){
        this.root = T;
    }
    public TreeNode getRoot (){
        return this.root;
    }
    public TreeNode search ( int data ){
        return search ( this.root, data);
    }
    private TreeNode search ( TreeNode node, int data ){

        if ( node != null ){
            int valueNode = node.getData();
            if ( valueNode == data ){
                return node;
            } else if ( valueNode < data ){
                return search ( node.getRight(), data );
            } else {
                return search ( node.getLeft(), data);
            }
        }
        return null;
    }

    public void insert ( int data ){
        insertPrivate ( data );
    }

    private void insertPrivate ( int data ){

        TreeNode x = this.root;
        TreeNode y = null;
        TreeNode z = new TreeNode ( data );

        while ( x != null ){
            y = x;
            int valueX = x.getData();
            if ( valueX < data ){
                x = x.getRight();
            } else {
                x = x.getLeft();
            }
        }

        z.setParent ( y );
        
        if ( y == null ){
            this.root = z;
        } else if ( y.getData() < z.getData()){
            y.setRight ( z );
        } else {
            y.setLeft ( z );
        }  
    }

    public TreeNode TMaximum (){
        return maximum ( this.root );
    }

    private TreeNode maximum ( TreeNode node ){
        if ( node != null ){
            while ( node.getRight() != null ){
                node = node.getRight();
            }
        } 
        return node;
    }

    public TreeNode TMinimum ( TreeNode node ){
        return minimum ( this.root );
    }

    private TreeNode minimum (TreeNode node ){
        if (node != null ){
            while ( node.getLeft() != null ){
                node = node.getLeft();
            }
        }
        return node;
    }

    private TreeNode successor (TreeNode node ) {

        if ( node.getRight () != null ){
            return minimum ( node.getRight());
        }

        TreeNode y = node.getParent();

        while ( y != null && y.getRight() == node ){
            node = y;
            y = y.getParent();
        }
        return y;
    }

    private TreeNode predecessor (TreeNode node ) {

        if ( node.getLeft () != null ){
            return maximum ( node.getLeft());
        }

        TreeNode y = node.getParent();

        while ( y != null && y.getLeft() == node){
            node = y;
            y = y.getParent();
        }
        return y;
    }

    private void transplant ( TreeNode u, TreeNode v ){

        if ( u.getParent() == null ){
            this.root = v;
        }
        else if ( u == u.getParent().getLeft()){
            u.getParent().setLeft ( v );
        } else {
            u.getParent().setRight( v );
        }
        if ( v != null ){
            v.setParent( u.getParent());
        }
    }

    public void remove ( int value ){

        TreeNode z = search ( value );
        if ( z != null ){
            remove ( z );
        }
    }

    private void remove ( TreeNode z ){

        if ( z.getLeft() == null ){
            this.transplant ( z, z.getRight());
        }
        else if ( z.getRight() == null ){
            this.transplant ( z, z.getLeft() );
        } else{
            TreeNode y = minimum( z.getRight());
            if ( y.getParent() != z ){
                this.transplant ( y, y.getRight());
                y.setRight( z.getRight() );
                y.getRight().setParent ( y );
            }
            this.transplant ( z, y );
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
        }
    }

    private void preOrder ( TreeNode t ){

        if ( t != null  ){
            System.out.printf("%d ", t.getData());
            this.preOrder(t.getLeft());
            this.preOrder(t.getRight());
        }
    }

    public void preOrder(){
        preOrder( this.root );
    }
    
}