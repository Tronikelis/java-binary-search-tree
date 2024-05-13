public class Main {
    public static void main(String[] args) {
        Bst bst = new Bst();

        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(25);
        bst.insert(11);
        bst.insert(9);
        bst.insert(4);

        bst.print();

        bst.remove(10);

        bst.print();

        System.out.println("\n\n\n");

        bst.remove(11);

        System.out.println("\n\n\n");

        bst.print();
    }
}
