package dataStructures;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

public class Stack extends JPanel {
    // instance variables
    private int stackSize = 0;
    private String[] arr;
    private int CurrentSize = 0;

    // constructor
    public Stack(int stackSize) {
        super();
        this.stackSize = stackSize;
        arr = new String[stackSize];
    }

    public void push(String x) {
        if (CurrentSize != stackSize) {
            arr[CurrentSize++] = x;
            repaint();
        } else
            JOptionPane.showMessageDialog(null, "the stack is full", "Full",
                    JOptionPane.PLAIN_MESSAGE);
    }

    public String pop() {
        String temp;
        if (CurrentSize != 0) {
            temp = arr[--CurrentSize];
            repaint();
        } else
            temp = "empty";
        return temp;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.black);

        for (int i = 20 + 400 / stackSize; i < 420; i += 400 / stackSize) {
            g.drawLine(20, i, 220, i);

        }
        g.drawRoundRect(20, 20, 200, 400, 20, 20);

        g.setColor(Color.BLUE);
        if (stackSize < 10) {
            g.setFont(new Font("Arial", Font.PLAIN, 40));
        } else
            g.setFont(new Font("Arial", Font.PLAIN, 24 * 15 / stackSize));

        for (int i = 0; i < CurrentSize; i++) {
            int shift = arr[i].length() * 9;
            if (stackSize > 20) {
                g.drawString(arr[i], 100 - shift, 420 - ((i) * 400 / stackSize));

            } else
                g.drawString(arr[i], 100 - shift, 415 - ((i) * 400 / stackSize));

        }

    }
} // end class LinesRectsOvalsJPanel
