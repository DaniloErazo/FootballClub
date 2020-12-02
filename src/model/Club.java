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
		fillFacilities();
	}
	
	public String[][] getOffices(){
		return offices;
	}
	
	public String[][] getDressingA(){
		return dressingA;
	}
	
	public String[][] getDressingB(){
		return dressingB;
	}
	
	public void fillFacilities(){
		//Fill offices 
		for (int i=0; i< offices.length; i+=2) {
			for (int j = 0; j < offices[0].length; j+=2) {
				offices[i][j]="Disponible";
			}
		}
		
		for (int i=0; i< offices.length; i+=2) {
			for (int j = 1; j < offices[0].length; j+=2) {
				offices[i][j]="----------";
			}
		}
		
		for (int i=1; i< offices.length; i+=2) {
			for (int j = 0; j < offices[0].length; j++) {
				offices[i][j]="----------";
			}
		}
		
		//Fill dressing A
		for (int i=0; i< dressingA.length; i+=2) {
			for (int j = 0; j < dressingA[0].length; j+=2) {
				dressingA[i][j]="Disponible";
			}
		}
		
		for (int i=0; i< dressingA.length; i+=2) {
			for (int j = 1; j < dressingA[0].length; j+=2) {
				dressingA[i][j]="----------";
			}
		}
		
		for (int i=1; i< dressingA.length; i+=2) {
			for (int j = 0; j < dressingA[0].length; j++) {
				dressingA[i][j]="----------";
			}
		}
		
		//Fill dressingB
		for (int i=0; i< dressingB.length; i+=2) {
			for (int j = 0; j < dressingB[0].length; j+=2) {
				dressingB[i][j]="Disponible";
			}
		}
		
		for (int i=0; i< dressingB.length; i+=2) {
			for (int j = 1; j < dressingB[0].length; j+=2) {
				dressingB[i][j]="----------";
			}
		}
		
		for (int i=1; i< dressingB.length; i+=2) {
			for (int j = 0; j < dressingB[0].length; j++) {
				dressingB[i][j]="----------";
			}
		}
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
	public void addCoach (String name, String id, double salary, int experienceYears, int teamsExperience, int wonChampionships, String team){
		MainCoach ppalCoach = new MainCoach(name, id, salary, experienceYears, teamsExperience, wonChampionships);
		employees.add(ppalCoach);
		if(team.equals("Bridgets")){
			teamA.setMainCoach(ppalCoach);
		}else{
			teamB.setMainCoach(ppalCoach);
		}
		
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
	 * <b> Pos:</b> </br>
	 * @param id, it's the employee's identification to fire. id!= "", id!=null
	 */
	public void fireEmployee(String id){
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				employees.get(i).setStatus(false);
			}
		}
	}
	
	public String consultEmployee(String id){ //añadir a diagrama
		String info="";
		
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				info += employees.get(i).toString();
			}
		}
		
		return info;
	}
	
	public String consultTeam(int i){ //añadir a diagrama
		String info = "";
		if (i==1){
			info = teamA.toString();
		}else {
			info = teamB.toString();
		}
		
		return info;
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
	 * Method that checks if the given id corresponds to an employee<br>
	 * <b> pre: </b> employees is initialized and filled <br>  
	 * <b> pos: </b> <br>
	 * @param id it's the employee's identification to check existence. nickname!=null. nickname!="" <br>
	 * @return found which is true if the identification is found, false otherwise
	 */
	public boolean findId(String id){
		
		boolean found = false;
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				found=true;
			}
		}
		
		return found;
	}
	
	
	/**
	 * checkType, this method checks if the employee given id belongs to the type of employee required<br>
	 * <b> pre: </b> employees is initialized <br>  
	 * <b> pos: </b> <br>
	 * @param type is the type to be consulted, it's either 1, 2 or 3. 1 for player. 2 for assistant coach and 3 for coach. type &gt; 0 <br>
	 * @param id is the employee identification to check. id!=null, id!=""  
	 * @return typeFound if the playlist belongs to the given type it's true, otherwise is false 
	 */
	public boolean checkType(String id, int type){
		boolean typeFound=false;
		int index = 0;
		
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				index=i;
			}
		}
		
		if(type==1){
			if(employees.get(index) instanceof Player){
				typeFound=true;
			}
		}else if(type==2){
			if(employees.get(index) instanceof AssistantCoach){
				typeFound=true;
			}
		}else if (type==3){
			if(employees.get(index) instanceof MainCoach){
				typeFound=true;
			}
		}
		
		return typeFound;
	}
	
	
	/**
	 * teamAvailable, this method checks for the available space for players and assistants in a team<br>
	 * <b> pre: </b> the team is created <br>  
	 * <b> pos: </b> <br>
	 * @param team is the team name to be consulted. team!=null, team!="" 0 <br> 
	 * @return availables it's a boolean array size 2, in its first position saves if there's space
	 * for more players, and in the second for assistants
	 */
	public boolean[] teamAvailable(String team){
		boolean players=false;
		boolean assistants=false;
		boolean[] availables = new boolean[2];
		
		if(team.equals("Bridgets")){
			players=teamA.playerSpace();
			assistants=teamA.assistantSpace();
		}else{
			players=teamB.playerSpace();
			assistants=teamB.assistantSpace();
		}
		
		availables[0]=players;
		availables[1]=assistants;
		
		return availables;
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
				if(offices[i][j].equals("Disponible")){
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
		String employeeId="";
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				employeeId= employees.get(i).getId();
			}
		}
		
		boolean stop = false;
		for (int i=0; i< offices.length & !stop; i+=2) {
			for (int j = 0; j < offices[0].length & !stop; j+=2) {
				if(offices[i][j]=="Disponible"){
					offices[i][j]=employeeId;
					stop=true;
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
				if(dressingAux[i][j]=="Disponible"){
					count+=1;
				}
			}
		}
		return count>0;
	}
	
	/**
	 * verifyTeamtoDressing, this method checks if a player can be added to a dressing room according to the team</br>
	 * <b> Pre:</b> dressingA, dressingB, and employees are initialized</br>
	 * <b> Pos:</b> </br>
	 * @param dressing, it's the dressing room to check, 1 for dressingA, 2 for dressingB. dressing==(1 || 2)
	 * @param id it's the player's id to check 
	 * @return team true if the player can be added, false otherwise
	 */
	public boolean verifyTeamtoDressing(String id, int dressing){ //añadir a diagrama 
		
		boolean team = false;
		boolean team2 = false; 
		boolean team3 = false ;
		String employeeId = "";
		String[][] dressingAux;
		if(dressing==1){
			dressingAux=dressingA;
		}else {
			dressingAux=dressingB;
		}
		
		
		if(dressingAux[0][0]=="Disponible"){ //If the first position is "Disponible" it means that the dressing room is empty
			team = true; 
		}else { //if not, it compares if the team that the player in this position belongs to is the same to the one that the new player belongs to 
			
			for(int i=0; i<employees.size(); i++){
				String idCheck = employees.get(i).getId();
				if(idCheck.equals(dressingAux[0][0])){
					employeeId= employees.get(i).getId();
				}
			}
			
			team2 = teamA.findPlayer(employeeId); //check first team
			team3 = teamA.findPlayer(id);
			
			if(team2==true && team3==true){		//if not, check second team
				team = true;
			}else {
				team2 = teamB.findPlayer(employeeId);
				team3 = teamB.findPlayer(id);
			}
			
			if (team2==true && team3==true){
				team = true;
			}else {
				team=false;
			}
			
		}
		
		return team;
	}
	
	/**
	 * setInDressing, this method puts a player in an dressing room</br>
	 * <b> Pre:</b> dressingA, dressingB and employees are initialized. There's available indexes in dressingA or dressingB </br>
	 * <b> Pos:</b> dressingA or dressingB are updated</br>
	 * @param id,  it's the player identification. It does correspond to a player. id!=null, id!=""
	 * @param dressing, it's the dressing room to check, 1 for dressingA, 2 for dressingB. dressing==(1 || 2)
	 */
	public void setInDressing(String id, int dressing){
		String employeeId="";
		String[][] dressingAux;
		
		if(dressing==1){
			dressingAux=dressingA;
		}else {
			dressingAux=dressingB;
		}
		
		for(int i=0; i<employees.size(); i++){
			String idCheck = employees.get(i).getId();
			if(idCheck.equals(id)){
				employeeId= idCheck;
			}
		}
		
		boolean stop = false;
		for (int i=0; i< dressingAux.length & !stop; i+=2) {
			for (int j = 0; j < dressingAux[0].length & !stop; j+=2) {
				if(dressingAux[i][j]=="Disponible"){
					dressingAux[i][j]=employeeId;
					stop=true;
				}
			}
		}
		
		if(dressing==1){
			dressingA=dressingAux;
		}else {
			dressingB=dressingAux;
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
				print += dressingAux[i][j]+ "\t";
			}
			print += "\n";
		}

		return print;
	}
	
	public void addLineUp(String date, String formation, String tactics, String team){ //añadir a diagrama
		Tactics aTactics = Tactics.valueOf(tactics);
		
		if(team.equals("Bridgets")){
			teamA.addLineUp(date, formation, aTactics);
		}else{
			teamA.addLineUp(date, formation, aTactics);
		}
	}
	
	public String toString(){
		String info = "***********CLUB***********\n"; 
		info+= "Nombre: " + name + "\n" +
		"NIT: " + nit + "\n" +
		"Fecha de creación: " + creationDate + "\n" +
		"Bridgets: \n" + teamA.toString() + "\n" + 
		"Vulcano: \n" + teamB.toString()+ "\n";
		
		return info;
		
	}
	
	
	
	
	

}