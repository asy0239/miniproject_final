package frameChange.cardGame.vo;

import javax.swing.ImageIcon;

import frameChange.cardGame.view.MiniPoker;


public class UserDeck {
	private int jocbo[][] = new int[5][1];
	
	public UserDeck() {
		
	}
	
public void deck(int turn, MiniPoker mp) {
		
		int zz = turn + 1;
		
		if(turn == 1) {
			for(int z = 0; z < 2; z++) {
				
				for(int pp = 0; pp < 1; pp++) {
					
					switch(mp.players[0].cards[z]) {
					case 0 : 
					mp.images[z] = new ImageIcon("images/card/a_Joker.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[0][0]++;
					break;
					case 1 :
					mp.images[z] = new ImageIcon("images/card/b_Joker.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[0][0]++;
					break;
					case 2 :
					mp.images[z] = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[1][0]++;
					break;
					case 3 :
					mp.images[z] = new ImageIcon("images/card/J_2.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[1][0]++;
					break;
					case 4 :
					mp.images[z] = new ImageIcon("images/card/J_3.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[1][0]++;
					break;
					case 5 :
					mp.images[z] = new ImageIcon("images/card/J_4.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[1][0]++;
					break;
					case 6 :
					mp.images[z] = new ImageIcon("images/card/Q_1.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[2][0]++;
					break;
					case 7 :
					mp.images[z] = new ImageIcon("images/card/Q_2.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[2][0]++;
					break;
					case 8 :
					mp.images[z] = new ImageIcon("images/card/Q_3.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[2][0]++;
					break;
					case 9 :
					mp.images[z] = new ImageIcon("images/card/Q_4.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[2][0]++;
					break;
					case 10 :
					mp.images[z] = new ImageIcon("images/card/K_1.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[3][0]++;
					break;
					case 11 :
					mp.images[z] = new ImageIcon("images/card/K_2.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[3][0]++;
					break;
					case 12 :
					mp.images[z] = new ImageIcon("images/card/K_3.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[3][0]++;
					break;
					case 13 : 
					mp.images[z] = new ImageIcon("images/card/K_4.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[3][0]++;
					break;
					case 14 :
					mp.images[z] = new ImageIcon("images/card/r_Joker.png").getImage().getScaledInstance(80, 140, 0);
					getJocbo()[0][0]++;
					break;
					case 15 :
						mp.images[z] = new ImageIcon("images/card/A_1.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[4][0]++;
					break;
					case 16 :
						mp.images[z] = new ImageIcon("images/card/A_2.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[4][0]++;
					break;
					case 17 :
						mp.images[z] = new ImageIcon("images/card/A_3.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[4][0]++;
					break;
					case 18 :
						mp.images[z] = new ImageIcon("images/card/A_4.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[4][0]++;
					break;
					}

				}
				mp.addImage(z);
				
			}
			
		} else {
			for(int z = turn; z < zz; z++) {
				
				for(int pp = 0; pp < 1; pp++) {
					
					switch(mp.players[0].cards[z]) {
					case 0 : 
						mp.images[z] = new ImageIcon("images/card/a_Joker.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[0][0]++;
					break;
					case 1 :
						mp.images[z] = new ImageIcon("images/card/b_Joker.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[0][0]++;
					break;
					case 2 :
						mp.images[z] = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[1][0]++;
					break;
					case 3 :
						mp.images[z] = new ImageIcon("images/card/J_2.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[1][0]++;
					break;
					case 4 :
						mp.images[z] = new ImageIcon("images/card/J_3.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[1][0]++;
					break;
					case 5 :
						mp.images[z] = new ImageIcon("images/card/J_4.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[1][0]++;
					break;
					case 6 :
						mp.images[z] = new ImageIcon("images/card/Q_1.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[2][0]++;
					break;
					case 7 :
						mp.images[z] = new ImageIcon("images/card/Q_2.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[2][0]++;
					break;
					case 8 :
						mp.images[z] = new ImageIcon("images/card/Q_3.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[2][0]++;
					break;
					case 9 :
						mp.images[z] = new ImageIcon("images/card/Q_4.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[2][0]++;
					break;
					case 10 :
						mp.images[z] = new ImageIcon("images/card/K_1.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[3][0]++;
					break;
					case 11 :
						mp.images[z] = new ImageIcon("images/card/K_2.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[3][0]++;
					break;
					case 12 :
						mp.images[z] = new ImageIcon("images/card/K_3.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[3][0]++;
					break;
					case 13 :
						mp.images[z] = new ImageIcon("images/card/K_4.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[3][0]++;
					break;
					case 14 :
						mp.images[z] = new ImageIcon("images/card/r_Joker.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[0][0]++;
					break;
					case 15 :
						mp.images[z] = new ImageIcon("images/card/A_1.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[4][0]++;
					break;
					case 16 :
						mp.images[z] = new ImageIcon("images/card/A_2.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[4][0]++;
					break;
					case 17 :
						mp.images[z] = new ImageIcon("images/card/A_3.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[4][0]++;
					break;
					case 18 :
						mp.images[z] = new ImageIcon("images/card/A_4.png").getImage().getScaledInstance(80, 140, 0);
						getJocbo()[4][0]++;
					break;
					}
					
				}

				mp.addImage(z);
			}	
			
		}
		
	}

public int[][] getJocbo() {
	return jocbo;
}

public void setJocbo(int jocbo[][]) {
	this.jocbo = jocbo;
}
	
}
