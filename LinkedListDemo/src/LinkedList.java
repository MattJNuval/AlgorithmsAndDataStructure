public class LinkedList implements LinkedListInterface{
    private Node root;
    private boolean results;
    private Node next;
    private Node prev;

    @Override
    public void insert(int data) {
        insertNode(data, root);
    }

    private void insertNode(int data, Node curr) {
        if(curr == null) {
            curr = new Node(data);
            root = curr;
            System.out.println("Inserting new head if null: " + root.getData());
        } else {
            curr = new Node(data);
            curr.setNextNode(root);
            System.out.println("Connecting " + curr.getData() + " to current root " + root.getData());
            root = curr;
            System.out.println("Setting new head as: " + root.getData());

        }
    }

    @Override
    public void delete(int data) {
        System.out.println("\nDeleting: " + data);
        deleteNode(data, root, null);
    }

    private void deleteNode(int data, Node curr, Node prev) {
        //Base case
        if(curr == null){
            System.out.println(data + " not found" );
        } else {
            // If data is found
            if(curr.getData() == data) {
                // If the current next node is not null
                if(curr.getNextNode() != null) {
                    // if the current data is not the root data
                    if(curr.getData() != root.getData()) {
                        prev.setNextNode(curr.getNextNode());
                        curr.setNextNode(null);
                      //Otherwise
                    } else {
                        root = curr.getNextNode();
                        curr.setNextNode(null);
                    }
                  //Otherwise
                } else {
                    prev.setNextNode(null);
                }
              //Otherwise
            } else {
                deleteNode(data, curr.getNextNode(), curr);
            }
        }
    }

    @Override
    public void reverse() {
        System.out.println("\nReversing");
        reverseNode(root);
    }

    private void reverseNode(Node curr) {
        // Base case
        if(curr == null) {
            root = prev;
        } else {
            // Set the next node to current next node
            next = curr.getNextNode();
            // Connect the current node with the previous node
            curr.setNextNode(prev);
            // Set the previous node with the current node
            prev = curr;
            // Set the current node with next node
            curr = next;
            // Recursive call
            reverseNode(curr);
        }
    }

    @Override
    public boolean find(int data) {
        return findNode(data, root);
    }

    private boolean findNode(int data, Node curr) {
        if(curr == null){
            results = false;
        } else {
            if(curr.getData() == data) {
                results = true;
            } else {
                findNode(data, curr.getNextNode());
            }
        }
        return results;
    }

    @Override
    public void print() {
        System.out.println("\nPrinting");
        printNode(root);
    }
    private void printNode(Node curr){
        if(curr == null) {
            System.out.println(" (Done!)");
        } else {
            System.out.print(" --> "+ curr.getData());
            printNode(curr.getNextNode());
        }

    }
}
