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

	private JFrame frame;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	public static int num_veces_pulsado = 0;
	public static int letras_anadidas = 0;

	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(400, 100, 617, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		btnNewButton = new JButton("Pulse aquí");
		btnNewButton.setBounds(83, 191, 135, 42);
		btnNewButton.addActionListener(this);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(162, 123, 221, 32);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Pulse aquí 2");
		btnNewButton_1.setBounds(115, 64, 135, 48);
		btnNewButton_1.addActionListener(this);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(150, 260, 265, 32);
		textField.setColumns(10);
		textField.addActionListener(this);
		textField.addKeyListener(this);
		frame.getContentPane().add(textField);


	}
	
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == btnNewButton) {
    		//Indica si se ha pulsado este botón en ESPECÍFICO
    		num_veces_pulsado++;
    		lblNewLabel.setText("Se ha pulsado "+ num_veces_pulsado + " veces");
    	}
    	if(e.getSource() == textField) {
    		lblNewLabel.setText("Se están escribiendo palabras...");
    	}
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		letras_anadidas++;
		lblNewLabel.setText("Se están escribiendo " + letras_anadidas + " letras...");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
