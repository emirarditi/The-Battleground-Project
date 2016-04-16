//** Developed by Batuhan Erden & Emir Arditi **//

import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ArtificialIntelligence extends Character {

	private int InnerCounter;

	public ArtificialIntelligence() { // Constructor
		super("Artificial Intelligence", "Absorb", "Learn", "Call", "Heal",
				161, 13, 18, 29, 44);
		try {
			setQIcon(ImageIO.read(new File("Q-Absorb.png")));
			setWIcon(ImageIO.read(new File("W-Learn.png")));
			setEIcon(ImageIO.read(new File("E-Call.png")));
			setRIcon(ImageIO.read(new File("R-Heal.png")));
			setQMidIcon(ImageIO.read(new File("MIDDLE-Q-Absorb.png")));
			setWMidIcon(ImageIO.read(new File("MIDDLE-W-Learn.png")));
			setEMidIcon(ImageIO.read(new File("MIDDLE-E-Call.png")));
			setRMidIcon(ImageIO.read(new File("MIDDLE-R-Heal.png")));
			setCharacterPortrait(ImageIO.read(new File("AI.png")));
			setEnvironment(ImageIO.read(new File("Environment5.jpg")));
		} catch (IOException e) {
		}
	}

	@Override
	// FOR HEAL SKILL
	public void R() { // R (Ultimate) Skill
		if (getCountyCounter() >= 3) {
			Random random = new Random();
			int r = random.nextInt(100);
			if (r <= 39) { // 40% MISS CHANCE
				BattlePhase.currentAttack
						.setText("<html>You missed...<br/>Opponent blocked your: <br/>"
								+ BattlePhase.myHero.getRName());
				BattlePhase.mid.setIcon(new ImageIcon("Missed.png")); // Middle
				// Icons
				hasHeroMissed = true;
				BattlePhase.critical1.setIcon(new ImageIcon("Empty.png"));
				BattlePhase.critical1.setToolTipText("");
			} else if (r >= 95) { // 5% CRITICAL HIT CHANCE [DOUBLE HEAL]
				if (BattlePhase.myHero.getHealth() < BattlePhase.myHero_MAXHEALTH
						- (getRDamage() * 2))
					BattlePhase.myHero.setHealth(BattlePhase.myHero.getHealth()
							+ (getRDamage() * 2));
				else
					BattlePhase.myHero.setHealth(BattlePhase.myHero_MAXHEALTH);
				BattlePhase.currentAttack.setText("<html>You used: <br/>"
						+ BattlePhase.myHero.getRName()
						+ "<br/>!! CRITICAL HEAL !!<hmtl>");
				BattlePhase.mid.setIcon(new ImageIcon(getRMidIcon())); // Middle
				// Icons
				hasHeroMissed = false;
				RUsed = true;
				BattlePhase.critical1.setIcon(new ImageIcon("Critical.png"));
				BattlePhase.critical1
						.setToolTipText("Your last spell was critical.");
				BattlePhase.critheal.setIcon(new ImageIcon("CritHeal.png"));
			} else { // NORMAL ATTACK
				if (BattlePhase.myHero.getHealth() < BattlePhase.myHero_MAXHEALTH
						- getRDamage())
					BattlePhase.myHero.setHealth(BattlePhase.myHero.getHealth()
							+ getRDamage());
				else
					BattlePhase.myHero.setHealth(BattlePhase.myHero_MAXHEALTH);
				BattlePhase.currentAttack.setText("<html>You used: <br/>"
						+ BattlePhase.myHero.getRName());
				BattlePhase.mid.setIcon(new ImageIcon(getRMidIcon())); // Middle
				// Icons
				hasHeroMissed = false;
				RUsed = true;
				BattlePhase.critical1.setIcon(new ImageIcon("Empty.png"));
				BattlePhase.critical1.setToolTipText("");
			}
			setCountyCounter(0);
			BattlePhase.isOpponent = true;
		}
	}

	@Override
	// FOR HEAL SKILL
	public void opponentAttack() { // OPPONENT'S INTELLIGENCE
		Random random = new Random();
		if (InnerCounter == 3) { // OPPONENT USING ITS "R" ULTIMATE SKILL
			Random inner_random = new Random();
			int r = inner_random.nextInt(100);
			if (r <= 39) { // 40% MISS CHANCE
				BattlePhase.currentAttack
						.setText("<html>Opponent missed...<br/>You blocked opponent's: <br/>"
								+ BattlePhase.Opponent.getRName());
				BattlePhase.mid.setIcon(new ImageIcon("Missed.png")); // Middle
				// Icons
				hasOpponentMissed = true;
				BattlePhase.critical2.setIcon(new ImageIcon("Empty.png"));
				BattlePhase.critical2.setToolTipText("");
			} else if (r >= 95) { // 5% CRITICAL HIT CHANCE [DOUBLE DAMAGE]
				if (BattlePhase.Opponent.getHealth() < BattlePhase.Opponent_MAXHEALTH
						- getRDamage())
					BattlePhase.Opponent.setHealth(BattlePhase.Opponent
							.getHealth() + (getRDamage() * 2));
				else
					BattlePhase.Opponent
							.setHealth(BattlePhase.Opponent_MAXHEALTH);
				BattlePhase.currentAttack.setText("<html>Opponent used: <br/>"
						+ BattlePhase.Opponent.getRName()
						+ "<br/>!! CRITICAL HEAL !!<hmtl>");
				BattlePhase.mid.setIcon(new ImageIcon(BattlePhase.Opponent
						.getRMidIcon())); // Middle Icons
				hasOpponentMissed = false;
				RUsed = true;
				BattlePhase.critical2.setIcon(new ImageIcon("Critical.png"));
				BattlePhase.critical2
						.setToolTipText("Opponent's last spell was critical.");
				BattlePhase.critheal.setIcon(new ImageIcon("CritHeal.png"));
			} else { // NORMAL ATTACK
				if (BattlePhase.Opponent.getHealth() < BattlePhase.Opponent_MAXHEALTH
						- getRDamage())
					BattlePhase.Opponent.setHealth(BattlePhase.Opponent
							.getHealth() + getRDamage());
				else
					BattlePhase.Opponent
							.setHealth(BattlePhase.Opponent_MAXHEALTH);
				BattlePhase.currentAttack.setText("<html>Opponent used: <br/>"
						+ BattlePhase.Opponent.getRName());
				BattlePhase.mid.setIcon(new ImageIcon(BattlePhase.Opponent
						.getRMidIcon())); // Middle Icons
				hasOpponentMissed = false;
				RUsed = true;
				BattlePhase.critical2.setIcon(new ImageIcon("Empty.png"));
				BattlePhase.critical2.setToolTipText("");
			}
			InnerCounter = 0;
		} else {
			int r = random.nextInt(3);
			if (r == 0) { // OPPONENT USING ITS "Q" SKILL
				Random inner_random = new Random();
				int q = inner_random.nextInt(100);
				if (q <= 12) { // 13% MISS CHANCE
					BattlePhase.currentAttack
							.setText("<html>Opponent missed...<br/>You dodged opponent's: <br/>"
									+ BattlePhase.Opponent.getQName());
					BattlePhase.mid.setIcon(new ImageIcon("Missed.png")); // Middle
					// Icons
					hasOpponentMissed = true;
					BattlePhase.critical2.setIcon(new ImageIcon("Empty.png"));
					BattlePhase.critical2.setToolTipText("");
				} else if (q >= 95) { // 5% CRITICAL HIT CHANCE [DOUBLE DAMAGE]
					BattlePhase.myHero.setHealth(BattlePhase.myHero.getHealth()
							- (getQDamage() * 2));
					BattlePhase.currentAttack
							.setText("<html>Opponent used: <br/>"
									+ BattlePhase.Opponent.getQName()
									+ "<br/>!! CRITICAL HIT !!<hmtl>");
					BattlePhase.mid.setIcon(new ImageIcon(BattlePhase.Opponent
							.getQMidIcon())); // Middle Icons
					hasOpponentMissed = false;
					InnerCounter++;
					BattlePhase.critical2
							.setIcon(new ImageIcon("Critical.png"));
					BattlePhase.critical2
							.setToolTipText("Opponent's last spell was critical.");
					BattlePhase.crithit.setIcon(new ImageIcon("CritHit.png"));
				} else { // NORMAL ATTACK
					BattlePhase.myHero.setHealth(BattlePhase.myHero.getHealth()
							- getQDamage());
					BattlePhase.currentAttack
							.setText("<html>Opponent used: <br/>"
									+ BattlePhase.Opponent.getQName());
					BattlePhase.mid.setIcon(new ImageIcon(BattlePhase.Opponent
							.getQMidIcon())); // Middle Icons
					hasOpponentMissed = false;
					InnerCounter++;
					BattlePhase.critical2.setIcon(new ImageIcon("Empty.png"));
					BattlePhase.critical2.setToolTipText("");
				}
			}
			if (r == 1) { // OPPONENT USING ITS "W" SKILL
				Random inner_random = new Random();
				int w = inner_random.nextInt(100);
				if (w <= 16) { // 17% MISS CHANCE
					BattlePhase.currentAttack
							.setText("<html>Opponent missed...<br/>You dodged opponent's: <br/>"
									+ BattlePhase.Opponent.getWName());
					BattlePhase.mid.setIcon(new ImageIcon("Missed.png")); // Middle
					// Icons
					hasOpponentMissed = true;
					BattlePhase.critical2.setIcon(new ImageIcon("Empty.png"));
					BattlePhase.critical2.setToolTipText("");
				} else if (w >= 95) { // 5% CRITICAL HIT CHANCE [DOUBLE DAMAGE]
					BattlePhase.myHero.setHealth(BattlePhase.myHero.getHealth()
							- (getWDamage() * 2));
					BattlePhase.currentAttack
							.setText("<html>Opponent used: <br/>"
									+ BattlePhase.Opponent.getWName()
									+ "<br/>!! CRITICAL HIT !!<hmtl>");
					BattlePhase.mid.setIcon(new ImageIcon(BattlePhase.Opponent
							.getWMidIcon())); // Middle Icons
					hasOpponentMissed = false;
					InnerCounter++;
					BattlePhase.critical2
							.setIcon(new ImageIcon("Critical.png"));
					BattlePhase.critical2
							.setToolTipText("Opponent's last spell was critical.");
					BattlePhase.crithit.setIcon(new ImageIcon("CritHit.png"));
				} else { // NORMAL ATTACK
					BattlePhase.myHero.setHealth(BattlePhase.myHero.getHealth()
							- getWDamage());
					BattlePhase.currentAttack
							.setText("<html>Opponent used: <br/>"
									+ BattlePhase.Opponent.getWName());
					BattlePhase.mid.setIcon(new ImageIcon(BattlePhase.Opponent
							.getWMidIcon())); // Middle Icons
					hasOpponentMissed = false;
					InnerCounter++;
					BattlePhase.critical2.setIcon(new ImageIcon("Empty.png"));
					BattlePhase.critical2.setToolTipText("");
				}
			}
			if (r == 2) { // OPPONENT USING ITS "E" SKILL
				Random inner_random = new Random();
				int e = inner_random.nextInt(100);
				if (e <= 28) { // 29% MISS CHANCE
					BattlePhase.currentAttack
							.setText("<html>Opponent missed...<br/>You dodged opponent's: <br/>"
									+ BattlePhase.Opponent.getEName());
					BattlePhase.mid.setIcon(new ImageIcon("Missed.png")); // Middle
					// Icons
					hasOpponentMissed = true;
					BattlePhase.critical2.setIcon(new ImageIcon("Empty.png"));
					BattlePhase.critical2.setToolTipText("");
				} else if (e >= 95) { // 5% CRITICAL HIT CHANCE [DOUBLE DAMAGE]
					BattlePhase.myHero.setHealth(BattlePhase.myHero.getHealth()
							- (getEDamage() * 2));
					BattlePhase.currentAttack
							.setText("<html>Opponent used: <br/>"
									+ BattlePhase.Opponent.getEName()
									+ "<br/>!! CRITICAL HIT !!<hmtl>");
					BattlePhase.mid.setIcon(new ImageIcon(BattlePhase.Opponent
							.getEMidIcon())); // Middle Icons
					hasOpponentMissed = false;
					InnerCounter++;
					BattlePhase.critical2
							.setIcon(new ImageIcon("Critical.png"));
					BattlePhase.critical2
							.setToolTipText("Opponent's last spell was critical.");
					BattlePhase.crithit.setIcon(new ImageIcon("CritHit.png"));
				} else { // NORMAL ATTACK
					BattlePhase.myHero.setHealth(BattlePhase.myHero.getHealth()
							- getEDamage());
					BattlePhase.currentAttack
							.setText("<html>Opponent used: <br/>"
									+ BattlePhase.Opponent.getEName());
					BattlePhase.mid.setIcon(new ImageIcon(BattlePhase.Opponent
							.getEMidIcon())); // Middle Icons
					hasOpponentMissed = false;
					InnerCounter++;
					BattlePhase.critical2.setIcon(new ImageIcon("Empty.png"));
					BattlePhase.critical2.setToolTipText("");
				}
			}
		}
	}
}