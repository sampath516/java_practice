public abstract class MazeFactory {
	// The protected reference to the one and only instance.
	protected static MazeFactory uniqueInstance = null;

	// The private MazeFactory constructor.
	private MazeFactory() {
	}

	// Return a reference to the single instance.
	public static MazeFactory instance() {
		return uniqueInstance;
	}

}
