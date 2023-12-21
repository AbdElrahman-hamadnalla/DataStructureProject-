package dataStructures;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

public class Queuew extends JPanel {
    // instance variables
    private int head = -1;
    private int tail = -1;
    private int currentSize = 0;
    private String[] arr;
    private int queueSize = 0;

    // constructor
    public Queuew(int queueSize) {
        super();
        arr = new String[queueSize];
        this.queueSize = queueSize;
    }

    public void add(String x) {
        if (currentSize == 0) {
            head = 0;
            tail = 0;
            arr[tail] = x;
            currentSize++;
            repaint();
        } else if (currentSize == queueSize) {
            JOptionPane.showMessageDialog(null, "the Queue is full", "Full",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (tail < queueSize - 1) {
            tail++;
            arr[tail] = x;
            currentSize++;
            repaint();
        } else {
            tail = 0;
            arr[tail] = x;
            currentSize++;
            repaint();
        }

    }

    public String pop() {
        if (currentSize == 0) {

            return "empty";
        } else if (head < queueSize - 1) {
            String temp = arr[head];
            head++;
            currentSize--;
            if (currentSize == 0) {
                head = -1;
                tail = -1;
            }
            repaint();
            return temp;
        } else {
            String temp = arr[head];
            head = 0;
            currentSize--;
            if (currentSize == 0) {
                head = -1;
                tail = -1;
            }
            repaint();
            return temp;

        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.black);

        for (int i = 20 + 400 / queueSize; i < 420; i += 400 / queueSize) {
            g.drawLine(20, i, 220, i);

        }

        g.drawRoundRect(20, 20, 200, 400, 20, 20);
        g.setColor(Color.BLUE);
        if (queueSize < 10) {
            g.setFont(new Font("Arial", Font.PLAIN, 40));
        } else
            g.setFont(new Font("Arial", Font.PLAIN, 24 * 15 / queueSize));
        int j = 0;
        for (int i = head; i != tail; j++, i++) {
            if (i == queueSize)
                i = 0;
            if (i == tail)
                break;

            int shift = arr[i].length() * 9;

            if (queueSize > 20) {
                g.drawString(arr[i], 100 - shift, 420 - ((j) * 400 / queueSize));

            } else
                g.drawString(arr[i], 100 - shift, 415 - ((j) * 400 / queueSize));

        }
        if (currentSize != 0) {
            int shift = arr[tail].length() * 9;

            if (queueSize > 20) {
                g.drawString(arr[tail], 100 - shift, 420 - ((j) * 400 / queueSize));

            } else
                g.drawString(arr[tail], 100 - shift, 415 - ((j) * 400 / queueSize));
        }
    }

}
