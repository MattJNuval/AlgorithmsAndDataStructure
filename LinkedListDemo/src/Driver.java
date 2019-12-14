public class Driver {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);

        l.print();

        l.delete(3);
        l.delete(2);
        l.delete(9);

        l.print();
        
        System.out.println(l.find(2));
        System.out.println(l.find(3));
        System.out.println(l.find(4));


    }
}
