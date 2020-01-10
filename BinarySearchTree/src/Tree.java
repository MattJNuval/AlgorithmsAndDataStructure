public class Tree {
    private Node root;
    private Node parent;

    public void insert(int data) {
        insertNode(data, root);
    }

    private void insertNode(int data, Node curr) {
        if(root == null) {
            Node newNode = new Node(data);
            curr = newNode;
            root = curr;
        } else if(data <= curr.getData()){
            if(curr.getLeft() == null) {
                Node newNode = new Node(data);
                curr.setLeft(newNode);
            } else {
                insertNode(data, curr.getLeft());
            }
        } else if(data > curr.getData()) {
            if(curr.getRight() == null) {
                Node newNode = new Node(data);
                curr.setRight(newNode);
            } else {
                insertNode(data, curr.getRight());
            }
        }
    }


    public void find(int data) {
        System.out.println("\n\nFinding " + data);
        findNode(data, root);
    }

    private void findNode(int data, Node curr) {
        if(root == null) {
            System.out.println("Tree is empty");
        } else if(data < curr.getData()) {
            if(curr.getLeft() == null) {
                System.out.println("data not found");
            } else {
                System.out.println("Moving left from " + curr.getData() + " to " + curr.getLeft().getData());
                findNode(data, curr.getLeft());
            }
        } else if(data > curr.getData()) {
            if(curr.getRight() == null) {
                System.out.println("data not found");
            } else {
                System.out.println("Moving right from " + curr.getData() + " to " + curr.getLeft().getData());
                findNode(data, curr.getRight());
            }
        } else if(data == curr.getData()) {
            System.out.println("Current data: " + curr.getData() + " Expected data: " + data);
        }
    }

    public void delete(int data) {
        deleteNode(data, root);
    }

    public void deleteNode(int data, Node curr) {
        if(curr == null) {
            System.out.println("Data not found");
        } else {
            if(data < curr.getData()){
                if(curr.getLeft() != null) {
                    parent = curr;
                    deleteNode(data, curr.getLeft());
                } else {
                    System.out.println("Data not found");
                }
            } else if(data > curr.getData()) {
                if(curr.getRight() != null) {
                    parent = curr;
                    deleteNode(data, curr.getRight());
                } else {
                    System.out.println("Data not found");
                }
            } else if(data == curr.getData()) {
                System.out.println("data " + curr.getData() + " is found");
                // Case I: Leaf Node
                if(curr.getLeft() ==  null && curr.getRight() == null) {
                    System.out.println("Data " + curr.getData() + " is a leaf");
                    if(parent.getLeft().getData() == curr.getData()) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }
                // Case II: Node has one child
                else if(curr.getLeft() != null && curr.getRight() == null) {
                    System.out.println("Data " + curr.getData() + " has one child on the left");
                    if(parent.getLeft() != null) {
                        parent.setLeft(curr.getLeft());
                        curr.setLeft(null);
                    } else {
                        parent.setRight(curr.getLeft());
                        curr.setLeft(null);
                    }
                }
                else if(curr.getLeft() == null && curr.getRight() != null) {
                    System.out.println("Data " + curr.getData() + " has one child on the right");
                    if(parent.getRight() != null) {
                        parent.setLeft(curr.getRight());
                        curr.setRight(null);
                    } else {
                        parent.setRight(curr.getRight());
                        curr.setRight(null);
                    }
                }
                // Case III: Node has two children
                else if(curr.getLeft() != null && curr.getRight() != null) {
                    System.out.println("Data " + curr.getData() + " has two children");

                    int succ = getSuccessor(curr);



                    deleteNode(succ, curr);

                    curr.setData(succ);




                }
            }
        }
    }

    private int getSuccessor(Node curr) {

        if(curr.getLeft() == null) {
            return curr.getData();
        } else {
            return getSuccessor(curr.getLeft());
        }

    }



    public void inOrderTraversal() {
        System.out.println("\n\nTraversing");
        traverse(root);
    }

    private void traverse(Node curr) {
        if(root == null) {
            System.out.println("Tree is empty");
        }
        if(curr.getLeft() != null) {
            traverse(curr.getLeft());
        }
        System.out.print( curr.getData()+", ");
        if(curr.getRight() !=null) {
            traverse(curr.getRight());
        }
    }
}
