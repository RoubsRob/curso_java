package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class Functions {
	
	public static void printCSV(List<String[]> historico) {
		File csvFile = new File("operations.csv");
		try {
			
			String[][] employees = {
	                {"Man", "Sparkes", "msparkes0@springhow.com", "Engineering"},
	                {"Dulcinea", "Terzi", "dterzi1@springhow.com", "Engineering"},
	                {"Tamar", "Bedder", "tbedder2@springhow.com", "Legal"},
	                {"Vance", "Scouller", "vscouller3@springhow.com", "Sales"},
	                {"Gran", "Jagoe", "gjagoe4@springhow.com", "Business Development"}
	        };
			
			FileWriter fileWriter = new FileWriter(csvFile);
			//fileWriter.write("Teste");
			//fileWriter.write(line.toString());
			
			 for (String[] data : historico) { //trocar para employees para funcionar :( historico
		            StringBuilder line = new StringBuilder();
		            for (int i = 0; i < data.length; i++) { 	
		                line.append("\"");
		                line.append(data[i].replaceAll("\"","\"\""));
		                line.append("\"");
		                if (i != data.length - 1) {
		                    line.append(',');
		                }
		            }
		            line.append("\n");
		            fileWriter.write(line.toString());
		        }
			 	fileWriter.flush();
		        fileWriter.close();
		    }catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println("Não é possível exportar arquivo CSV!");
				e.printStackTrace();
		}
	}
}
