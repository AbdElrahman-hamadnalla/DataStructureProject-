import java.awt.Color;
import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JOptionPane;

import dataStructures.*;
//import java.lang.Thread;

public class DataStructureSmulation {
    // execute application

    public static void main(String[] args) throws InterruptedException {

        // geting the data structure type
        String dataStructureType = JOptionPane.showInputDialog("Enter the type of the data Structure");
        // infinite loop to interacte with the user
        while (true) {

            // create frame
            JFrame frame = new JFrame("Data Structure Semulation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // ! this is the stack execution
            if (dataStructureType.toLowerCase().equals("stack")) {

                // input stack size
                String firstNumber = JOptionPane.showInputDialog("Enter the size of the stack");
                int number1 = 0;
                Stack stack = null;
                try {
                    number1 = Integer.parseInt(firstNumber);// // todo handling exception
                    stack = new Stack(number1);
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "Please enter a number.",
                            "Error",
                            JOptionPane.PLAIN_MESSAGE);
                    continue;
                }
                stack.setBackground(Color.WHITE);

                frame.add(stack);
                frame.setSize(270, 500);
                frame.setVisible(true);
                // ifinite loop to get command from user
                while (true) {

                    String input = JOptionPane.showInputDialog("Enter :");

                    // deviding command to input parameters
                    int i = input.indexOf(' ');
                    String word = "";
                    String rest = "";
                    if (i >= 0) {
                        word = input.substring(0, i);
                        rest = input.substring(i);
                    }

                    // detect the action (pop or push or exit)
                    if (word.toLowerCase().equals("pop") || input.toLowerCase().equals("pop")) {

                        rest = stack.pop();
                        JOptionPane.showMessageDialog(null, "The top is " + rest, "The poping",
                                JOptionPane.PLAIN_MESSAGE);
                    } else if (word.toLowerCase().equals("push")) {
                        stack.push(rest);

                    } else if (input.toLowerCase().equals("exit")) {
                        break;

                    } else
                        JOptionPane.showMessageDialog(null, "Enter \"push \'numper\' \" OR \"pop\" OR \"exit\"",
                                "Error",
                                JOptionPane.PLAIN_MESSAGE);

                }

                // ending the program
                JOptionPane.showMessageDialog(null, "Thank you for using my program", "Thanks",
                        JOptionPane.PLAIN_MESSAGE);
                frame.setVisible(false);
                break;

                // ! this is the queue execution
            } else if (dataStructureType.toLowerCase().equals("queue")) {

                // input Queue size
                String firstNumber = JOptionPane.showInputDialog("Enter the size of the queue");
                int number1 = 0;
                Queuew queue = null;
                try {
                    number1 = Integer.parseInt(firstNumber);// // todo handling exception
                    queue = new Queuew(number1);
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "Please enter a number.",
                            "Error",
                            JOptionPane.PLAIN_MESSAGE);
                    continue;
                }
                queue.setBackground(Color.WHITE);
                frame.add(queue);
                frame.setSize(270, 500);
                frame.setVisible(true);

                // infinite loop to get command from user
                while (true) {

                    String input = JOptionPane.showInputDialog("Enter :");

                    // deviding command to input parameters
                    int i = input.indexOf(' ');
                    String word = "";
                    String rest = "";
                    if (i >= 0) {
                        word = input.substring(0, i);
                        rest = input.substring(i);
                    }

                    // detect the action (pop or push or exit)
                    if (word.toLowerCase().equals("pop") || input.toLowerCase().equals("pop")) {

                        rest = queue.pop();
                        JOptionPane.showMessageDialog(null, "The top is " + rest, "The poping",
                                JOptionPane.PLAIN_MESSAGE);
                    } else if (word.toLowerCase().equals("push")) {
                        queue.add(rest);

                    } else if (input.toLowerCase().equals("exit")) {
                        break;

                    } else
                        JOptionPane.showMessageDialog(null, "Enter \"push \'numper\' \" OR \"pop\" OR \"exit\"",
                                "Error",
                                JOptionPane.PLAIN_MESSAGE);

                }

                // ending the program
                JOptionPane.showMessageDialog(null, "Thank you for using my program", "Thanks",
                        JOptionPane.PLAIN_MESSAGE);
                frame.setVisible(false);
                break;

                // ! this is the linked list execution
            } else if (dataStructureType.toLowerCase().equals("linked list")) {

                MyLinkedList head = new MyLinkedList();
                head.setBackground(Color.WHITE);
                frame.add(head);
                frame.setSize(1300, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // infinite loop to get command from user
                while (true) {

                    String input = JOptionPane.showInputDialog("Enter :");

                    // deviding command to input parameters
                    int i = input.indexOf(' ');
                    String word = "";
                    String rest = "";
                    if (i >= 0) {
                        word = input.substring(0, i);
                        rest = input.substring(i + 1);
                    }

                    // *detect the action (remove or add or exit)
                    if (word.toLowerCase().equals("remove") || input.toLowerCase().equals("remove")) {

                        head.removeNode(rest);

                    } else if (word.toLowerCase().equals("add") && rest.length() > 7) {

                        if (rest.substring(0, 7).toLowerCase().equals("at head")) {

                            head.addAtHead(rest.substring(8));

                        } else if (rest.substring(0, 7).toLowerCase().equals("at tail")) {

                            head.addAtTail(rest.substring(8));

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Enter \"add at head \'number\'  \" OR\"add at tail \'number\' \" OR \"remove \'number\' \"  OR \"exit\"",
                                    "Error",
                                    JOptionPane.PLAIN_MESSAGE);
                        }
                    } else if (input.toLowerCase().equals("exit")) {
                        break;

                    } else
                        JOptionPane.showMessageDialog(null,
                                "Enter \"add at head \'number\'  \" OR\"add at tail \'number\' \" OR \"remove \'number\' \"  OR \"exit\"",
                                "Error",
                                JOptionPane.PLAIN_MESSAGE);

                }

                // ending the program
                JOptionPane.showMessageDialog(null, "Thank you for using my program", "Thanks",
                        JOptionPane.PLAIN_MESSAGE);
                frame.setVisible(false);
                break;

                // ! this is the tree execution
            } else if (dataStructureType.toLowerCase().equals("tree")) {

                MyATree root = new MyATree();
                root.setBackground(Color.WHITE);
                frame.add(root);
                frame.setSize(1350, 700);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // infinite loop to get command from user
                while (true) {

                    String input = JOptionPane.showInputDialog("Enter :");

                    // deviding command to input parameters
                    int i = input.indexOf(' ');
                    String word = "";
                    String rest = "";
                    if (i >= 0) {
                        word = input.substring(0, i);
                        rest = input.substring(i + 1);
                    }

                    // * detect the action (pop or push or exit)

                    if (word.toLowerCase().equals("remove") || input.toLowerCase().equals("remove")) {
                        try {
                            int number1 = Integer.parseInt(rest);// // todo handling exception
                            root.remove(number1);
                        }

                        catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Please enter a number.",
                                    "Error",
                                    JOptionPane.PLAIN_MESSAGE);
                            continue;

                        }

                    } else if (word.toLowerCase().equals("add")) {
                        try {
                            int number1 = Integer.parseInt(rest);// // todo handling exception
                            root.add(number1);
                        }

                        catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Please enter a number.",
                                    "Error",
                                    JOptionPane.PLAIN_MESSAGE);
                            continue;

                        }

                    } else if (input.toLowerCase().equals("exit")) {
                        break;

                    } else
                        JOptionPane.showMessageDialog(null,
                                "Enter \"add  \'number\'  \" OR \"remove \'number\' \"  OR \"exit\"",
                                "Error",
                                JOptionPane.PLAIN_MESSAGE);

                }

                // ending the program
                JOptionPane.showMessageDialog(null, "Thank you for using my program", "Thanks",
                        JOptionPane.PLAIN_MESSAGE);
                frame.setVisible(false);
                break;

            } else {
                JOptionPane.showMessageDialog(null,
                        "Wrong datastructure type , stay focused",
                        "Error",
                        JOptionPane.PLAIN_MESSAGE);
                dataStructureType = JOptionPane.showInputDialog("Enter the type of the data Structure");

            }

        }

    }
}
