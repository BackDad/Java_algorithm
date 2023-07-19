package org.example;

public class BinTree {
    Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value, Color.black);
            return true;
        }
        root = addNode(root, value);
        root.color = Color.black; // У корня должен быть черный цвет
        return true;
    }

    private Node addNode(Node node, int value) {
        if (node == null) {
            return new Node(value, Color.red);
        }

        if (value < node.value) {
            node.left = addNode(node.left, value);
        } else if (value > node.value) {
            node.right = addNode(node.right, value);
        }

        // Балансировка после добавления узла
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == Color.red;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        rightChild.color = node.color;
        node.color = Color.red;
        return rightChild;
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        leftChild.color = node.color;
        node.color = Color.red;
        return leftChild;
    }

    private void flipColors(Node node) {
        node.color = Color.red;
        node.left.color = Color.black;
        node.right.color = Color.black;
    }

    public boolean contain(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node(int value, Color color) {
            this.value = value;
            this.color = color;
        }
    }

    enum Color { red, black }

    public static void main(String[] args) {
        BinTree tree = new BinTree();

        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        // Проверка наличия элементов
        System.out.println("Contain 4: " + tree.contain(4)); // Ожидаемый результат: true
        System.out.println("Contain 10: " + tree.contain(10)); // Ожидаемый результат: false

        // Проверка наличия корня и его цвета
        System.out.println("Root value: " + tree.root.value); // Ожидаемый результат: 5
        System.out.println("Root color: " + tree.root.color); // Ожидаемый результат: black
    }




}
