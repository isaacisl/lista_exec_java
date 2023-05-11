package lista_exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println();
			System.out.printf("Emplyoee #%d: %n", i + 1);
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			// Verifica se já existe algum ID igual.
			while (hasId(list, id)) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		
		System.out.print("Enter the employee id that will have salary increase : ");
		int idsalary  = sc.nextInt();
		
		// Integer pos = position(list, idsalary);
		Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
		
		if(emp == null) {
			System.out.println("This Id does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees: ");
		
		for(Employee e : list) {
			System.out.println(e);
		}
		
	
	}
	
	// Cria uma subclasse para pegar a posição do funcionario digitado, cas existir
	// Caso não existir ele retorna NULL
	public static Integer position(List<Employee> list, int id) {
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	// Cria uma função pra verificar se existe algum id igual
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
