package model;

public abstract class Coach extends Employee{
	
	private int experienceYears;
	
	/**
	* Constructor for a coach with basic information, used in the sub classes
	 * @param name, it's the employee's name 
	 * @param id, it's the employee's identification
	 * @param salary, it's the employee's salary
	 * @param experienceYears, experience in years of the coach
	*/
	public Coach(String name, String id, double salary, int experienceYears){
	
		super(name, id, salary);
		this.experienceYears= experienceYears;
	}
	
	
	public int getExperienceYears(){
		return experienceYears;
	}
	
	@Override
	public String toString(){
		String info = "*************Entrenador*************\n";
		info += super.toString() + 
		"Años de experiencia: " + experienceYears;
		return info;
	}


}