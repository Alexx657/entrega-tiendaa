package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener {
    private JTextField employeeNumberField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private int failedAttempts = 0; // Contador de intentos fallidos

    public LoginView() {
        // Configuración del JFrame
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Crear y agregar componentes
        JLabel employeeNumberLabel = new JLabel("Número de empleado");
        employeeNumberLabel.setBounds(10, 10, 120, 25);
        add(employeeNumberLabel);

        employeeNumberField = new JTextField(20);
        employeeNumberField.setBounds(150, 10, 120, 25);
        add(employeeNumberField);

        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setBounds(10, 40, 120, 25);
        add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 40, 120, 25);
        add(passwordField);

        loginButton = new JButton("Acceder");
        loginButton.setBounds(100, 80, 100, 25);
        add(loginButton);

        // Añadir ActionListener al botón
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String employeeNumber = employeeNumberField.getText();
            String password = new String(passwordField.getPassword());

            // Validar credenciales
            if (employeeNumber.equals("123") && password.equals("test")) {
                // Abrir ventana ShopView
                ShopView shopView = new ShopView();
                shopView.setVisible(true);
                this.dispose();
            } else {
                failedAttempts++; // Incrementar contador de intentos fallidos
                if (failedAttempts >= 3) {
                    JOptionPane.showMessageDialog(this, "Ha superado el número máximo de intentos fallidos.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0); // Cerrar la aplicación
                } else {
                    // Mostrar mensaje de error
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana de login
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
}
