package model;

public class AssistantCoach extends Coach{
	
	private boolean wasPlayer;
	private Skill skills;
	
	public AssistantCoach(String name, String id, double salary, int experienceYears, boolean wasPlayer, Skill skills){
		super(name, id, salary, experienceYears);
		this.wasPlayer=wasPlayer;
		this.skills=skills;
	}

	public String toString(){
		String info="";
		info = super.toString() + 
		"Experiencia como jugador: " + wasPlayer + "\n" +
		"Habilidades: " + skills;
		return info;
	}


}