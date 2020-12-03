package model;

public class AssistantCoach extends Coach{
	
	private boolean wasPlayer;
	private Skill skills;
	
	/**
	* Constructor for an assistant coach with all the information needed
	 * @param name, it's the employee's name 
	 * @param id, it's the employee's identification
	 * @param salary, it's the employee's salary
	 * @param experienceYears, experience in years of the coach
	 * @param wasPlayer, boolean for experience as a player 
	 * @param skills, special skills that the coach manages 
	*/
	public AssistantCoach(String name, String id, double salary, int experienceYears, boolean wasPlayer, Skill skills){
		super(name, id, salary, experienceYears);
		this.wasPlayer=wasPlayer;
		this.skills=skills;
	}
	
	@Override
	public String toString(){
		String info="(Asitente) \n";
		info += super.toString() + 
		"Experiencia como jugador: " + wasPlayer + "\n" +
		"Habilidades: " + skills;
		return info;
	}


}