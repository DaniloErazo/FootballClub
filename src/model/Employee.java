package model;

public abstract class Employee{

	private String name;
	private String id; 
	private double salary;
	private boolean status;
	
	
	/**
	* Constructor for an employee with basic information, used in the sub classes
	 * @param name, it's the employee's name 
	 * @param id, it's the employee's identification
	 * @param salary, it's the employee's salary
	*/
	public Employee(String name, String id, double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
		status=true;
	}
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public void setStatus(boolean status){
		this.status=status;
	}
	
	/**
	 * Method that produces a String with the information of the employee
	 * @return info String with all the information
	 */
	public String toString(){
		String info="";
		info = "*************Empleado*************\n"+
		"Nombre: " + name + "\n" +
		"Identificación: " + id + "\n" + 
		"Salario: " + salary + "\n";
		return info;
	}
}