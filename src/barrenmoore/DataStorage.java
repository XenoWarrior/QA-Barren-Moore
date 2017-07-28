package barrenmoore;

public class DataStorage {
	
	/**
	 * Variable definitions
	 */
	private static int changeNone = 80;
	private static int chanceEnemy = 40;
	private static int chanceBonus = 40;
	private static int chanceTreasure = 20;
	
	private static boolean printDebug = true;

	/**
	 * Returns if the game should show debug messages
	 * @return boolean
	 */
	public static boolean debugEnabled() {
		return DataStorage.printDebug;
	}
	
	/**
	 * Toggles the display of debug messages
	 */
	public static void toggleDebug(boolean silent) {
		DataStorage.printDebug = !DataStorage.printDebug;
		
		if(!silent)
			System.out.printf("[DataStorage]: Debug has been %s\n", (DataStorage.debugEnabled())  ?  "enabled" : "disabled");
	}
	
}
