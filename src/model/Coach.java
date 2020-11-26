package model;

public abstract class Coach extends Employee{
	
	private int experienceYears;
	
	public Coach(String name, String id, double salary, int experienceYears){
	
		super(name, id, salary);
		this.experienceYears= experienceYears;
	}
	
	
	@Override
	public String toString(){
		String info = "";
		info = super.toString() + 
		"Años de experiencia: " + experienceYears;
		return info;
	}


}