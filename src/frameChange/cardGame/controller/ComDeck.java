package frameChange.cardGame.controller;

import javax.swing.ImageIcon;

import frameChange.cardGame.view.MiniPoker;

public class ComDeck {
	
	private int jocbo2[][] = new int[5][1];
	
	public ComDeck() {
		
	}
	
	public void deck(int turn, MiniPoker mp) {
		int zz = turn +1;
		
		if(turn == 1) {
			
			for(int z = 0; z < 2; z++) {
				
				for(int pp = 0; pp < 1; pp++) {
					
					////////////////////////////////////////////////컴퓨터
					switch(mp.players[1].cards2[z]) {
					case 0 : System.out.println("a_Joker");
					mp.images2[z] = new ImageIcon("images/card/a_Joker.png");
					getJocbo2()[0][0]++;
					break;
					case 1 : System.err.println("b_Joker");
					mp.images2[z] = new ImageIcon("images/card/b_Joker.png");
					getJocbo2()[0][0]++;
					break;
					case 2 : System.out.println("J_1");
					mp.images2[z] = new ImageIcon("images/card/J_1.png");
					getJocbo2()[1][0]++;
					break;
					case 3 : System.out.println("J_2");
					mp.images2[z] = new ImageIcon("images/card/J_2.png");
					getJocbo2()[1][0]++;
					break;
					case 4 : System.out.println("J_3");
					mp.images2[z] = new ImageIcon("images/card/J_3.png");
					getJocbo2()[1][0]++;
					break;
					case 5 : System.out.println("J_4");
					mp.images2[z] = new ImageIcon("images/card/J_4.png");
					getJocbo2()[1][0]++;
					break;
					case 6 : System.out.println("Q_1");
					mp.images2[z] = new ImageIcon("images/card/Q_1.png");
					getJocbo2()[2][0]++;
					break;
					case 7 : System.out.println("Q_2");
					mp.images2[z] = new ImageIcon("images/card/Q_2.png");
					getJocbo2()[2][0]++;
					break;
					case 8 : System.out.println("Q_3");
					mp.images2[z] = new ImageIcon("images/card/Q_3.png");
					getJocbo2()[2][0]++;
					break;
					case 9 : System.out.println("Q_4");
					mp.images2[z] = new ImageIcon("images/card/Q_4.png");
					getJocbo2()[2][0]++;
					break;
					case 10 : System.out.println("K_1");
					mp.images2[z] = new ImageIcon("images/card/K_1.png");
					getJocbo2()[3][0]++;
					break;
					case 11 : System.out.println("K_2");
					mp.images2[z] = new ImageIcon("images/card/K_2.png");
					getJocbo2()[3][0]++;
					break;
					case 12 : System.out.println("K_3");
					mp.images2[z] = new ImageIcon("images/card/K_3.png");
					getJocbo2()[3][0]++;
					break;
					case 13 : System.out.println("K_4");
					mp.images2[z] = new ImageIcon("images/card/K_4.png");
					getJocbo2()[3][0]++;
					break;
					case 14 : System.out.println("r_Joker");
					mp.images2[z] = new ImageIcon("images/card/r_Joker.png");
					getJocbo2()[0][0]++;
					break;
					case 15 : System.out.println("A_1");
					mp.images2[z] = new ImageIcon("images/card/A_1.png");
					getJocbo2()[4][0]++;
					break;
					case 16 : System.out.println("A_2");
					mp.images2[z] = new ImageIcon("images/card/A_2.png");
					getJocbo2()[4][0]++;
					break;
					case 17 : System.out.println("A_3");
					mp.images2[z] = new ImageIcon("images/card/A_3.png");
					getJocbo2()[4][0]++;
					break;
					case 18 : System.out.println("A_4");
					mp.images2[z] = new ImageIcon("images/card/A_4.png");
					getJocbo2()[4][0]++;
					break;
					}
				}

				mp.addImage2(z);
			}	
			
		} else {
			
			for(int z = turn; z < zz; z++) {
				
				for(int pp = 0; pp < 1; pp++) {
					
					////////////////////////////////////////////////컴퓨터
					switch(mp.players[1].cards2[z]) {
					case 0 : System.out.println("a_Joker");
					mp.images2[z] = new ImageIcon("images/card/a_Joker.png");
					getJocbo2()[0][0]++;
					break;
					case 1 : System.err.println("b_Joker");
					mp.images2[z] = new ImageIcon("images/card/b_Joker.png");
					getJocbo2()[0][0]++;
					break;
					case 2 : System.out.println("J_1");
					mp.images2[z] = new ImageIcon("images/card/J_1.png");
					getJocbo2()[1][0]++;
					break;
					case 3 : System.out.println("J_2");
					mp.images2[z] = new ImageIcon("images/card/J_2.png");
					getJocbo2()[1][0]++;
					break;
					case 4 : System.out.println("J_3");
					mp.images2[z] = new ImageIcon("images/card/J_3.png");
					getJocbo2()[1][0]++;
					break;
					case 5 : System.out.println("J_4");
					mp.images2[z] = new ImageIcon("images/card/J_4.png");
					getJocbo2()[1][0]++;
					break;
					case 6 : System.out.println("Q_1");
					mp.images2[z] = new ImageIcon("images/card/Q_1.png");
					getJocbo2()[2][0]++;
					break;
					case 7 : System.out.println("Q_2");
					mp.images2[z] = new ImageIcon("images/card/Q_2.png");
					getJocbo2()[2][0]++;
					break;
					case 8 : System.out.println("Q_3");
					mp.images2[z] = new ImageIcon("images/card/Q_3.png");
					getJocbo2()[2][0]++;
					break;
					case 9 : System.out.println("Q_4");
					mp.images2[z] = new ImageIcon("images/card/Q_4.png");
					getJocbo2()[2][0]++;
					break;
					case 10 : System.out.println("K_1");
					mp.images2[z] = new ImageIcon("images/card/K_1.png");
					getJocbo2()[3][0]++;
					break;
					case 11 : System.out.println("K_2");
					mp.images2[z] = new ImageIcon("images/card/K_2.png");
					getJocbo2()[3][0]++;
					break;
					case 12 : System.out.println("K_3");
					mp.images2[z] = new ImageIcon("images/card/K_3.png");
					getJocbo2()[3][0]++;
					break;
					case 13 : System.out.println("K_4");
					mp.images2[z] = new ImageIcon("images/card/K_4.png");
					getJocbo2()[3][0]++;
					break;
					case 14 : System.out.println("r_Joker");
					mp.images2[z] = new ImageIcon("images/card/r_Joker.png");
					getJocbo2()[0][0]++;
					break;
					case 15 : System.out.println("A_1");
					mp.images2[z] = new ImageIcon("images/card/A_1.png");
					getJocbo2()[4][0]++;
					break;
					case 16 : System.out.println("A_2");
					mp.images2[z] = new ImageIcon("images/card/A_2.png");
					getJocbo2()[4][0]++;
					break;
					case 17 : System.out.println("A_3");
					mp.images2[z] = new ImageIcon("images/card/A_3.png");
					getJocbo2()[4][0]++;
					break;
					case 18 : System.out.println("A_4");
					mp.images2[z] = new ImageIcon("images/card/A_4.png");
					getJocbo2()[4][0]++;
					break;
					}
				}

				mp.addImage2(z);
			}	
			
		}
		
	}

	public int[][] getJocbo2() {
		return jocbo2;
	}

	public void setJocbo2(int jocbo2[][]) {
		this.jocbo2 = jocbo2;
	}
	
}
