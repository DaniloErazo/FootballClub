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
				"(7) Mostrar info \n"+
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
			System.out.println("Gracias por usar MSC!");
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
			
			break;
		case 7:
			
			break;
		default:
			System.out.println("Error, opción no válida");
		
		}
	}
	
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
		
		position = (String)JOptionPane.showInputDialog(null,"Seleccione la posición que juega","Posiciones", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "GOALKEEPER","DEFENDER", "MILDFIELD", "STRICKER"},"Seleccione");
		
		newClub.addPlayer(name, id, salary, shirt, rating, goals, position);
		System.out.println("Jugador contratado");
		
	}
	
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
			/*while(more.equals("si")){
				type+= 
			}*/ //In case more than one skill is needed
			
		} else {
			int teamExperience=0;
			int won=0;
			
			System.out.println("Digite cuantos equipos ha dirigido");
			teamExperience=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Digite cuantos campeonatos ha ganado");
			won=sc.nextInt();
			sc.nextLine();
			
			newClub.addCoach(name, id, salary, experience, teamExperience, won);
			System.out.println("Entrenador contratado");
			
		}
	}
	
	public boolean verifyString(String ID){
		boolean accepted=false;
		try {
			Long.parseLong(ID);
			 accepted=true;
		} catch (NumberFormatException nfe){
			accepted=false;
		}
		return accepted;
	}
	
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
	
	
}