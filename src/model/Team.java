package model;
import java.util.ArrayList;

public class Team{

	private String name;
	
	//Relations
	
	private MainCoach mainCoach;
	private AssistantCoach[] assistants;
	private Player[] players;
	private ArrayList<LineUp> line;
	private int currentPlayers;
	private int currentAssistants;

	public Team(String name){
		this.name=name;
		currentPlayers=0;
		players = new Player[25];
		assistants = new AssistantCoach[3];
		line = new ArrayList<LineUp>();
	}
	
	public void addLineUp(String date, String chain, Tactics tactics){
		LineUp newLine = new LineUp(date, chain, tactics);
		line.add(newLine);
	}
	
	public void setMainCoach(MainCoach ppal){
		mainCoach=ppal;
	}
	
	public String getName(){
		return name;
	}
	
	
	/**
	 * playerSpace, this method informs if there's space for new players</br>
	 * <b> Pre:</b> players is initialized</br>
	 * <b> Pos:</b> </br>
	 * @return it returns true if there's space, false otherwise
	 */
	public boolean playerSpace(){
		return currentPlayers<players.length;
	}
	
	/**
	 * assistantSpace, this method informs if there's space for new assistant coaches</br>
	 * <b> Pre:</b> assistants is initialized</br>
	 * <b> Pos:</b> </br>
	 * @return it returns true if there's space, false otherwise
	 */
	public boolean assistantSpace(){
		return currentAssistants<assistants.length;
	}
	
	/**
	 * addPlayer, this method adds a player to the team</br>
	 * <b> Pre:</b> players is initialized and has empty indexes </br>
	 * <b> Pos:</b> players has a new object in the first empty found position. currentPlayers is incremented by one</br>
	 * @param newPlayer, it's the new player to add
	 */
	public void addPlayer(Player newPlayer){
		for(int i=0; i<players.length; i++){
			if(players[i]==null){
				players[i]=newPlayer;
			}
		}
		currentPlayers++;
	}
	
	/**
	 * findPlayer, this method checks if a player belongs to the team</br>
	 * <b> Pre:</b> players is initialized and filled</br>
	 * <b> Pos:</b> </br>
	 * @param id, it's the player's id to check 
	 * @return found, which is true if the player belongs to, false otherwise
	 */
	public boolean findPlayer(String id){ //añadir a diagrama 
		boolean found = false; 
		for(int i=0; i<players.length; i++){
			if(players[i].getId().equals(id)){
				found = true;
			}
		}
		return found;
	}
	
	/**
	 * addCoach, this method adds a coach to the team</br>
	 * <b> Pre:</b> assistants is initialized and has empty indexes </br>
	 * <b> Pos:</b> assistants has a new object in the first empty found position. currentAssistants is incremented by one</br>
	 * @param newCoach, it's the new coach to add
	 */
	public void addCoach(AssistantCoach newCoach){
		for(int i=0; i<assistants.length; i++){
			if(assistants[i]==null){
				assistants[i]=newCoach;
			}
		}
		currentAssistants++;
	}
	
	/**
	 * Method that produces a String with all the information of a team
	 * @return info String with the mentioned information
	 */
	public String toString(){
		String info="";
		info = "*************Equipo*************\n" + 
		"Entrenador principal: " + mainCoach.getName() + "\n" + playersAndAssistants()+
		"Alineaciones: \n " + allLines();
		return info;
	}
	
	/**
	 * Method that produces a String with the names of all the players and assistant coaches
	 * <b> Pre:</b> assistants and players are initialized</br>
	 * <b> Pos:</b> </br>
	 * @return playerAndAssistantInfo String with the mentioned names 
	 */
	public String playersAndAssistants(){
		
		String playerAndAssistantInfo = "Entrenadores asistentes: \n";
		
		for (int i=0; i<assistants.length; i++){
			if(assistants[i]!=null){
				playerAndAssistantInfo += assistants[i].getName() + "\n";
			}
		}
		
		playerAndAssistantInfo += "Jugadores:\n";
		
		for (int i=0; i<players.length; i++){
			if(players[i]!=null){
				playerAndAssistantInfo += players[i].getName() + "\n";
			}
		}
		
		return playerAndAssistantInfo;
		
	}
	
	/**
	 * Method that produces a String with the information of all the formations added
	 * <b> Pre:</b> line is initialized</br>
	 * <b> Pos:</b> </br>
	 * @return lineInfo String with the information of each formation
	 */
	public String allLines(){ //Añadir a diagrama 
		String lineInfo="";
		
		for (int i=0; i<line.size(); i++){
			if(line.get(i)!=null){
				lineInfo += line.get(i).toString() + "\n";
			}
		}
		
		return lineInfo;
	}
	

}