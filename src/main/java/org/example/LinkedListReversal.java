package org.example;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListReversal {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Тест для проверки работы программы
    public static void main(String[] args) {
        // Создание списка 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Исходный список:");
        printLinkedList(head);

        LinkedListReversal listReversal = new LinkedListReversal();
        ListNode reversedHead = listReversal.reverseLinkedList(head);

        System.out.println("\nРеверсированный список:");
        printLinkedList(reversedHead);
    }

    // Вспомогательный метод для вывода списка на экран
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
