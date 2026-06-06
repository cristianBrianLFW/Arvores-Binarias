public class TreeNode {

    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;
    private int data;

    public TreeNode ( int data ){

        this.data = data;
        this.left = null ;
        this.right = null ;
        this.parent = null ;
    }

    public void setParent ( TreeNode p ){
        this.parent = p;
    }

    public TreeNode getParent (){
        return this.parent;
    }

    public void setLeft ( TreeNode l ){
        this.left = l;
    }

    public TreeNode getLeft (){
        return this.left;
    }

    public void setRight ( TreeNode r ){
        this.right = r;
    }

    public TreeNode getRight (){
        return this.right;
    }

    public void setData ( int data ){
        this.data = data;
    }

    public int getData (){
        return this.data;
    }

}

