public class Main {

	private static void toPikachu(Pikachu pkm) {
		pkm.shootElectricity();
	}

	private static void toSquirtle(Squirtle pkm) {
		pkm.shootWater();
	}

	public static void main(String[] args) {
		Ditto pkm = new ShinyDitto();
		toPikachu(pkm);
		toSquirtle(pkm);
	}
}

