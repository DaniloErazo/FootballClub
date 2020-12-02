package model;

public class LineUp{
	
	public final static int LINEUP_ROWS = 10;
	public final static int LINEUP_COLUMNS = 7;
	private String date;
	private int[][] formation;
	private Tactics tactics;
	
	/**
	* This constructor 
	*/
	public LineUp(String date, String chain, Tactics tactics){
		this.date=date;
		this.tactics=tactics;
		formation = new int[LINEUP_ROWS][LINEUP_COLUMNS];
		formation = stringToMatrix(chain);
	}
	
	public int[][] stringToMatrix(String chain){
		String[] parts = chain.split("-");
		
		int size = parts.length;
		
		int[] parts2 = new int[size];
		for (int i=0; i<parts.length; i++){
			parts2[i] = Integer.parseInt(parts[i]);
		}
		
		int row = parts.length;
		
		int[][] output = new int[LINEUP_ROWS][LINEUP_COLUMNS];
		
		switch (row){
			case 3:
				output[2]= fillRow(parts2[0]);
				output[5]= fillRow(parts2[1]);
				output[8]= fillRow(parts2[2]);		
				break;
			case 4:
				output[2]= fillRow(parts2[0]);
				output[4]= fillRow(parts2[1]);
				output[6]= fillRow(parts2[2]);
				output[8]= fillRow(parts2[3]);
				break;
			case 5:
				output[0]= fillRow(parts2[0]);
				output[2]= fillRow(parts2[1]);
				output[4]= fillRow(parts2[2]);
				output[6]= fillRow(parts2[3]);
				output[8]= fillRow(parts2[4]);
				break;
			default:
			
		}
		return output;
	}
	
	public int[] fillRow(int players){
		
		int[] out = new int[7];
		
		int half = players/2;
		if(players%2==0){
			for (int i = 1; i <= half; i++) {
				out[3-i] = 1;
				out[3+i] = 1;
			}
		}else {
			out[3]=1;
			for (int i = 1; i <= half; i++) {
				out[3-i] = 1;
				out[3+i] = 1;
			}
		}
		
		return out;
	}

	public String matrixToString(){
		String lineUpString="";
		
		for (int i=0; i< formation.length; i++ ) {
		    int count=0;
			for (int j = 0; j < formation[0].length; j++) {
				if (formation[i][j]==1){
					count++;
				}
				
			}
			
			if (count!=0){
				lineUpString+=count + "-";
			}
			
		}
	
		return lineUpString;
	}
	
	public String showMatrix(int[][] matrix){
		String print ="";
		for (int i=0; i< matrix.length; i++ ) {
			for (int j = 0; j < matrix[0].length; j++) {
				print += matrix[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}
	
	
	public String toString(){
		String out = "";
		out+="****** Alineación*********\n"+
		"Fecha: " + date + "/n"+
		"Alineación: " + matrixToString() + "/n"+
		showMatrix(formation);
		
		return out;
	}
	


}