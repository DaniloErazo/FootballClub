package model;

public class Player extends Employee{
	
	private String numberShirt;
	private double averageRating;
	private int numberGoals;
	private Position position;

	public Player(String name, String id, double salary, String shirt, double rating, int goals, Position position){
		super(name, id, salary);
		numberShirt=shirt;
		averageRating=rating;
		numberGoals=goals;
		this.position=position;
	}
	
	@Override
	public String toString(){
		String info="";
		info = super.toString() + 
		"Dorsal: " + numberShirt + "\n" +
		"Calificación promedio: " + averageRating + "\n" +
		"Número de goles marcados: " + numberGoals + "\n" +
		"Posición: " + position + "\n";
		return info;
	}


}