public class Driver
{
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.insert(7);
        l.insert(6);
        l.insert(5);
        l.insert(4);
        l.insert(3);
        l.insert(2);
        l.insert(1);

        l.delete(4);
        l.delete(1);
        l.delete(7);
        l.delete(2);

        l.reverse();

        l.print();

        System.out.println("\n"+l.find(3));
        System.out.println(l.find(9));


    }
}
