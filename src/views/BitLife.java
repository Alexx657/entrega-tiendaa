package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BitLife extends JFrame implements ActionListener {
    private JButton button;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private int happiness;
    private int wealth;
    private boolean alive;

    public BitLife() {
        setTitle("BitLife Simulator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        button = new JButton("Next");
        button.addActionListener(this);
        add(button, BorderLayout.SOUTH);

        happiness = 50;
        wealth = 50;
        alive = true;

        setVisible(true);
    }

    public static void main(String[] args) {
        new BitLife();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alive) {
            JOptionPane.showMessageDialog(this, "You died. Game over!");
            dispose(); // Close the window
            return;
        }

        // Generate random events or life choices
        String[] events = {"Got a job", "Got a promotion", "Lost a job", "Bought a car",
                           "Bought a house", "Got married", "Had a baby", "Went on vacation",
                           "Encountered a challenge", "Received inheritance", "Died"};
        int randomIndex = (int) (Math.random() * events.length);
        String event = events[randomIndex];

        if (event.equals("Died")) {
            alive = false;
        }

        // Update happiness and wealth based on event
        switch (event) {
            case "Got a job":
                happiness += 5;
                wealth += 10;
                break;
            case "Got a promotion":
                happiness += 10;
                wealth += 20;
                break;
            case "Lost a job":
                happiness -= 10;
                wealth -= 20;
                break;
            case "Bought a car":
                happiness -= 5;
                wealth -= 15;
                break;
            case "Bought a house":
                happiness += 15;
                wealth -= 30;
                break;
            case "Got married":
                happiness += 20;
                break;
            case "Had a baby":
                happiness += 10;
                break;
            case "Went on vacation":
                happiness += 15;
                wealth -= 10;
                break;
            case "Encountered a challenge":
                happiness -= 10;
                wealth -= 10;
                break;
            case "Received inheritance":
                happiness += 20;
                wealth += 30;
                break;
            case "Died":
                happiness = 0;
                wealth = 0;
                break;
        }

        // Ensure happiness and wealth stay within bounds
        happiness = Math.max(0, Math.min(100, happiness));
        wealth = Math.max(0, Math.min(100, wealth));

        // Append event and updated stats to the text area
        textArea.append("Event: " + event + "\n");
        textArea.append("Happiness: " + happiness + ", Wealth: " + wealth + "\n\n");

        if (!alive) {
            button.setText("Exit");
        }
    }
}
