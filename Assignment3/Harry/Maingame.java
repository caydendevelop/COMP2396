package comp2396_a3;

/**
 * MainGame class start the game screen by calling GameBackend.initialize() 
 * and act as starting point from main running function of system
 */
public class Maingame {
	public static void main(String[] args) { 
		GameBackend backend = new GameBackend();
		backend.initialize();
	}
	
}
