//** Developed by Batuhan Erden & Emir Arditi **//

import java.awt.Font;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JLabel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Counter extends Thread {

	protected static JLabel label;
	protected static InputStream battle;
	protected static AudioStream audioStream2;

	public Counter() { // Constructor
		Font font = new Font("Arial", 8, 50);
		label = new JLabel();
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.CENTER);
		try {
			AudioPlayer.player.stop(Main.audioStream);
			battle = new FileInputStream("battle.wav");
			audioStream2 = new AudioStream(battle);
			AudioPlayer.player.start(audioStream2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		if (Main.isCounter == true) {
			Main.frame.add(label);
			Main.frame.repaint();
			Main.frame.revalidate();
			for (int i = 5; i > 0; i--) {
				label.setText("The Match Begins in: " + i);
				Main.frame.add(label);
				Main.frame.repaint();
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			BattlePhase phase = new BattlePhase();
			Main.frame.remove(label); // Just to remove.
			Main.frame.remove(Main.text);
			Main.frame.repaint();
			Main.frame.add(phase);
			Main.frame.revalidate();
		}
	}
}