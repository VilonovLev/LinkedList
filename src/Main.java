import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static class DiyLinkedList
    {
        private Node head;
        private Node tail;

        @Override
        public String toString() {
            if (head == null) {
                return "List empty";
            }
            return head.toString();
        }

        class Node {
            private int value;
            private Node next;
            private Node previous;

            public Node(int value) {
                this.value = value;
            }

            public Node() {}

            @Override
            public String toString() {
                return "Node{" +
                        "value=" + value +
                        ", next=" + next +
                        '}';
            }
        }

        public void addFirst(int value) {
            Node node = new Node(value);
            node.next = head;
            head = node;
            if (tail == null) {
                tail = node;
            }
        }

        public void removeFirst() {
            if (head != tail) {
                head = head.next;
                head.previous = null;
            } else {
                head = null;
                tail = null;
            }
        }

        public Node findNode(int value) {
            Node node = head;
            while (node != null){
                if (node.value == value)
                    return node;
                node = node.next;
            }
            return new Node();
        }

        public void push(int value) {
            if (tail == null) {
                addFirst(value);
            } else {
                Node node = new Node(value);
                tail.next = node;
                node.previous = tail;
                tail = tail.next;
            }
        }
        public void removeLast() {
            if (head == tail) {
                removeFirst();
            } else {
                  tail = tail.previous;
                  tail.next = null;
            }
        }

        public void sort() {
            Node headList = head;
            Node tailList;
            int value;
            while (headList != null) {
                tailList = headList.next;
                while (tailList != null) {
                    if (headList.value > tailList.value) {
                        value = tailList.value;
                        tailList.value = headList.value;
                        headList.value = value;
                    }
                    tailList = tailList.next;
                }
                headList = headList.next;
            }
        }

        public void reverse() {
            Node correntHead = head;
            Node correntTail = tail;
            while (correntHead.previous != correntTail && correntHead != correntTail) {
                int val = correntHead.value;
                correntHead.value = correntTail.value;
                correntTail.value = val;
                correntHead = correntHead.next;
                correntTail = correntTail.previous;
            }

        }

    }

    public static void main(String[] args) {
        DiyLinkedList list = new DiyLinkedList();
        list.push(4);
        list.push(5);
        list.addFirst(45);
        list.push(0);
        System.out.println(list);
        list.sort();
        System.out.println(list);
        list.reverse();
        System.out.println(list);



    }



}