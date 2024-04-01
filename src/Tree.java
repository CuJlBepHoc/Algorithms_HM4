public class Tree {
    Node root;

    class Node{
        int value;
        Node left;
        Node right;
        Color color;

        Node(int value) {
            this.value = value;
            this.color = Color.RED; // Новые узлы всегда красные
        }
    }

    enum Color{
        BLACK,
        RED
    }

    public void insert(int value){
        if(root != null) {
            root = insert(root, value);
            root.color = Color.BLACK; // Корень всегда черный
        } else {
            root = new Node(value);
            root.color = Color.BLACK; // Корень всегда черный
        }
    }

    private Node insert(Node node, int value){
        if(node == null)
            return new Node(value);

        if(node.value < value){
            node.right = insert(node.right, value);
        } else if(node.value > value){
            node.left = insert(node.left, value);
        } else {
            // Если ключ уже существует, ничего не делаем
            return node;
        }

        // Балансировка после вставки
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            swapColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    private Node leftRotate(Node node){
        Node cur = node.right;
        node.right = cur.left;
        cur.left = node;
        cur.color = node.color;
        node.color = Color.RED;
        return cur;
    }

    private Node rightRotate(Node node){
        Node cur = node.left;
        node.left = cur.right;
        cur.right = node;
        cur.color = node.color;
        node.color = Color.RED;
        return cur;
    }

    private void swapColors(Node node){
        node.color = (node.color == Color.RED ? Color.BLACK : Color.RED);
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    public Node find(int value){
        return find(root, value);
    }

    private Node find(Node node, int value){
        if(node == null)
            return null;
        if(node.value == value){
            return node;
        }
        if(node.value < value){
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }
}
