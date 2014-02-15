package dotComGame;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class DotComTestDriver extends TestCase {
	private DotComBust dot;
	private List<DotCom> dotComs;
	
	@Override
	protected void setUp() throws Exception {
		dot = new DotComBust("Pets.com", "eToys.com", "Go2.com");
		dotComs = new ArrayList<DotCom>();
		
		for (int i = 0; i < 3; i++) {
			DotCom d = new DotCom();
			d.setName("test" +i);
			dotComs.add(d);
		}
		
		List<String> loc1 = new ArrayList<String>();
		loc1.add("A1");
		loc1.add("B1");
		loc1.add("C1");
		
		List<String> loc2 = new ArrayList<String>();
		loc2.add("D1");
		loc2.add("D2");
		loc2.add("D3");
		
		List<String> loc3 = new ArrayList<String>();
		loc3.add("E4");
		loc3.add("E5");
		loc3.add("E6");
		
		dotComs.get(0).setLocationCells(loc1);
		dotComs.get(1).setLocationCells(loc2);
		dotComs.get(2).setLocationCells(loc3);
	}
	
	@Test
	public void testUserGuesses() {
		String userGuess = "A1";
		assertEquals("hit", dotComs.get(0).checkYourself(userGuess));
	}
	
	@Test
	public void testExecution() {
		dot.setUpGame();
	}

}
