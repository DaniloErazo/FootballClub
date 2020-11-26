package model;
import model.*;
import java.util.ArrayList;

public class Club{
	
	private String name;
	private String nit;
	private String creationDate;
	private String[][] offices;
	private String[][] dressingA;
	private String[][] dressingB;
	
	//Relations
	
	private Team teamA;
	private Team teamB;
	private ArrayList<Employee> employees;
	
	/**
	* Constructor for creating a Club with its name and its teams' names 
	*/
	public Club(String name, String nit, String date, String A, String B){
		this.name=name;
		this.nit=nit;
		creationDate=date;
		offices = new String[6][6];
		dressingA= new String[7][6];
		dressingB= new String[7][7];
		teamA = new Team(A);
		teamB = new Team(B);
		employees = new ArrayList<Employee>();
	}
	
	/**
	 * addPlayer, this method hires a player for the club </br>
	 * <b> Pre:</b> employees is initialized </br>
	 * <b> Pos:</b> employees has a new object in the first empty found position </br>
	 * @param name, it's the player's name. name!= "", name!=null
	 * @param id,  it's the player's identification. id!="", id!=null
	 * @param salary, player's assigned salary. salary &gt 0
	 * @param shirt, player's shirt number. shirt!= "", shirt!=null
	 * @param rating, player's average calification. rating &gt 0
	 * @param goals, player's scored goals. goals &gt 0
	 * @param position, player's position in the field. position!= "", position!=null, 
	 * position belongs to one of the enum Position
	 */
	public void addPlayer(String name, String id, double salary, String shirt, double rating, int goals, String position){
		Position aPosition = Position.valueOf(position);
		Player player = new Player(name, id, salary, shirt, rating, goals, aPosition); 
		employees.add(player);
		
	}
	
	/**
	 * addCoach, this method hires a main coach for the club </br>
	 * <b> Pre:</b> employees is initialized </br>
	 * <b> Pos:</b> employees has a new object in the first empty found position </br>
	 * @param name, it's the coach name. name!= "", name!=null
	 * @param id,  it's the coach identification. id!="", id!=null
	 * @param salary, coach assigned salary. salary &gt 0
	 * @param experienceYears, coach experience in years. experienceYears &gt 0
	 * @param teamsExperience, number of teams that the coach has managed. teamsExperience &gt 0
	 * @param wonChampionships, number of championships won by the coach. wonChampionships &gt 0
	 */
	public void addCoach (String name, String id, double salary, int experienceYears, int teamsExperience, int wonChampionships){
		MainCoach ppalCoach = new MainCoach(name, id, salary, experienceYears, teamsExperience, wonChampionships);
		employees.add(ppalCoach);
	}
	
	/**
	 * addCoach, this method hires an assistant coach for the club </br>
	 * <b> Pre:</b> employees is initialized </br>
	 * <b> Pos:</b> employees has a new object in the first empty found position </br>
	 * @param name, it's the coach name. name!= "", name!=null
	 * @param id,  it's the coach identification. id!="", id!=null
	 * @param salary, coach assigned salary. salary &gt 0
	 * @param experienceYears, coach experience in years. experienceYears &gt 0
	 * @param wasPlayer, if the coach was a player it's true, otherwise false
	 * @param skill, contains the coach special skill. It belongs to enum Skill. skill!="", skill!=null
	 */
	public void addCoach (String name, String id, double salary, int experienceYears, boolean wasPlayer, String skill){
		Skill aSkill = Skill.valueOf(skill);
		AssistantCoach sndCoach = new AssistantCoach(name, id, salary, experienceYears, wasPlayer, aSkill);
		employees.add(sndCoach);
	}
	
