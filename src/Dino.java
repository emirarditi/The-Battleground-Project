//** Developed by Batuhan Erden & Emir Arditi **//

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Dino extends Character {

	public Dino() {
		super("Dino", "Roar", "Tail Attack", "Stomp", "Extinction", 117, 18,
				24, 39, 60); // Constructor
		try {
			setQIcon(ImageIO.read(new File("Q-Roar.png")));
			setWIcon(ImageIO.read(new File("W-Tail Attack.png")));
			setEIcon(ImageIO.read(new File("E-Stomp.png")));
			setRIcon(ImageIO.read(new File("R-Extinction.png")));
			setQMidIcon(ImageIO.read(new File("MIDDLE-Q-Roar.png")));
			setWMidIcon(ImageIO.read(new File("MIDDLE-W-Tail Attack.png")));
			setEMidIcon(ImageIO.read(new File("MIDDLE-E-Stomp.png")));
			setRMidIcon(ImageIO.read(new File("MIDDLE-R-Extinction.png")));
			setCharacterPortrait(ImageIO.read(new File("Dino.png")));
			setEnvironment(ImageIO.read(new File("Environment2.jpg")));
		} catch (IOException e) {
		}
	}
}