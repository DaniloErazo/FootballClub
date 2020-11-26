package model;

public class Team{

	private String name;
	
	//Relations
	
	private MainCoach mainCoach;
	private AssistantCoach[] assistants;
	private Player[] players;
	private LineUp line;
	private int currentPlayers;
	private int currentAssistants;

	public Team(String name){
		this.name=name;
		currentPlayers=0;
		players = new Player[25];
		assistants = new AssistantCoach[3];
	}
	
	public void addLineUp(String date, String chain){
		
		LineUp line = new LineUp(date, chain);
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
		"Entrenador principal: " + mainCoach.getName() + "\n" + playersAndAssistants();
		return info;
	}
	
	/**
	 * Method that produces a String with the names of all the players and assistant coaches
	 * @return info String with the mentioned names 
	 */
	public String playersAndAssistants(){
		
		String playerAndAssistantInfo = "Entrenadores asistentes: \n";
		
		for (int i=0; i<players.length; i++){
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
	

}