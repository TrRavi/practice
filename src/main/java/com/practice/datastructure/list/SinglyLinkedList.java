package com.practice.datastructure.list;
class Node{
     int data;
     Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class SinglyLinkedList {
    Node head;
    public static SinglyLinkedList insertIntoLinkedList(SinglyLinkedList list, int data){
        Node newNode = new Node(data);

        if(list.head == null){
            list.head = newNode;
        }else{

            Node currentNode = list.head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }

            currentNode.next =newNode;
        }
        return list;
    }


    public static void printList(SinglyLinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list  =  new SinglyLinkedList();
        
    }

    public static SinglyLinkedList deleteByKey(SinglyLinkedList list, int key)
    {
        Node currNode = list.head, prev = null;
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head

            System.out.println(key + " found and deleted");

            return list;
        }
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        if (currNode == null) {
            System.out.println(key + " not found");
        }

       return list;
    }


    public static SinglyLinkedList deleteAtPosition(SinglyLinkedList list, int index)
    {
       Node currNode = list.head, prev = null;
         if (index == 0 && currNode != null) {
            list.head = currNode.next; // Changed head

            System.out.println(index + " position element deleted");

            return list;
        }

        int counter = 0;

         while (currNode != null) {

            if (counter == index) {
                 prev.next = currNode.next;
                 System.out.println(index + " position element deleted");
                break;
            }
            else {
                 prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        if (currNode == null) {
            // Display the message
            System.out.println(index + " position element not found");
        }

        return list;
    }

}
