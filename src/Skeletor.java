//** Developed by Batuhan Erden & Emir Arditi **//

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Skeletor extends Character {

	public Skeletor() {
		super("Skeletor", "Bone Attack", "Eye Contact", "Mummify", "Graveyard",
				93, 23, 30, 50, 75); // Constructor
		try {
			setQIcon(ImageIO.read(new File("Q-Bone Attack.png")));
			setWIcon(ImageIO.read(new File("W-Eye Contact.png")));
			setEIcon(ImageIO.read(new File("E-Mummify.png")));
			setRIcon(ImageIO.read(new File("R-Graveyard.png")));
			setQMidIcon(ImageIO.read(new File("MIDDLE-Q-Bone Attack.png")));
			setWMidIcon(ImageIO.read(new File("MIDDLE-W-Eye Contact.png")));
			setEMidIcon(ImageIO.read(new File("MIDDLE-E-Mummify.png")));
			setRMidIcon(ImageIO.read(new File("MIDDLE-R-Graveyard.png")));
			setCharacterPortrait(ImageIO.read(new File("Skeletor.png")));
			setEnvironment(ImageIO.read(new File("Environment4.jpg")));
		} catch (IOException e) {
		}
	}
}