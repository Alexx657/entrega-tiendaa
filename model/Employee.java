package model;

import dao.Dao;
import dao.DaoImplJDBC;
import java.util.Scanner;
import main.Logable;
  
public class Employee extends Person implements Logable {
    private int employed;
    private Dao dao;

    public Employee() {
        this.dao = new DaoImplJDBC();
    }

    public Employee(Dao dao) {
        this.dao = dao;
    }

    public Employee(int employed, Dao dao) {
        this.employed = employed;
        this.dao = dao;
    }

    public boolean login(int employedId, String password) {
        dao.connect();

        Employee employee = dao.getEmployee(employedId, password);

        dao.disconnect();

        return employee != null;
    }

    public void login(Scanner scanner) {
        System.out.print("Introducela ID de empleado: ");
        int employedId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Introduce la contraseña: ");
        String password = scanner.nextLine();

        if (login(employedId, password)) {
            System.out.println("Login correcto.");
        } else {
            System.out.println("Login fallido.");
        }
    }

    public void setId(int id) {
        this.employed = id;
    }

    public void setName(String name) {
        // Implement the setName method
    }

	public void setPassword(String string) {
		// TODO Auto-generated method stub
		
	}
}
