public class LinkedList {
    private LinkedNode root;
    //This is used for the reverse method
    private LinkedNode prev;
    private LinkedNode next;

    private boolean result = false;


    public void insert(int data) {
        insertNode(data, root);
    }

    private void insertNode(int data, LinkedNode curr) {
        if(root == null) {
            LinkedNode newNode = new LinkedNode(data);
            curr = newNode;
            root = curr;
        } else {
            LinkedNode newNode = new LinkedNode(data);
            curr = newNode;
            curr.setNext(root);
            root = curr;
        }
    }

    public boolean find(int data) {
        return findNode(data, root);
    }

    private boolean findNode(int data, LinkedNode curr) {
        if(curr == null) {
            result = false;
        } else {
            if(curr.getData() == data) {
                result = true;
            } else {
                findNode(data, curr.getNext());
            }
        }
        return result;
    }

    public void delete(int data) {
        deleteNode(data,null, root);
    }

    private void deleteNode(int data, LinkedNode prev, LinkedNode curr) {
        if(curr ==null) {
            System.out.println("Data not found");
        } else {
            if(curr.getData() == data) {
                if(curr.getData() == root.getData()) {
                    root = curr.getNext();
                    curr.setNext(null);
                } else if(curr.getNext() != null) {
                    prev.setNext(curr.getNext());
                    curr.setNext(null);
                } else {
                    prev.setNext(null);
                }
            } else {
                deleteNode(data, curr, curr.getNext());
            }

        }
    }

    public void reverse() {
        reverseNode(root);
    }

    private void reverseNode(LinkedNode curr) {
        if(curr == null) {
            root = prev;
        } else {
            // Set the next pointer to the next current node
            next = curr.getNext();
            // Connect the current node to the previous node
            curr.setNext(prev);
            // Set the previous pointer to the current pointer
            prev = curr;
            // Set the current pointer to the next pointer
            curr = next;
            reverseNode(curr);
        }
    }


    public void print() {
        printNode(root);
    }

    private void printNode(LinkedNode curr) {
        if(curr == null) {

        } else {
            System.out.print(" --> " + curr.getData());
            printNode(curr.getNext());
        }
    }
}
