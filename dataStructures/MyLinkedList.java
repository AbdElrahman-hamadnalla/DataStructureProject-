package dataStructures;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

public class MyLinkedList extends JPanel {
    private int linkedSize;
    private Node head;

    public MyLinkedList() {
        super();
        linkedSize = 0;
    }

    public void addAtHead(String x) {
        if (linkedSize == 7) {
            JOptionPane.showMessageDialog(null, "the maximum number of nodes is 7", "Full",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            if (head == null)
                head = new Node(x, null);
            else {

                head = new Node(x, head);
            }
            // System.out.println("+" + x + "+");
            linkedSize++;
            repaint();
        }
    }

    public void addAtTail(String x) {
        if (linkedSize == 7) {
            JOptionPane.showMessageDialog(null, "the maximum number of nodes is 7", "Full",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (linkedSize == 0) {
            if (head == null)
                head = new Node(x, null);
            else {

                head = new Node(x, head.next);
            }
            // System.out.println("+" + x + "+");

            linkedSize++;
            repaint();
        }

        else {
            Node temp;
            for (temp = head; temp.next != null; temp = temp.next)
                ;
            temp.next = new Node(x, null);
            // System.out.println("+" + x + "+");

            linkedSize++;
            repaint();
        }
    }

    public boolean removeNode(String target) {
        if (linkedSize == 0) {
            JOptionPane.showMessageDialog(null, "the linked list is empty", "Empty",
                    JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        Node temp;
        if (head.data.equals(target)) {
            head = head.next;
            linkedSize--;
            repaint();
            return true;
        }

        for (temp = head; temp.next != null && !(temp.next.data.equals(target)); temp = temp.next)
            ;

        if (temp.next != null) {
            temp.next = temp.next.next;
            linkedSize--;
            repaint();
            return true;
        }
        JOptionPane.showMessageDialog(null, "the target is missed", "Missed",
                JOptionPane.PLAIN_MESSAGE);
        return false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Head", 60, 30);
        g.drawLine(100, 40, 100, 100);
        g.fillOval(95, 35, 10, 10);
        g.drawLine(105, 90, 100, 100);
        g.drawLine(95, 90, 100, 100);
        g.drawLine(105, 90, 95, 90);

        for (int i = 0; i < linkedSize; i++) {
            g.drawRoundRect(50 + 150 * i, 100, 100, 150, 20, 20);
            g.drawLine(117 + 150 * i, 100, 117 + 150 * i, 250);

            g.drawLine(135 + i * 150, 175, 200 + i * 150, 175);

            g.drawLine(190 + i * 150, 170, 200 + i * 150, 175);
            g.drawLine(190 + i * 150, 180, 200 + i * 150, 175);
            g.drawLine(190 + i * 150, 170, 190 + i * 150, 180);

            g.fillOval(130 + i * 150, 170, 10, 10);

        }
        g.drawString("Null", 200 + 150 * (linkedSize - 1), 190);
        Node temp;
        int i3 = 0;
        for (temp = head; temp != null; temp = temp.next) {
            g.drawString(temp.data, 60 + 150 * i3, 190);
            i3++;
        }

    }
}

class Node {

    public String data;
    public Node next;

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}