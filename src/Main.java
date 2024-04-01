public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        // Вставляем элементы
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.insert(5);

        // Проверяем поиск элементов
        int keyToSearch = 20;
        Tree.Node foundNode = tree.find(keyToSearch);
        if (foundNode != null) {
            System.out.println("Element " + keyToSearch + " found in the tree.");
        } else {
            System.out.println("Element " + keyToSearch + " not found in the tree.");
        }

        keyToSearch = 40;
        foundNode = tree.find(keyToSearch);
        if (foundNode != null) {
            System.out.println("Element " + keyToSearch + " found in the tree.");
        } else {
            System.out.println("Element " + keyToSearch + " not found in the tree.");
        }
    }
}
