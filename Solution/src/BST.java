import jdk.nashorn.api.tree.Tree;

public class BST {
    private TreeNode root;
    private TreeNode parent;
    private boolean result = false;

    public void insert(int data) {
        insertNode(data, root);
    }

    private void insertNode(int data, TreeNode curr) {
        if(root == null) {
            TreeNode newNode = new TreeNode(data);
            curr = newNode;
            root = curr;
        } else if(data <= curr.getData()) {
            if(curr.getLeft() != null) {
                insertNode(data, curr.getLeft());
            } else {
                TreeNode newNode = new TreeNode(data);
                curr.setLeft(newNode);
                curr.getLeft();
            }
        } else if(data > curr.getData()) {
            if(curr.getRight() != null) {
                insertNode(data, curr.getRight());
            } else {
                TreeNode newNode = new TreeNode(data);
                curr.setRight(newNode);
            }
        }
    }

    public void search(int data) {
        searchNode(data, root);
    }

    private void searchNode(int data, TreeNode curr) {
        if(root == null) {
            System.out.println("Tree is empty");
        } else if(data < curr.getData()) {
            if(curr.getLeft() != null) {
                searchNode(data, curr.getLeft());
            } else {
                System.out.println("Data not found ");
            }
        } else if(data > curr.getData()) {
            if(curr.getRight() != null) {
                searchNode(data, curr.getRight());
            } else {
                System.out.println("Data not found ");
            }
        } else if(data == curr.getData()) {
            System.out.println("Data: " + data + " is found");
        }
    }

    public void traverse() {
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode curr) {
        if(curr.getLeft() != null) {
            inOrderTraversal(curr.getLeft());
        }
        System.out.print( curr.getData()+", ");
        if(curr.getRight() != null) {
            inOrderTraversal(curr.getRight());
        }
    }


    public void delete(int data) {
        System.out.println("DELETING: " + data);
        deleteNode(data, root);
    }

    private void deleteNode(int data, TreeNode curr) {
        if(root == null || curr == null) {
            System.out.print("Tree is empty");
        }

        if(data < curr.getData()) {
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
            System.out.println(curr.getData() + " is founded");
            if(curr.getLeft() == null && curr.getRight() == null) {
                System.out.println(curr.getData() + " is a leaf");
                if(parent.getLeft() == curr) {
                    parent.setLeft(null);
                } else if(parent.getRight() == curr) {
                    parent.setRight(null);
                }
            } else if(curr.getRight() == null) {
                System.out.println(curr.getData() + " has one child");
                if(parent.getLeft() == curr) {
                    parent.setLeft(curr.getLeft());
                } else if(parent.getRight() == curr) {
                    parent.setRight(curr.getLeft());
                }
            } else if(curr.getLeft() == null) {
                System.out.println(curr.getData() + " has one child");
                if(parent.getLeft() == curr) {
                    parent.setLeft(curr.getRight());
                } else if(parent.getRight() == curr) {
                    parent.setRight(curr.getRight());
                }
            } else if(curr.getRight() != null && curr.getLeft() != null){
                System.out.println(curr.getData() + " has two child");
                TreeNode successor = minKey(curr.getRight());
                int val = successor.getData();
                System.out.println("The succ data is " + successor.getData());
                deleteNode(successor.getData(), root);
                curr.setData(val);
            }
        }

    }

    private TreeNode minKey(TreeNode curr) {
        while(curr.getLeft() != null) {
            curr = curr.getLeft();
        }
        return curr;
    }


}
