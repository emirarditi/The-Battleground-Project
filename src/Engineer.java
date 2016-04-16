//** Developed by Batuhan Erden & Emir Arditi **//

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Engineer extends Character {

	public Engineer() {
		super("Engineer", "Wrench", "Integral", "Triplet", "Re-Programme", 140,
				15, 20, 33, 50); // Constructor
		try {
			setQIcon(ImageIO.read(new File("Q-Wrench.png")));
			setWIcon(ImageIO.read(new File("W-Integral.png")));
			setEIcon(ImageIO.read(new File("E-Triplet.png")));
			setRIcon(ImageIO.read(new File("R-Reprogramme.png")));
			setQMidIcon(ImageIO.read(new File("MIDDLE-Q-Wrench.png")));
			setWMidIcon(ImageIO.read(new File("MIDDLE-W-Integral.png")));
			setEMidIcon(ImageIO.read(new File("MIDDLE-E-Triplet.png")));
			setRMidIcon(ImageIO.read(new File("MIDDLE-R-Reprogramme.png")));
			setCharacterPortrait(ImageIO.read(new File("Engineer.png")));
			setEnvironment(ImageIO.read(new File("Environment1.jpg")));
		} catch (IOException e) {
		}
	}
}