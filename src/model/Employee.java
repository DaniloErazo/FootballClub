package model;

public abstract class Employee{

	private String name;
	private String id; 
	private double salary;
	private boolean status;
	
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