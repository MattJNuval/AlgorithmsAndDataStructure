public class LinkedList {
    private Node root;
    private boolean results;

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

    public void delete(int data) {
        System.out.println("\nDeleting: " + data);
        deleteNode(data, root, null);
    }

    private void deleteNode(int data, Node curr, Node prev) {
        if(curr == null){
            System.out.println(data + " not found" );
        } else {
            if(curr.getData() == data) {
                if(curr.getNextNode() != null) {
                    if(curr.getData() != root.getData()) {
                        prev.setNextNode(curr.getNextNode());
                        curr.setNextNode(null);
                    } else {
                        root = curr.getNextNode();
                        curr.setNextNode(null);
                    }
                } else {
                    prev.setNextNode(null);
                }
            } else {
                deleteNode(data, curr.getNextNode(), curr);
            }
        }
    }

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
