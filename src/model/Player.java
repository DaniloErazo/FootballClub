package model;

public class Player extends Employee implements Profitable{
	
	private String numberShirt;
	private double averageRating;
	private int numberGoals;
	private double marketPrice;
	private double level;
	
	//Relations
	private Position position;

	/**
	* Constructor for a player with all the information needed 
	 * @param name, it's the employee's name
	 * @param id, it's the employee's identification
	 * @param salary, it's the employee's salary
	 * @param shirt, it's the number of the player's shirt 
	 * @param rating, it's the average calification 
	 * @param goals, the number of goals scored 
	 * @param position, the position in which the player plays 
	*/
	public Player(String name, String id, double salary, String shirt, double rating, int goals, Position position){
		super(name, id, salary);
		numberShirt=shirt;
		averageRating=rating;
		numberGoals=goals;
		this.position=position;
		marketPrice = calculateMarketPrice();
		level = calculateLevel();
	}
	
	@Override
	public double calculateMarketPrice(){
		double price=0;
		if(position==Position.GOALKEEPER){
			price = (super.getSalary()*12) + (averageRating*150);
		} else if (position==Position.DEFENDER){
			price = (super.getSalary()*13) + (averageRating*125) + (numberGoals*100);
		} else if (position==Position.MIDFILDER){
			price = (super.getSalary()*14) + (averageRating*135) + (numberGoals*125);
		} else if (position==Position.STRIKER){
			price = (super.getSalary()*15) + (averageRating*145) + (numberGoals*150);
		}
		return price;
	}
	
	@Override
	public double calculateLevel(){
		double level=0;
		
		if(position==Position.GOALKEEPER){
			level = averageRating*0.9;
		} else if (position==Position.DEFENDER){
			level = averageRating*0.9 + numberGoals/100;
		} else if (position==Position.MIDFILDER){
			level = averageRating*0.9 + numberGoals/90;
		} else if (position==Position.STRIKER){
			level = averageRating*0.9 + numberGoals/80;
		}
		
		return level;
	}
	
	@Override
	public String toString(){
		String info="*************Jugador*************\n";
		info += super.toString() + 
		"Dorsal: " + numberShirt + "\n" +
		"Calificación promedio: " + averageRating + "\n" +
		"Número de goles marcados: " + numberGoals + "\n" +
		"Posición: " + position + "\n" + 
		"Precio de mercado: " + marketPrice + "\n" +
		"Nivel: " + level + "\n";
		return info;
	}


}