package ru.jebsuz.hrc.ctcic.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/ctci-contacts/problem
 */
public class TriesContacts {

  private static final Node contactsBook = new Node();

  static void add(String contact) {
    contactsBook.add(contact);
  }

  static void find(String partial) {
    Node node = contactsBook.find(partial);
    if (node != null) {
      System.out.println(node.completeContacts);
    } else {
      System.out.println(0);
    }
  }

  static class Node {

    Map<Character, Node> children = new HashMap<>();
    boolean isCompleteContact = false;
    long completeContacts = 0;

    void add(String contact) {
      char[] chars = contact.toCharArray();
      Node next = this;
      for (int i = 0; i < chars.length; i++) {
        next = addCharacter(chars[i], next);
      }
      next.isCompleteContact = true;
    }

    private Node addCharacter(char character, Node node) {
      Node next;
      if (node.children.containsKey(character)) {
        next = node.children.get(character);
      } else {
        next = new Node();
        node.children.put(character, next);
      }
      next.completeContacts++;
      return next;
    }

    Node find(String contact) {
      char[] chars = contact.toCharArray();
      if (!children.containsKey(chars[0])) {
        return null;
      }
      Node result = this;
      for (int i = 0; i < chars.length; i++) {
        result = find(chars[i], result);
        if (result == null) {
          break;
        }
      }
      return result;
    }

    Node find(Character character, Node node) {
      return node.children.get(character);
    }
  }
}
