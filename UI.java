import java.util.ArrayList;
import java.util.Scanner;

public class UI {
	
	private static String fileName = "";
	
	//possible messages
	private static final String MESSAGE_WELCOME = "Welcome to TextBuddy. %1$s is ready for use";
	private static final String MESSAGE_EMPTY = "%1$s is empty";
	
	Scanner sc;
	
	public UI(String name){
		fileName = name;
		sc = new Scanner(System.in);
	}
		
	/**
	 * this operation outputs the welcome message to user
	 * 
	 * @param name	name of new file to be created
	 */
	public void printWelcomeMessage (){ //UI
		System.out.println (String.format(MESSAGE_WELCOME, fileName ));
	}

	public String scanCommand() {
		return sc.next();
	}
	public String scanLine(){
		return sc.nextLine();
	}
	public int scanInt(){
		return sc.nextInt();
	}
	
	public void printMessage(String message){
		System.out.println(message);
	}
	
	/**
	 * this operation displays the current contents to be written into file
	 * 
	 * @param contents
	 * @return an arrayList of the content for testing purpose
	 */
	public ArrayList<String> display(ArrayList<String> contents) { //UI
		ArrayList<String> ans = new ArrayList<String>(); //for testing purpose in jUnit
		if (contents.isEmpty()){
			System.out.println(String.format(MESSAGE_EMPTY,fileName));
		} else {
			for (int i = 0; i<contents.size();i++) {
				ans.add((i+1)+". "+contents.get(i));
				System.out.println((i+1)+". "+contents.get(i));
			}
		}
		return ans;
	}
}
