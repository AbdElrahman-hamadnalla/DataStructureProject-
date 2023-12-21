package dataStructures;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

import java.lang.Math;

public class MyATree extends JPanel {

    // instance variables
    private int[] root;
    private int treeElement;

    // constructor
    public MyATree() {
        super();
        treeElement = 0;
        root = new int[31];
    }

    // add the element
    public void add(int element) {

        if (treeElement == 0) {
            root[0] = element;
            treeElement++;
            repaint();
        } else if (treeElement < 31) {

            // get the position of the adding
            int pos = getAdd(element, 0, treeElement - 1);
            for (int i = treeElement; i > pos; i--) {

                root[i] = root[i - 1];
            }

            root[pos] = element;
            treeElement++;
            repaint();
        } else {
            JOptionPane.showMessageDialog(null,
                    "The tree is full",
                    "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    // get the position of the adding
    public int getAdd(int element, int begain, int end) {

        int mid = (begain + end) / 2;

        if (begain == end && !(element == (root[end]))) {
            if (element > root[end]) {
                return end + 1;
            } else
                return end;
        }

        if (element == (root[mid]))
            return mid;
        else if (element > (root[mid]))
            return getAdd(element, mid + 1, end);
        else
            return getAdd(element, begain, mid);

    }

    // get the position of the element
    public int get(int element, int begain, int end) {
        int mid = (begain + end) / 2;
        if (begain == end && !(element == (root[end])))
            return -1;
        if (element == (root[mid]))
            return mid;
        else if (element > root[mid])
            return get(element, mid + 1, end);
        else
            return get(element, begain, mid);

    }

    public void remove(int element) {
        treeElement--;
        int pos = get(element, 0, treeElement);
        if (pos != -1) {
            for (int i = pos; i < treeElement; i++) {
                root[i] = root[i + 1];
            }

            repaint();
        }

    }

    // this get the depth
    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        int x;
        int y;

        // ! paint the nodes
        for (int i = 0; i < treeElement; i++) {
            int first = i + 1;
            int l = log2(first) + 1;
            int temp = l;
            y = l * 100 + 20;
            int j = 1;
            while (temp == l) {
                x = (int) (((double) (j)) * 1350 / (((double) (first)) + 1)) - 33;

                g.drawRoundRect(x, y, 66, 66, 10, 10);

                if (i % 2 == 0 && i != 0)
                    g.drawLine(x + 33, y, (int) ((((double) (j)) - 0.5) * (1350 / (((double) first) + 1))), y - 34);
                else if (i != 0)
                    g.drawLine(x + 33, y, (int) ((((double) (j)) + 0.5) * (1350 / (((double) first) + 1))), y - 34);

                g.drawString("" + root[i] + "", x + 2, y + 40);

                i++;
                j++;
                temp = log2(i + 1) + 1;
                if (i == treeElement) {
                    i++;
                    break;
                }
            }
            i--;

        }

    }

}
