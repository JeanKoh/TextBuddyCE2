
/**
 * This class is used to store and retrieve statements from a file
 * It is assumed that statement numbering will be dynamic
 * File will only be saved after the program is exited
 * File will be overwritten if there is an existing file with the same name.
 * The comment format is given by the example interaction below:

		Welcome to TextBuddy. mytextfile.txt is ready for use
		command: add little brown fox
		added to mytextfile.txt: "little brown fox"
		command: display
		1. little brown fox
		command: add jumped over the moon
		added to mytextfile.txt: "jumped over the moon"
		command: display
		1. little brown fox
		2. jumped over the moon
		command: delete 2
		deleted from mytextfile.txt: "jumped over the moon"
		command: display
		1. little brown fox
		command: clear
		all content deleted from mytextfile.txt
		command: display
		mytextfile.txt is empty
		command: exit
 * 
 * @author Koh Ling Ling Jean
 *
 */

public class TextBuddy{

	public static void main(String[] args) {
		Logic logic = new Logic(args);
		logic.run();
	}

}
