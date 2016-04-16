//** Developed by Batuhan Erden & Emir Arditi **//

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TheThing extends Character {

	public TheThing() {
		super("The Thing", "Summon Djinn", "Summon Undead", "Summon Ghost",
				"Summon Dalek", 200, 11, 14, 23, 35); // Constructor
		try {
			setQIcon(ImageIO.read(new File("Q-Summon Djinn.png")));
			setWIcon(ImageIO.read(new File("W-Summon Undead.png")));
			setEIcon(ImageIO.read(new File("E-Summon Ghost.png")));
			setRIcon(ImageIO.read(new File("R-Summon Dalek.png")));
			setQMidIcon(ImageIO.read(new File("MIDDLE-Q-Summon Djinn.png")));
			setWMidIcon(ImageIO.read(new File("MIDDLE-W-Summon Undead.png")));
			setEMidIcon(ImageIO.read(new File("MIDDLE-E-Summon Ghost.png")));
			setRMidIcon(ImageIO.read(new File("MIDDLE-R-Summon Dalek.png")));
			setCharacterPortrait(ImageIO.read(new File("TheThing.png")));
			setEnvironment(ImageIO.read(new File("Environment6.jpg")));
		} catch (IOException e) {
		}
	}
}