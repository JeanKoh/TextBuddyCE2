import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Logic {

	//List of possible messages

	private static final String MESSAGE_ADD = "added to %1$s: \"%2$s\"";
	private static final String MESSAGE_DELETED = "deleted from %1$s: \"%2$s\"";
	private static final String MESSAGE_CLEAR = "all content deleted from %1$s";
	private static final String MESSAGE_EMPTY = "content is empty";
	private static final String MESSAGE_SORTED = "content is sorted";

	//List of possible errors
	private static final String ERROR_NO_COMMAND = "no such command";
	private static final String ERROR_NO_SUCH_INDEX = "no such index";
	private static final String ERROR_NO_STATEMENT = "no such statement";

	//This arraylist will be used to store data for the file
	private static ArrayList<String> contents;

	
	private static String fileName = "";
	UI ui;
	Storage storage;
	Parser parser;

	public Logic(String[] args){
		contents = new ArrayList<String>();
		String name = Arrays.toString(args);
		fileName= name.substring (1, name.length()-1);
		ui = new UI (fileName);
		parser = new Parser();
		storage = new Storage();
	}

	public void run() {
		ui.printWelcomeMessage();
		try {
			storage.createFile(fileName);
		} catch (IOException error) {
			error.printStackTrace();
		}
		runInput();
	}
	/**
	 * This operation determines which command to run base on user input
	 * 
	 * @param file is the newly created file named by the user
	 */
	public void runInput() {
		System.out.print("command: ");
		String command = ui.scanCommand();
		while (!command.equals("exit")){ //logic
			Parser.COMMAND_TYPE commandType = parser.checkCommandType(command);
			switch(commandType){
			case COMMAND_ADD:
				add(ui.scanLine());
				break; 
			case COMMAND_DELETE:
				delete(ui.scanInt());
				break;
			case COMMAND_DISPLAY:
				ui.display(contents);
				break;
			case COMMAND_CLEAR:
				clear();
				break;
			case COMMAND_SORT:
				sortByAlpha();
				break;
			default:
				ui.scanLine();
				ui.printMessage(ERROR_NO_COMMAND);
			}
			System.out.print("command: ");
			command = ui.scanCommand();
		}
		try {
			storage.exitAndSave(contents);
		} catch (IOException error) {
			System.out.println(error);
		}
	}

	/**
	 * this operation adds the string into an array list
	 * 
	 * @param statement to be added in
	 */
	public void add(String statement) {
		if (statement == ""){
			System.out.println(ERROR_NO_STATEMENT);
			return;
		} else {
			statement = statement.substring(1,statement.length());
			contents.add(statement);
			String message = String.format(MESSAGE_ADD, fileName, statement);
			ui.printMessage(message);
		}
	}

	/**
	 * this operation deletes the statement corresponding to the given index
	 * 
	 * @param num index to be deleted
	 */
	public void delete(int num) {
		if (num>contents.size()) {
			System.out.println(ERROR_NO_SUCH_INDEX);
		} else {
			ui.printMessage(String.format(MESSAGE_DELETED,fileName,contents.get(num-1)));
			contents.remove(num-1);
		}
	}

	public void clear() { //logic
		contents.clear();
		System.out.println(String.format(MESSAGE_CLEAR,fileName));
	}
	
	public ArrayList<String> display(){
		return ui.display(contents);
	}
	
	public String sortByAlpha(){
		if (contents.isEmpty()){
			return MESSAGE_EMPTY;
		} else {
			Collections.sort(contents);
			return MESSAGE_SORTED;
		}
	}


}
