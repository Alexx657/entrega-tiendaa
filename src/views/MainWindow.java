package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.SpringLayout;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class MainWindow implements ActionListener, KeyListener{

	private JFrame frmSampleSwing;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	public static int counterClicks = 0;
	public static int counterLetters = 0;

	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmSampleSwing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// launch main window
		frmSampleSwing = new JFrame();
		frmSampleSwing.setTitle("Sample Swing");
		frmSampleSwing.setBounds(400, 100, 617, 416);
		frmSampleSwing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSampleSwing.getContentPane().setLayout(null);
		
		// create click button
		btnNewButton = new JButton("Count clicks");
		btnNewButton.setBounds(117, 64, 135, 42);
		frmSampleSwing.getContentPane().add(btnNewButton);
		// add listener action
		btnNewButton.addActionListener(this);
		
		// create nothing button 
		btnNewButton_1 = new JButton("Do nothing");
		btnNewButton_1.setBounds(117, 132, 135, 48);
		// add listener action
		btnNewButton_1.addActionListener(this);
		frmSampleSwing.getContentPane().add(btnNewButton_1);
		
		// create result label button
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(185, 280, 221, 32);
		frmSampleSwing.getContentPane().add(lblNewLabel);
		
		// create type text field
		textField = new JTextField();
		textField.setBounds(166, 209, 265, 32);
		textField.setColumns(10);
		// add listener action
		textField.addActionListener(this);
		// add listener key
		textField.addKeyListener(this);
		frmSampleSwing.getContentPane().add(textField);


	}
	
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == btnNewButton) {
    		//in case clicks button
    		counterClicks++;
    		lblNewLabel.setText("Button clicked "+ counterClicks + " times");
    	}
    	if(e.getSource() == btnNewButton_1) {
    		lblNewLabel.setText("Do nothing ...");
    	}
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		counterLetters++;
		lblNewLabel.setText("They are writing " + counterLetters + " letters...");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
