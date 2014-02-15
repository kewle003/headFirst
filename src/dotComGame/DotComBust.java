package dotComGame;

import java.util.ArrayList;
import java.util.List;

public class DotComBust {
	
	/**
	 * GameHelper object, assigns DotComs and gets User
	 * input.
	 */
	private GameHelper helper = new GameHelper();
	
	/**
	 * List of our DotComs
	 */
	private List<DotCom> dotComsList = new ArrayList<DotCom>();
	
	/**
	 * How we can rate our user
	 */
	private int numOfGuesses = 0;
	
	private String dotName1;
	private String dotName2;
	private String dotName3;
	
	/**
	 * 
	 * @param dotName1 - name of your first DotCom
	 * @param dotName2 - name of your second DotCom
	 * @param dotName3 - name of your third DotCom
	 */
	public DotComBust(String dotName1, String dotName2, String dotName3) {
		this.dotName1 = dotName1;
		this.dotName2 = dotName2;
		this.dotName3 = dotName3;
		dotComsList.add(new DotCom(dotName1));
		dotComsList.add(new DotCom(dotName2));
		dotComsList.add(new DotCom(dotName3));
	}
	
	public void setUpGame() {
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("" +this.dotName1+ ", " +this.dotName2+ ", " +this.dotName3);
		System.out.println("Try to sink them all in the fewest number of guesses");
		
		for (DotCom dotComToSet : dotComsList) {
			List<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		} 
		
		startPlaying();
	}
	
	private void startPlaying() {
		while (!dotComsList.isEmpty()) {
			String input = helper.getUserInput("Enter a guess:");
			checkUserGuess(input);
		}
		
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		
		for (DotCom dotComToTest : dotComsList) {
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("hit")) {
				break;
			}
			if (result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " +numOfGuesses+ " guesses.");
			System.out.println("You got out before your options sank.");
		} else {
			System.out.println("Took you long enough. " +numOfGuesses+ " gueses.");
			System.out.println("Fish are dancing with your options.");
		}
	}

}
