package ui;
import model.Club;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main{
	
	private Club newClub;
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		
		Main ppal = new Main();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
		
		
		
	}
	
	/**
	 * Constructor that creates one object of the Club class in order to 
	 * initialize the application, includding name, nit, foundation date and its teams names 
	 */
	public Main(){
		newClub= new Club("Club Los Olivos", "800.197.268-4", "12/10/1979", "Bridgets", "Vulcano");
	}
	
	/**
	 * showMenu is a method that shows the main menu for the application
	 * with the main functions
	 * @return option which is the option selected by the user 
	 */
	public int showMenu() {
		int option=0;
		
		System.out.println(
				"Menú principal, seleccione una opción\n" +
				"(1) Contratar empleado \n" +
				"(2) Despedir empleado \n" +
				"(3) Añadir jugador a equipo \n"+
				"(4) Añadir entrenador asistente a equipo \n" +
				"(5) Ubicar empleado en las oficinas \n"+
				"(6) Ubicar jugador en camerinos \n" + 
				"(7) Añadir alineación a equipo \n"+
				"(8) Consultar información \n"+
				"(0) Para salir"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	/**
	 * executeOperation is a method that executes the function according to the main menu
	 *@param operation is the function chosen by the user in the main menu  
	 */
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("¡Hasta pronto!");
			break;
		case 1:
			hireEmployee();
			break;
		case 2:
			fireEmployee();
			break;
		case 3:
			playertoTeam();
			break;

		case 4:
			coachToTeam();
			break;
		case 5:
			setInOffice();
			break;
		case 6:
			setInDressing();
			break;
		case 7:
			addLine();
			break;
		case 8:
			consult();
			break;
		default:
			System.out.println("Error, opción no válida");
		
		}
	}
	
	/**
	 * hireEmployee is a method that asks for the necessary information to hire a new employee, 
	 * it validates accurate inputs
	 */
	public void hireEmployee(){
		String name="";
		String id="";
		double salary=0;
		
		System.out.println("Digite el nombre del empleado");
		name=sc.nextLine();
		
		System.out.println("Digite la identificación");
		id=sc.nextLine();
		
		System.out.println("Digite el salario asignado");
		salary=sc.nextDouble();
		
		if(newClub.findId(id)){
			System.out.println("La identificación ingresada ya se encuentra registrada, intente de nuevo");
		}else if(!verifyString(id)){
			System.out.println("La identificación solo puede contener números");
		} else {
			int option=0;
			System.out.println("¿Qué tipo de empleado desea contratar? 1 para jugador, 2 para entrenador");
			option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
				case 1: 
					hirePlayer(name, id, salary);
					break;
				case 2:
					hireCoach(name, id, salary);
					break;
				default:
				System.out.println("Error, opción no válida");
			}
			
		}
	}
	
	/**
	 * hirePlayer is a method that asks for the necessary information to hire a new player
	 * @param name, it's the employee's name 
	 * @param id, it's the employee's identification
	 * @param salary, it's the employee's salary 
	 */
	public void hirePlayer(String name, String id, double salary){
		String shirt="";
		double rating=0;
		int goals=0;
		String position="";
		
		System.out.println("Digite el número de camiseta");
		shirt=sc.nextLine();
		
		System.out.println("Digite la calificación promedio del jugador");
		rating=sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Digite el número de goles marcados");
		goals=sc.nextInt();
		sc.nextLine();
		
		position = (String)JOptionPane.showInputDialog(null,"Seleccione la posición que juega","Posiciones", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "GOALKEEPER","DEFENDER", "MIDFIELDER", "STRIKER"},"Seleccione");
		
		newClub.addPlayer(name, id, salary, shirt, rating, goals, position);
		System.out.println("Jugador contratado");
		
	}
	
	/**
	 * hireCoach is a method that asks for the necessary information to hire a new coach, either assistant or main coach
	 * @param name, it's the employee's name 
	 * @param id, it's the employee's identification
	 * @param salary, it's the employee's salary 
	 */
	public void hireCoach(String name, String id, double salary){
		String type="";
		int experience=0;
		
		System.out.println("Digite los años de experiencia");
		experience=sc.nextInt();
		sc.nextLine();
		
		type = (String)JOptionPane.showInputDialog(null,"Tipo de entrenador","Entrenadores", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Asistente","Principal"},"Seleccione");
		
		if(type.equals("Asistente")){
			String player="";
			boolean player2=false;
			String skill="";
			
			System.out.println("¿Fue jugador profesional? Si/No" );
			player=sc.nextLine().toLowerCase();
			if(player.equals("si")){
				player2=true;
			}else if (player.equals("no")){
				player2=false;
			}
			
			skill = (String)JOptionPane.showInputDialog(null,"Seleccione habilidad","Habilidades", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "OFFENSIVE","DEFFENSIVE", "CONTROLLER", "LAB_PLAYS"},"Seleccione");
			
			newClub.addCoach(name, id, salary, experience, player2, skill);
			System.out.println("Asistente contratado");
			
		} else {
			int teamExperience=0;
			int won=0;
			
			System.out.println("Digite cuantos equipos ha dirigido");
			teamExperience=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Digite cuantos campeonatos ha ganado");
			won=sc.nextInt();
			sc.nextLine();
			
			String team = (String)JOptionPane.showInputDialog(null,"Seleccione equipo","Equipos", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Bridgets","Vulcano"},"Seleccione");
			
			newClub.addCoach(name, id, salary, experience, teamExperience, won, team);
			System.out.println("Entrenador principal contratado en el equipo " + team);
			
		}
	}
	
	/**
	 * verifyString is a method that validates if a String only contains numbers
	 * @param id, it's the String that is going to be checked 
	 * @return accepted, which is true if the String only has numbers, false otherwise 
	 */
	public boolean verifyString(String id){
		boolean accepted=false;
		try {
			Long.parseLong(id);
			 accepted=true;
		} catch (NumberFormatException nfe){
			accepted=false;
		}
		return accepted;
	}
	
	/**
	 * fireEmployee is a method that asks for the identification of an employee to be fired,
	 * it validates accurate input 
	 */
	public void fireEmployee(){
		String id="";
		
		System.out.println("Digite la identificación del empleado a despedir");
		id=sc.nextLine();
		
		if(!newClub.findId(id)){
			System.out.println("Identificación no encontrada, intente de nuevo");
		}else {
			newClub.fireEmployee(id);
			System.out.println("Empleado despedido");
		}
		
		
	}
	
	/**
	 * playertoTeam is a method that assigns a player to a team through their identification, 
	 * it validates space in the team and the identification
	 */
	public void playertoTeam(){
		String id="";
		String team="";
		
		System.out.println("Digite la identificación del jugador a asignar");
		id=sc.nextLine();
		
		team = (String)JOptionPane.showInputDialog(null,"Seleccione equipo","Equipos", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Bridgets","Vulcano"},"Seleccione");
		boolean[] aux = newClub.teamAvailable(team);
		
		if(!newClub.findId(id)){
			System.out.println("Identificación no encontrada, intente de nuevo");
		}else if (!newClub.checkType(id, 1)){
			System.out.println("La identificación no corresponde a un jugador");
		}else if (!aux[0]){
			System.out.println("No hay más espacio en la plantilla de este equipo");
		}else {
			newClub.playerToTeam(id, team);
			System.out.println("Jugador añadido");
		}
	}
	
	/**
	 * coachToTeam is a method that assigns an assistant coach to a team through their identification, 
	 * it validates space in the team and the identification
	 */
	public void coachToTeam(){
		String id="";
		String team="";
		
		System.out.println("Digite la identificación del entrenador a asignar");
		id=sc.nextLine();
		
		team = (String)JOptionPane.showInputDialog(null,"Seleccione equipo","Equipos", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Bridgets","Vulcano"},"Seleccione");
		boolean[] aux = newClub.teamAvailable(team);
		
		if(!newClub.findId(id)){
			System.out.println("Identificación no encontrada, intente de nuevo");
		}else if (!newClub.checkType(id, 2)){
			System.out.println("La identificación no corresponde a un entrenador asistente");
		}else if (!aux[1]){
			System.out.println("No hay espacio para más asistentes en este equipo");
		}else {
			newClub.coachToTeam(id, team);
			System.out.println("Entrenador añadido");
		}
		
	}
	
	/**
	 * setInOffice is a method that assigns an office to a coach, it validates space in the office and the given identification
	 */
	public void setInOffice(){
		String id="";
		
		System.out.println("Digite la identificación del entrenador para asignar oficina");
		id=sc.nextLine();
		
		if(!newClub.findId(id)){
			System.out.println("Identificación no encontrada, intente de nuevo");
		}else if (!newClub.checkType(id, 2)&& !newClub.checkType(id, 3)){
			System.out.println("La identificación no corresponde a un entrenador asistente o principal");
		}else if (!newClub.officeSpace()){
			System.out.println("Oficina llena");
		}else {
			newClub.setInOffice(id);
			System.out.println(newClub.showOffice());
		}
	}
	
	/**
	 * setInOffice is a method that assigns a player to a dressing room, it validates space in the dressing room and the given identification
	 */
	public void setInDressing(){
		String id="";
		int dressing = 0;
		System.out.println("Digite la identificación del jugador para asignar ubicación en camerino");
		id=sc.nextLine();
		
		System.out.println("Digite el camerino, 1 para el camerino 6x7, 2 para el camerino 7x7");
		dressing=sc.nextInt();
		sc.nextLine();
		
		if(!newClub.findId(id)){
			System.out.println("Identificación no encontrada, intente de nuevo");
		}else if (!newClub.checkType(id, 1)){
			System.out.println("La identificación no corresponde a un jugador");
		}else if (!newClub.dressingSpace(dressing)){
			System.out.println("Camerino lleno");
		}else if (!newClub.verifyTeamtoDressing(id, dressing)){
			System.out.println("El camerino está asignado a un equipo diferente");
		}else {
			newClub.setInDressing(id, dressing);
			System.out.println(newClub.showDressing(dressing));
		}
	}
	
	/**
	 * addLine is a method that asks for the necessary information to add a line up to a team, 
	 * it validates accurate inputs
	 */
	public void addLine(){
		String date="";
		String formation="";
		String tactic="";
		String team="";
		
		System.out.println("Digite la fecha asignada para la formación");
		date=sc.nextLine();
		
		System.out.println("Digite la formación separada por - (Ej: 4-4-2)");
		formation=sc.nextLine();
		
		String[] parts = formation.split("-");
		
		int size = parts.length;
		
		int[] parts2 = new int[size];
		int count = 0;
		for (int i=0; i<parts.length; i++){
			parts2[i] = Integer.parseInt(parts[i]);
			count+=parts2[i];
		}
		
		if(count>10 || count<10){
			System.out.println("Formación no válida, debe contener 10 jugadores");
		} else if (size>5){
			System.out.println("Formación no válida, no puede contener más de 5 posiciones");
		}
		else {
			team = (String)JOptionPane.showInputDialog(null,"Seleccione equipo","Equipos", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Bridgets","Vulcano"},"Seleccione");
		
			tactic = (String)JOptionPane.showInputDialog(null,"Seleccione táctica","Tácticas", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "POSSESSION","COUNTERATTACK", "HIGH_PRESSURE", "DEFAULT"},"Seleccione");
			
			newClub.addLineUp(date, formation, tactic, team);
		}
		
		
		
	}
	
	/**
	 * consult is a method that shows the menu of consults and executes the chosen one
	 */
	public void consult(){
		System.out.println(
				"Menú de consultas, seleccione una opción\n" +
				"(1) Acceder a la información de un empleado \n" +
				"(2) Consultar información de un equipo \n" +
				"(3) Desplegar toda la información del Club  \n"+
				"(4) Consultar camerinos \n" +
				"(5) Consultar oficinas \n"+
				"(0) Para salir"
				);
		int option= sc.nextInt();
		sc.nextLine();
		
		switch(option){
			case 1: 
			System.out.println("Digite la identificación del empleado");
			String id=sc.nextLine();
			
			if(!newClub.findId(id)){
				System.out.println("Identificación no encontrada, intente de nuevo");
			} else {
				System.out.println(newClub.consultEmployee(id));
			}
			break;
			
			case 2:
			int chose = 0 ;
			String team = (String)JOptionPane.showInputDialog(null,"Seleccione equipo","Equipos", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Bridgets","Vulcano"},"Seleccione");
			if (team.equals("Bridgets")){
				chose = 1;
			}else{
				chose = 2; 
			}
			System.out.println(newClub.consultTeam(chose));
			break;
			
			case 3:
			System.out.println(newClub.toString());
			break;
			
			case 4:
			System.out.println("Camerino 6x7 \n");
			System.out.println(newClub.showDressing(1));
			
			System.out.println("Camerino 7x7 \n");
			System.out.println(newClub.showDressing(2));
			break;
			
			case 5:
			System.out.println(newClub.showOffice());
			break;
			
			default:
			System.out.println("Opción no válida");
		}
	}
	
}