	/**
	 * fireEmployee, this method fires an employee  </br>
	 * <b> Pre:</b> employees is initialized and filled </br>
	 * <b> Pos:</b> employees has one object less </br>
	 * @param id, it's the employee's identification to fire. id!= "", id!=null
	 */
	public void fireEmployee(String id){
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				employees.remove(i);
			}
		}
	}
	
	/**
	 * playerToTeam, this method assigns a player to a team  </br>
	 * <b> Pre:</b> employees is initialized and filled. </br>
	 * <b> Pos:</b>  </br>
	 * @param id, it's the player's identification. It does correspond to a player. id!= "", id!=null
	 * @param team, it's the name of the team that is going to have a new player. The team exists. team!= "", team!=null
	 */
	public void playerToTeam(String id, String team){
		
		int index=0;
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				index=i;
			}
		}
		
		Player playerTeam = (Player)employees.get(index);
		
		if(teamA.getName().equals(team)){
			teamA.addPlayer(playerTeam);
		}else{
			teamB.addPlayer(playerTeam);
		}
		
	}
	
	/**
	 * coachToTeam, this method assigns an assistant coach to a team  </br>
	 * <b> Pre:</b> employees is initialized and filled. </br>
	 * <b> Pos:</b>  </br>
	 * @param id, it's the coach identification. It does correspond to an assistant coach. id!= "", id!=null
	 * @param team, it's the name of the team that is going to have a new coach. The team exists. team!= "", team!=null
	 */
	public void coachToTeam(String id, String team){
		
		int index=0;
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				index=i;
			}
		}
		
		AssistantCoach assitantTeam = (AssistantCoach)employees.get(index);
		
		if(teamA.getName().equals(team)){
			teamA.addCoach(assitantTeam);
		}else{
			teamB.addCoach(assitantTeam);
		}
		
	}
	
	/**
	 * officeSpace, this method informs if there's space available in the offices</br>
	 * <b> Pre:</b> offices is initialized</br>
	 * <b> Pos:</b> </br>
	 * @return it returns true if there's space, false otherwise
	 */
	public boolean officeSpace(){
		int count=0;
		for (int i=0; i< offices.length; i+=2) {
			for (int j = 0; j < offices[0].length; j+=2) {
				if(offices[i][j]==null){
					count+=1;
				}
			}
		}
		return count>0;
	}
	
	/**
	 * setInOffice, this method puts an employee in an office</br>
	 * <b> Pre:</b> offices and employees are initialized. There's available indexes in offices</br>
	 * <b> Pos:</b> offices has an index filled</br>
	 * @param id,  it's the employee identification. id!=null, id!=""
	 */
	public void setInOffice(String id){
		String employeeName="";
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				employeeName= employees.get(i).getName();
			}
		}
		
		for (int i=0; i< offices.length; i+=2) {
			for (int j = 0; j < offices[0].length; j+=2) {
				if(offices[i][j]==null){
					offices[i][j]=employeeName;
				}
			}
		}
	}
	
	
	/**
	 * dressingSpace, this method informs if there's space available in a dressing room</br>
	 * <b> Pre:</b> dressingA and dressingB are initialized</br>
	 * <b> Pos:</b> </br>
	 * @param dressing, it's the dressing room to check, 1 for dressingA, 2 for dressingB. dressing==(1 || 2)
	 * @return it returns true if there's space, false otherwise
	 */
	public boolean dressingSpace(int dressing){
		String[][] dressingAux;
		if(dressing==1){
			dressingAux=dressingA;
		}else {
			dressingAux=dressingB;
		}
		int count=0;
		for (int i=0; i< dressingAux.length; i+=2) {
			for (int j = 0; j < dressingAux[0].length; j+=2) {
				if(dressingAux[i][j]==null){
					count+=1;
				}
			}
		}
		return count>0;
	}
	
	/**
	 * setInDressing, this method puts a player in an dressing room</br>
	 * <b> Pre:</b> dressingA, dressingB and employees are initialized. There's available indexes in dressingA or dressingB </br>
	 * <b> Pos:</b> dressingA or dressingB have an index filled</br>
	 * @param id,  it's the player identification. It does correspond to a player. id!=null, id!=""
	 * @param dressing, it's the dressing room to check, 1 for dressingA, 2 for dressingB. dressing==(1 || 2)
	 */
	public void setInDressing(String id, int dressing){
		String employeeName="";
		String[][] dressingAux;
		
		if(dressing==1){
			dressingAux=dressingA;
		}else {
			dressingAux=dressingB;
		}
		
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				employeeName= employees.get(i).getName();
			}
		}
		
		for (int i=0; i< dressingAux.length; i+=2) {
			for (int j = 0; j < dressingAux[0].length; j+=2) {
				if(dressingAux[i][j]==null){
					dressingAux[i][j]=employeeName;
				}
			}
		}
	}
	
	
	/**
	 * showOffice, this method puts the offices content in a String</br>
	 * <b> Pre:</b> offices is initialized</br>
	 * <b> Pos:</b> </br>
	 * @return print it returns a String with the information of how the offices are organized 
	 */
	public String showOffice() {
		String print ="";
		
		for (int i=0; i< offices.length; i++ ) {
			for (int j = 0; j < offices[0].length; j++) {
				print += offices[i][j] + "\t";
			}
			print += "\n";
		}

		return print;
	}
	
	/**
	 * showDressing, this method puts the dressing room content in a String</br>
	 * <b> Pre:</b> dressingA and dressingB are initialized</br>
	 * <b> Pos:</b> </br>
	 * @param dressing it's the dressing room to check, 1 for dressingA, 2 for dressingB. dressing==(1 || 2)
	 * @return print it returns a String with the information of the selected dressing room 
	 */
	public String showDressing(int dressing) {
		String print ="";
		String[][] dressingAux;
		
		if(dressing==1){
			dressingAux=dressingA;
		}else {
			dressingAux=dressingB;
		}
		
		for (int i=0; i< dressingAux.length; i++ ) {
			for (int j = 0; j < dressingAux[0].length; j++) {
				print += dressingAux[i][j] + "\t";
			}
			print += "\n";
		}

		return print;
	}
	
	
	
	
	

}