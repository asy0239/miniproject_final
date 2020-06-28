package frameChange.cardGame.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import frameChange.cardGame.controller.Buffer;
import frameChange.cardGame.controller.ComDeck;
import frameChange.cardGame.controller.TrunTimer;
import frameChange.cardGame.controller.UserDeck;
import frameChange.cardGame.vo.Player;
import frameChange.controller.ChangePanel;

public class MiniPoker extends JPanel{
	
	private ChangePanel mf;
	
	private JButton die; private JButton call;
	private JButton ddable; private JButton half;
	
	private JLabel myMoney; private JLabel panDon;
	public JLabel comMoney;
	
	public JLabel getMyMoney() {
		return myMoney;
	}

	public void setMyMoney(JLabel myMoney) {
		this.myMoney = myMoney;
	}
	private JLabel myJocbo;
	
	public JLabel turnTimer;
	public int turnCho = 10;
	
	private JLabel myCard1;
	private JLabel myCard2;
	private JLabel myCard3;
	private JLabel myCard4;
	private JLabel myCard5;
	
	private JLabel comCard1;
	private JLabel comCard2;
	private JLabel comCard3;
	private JLabel comCard4;
	private JLabel comCard5;
	
	private UserDeck ud = new UserDeck();
	private ComDeck cd = new ComDeck();
	private TrunTimer tt = new TrunTimer();
	
	public Image[] images = new Image[6]; public ImageIcon[] images2 = new ImageIcon[6];
	
	public static int myMoney1 = 500000;
	public static int comMoney1 = 500000;
	public static int panDon1 = 1000 * 2;
	public static int panDon2 = 1000 * 2;
	
	int kind; int number; int mypoint = 0; int compoint = 0;
	public Player[] players = new Player[2];
	
	private boolean isDie = false;
	private boolean game = true;
	private boolean isWin = false;
	private boolean btnEn = false;
	private boolean stop = false;
	private boolean isStart = false;
	
	public static boolean myTurn = false;
	public static boolean comTurn = false;
	public static boolean turnExit = false;
	
	private Image icon; private Image icon2; private Image icon3;
	private Image icon4; private Image icon5;
	private ImageIcon icon1_1; private ImageIcon icon1_2; private ImageIcon icon1_3;
	private ImageIcon icon1_4; private ImageIcon icon1_5;
	private Image icon1_11; private Image icon1_21; private Image icon1_31;
	private Image icon1_41; private Image icon1_51;
	/////////////////////////////////////////////////////////////////////////////
	private ImageIcon jocboState1; private ImageIcon jocboState2;
	private ImageIcon jocboState3; private ImageIcon jocboState4;
	private ImageIcon jocboState5;
	
	private int comI = 0; private int userI = 0;
	
	Image jdlogBack; JDialog jdlog = new JDialog();JPanel jp = new JPanel();
	////////////////////////////////////////////////////////////////////////////
	ImageIcon back;
	///////////////////////////////////////
	int random = 0; int random2 = 0;
	int[] cards = new int[7];
	int[] cards2 = new int[7];
	 ///////////////////////////////////////
	Buffer buffer = new Buffer();
	
	Thread t1 = new Computer(buffer);
	Thread t2 = new User(buffer);
	
