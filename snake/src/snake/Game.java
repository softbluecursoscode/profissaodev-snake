package snake;

public class Game {

	private GameWindow gameWindow;
	private Snake snake;
	
	public void start() {
		gameWindow = new GameWindow();
		snake = new Snake();
		
		Renderer renderer = gameWindow.getRenderer();
		renderer.add(new Background());
		renderer.add(snake);
	}
	
	public void run() {
		while (!isGameOver()) {
			gameWindow.repaint();
		}
	}
	
	private boolean isGameOver() {
		return false;
	}
}
