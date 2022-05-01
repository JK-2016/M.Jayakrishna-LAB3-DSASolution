package PairOfSum.Question2;

public class BinarySearchTree {
    Node root;
    BinarySearchTree(){
        root = null;
    }

    public static class Node{
        int data;
        Node leftChild, rightChild;
        Node(int data){
            this.data =data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    public Node insert(int data, Node root){

        if(root==null){
            root = new Node(data);
            //System.out.println("Value inserted is: "+data);
            return root;
        }
        if(data < root.data){
            if(root.leftChild == null){
                root.leftChild = new Node(data);
               //System.out.println("Value inserted is: "+data);
                return root;
            }
            insert(data,root.leftChild);
        }
        if(data> root.data){
            if(root.rightChild == null){
                root.rightChild = new Node(data);
                //System.out.println("Value inserted is: "+data);
                return root;
            }
            insert(data,root.rightChild);
        }
        return root;
    }
    public  void printInorder(Node root){
        if(root==null){
            return;
        }
        printInorder(root.leftChild);
        System.out.print(root.data + " ");
        printInorder(root.rightChild);

    }
    public static boolean searchTree(int data, Node root){
//        if(root.data == data){
//            return  true;
//        }
        Node prev, curr;
        curr = root;
        prev = root;
        while(curr!=null) {
            if (data < curr.data) {
                prev = curr;
                curr = curr.leftChild;
            } else if (curr.data < data) {
                prev = curr;
                curr = curr.rightChild;
            } else {
                //System.out.println(data + " is found and parent is "+ prev.data);
                return true;
            }
        }
        //System.out.println("Data not found");
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int [] arr = new int[]{6,4,2,5,7,8};
        for (int i =0; i< arr.length;i++) {
          bst.root = bst.insert(arr[i], bst.root);
        }
        bst.printInorder(bst.root);
        System.out.println();
        bst.searchTree(8,bst.root);
        bst.searchTree(11,bst.root);


        /*Node root = new Node(5);
        Node lc = new Node(2);
        Node rc = new Node(6);
        root.leftChild = lc;
        root.rightChild =rc;
        System.out.println("root is:" + root.data);
        System.out.println("root's left child is:" + root.leftChild.data);
        System.out.println("root's RIGHT CHILD  is:" + root.rightChild.data);
        */
    }
}