	// frameChange.model.vo.Player mainPlayer : 맵 상에 돌아다니는 player 객체
	public MiniPoker(ChangePanel mf, frameChange.model.vo.Player mainPlayer) {
		this.mf = mf;
        
/*		if(comTurn == true) {
			
			t1.start();
			
		} else {
			
			t2.start();
			
		}*/
		
		play();
		
		jdlogBack = new ImageIcon("images/card/PokerBack.jpg").getImage().getScaledInstance(600, 600, 0);
		
		jdlog.setTitle("게임 설명");
		jdlog.setLayout(null);
		jp.setLayout(null);
		
		JLabel info1 = new JLabel();
		info1.setText("족보");
		info1.setSize(500, 15);
		info1.setLocation(10, 15);
		
		JLabel wiki1 = new JLabel();
		wiki1.setText("같은 카드가 1장이면 원페어, 같은 카드가 2장이면 투페어");
		wiki1.setSize(500,15);
		wiki1.setLocation(10, 30);
		
		JLabel wiki1_1 = new JLabel();
		wiki1_1.setText("같은 카드가 3장이면 트리플, 같은 카드가 4장이면 포카드");
		wiki1_1.setSize(500, 15);
		wiki1_1.setLocation(10, 45);
		
		JLabel wiki2 = new JLabel();
		wiki2.setText("카드는 총: 19장입니다.");
		wiki2.setSize(500, 15);
		wiki2.setLocation(10, 75);
		
		JLabel wiki2_1 = new JLabel();
		wiki2_1.setText("스페이드 A, 다이아몬드 A, 클로버 A, 하트 A");
		wiki2_1.setSize(500, 15);
		wiki2_1.setLocation(10, 90);
		
		JLabel wiki2_2 = new JLabel();
		wiki2_2.setText("스페이드 K, 다이아몬드 K, 클로버 K, 하트 K");
		wiki2_2.setSize(500, 15);
		wiki2_2.setLocation(10, 105);
		
		JLabel wiki2_3 = new JLabel();
		wiki2_3.setText("스페이드 Q, 다이아몬드 Q, 클로버 Q, 하트 Q");
		wiki2_3.setSize(500, 15);
		wiki2_3.setLocation(10, 120);
		
		JLabel wiki2_4 = new JLabel();
		wiki2_4.setText("스페이드 J, 다이아몬드 J, 클로버 J, 하트 J");
		wiki2_4.setSize(500, 15);
		wiki2_4.setLocation(10, 135);
		
		JLabel wiki2_5 = new JLabel();
		wiki2_5.setText("레드조커, 블랙조커, 애니메이션 조커");
		wiki2_5.setSize(500, 15);
		wiki2_5.setLocation(10, 150);
		
		JLabel wiki3 = new JLabel();
		wiki3.setText("족보 우선순위");
		wiki3.setSize(500, 15);
		wiki3.setLocation(10, 180);
		
		JLabel wiki3_1 = new JLabel();
		wiki3_1.setText("조커 < 스페이드 < 다이아몬드 < 클로버 < 하트");
		wiki3_1.setSize(500, 15);
		wiki3_1.setLocation(10, 195);
		
		jdlog.setSize(400, 300);
		jdlog.setLocation(1024, 000);
		jp.setSize(400, 300);
		jdlog.setVisible(false);
		
		jp.add(info1);
		jp.add(wiki1);
		jp.add(wiki1_1);
		jp.add(wiki2);
		jp.add(wiki2_1);
		jp.add(wiki2_2);
		jp.add(wiki2_3);
		jp.add(wiki2_4);
		jp.add(wiki2_5);
		jp.add(wiki3);
		jp.add(wiki3_1);
		jdlog.add(jp);
		
		
		this.setLayout(null);
		/////////////////////////////////////////////////////////
		jocboState1 = new ImageIcon("images/card/originJocbo.png");
		myJocbo = new JLabel(jocboState1);
		myJocbo.setSize(200, 300);
		myJocbo.setLocation(800, 300);
		
		add(myJocbo);
		
		//////////////////////////////////////////////////////////
		back = new ImageIcon("images/card/PokerTable.PNG");
		
		turnTimer = new JLabel(turnCho + "초");
		turnTimer.setSize(100,20);
		turnTimer.setLocation(950, 10);
		turnTimer.setFont(new Font("Serif", Font.BOLD, 16));
		turnTimer.setForeground(Color.WHITE);
		add(turnTimer);
		
		myMoney = new JLabel(myMoney1 + " 원");
		myMoney.setSize(100,100);
		myMoney.setLocation(850, 600);
		myMoney.setFont(new Font("Serif", Font.BOLD, 20));
		myMoney.setForeground(Color.WHITE);
		add(myMoney);
		
		comMoney = new JLabel(comMoney1 + " 원");
		comMoney.setSize(100,100);
		comMoney.setLocation(70, 0);
		comMoney.setFont(new Font("Serif", Font.BOLD, 20));
		comMoney.setForeground(Color.WHITE);
		add(comMoney);
		
		setPanDon(new JLabel(panDon1 + "원"));
		getPanDon().setSize(100,100);
		getPanDon().setLocation(480, 310);
		getPanDon().setFont(new Font("Serif", Font.BOLD, 20));
		getPanDon().setForeground(Color.WHITE);
		add(getPanDon());
		
        die = new JButton("다이");
        die.setSize(256,30);        
        die.setLocation(0, 710);
        add(die);
        
        die.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("다이");
				sound("sound/music/die.wav");
				isDie = true;
				myTurn = true;
				comTurn = false;
				stop = false;
				die.setEnabled(false);
				call.setEnabled(false);
				ddable.setEnabled(false);
				half.setEnabled(false);
				
				turnTimer.setText(10 + "초");
				turnCho = 0;
				tt.turn = false;
				
			}
		});
        
        call = new JButton("콜");
        call.setSize(256,30);
        call.setLocation(256, 710);
        add(call);
		
        call.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("콜");
				sound("sound/music/call.wav");
				panDon1 += panDon2;
				myMoney1 -= panDon2;
				getPanDon().setText(Integer.toString(panDon1));
				myMoney.setText(Integer.toString(myMoney1) + " 원");
				panDon2 += panDon2;
				myTurn = true;
				comTurn = false;
				stop = false;
				
				die.setEnabled(false);
				call.setEnabled(false);
				ddable.setEnabled(false);
				half.setEnabled(false);
				
				turnTimer.setText(10 + "초");
				turnCho = 0;
				tt.turn = false;
				
				if(myMoney1 < 0) {
					call.setEnabled(false);
					ddable.setEnabled(false);
					half.setEnabled(false);
					myMoney1 = 0;
					myMoney.setText(myMoney1 + " 원");
				}
				
			}
		});
        
        ddable = new JButton("더블");
        ddable.setSize(256,30);
        ddable.setLocation(512, 710);
        add(ddable);
        
        ddable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("더블");
				sound("sound/music/ddable.wav");
				panDon1 += panDon2 * 2;
				myMoney1 -= panDon2 * 2;
				getPanDon().setText(Integer.toString(panDon1));
				myMoney.setText(Integer.toString(myMoney1) + " 원");
				panDon2 += panDon2 * 2;
				myTurn = true;
				comTurn = false;
				stop = false;
				
				die.setEnabled(false);
				call.setEnabled(false);
				ddable.setEnabled(false);
				half.setEnabled(false);
				
				turnTimer.setText(10 + "초");
				turnCho = 0;
				tt.turn = false;
				
				if(myMoney1 < 0) {
					call.setEnabled(false);
					ddable.setEnabled(false);
					half.setEnabled(false);
					myMoney1 = 0;
					myMoney.setText(myMoney1 + " 원");
				}
				
			}
		});
        
        half = new JButton("하프");
        half.setSize(256,30);
        half.setLocation(768, 710);
        add(half);
        
        half.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("하프");
				sound("sound/music/half.wav");
				panDon1 += panDon2 * 0.3;
				myMoney1 -= panDon2 * 0.3;
				getPanDon().setText(Integer.toString(panDon1));
				myMoney.setText(Integer.toString(myMoney1) + " 원");
				panDon2 += panDon2 * 0.3;
				myTurn = true;
				comTurn = false;
				stop = false;
				
				die.setEnabled(false);
				call.setEnabled(false);
				ddable.setEnabled(false);
				half.setEnabled(false);
				
				turnTimer.setText(10 + "초");
				turnCho = 0;
				tt.turn = false;
				
				if(myMoney1 < 0) {
					call.setEnabled(false);
					ddable.setEnabled(false);
					half.setEnabled(false);
					myMoney1 = 0;
					myMoney.setText(myMoney1 + " 원");
				}
				
			}
		});
        
        this.setSize(1024, 768);
        mf.add(this);
        
        this.addKeyListener(new KeyAdapter() {
        	
        	@Override
        	public void keyPressed(KeyEvent e) {
        		
        		switch(e.getKeyCode()) {
        		
        		case KeyEvent.VK_F1 :

//        			JOptionPane.showMessageDialog(null, "카드를 최대 5장을 받아서 컴퓨터와 대결하는 미니게임입니다.","게임설명",JOptionPane.QUESTION_MESSAGE);
        			
        			jdlog.setVisible(true);
        			
        			break;
        		case KeyEvent.VK_ESCAPE :
        			

        			mf.change("gameCenter");
        			myMoney1 = 500000;
        			myMoney.setText(myMoney1 + " 원");
        			comMoney1 = 500000;
        			comMoney.setText(comMoney1 + " 원");
        			panDon1 = 1000 * 2;
        			panDon2 = 1000 * 2;
        			panDon.setText(panDon1 + "원 ");
        			tt.setTurn(false);
        			turnCho = 0;
        			turnTimer.setText(10 + "초");

        			mf.change("gameCenter", mainPlayer);
        	
        			break;
        		case KeyEvent.VK_SPACE :
        			
        			isStart = true;
        			
        			if(!isStart) {
        					
        				
        			} else {
        				
        				t1.start(); t2.start();
        				
        				isStart = false;
        				
        			}
        			
        			break;
        		}
        			
        	}
		});
        
	}
	
	public static int getMyMoney1() {
		return myMoney1;
	}

	public static void setMyMoney1(int myMoney1) {
		MiniPoker.myMoney1 = myMoney1;
	}

	public JLabel getComMoney() {
		return comMoney;
	}

	public void setComMoney(JLabel comMoney) {
		this.comMoney = comMoney;
	}

	public static int getComMoney1() {
		return comMoney1;
	}

	public static void setComMoney1(int comMoney1) {
		MiniPoker.comMoney1 = comMoney1;
	}

	public static int getPanDon1() {
		return panDon1;
	}

	public static void setPanDon1(int panDon1) {
		MiniPoker.panDon1 = panDon1;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public JButton getDie() {
		return die;
	}

	public void setDie(JButton die) {
		this.die = die;
	}

	public JButton getCall() {
		return call;
	}

	public void setCall(JButton call) {
		this.call = call;
	}

	public JButton getDdable() {
		return ddable;
	}

	public void setDdable(JButton ddable) {
		this.ddable = ddable;
	}

	public JButton getHalf() {
		return half;
	}

	public void setHalf(JButton half) {
		this.half = half;
	}

	public void paintComponent(Graphics g) {
        MiniPoker.this.requestFocus();
        MiniPoker.this.setFocusable(true);
		g.drawImage(back.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
		
	}
	
	public void addImage(int turn) {
		int zz = turn;
			
			if(zz == 1) {
//				icon = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon = images[0];
				myCard1 = new JLabel(new ImageIcon(icon));
				myCard1.setSize(80,140);
				myCard1.setLocation(289,502);
				
				add(myCard1);
				
//				icon2 = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon2 = images[1];
				myCard2 = new JLabel(new ImageIcon(icon2));
				myCard2.setSize(80,140);
				myCard2.setLocation(382,502);
				
				add(myCard2);	

			}
			if(zz == 2) {
//				icon3 = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon3 = images[2];
				myCard3 = new JLabel(new ImageIcon(icon3));
				myCard3.setSize(80,140);
				myCard3.setLocation(472,502);
				
				add(myCard3);	
				mf.repaint();

			}
			if(zz == 3) {
//				icon4 = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon4 = images[3];
				myCard4 = new JLabel(new ImageIcon(icon4));
				myCard4.setSize(80,140);
				myCard4.setLocation(566,502);
				
				add(myCard4);	
				mf.repaint();

			}
			if(zz == 4) {
//				icon5 = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon5 = images[4];
				myCard5 = new JLabel(new ImageIcon(icon5));
				myCard5.setSize(80,140);
				myCard5.setLocation(658,502);
				
				add(myCard5);	
				mf.repaint();

			}
		
		

	}
	
	public void addImage2(int turn) {
		int zz = turn;
		
		if(zz == 1) {
			///////////////////////////////////////////////컴퓨터
//			icon1_1 = new ImageIcon("images/card/green_back.png").getImage().getScaledInstance(80, 140, 0);
			icon1_1 = images2[0];
			icon1_11 = images2[0].getImage();
			icon1_11 = icon1_11.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon1 = new ImageIcon(icon1_11);
			comCard1 = new JLabel(icon1);
			comCard1.setSize(80,140);
			comCard1.setLocation(289,33);
			
			add(comCard1);
			
//			icon1_2 = new ImageIcon("images/card/green_back.png").getImage().getScaledInstance(80, 140, 0);
			icon1_2 = images2[1];
			icon1_21 = images2[1].getImage();
			icon1_21 = icon1_21.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon2 = new ImageIcon(icon1_21);
			comCard2 = new JLabel(icon2);
			comCard2.setSize(80,140);
			comCard2.setLocation(382,33);
			
			add(comCard2);
			mf.repaint();
		}
		if(zz == 2) {
			///////////////////////////////////////////////컴퓨터
			icon1_3 = new ImageIcon("images/card/green_back.png");
			icon1_31 = icon1_3.getImage();
			icon1_31 = icon1_31.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon3 = new ImageIcon(icon1_31);
			comCard3 = new JLabel(icon3);
			comCard3.setSize(80,140);
			comCard3.setLocation(474,33);
			
			add(comCard3);
			mf.repaint();
		}
		if(zz == 3) {
			//////////////////////////////////////////////컴퓨터
			icon1_4 = new ImageIcon("images/card/green_back.png");
			icon1_41 = icon1_4.getImage();
			icon1_41 = icon1_41.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon4 = new ImageIcon(icon1_41);
			comCard4 = new JLabel(icon4);
			comCard4.setSize(80,140);
			comCard4.setLocation(566,33);
			
			add(comCard4);
			mf.repaint();
		}
		if(zz == 4) {
			//////////////////////////////////////////////컴퓨터
			icon1_5 = new ImageIcon("images/card/green_back.png");
			icon1_51 = icon1_5.getImage();
			icon1_51 = icon1_51.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon5 = new ImageIcon(icon1_51);
			comCard5 = new JLabel(icon5);
			comCard5.setSize(80,140);
			comCard5.setLocation(658,33);
			
			add(comCard5);
			mf.repaint();
		}
		
	}
	
	public void exitImage() {
			
			///////////////////////////////////////////////컴퓨터
			icon1_3 = images2[2];
			icon1_31 = images2[2].getImage();
			icon1_31 = icon1_31.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon3 = new ImageIcon(icon1_31);
			comCard3.setIcon(icon3);
			mf.repaint();
			
			//////////////////////////////////////////////컴퓨터
			icon1_4 = images2[3];
			icon1_41 = images2[3].getImage();
			icon1_41 = icon1_41.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon4 = new ImageIcon(icon1_41);
			comCard4.setIcon(icon4);
			mf.repaint();
			
			//////////////////////////////////////////////컴퓨터
			icon1_5 = images2[4];
			icon1_51 = images2[4].getImage();
			icon1_51 = icon1_51.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon5 = new ImageIcon(icon1_51);
			comCard5.setIcon(icon5);

			mf.repaint();
		
	}
	
	public void play() {
		
		for(int i = 0; i < players.length; i++) {
			players[i] = new Player();
		}
		
		players[0].name = "user";
		players[1].name = "computer";
			
//		t1.start(); t2.start();
		
		int random = 0; int random2 = 0;
		int[] cards = new int[6];
		int[] cards2 = new int[6];
		
		for(int q = 0; q < 5; q++) {
			random2 = (int) (Math.random() * 19);
			cards2[q] = random2;
			
			for(int e = 0; e < q; e++) {
				
				if(cards2[q]==cards2[e]) {
					
					q--;
					
				}
				
			}
			players[1].cards2[q] = cards2[q];
		}
		
	}
	
	public String myresult() {
		
			if (ud.getJocbo()[4][0] == 4) {
				mypoint += 20;
				return "A포카드!";
			} else if (ud.getJocbo()[3][0] == 4) {
				mypoint += 19;
				return "K포카드!";
			} else if (ud.getJocbo()[2][0] == 4) {
				mypoint += 18;
				return "Q포카드!";
			} else if (ud.getJocbo()[1][0] == 4) {
				mypoint += 17;
				return "J포카드!";
			} else if(ud.getJocbo()[0][0] == 3) {
				mypoint += 16;
				return "조커트리플!";
			} else if (ud.getJocbo()[4][0] == 3) {
				mypoint += 15;
				return "A트리플!";
			} else if (ud.getJocbo()[3][0] == 3) {
				mypoint += 14;
				return "K트리플!";
			} else if (ud.getJocbo()[2][0] == 3) {
				mypoint += 13;
				return "Q트리플!";
			} else if (ud.getJocbo()[1][0] == 3) {
				mypoint += 12;
				return "J트리플!";
			} else if (ud.getJocbo()[0][0] == 2) {
				mypoint += 11;
				return "조커투페어!";
			} else if (ud.getJocbo()[4][0] == 2) {
				mypoint += 10;
				return "A투페어!";
			} else if (ud.getJocbo()[3][0] == 2) {
				mypoint += 9;
				return "K투페어!";
			} else if (ud.getJocbo()[2][0] == 2) {
				mypoint += 8;
				return "Q투페어!";
			} else if (ud.getJocbo()[1][0] == 2) {
				mypoint += 7;
				return "J투페어!";
			} else if (ud.getJocbo()[0][0] == 1) {
				mypoint += 6;
				return "조커원페어!";
			} else if (ud.getJocbo()[4][0] == 1) {
				mypoint += 5;
				return "A원페어!";
			} else if (ud.getJocbo()[3][0] == 1) {
				mypoint += 4;
				return "K원페어!";
			} else if (ud.getJocbo()[2][0] == 1) {
				mypoint += 3;
				return "Q원페어!";
			} else if (ud.getJocbo()[1][0] == 1) {
				mypoint += 2;
				return "J원페어!";
			}		
			
		return "";
		
	}
	
	public String comresult() {
		
		if (cd.getJocbo2()[4][0] == 4) {
			compoint += 20;
			return "A포카드!";
		} else if (cd.getJocbo2()[3][0] == 4) {
			compoint += 19;
			return "K포카드!";
		} else if (cd.getJocbo2()[2][0] == 4) {
			compoint += 18;
			return "Q포카드!";
		} else if (cd.getJocbo2()[1][0] == 4) {
			compoint += 17;
			return "J포카드!";
		} else if(cd.getJocbo2()[0][0] == 3) {
			compoint += 16;
			return "조커트리플!";
		} else if (cd.getJocbo2()[4][0] == 3) {
			compoint += 15;
			return "A트리플!";
		} else if (cd.getJocbo2()[3][0] == 3) {
			compoint += 14;
			return "K트리플!";
		} else if (cd.getJocbo2()[2][0] == 3) {
			compoint += 13;
			return "Q트리플!";
		} else if (cd.getJocbo2()[1][0] == 3) {
			compoint += 12;
			return "J트리플!";
		} else if (cd.getJocbo2()[0][0] == 2) {
			compoint += 11;
			return "조커투페어!";
		} else if (cd.getJocbo2()[4][0] == 2) {
			compoint += 10;
			return "A투페어!";
		} else if (cd.getJocbo2()[3][0] == 2) {
			compoint += 9;
			return "K투페어!";
		} else if (cd.getJocbo2()[2][0] == 2) {
			compoint += 8;
			return "Q투페어!";
		} else if (cd.getJocbo2()[1][0] == 2) {
			compoint += 7;
			return "J투페어!";
		} else if (cd.getJocbo2()[0][0] == 1) {
			compoint += 6;
			return "조커원페어!";
		} else if (cd.getJocbo2()[4][0] == 1) {
			compoint += 5;
			return "A원페어!";
		} else if (cd.getJocbo2()[3][0] == 1) {
			compoint += 4;
			return "K원페어!";
		} else if (cd.getJocbo2()[2][0] == 1) {
			compoint += 3;
			return "Q원페어!";
		} else if (cd.getJocbo2()[1][0] == 1) {
			compoint += 2;
			return "J원페어!";
		}
		
		return "";
		
	}
	
	public String isWin() {
		
		if(mypoint > compoint) {
			
			return "나의 승리!";
		} else if (mypoint < compoint) {
			
			return "컴퓨터 승리!";
		} else {
			return "무승부!";
		}
	 
	}
	
	public void sound(String fileName) {
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
public JLabel getPanDon() {
		return panDon;
	}

	public void setPanDon(JLabel panDon) {
		this.panDon = panDon;
	}
	//컴퓨터
	class Computer extends Thread{

		private Buffer criticalData;
		
		public Computer(Buffer buffer) {
			this.criticalData = buffer;

		}
		
		@Override
		public void run() {

			for(comI = 1; comI <= 4; comI++) {
				criticalData.comTurn(comI,MiniPoker.this);
				
				if(comI == 1) {
					
					cd.deck(comI, MiniPoker.this);

				} else if (comI == 2) {
					
					cd.deck(comI, MiniPoker.this);
				} else if (comI == 3) {
					
					cd.deck(comI, MiniPoker.this);
				} else if (comI == 4) {
					
					cd.deck(comI, MiniPoker.this);
				} else {
					break;
				}
				
				try {
					
					Thread.sleep(1000);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		}
		
	}
//유저
	class User  extends Thread{
		private Buffer criticalData;
		
		public User(Buffer buffer) {
			this.criticalData = buffer;
			
		}
		
		@Override
		public void run() {

			for(userI = 1; userI <= 4; userI++) {
				criticalData.myTurn(MiniPoker.this);
				
				if(userI == 1) {
					
					for(int ii = 0; ii < 2; ii++) {
						random = (int) (Math.random() * 19);
						cards[ii] = random;
						
						for(int oo = 0; oo < ii; oo++) {
							
							if (cards[ii] == cards[oo]) {
								
								ii--;
								
							}
							
						}
						
						players[0].cards[ii] = cards[ii];
					}
					
					ud.deck(userI, MiniPoker.this);
					
					if("포카드".equals(myresult().substring(1, 4))) {
						
						jocboState2 = new ImageIcon("images/card/FourCard.png");
						myJocbo.setIcon(jocboState2);
						
					} else if ("트리플".equals(myresult().substring(1, 4))) {
						
						jocboState3 = new ImageIcon("images/card/TripleCard.png");
						myJocbo.setIcon(jocboState3);
						
					} else if ("투페어".equals(myresult().substring(1, 4))) {
						
						jocboState4 = new ImageIcon("images/card/TwoPareCard.png");
						myJocbo.setIcon(jocboState4);
						
					} else if ("원카드".equals(myresult().substring(1, 4))) {
						
						jocboState5 = new ImageIcon("images/card/OnePareCard.png");
						myJocbo.setIcon(jocboState5);
						
					}
					
				} else if (userI == 2) {
					
					for(int ii = userI; ii < userI+1; ii++) {
						random = (int) (Math.random() * 19);
						cards[ii] = random;
						
						for(int oo = 0; oo < 2; oo++) {
							
							if (cards[ii] == players[0].cards[oo]) {
								
								ii--;
								
							}
							
						}
						
						players[0].cards[ii] = cards[ii];
					}
					
					ud.deck(userI,MiniPoker.this);

					if("포카드".equals(myresult().substring(1, 4))) {
						
						jocboState2 = new ImageIcon("images/card/FourCard.png");
						myJocbo.setIcon(jocboState2);
						
					} else if ("트리플".equals(myresult().substring(1, 4))) {
						
						jocboState3 = new ImageIcon("images/card/TripleCard.png");
						myJocbo.setIcon(jocboState3);
						
					} else if ("투페어".equals(myresult().substring(1, 4))) {
						
						jocboState4 = new ImageIcon("images/card/TwoPareCard.png");
						myJocbo.setIcon(jocboState4);
						
					} else if ("원카드".equals(myresult().substring(1, 4))) {
						
						jocboState5 = new ImageIcon("images/card/OnePareCard.png");
						myJocbo.setIcon(jocboState5);
						
					}
					
				} else if (userI == 3) {

					for(int ii = userI; ii < userI+1; ii++) {
						random = (int) (Math.random() * 19);
						cards[ii] = random;
						
						for(int oo = 0; oo < 2; oo++) {
							
							if (cards[ii] == players[0].cards[oo]) {
								
								ii--;
								
							}
							
						}
						
						players[0].cards[ii] = cards[ii];
					}
					
					ud.deck(userI, MiniPoker.this);

					if("포카드".equals(myresult().substring(1, 4))) {
						
						jocboState2 = new ImageIcon("images/card/FourCard.png");
						myJocbo.setIcon(jocboState2);
						
					} else if ("트리플".equals(myresult().substring(1, 4))) {
						
						jocboState3 = new ImageIcon("images/card/TripleCard.png");
						myJocbo.setIcon(jocboState3);
						
					} else if ("투페어".equals(myresult().substring(1, 4))) {
						
						jocboState4 = new ImageIcon("images/card/TwoPareCard.png");
						myJocbo.setIcon(jocboState4);
						
					} else if ("원카드".equals(myresult().substring(1, 4))) {
						
						jocboState5 = new ImageIcon("images/card/OnePareCard.png");
						myJocbo.setIcon(jocboState5);
						
					}
					
				} else if (userI == 4) {
					
					for(int ii = userI; ii < userI+1; ii++) {
						random = (int) (Math.random() * 19);
						cards[ii] = random;
						
						for(int oo = 0; oo < 2; oo++) {
							
							if (cards[ii] == players[0].cards[oo]) {
								
								ii--;
								
							}
							
						}
						
						players[0].cards[ii] = cards[ii];
					}
					
					ud.deck(userI, MiniPoker.this);

					System.out.println("나의 족보: " + myresult());
					System.out.println("컴퓨터 족보: " + comresult());
					System.out.println(mypoint);
					System.out.println(compoint);
					System.out.println(isWin());
					////////////////////////////////////////////////////
					if("포카드".equals(myresult().substring(1, 4))) {
						
						jocboState2 = new ImageIcon("images/card/FourCard.png");
						myJocbo.setIcon(jocboState2);
						
					} else if ("트리플".equals(myresult().substring(1, 4))) {
						
						jocboState3 = new ImageIcon("images/card/TripleCard.png");
						myJocbo.setIcon(jocboState3);
						
					} else if ("투페어".equals(myresult().substring(1, 4))) {
						
						jocboState4 = new ImageIcon("images/card/TwoPareCard.png");
						myJocbo.setIcon(jocboState4);
						
					} else if ("원카드".equals(myresult().substring(1, 4))) {
						
						jocboState5 = new ImageIcon("images/card/OnePareCard.png");
						myJocbo.setIcon(jocboState5);
						
					}
					///////////////////////////////////////////////////////////
					if("나의 승리!".equals(isWin())) {
						
						exitImage();
						JOptionPane.showMessageDialog(null, "나의 족보: " + myresult() + "\n" + "컴퓨터 족보: " + comresult() + "\n   "
								+ "               승리","승리", JOptionPane.OK_CANCEL_OPTION);
						
					} else if("컴퓨터 승리!".equals(isWin())){
						
						exitImage();
						JOptionPane.showMessageDialog(null, "나의 족보: " + myresult() + "\n" + "컴퓨터 족보: " + comresult() + "\n   "
								+ "               패배","패배", JOptionPane.OK_CANCEL_OPTION);
						
					} else {
						
						exitImage();
						JOptionPane.showMessageDialog(null, "나의 족보: " + myresult() + "\n" + "컴퓨터 족보: " + comresult() + "\n   "
								+ "               무승부","무승부", JOptionPane.OK_CANCEL_OPTION);
						
					} 
					
				} else {
					 break;
				}
				
				try {
					
						Thread.sleep(1000);
						
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
	}	
	
}



