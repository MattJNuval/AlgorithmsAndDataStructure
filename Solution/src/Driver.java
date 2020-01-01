public class Driver
{
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        BST b = new BST();

        b.insert(8);
        b.insert(3);
        b.insert(10);
        b.insert(1);
        b.insert(6);
        b.insert(4);
        b.insert(7);
        b.insert(14);
        b.insert(13);

        b.traverse();

        b.search(6);
        b.search(4);
        b.search(13);
        b.search(18);
        b.search(8);
        b.search(1);


    }
}
