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
	public LineUp(String date, String chain){
		this.date=date;
		formation = stringToMatrix(chain);
	}
	
	public int[][] stringToMatrix(String chain){
		
		int[][] output = new int[LINEUP_ROWS][LINEUP_COLUMNS];
		
		int count = 0;
		for (int i=0 ; i<chain.length(); i++){
			char ch = chain.charAt(i);
			 if(ch == '-'){
				count ++;
			 }
		}
		
		return output;
	}
	
	public String matrixToString(){
		String lineUpString="";
		
		return lineUpString;
	}
	
	public void showMatrix(int[][] matrix){
		
	}
	
	/*public String toString(){
		String out = "";
		out+="****** LineUp*********"+
		date + "/n"+
		matrixToString() +
		//showMatrix();
		return out;
	}*/

}