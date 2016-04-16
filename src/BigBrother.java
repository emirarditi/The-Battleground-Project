//** Developed by Batuhan Erden & Emir Arditi **//

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BigBrother extends Character {

	public BigBrother() {
		super("Big Brother", "Fist", "Charge", "Drown", "Starve", 300, 7, 9,
				15, 23); // Constructor
		try {
			setQIcon(ImageIO.read(new File("Q-Fist.png")));
			setWIcon(ImageIO.read(new File("W-Charge.png")));
			setEIcon(ImageIO.read(new File("E-Drown.png")));
			setRIcon(ImageIO.read(new File("R-Starve.png")));
			setQMidIcon(ImageIO.read(new File("MIDDLE-Q-Fist.png")));
			setWMidIcon(ImageIO.read(new File("MIDDLE-W-Charge.png")));
			setEMidIcon(ImageIO.read(new File("MIDDLE-E-Drown.png")));
			setRMidIcon(ImageIO.read(new File("MIDDLE-R-Starve.png")));
			setCharacterPortrait(ImageIO.read(new File("BigBrother.png")));
			setEnvironment(ImageIO.read(new File("Environment3.jpg")));
		} catch (IOException e) {
		}
	}
}