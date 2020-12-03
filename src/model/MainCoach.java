package model;

public class MainCoach extends Coach implements Profitable{

	private int teamsExperience;
	private int wonChampionships;
	private double marketPrice;
	private double level;
	
	/**
	* Constructor for a main coach with all the information needed
	 * @param name, it's the employee's name 
	 * @param id, it's the employee's identification
	 * @param salary, it's the employee's salary
	 * @param experienceYears, experience in years of the coach
	 * @param teamsExperience, experience in number of teams as coach
	 * @param  wonChampionships, number of won championships in the coach career 
	*/
	public MainCoach(String name, String id, double salary, int experienceYears, int teamsExperience, int wonChampionships){
	
		super(name, id, salary, experienceYears);
		this.teamsExperience=teamsExperience;
		this.wonChampionships=wonChampionships;
		marketPrice = calculateMarketPrice();
		level = calculateLevel();
	}
	
	
	@Override
	public String toString(){
		String info="(Principal)\n";
		info += super.toString() + 
		"Número de equipos de experiencia: " + teamsExperience + "\n" +
		"Campeonatos ganados: " + wonChampionships + "\n" +
		"Precio de mercado: " + marketPrice + "\n" +
		"Nivel: " + level + "\n";
		return info;
	}
	
	@Override
	public double calculateMarketPrice(){
		double price=0;
		price = (super.getSalary()*10) + (super.getExperienceYears()*100) + (wonChampionships*50);
		return price;
	}
	
	@Override
	public double calculateLevel(){
		double level=0;
		level = 5 + wonChampionships/10;
		return level;
	}

}