package model;

public class MainCoach extends Coach{

	private int teamsExperience;
	private int wonChampionships;
	
	public MainCoach(String name, String id, double salary, int experienceYears, int teamsExperience, int wonChampionships){
	
		super(name, id, salary, experienceYears);
		this.teamsExperience=teamsExperience;
		this.wonChampionships=wonChampionships;
	}
	
	
	@Override
	public String toString(){
		String info="(Principal)\n";
		info += super.toString() + 
		"Número de equipos de experiencia: " + teamsExperience + "\n" +
		"Campeonatos ganados: " + wonChampionships + "\n";
		return info;
	}

}