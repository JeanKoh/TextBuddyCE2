
public class Parser {
	//Possible commands types
		enum COMMAND_TYPE{
			COMMAND_ADD, COMMAND_DELETE, COMMAND_CLEAR, COMMAND_EXIT, COMMAND_DISPLAY,
			COMMAND_INVALID, COMMAND_SEARCH, COMMAND_SORT
		}
		public Parser(){
		}
		
		/**
		 * this operation determines which command type correspond to user input.
		 * 
		 * @param userInput entered by user
		 * @return command type
		 */
		COMMAND_TYPE checkCommandType(String userInput) { //parser
			if (userInput == null) {
				throw new Error("no inputs");
			}
			if (userInput.equals("add")) {
				return COMMAND_TYPE.COMMAND_ADD;
			} else if (userInput.equals("display")) {
				return COMMAND_TYPE.COMMAND_DISPLAY;
			} else if (userInput.equals("delete")) {
				return COMMAND_TYPE.COMMAND_DELETE;
			} else if (userInput.equals("clear")) {
				return COMMAND_TYPE.COMMAND_CLEAR;
			} else if (userInput.equals("exit")) {
				return COMMAND_TYPE.COMMAND_EXIT;
			} else if (userInput.equals("search")){
				return COMMAND_TYPE.COMMAND_SEARCH;
			} else if (userInput.equals("sort")){
				return COMMAND_TYPE.COMMAND_SORT;
			} else {
				return COMMAND_TYPE.COMMAND_INVALID;
			}
		}
	
}
