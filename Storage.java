import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
	
	//possible messages
	private static final String MESSAGE_CREATE = "file is created";
	
	File file;
	

	/**
	 * this operation creates a new file object input name
	 * 
	 * @return	file created 
	 * @throws IOException when error occurs during creating new file
	 */
	public void createFile(String name)throws IOException { //storage
		file = new File(name);
		if (!file.exists()){
			file.createNewFile();
			System.out.println(MESSAGE_CREATE);	
		}
	}
	
		/**
		 * This operation saves the data into the file when user exits the program
		 * 
		 * @param file	file to be written into
		 * @throws IOException is thrown when errors occurs during writing
		 */
		public void exitAndSave(ArrayList<String> contents)throws IOException{
			if (contents.isEmpty()){
				return;
			}
			FileWriter writer = new FileWriter(file);
			BufferedWriter bWriter = new BufferedWriter(writer);
			for (int i =0;i <contents.size();i++) {
				bWriter.write((i+1)+". "+contents.get(i)+"\n");
			}
			bWriter.close();
		}
		
	}
