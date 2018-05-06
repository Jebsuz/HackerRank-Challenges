package ru.jebsuz.hrc.ds.linkedlists;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
 */
public class PrintElementsOfLinkedList {

  void Print(Node head) {
    if (head != null) {
      System.out.println(head.data);
      Print(head.next);
    }
  }

  static class Node {

    int data;
    Node next;
  }
}
