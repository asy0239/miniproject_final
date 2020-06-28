package frameChange.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import frameChange.model.vo.Player;

class oneTo50 extends JPanel implements ActionListener {
	String path = System.getProperty("user.dir") + "\\images\\";
	private ChangePanel win;
	private Player player;
	Random ran = new Random();

	JButton gameBtn[][];
	JButton resetBtn;
	JButton exitBtn;
	JButton startBtn;
	
	JLabel btnNum = new JLabel();
	JLabel nextNum;
	JLabel numClick = new JLabel();
	JLabel manyClick;
	
	String name;
	
	int timecheck;
	int front[][];
	int back[][];
	int gameNum; // 맞춰야하는 숫자
	int clickNum; //클릭 수. 잘못 클릭한것도 세준다
	int total;
	
	
	ImageIcon backG = new ImageIcon(path + "bg\\1to50bg.png");

	public oneTo50(ChangePanel win, Player player) {
		this.win = win;
		this.player = player;
		setLayout(null);
		
		timecheck = 0;
		gameNum = 1;
		clickNum = 0;
	
		
		JLabel nextNum = new JLabel("다음 눌러야 할 번호", JLabel.RIGHT);
		nextNum.setForeground(Color.white);
		nextNum.setBounds(700, 100, 150, 50);
		
		btnNum.setBounds(700, 150, 100, 50);
		btnNum.setText("" + gameNum);
		btnNum.setForeground(Color.black);
		btnNum.setOpaque(true);
		
		JLabel manyClick = new JLabel("클릭한 횟수", JLabel.RIGHT);
		manyClick.setForeground(Color.white);
		manyClick.setBounds(700, 250, 150, 50);
		
	
		numClick.setBounds(700, 350, 100, 50);
		numClick.setText("" + clickNum);
		numClick.setForeground(Color.black);
		numClick.setOpaque(true);
		
		
		
		
		exitBtn = new JButton("exit");
		exitBtn.setBounds(700, 500, 100, 50);
		exitBtn.setBorder(null);
		exitBtn.addActionListener(this);

		resetBtn = new JButton("reset");
		resetBtn.setBorder(null);
		resetBtn.setBounds(700, 600, 100, 50);
		resetBtn.addActionListener(this);
		
		add(nextNum);
		add(btnNum);
		add(manyClick);
		add(numClick);
		add(exitBtn);
		add(resetBtn);
		

	


		gameBtn = new JButton[5][5];
		front = new int[5][5];
		back = new int[5][5];
		setNumber();
		setButton();

	}
	
	public void Timer() {
		
	}

	// 배경을 그리는 부분
	public void paintComponent(Graphics g) {
		g.drawImage(backG.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	//숫자를 설정하는 부분
	public void setNumber() {
		int o = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				front[i][j] = o; // front[0][0~4] = 1 ~ 25
				back[i][j] = o + 25; // back[0] [0~4] = 26~
				o += 1;
			}
		}
		shuffle();
	}

	// 섞기
	public void shuffle() {
		for (int i = 0; i < 200; i++) { //i의 값으로 숫자를 섞는다
			int r1 = ran.nextInt(5); // 0~4 의 배열 내에서 섞기 위해 랜덤값 지정
			int r2 = ran.nextInt(5); // 0~4 의 배열 내에서 섞기 위한 랜던값 지정

			int temp = front[0][0]; // temp값에 0 0 값 담음
			front[0][0] = front[r1][r2];
			front[r1][r2] = temp;

			r1 = ran.nextInt(5);
			r2 = ran.nextInt(5);

			temp = back[0][0];
			back[0][0] = back[r1][r2];
			back[r1][r2] = temp;
		}
	}

	//버튼을 생성하는 부분
	public void setButton() {

		Font font = new Font("맑은 고딕", Font.BOLD, 40);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				gameBtn[i][j] = new JButton(); // 새버튼 생성
				gameBtn[i][j].setSize(100, 100); // 사이즈 설정
				gameBtn[i][j].setLocation(150 + j * 100, 150 + i * 100); // 위치를 설정한다
				gameBtn[i][j].setText("" + front[i][j]);
				gameBtn[i][j].setFont(font);
				gameBtn[i][j].setBackground(Color.lightGray);
				gameBtn[i][j].addActionListener(this);
				add(gameBtn[i][j]); // 버튼을 추가한다
			}
		}
	}

	// 게임을 다시 재설정하는 부분임.
	public void reset() {
		setNumber(); // 숫자 재설정을 해준다 내부에 셔플있음.
		clickNum = 0;
		gameNum = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				gameBtn[i][j].setText("" + front[i][j]);
				gameBtn[i][j].setBackground(Color.lightGray); //배경색을 다시 원점으로 돌려준다
				
				

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (e.getSource() == gameBtn[i][j]) {
					clickNum++;
					numClick.setText("" + clickNum);
					
					if (front[i][j] == gameNum) {
						
						if (0 < gameNum && gameNum < 26) {
							front[i][j] = back[i][j];
							gameBtn[i][j].setText("" + front[i][j]);
							gameBtn[i][j].setBackground(Color.orange);
						} else {
							front[i][j] = 0;
							gameBtn[i][j].setText("");
							gameBtn[i][j].setBackground(Color.darkGray);
						}
						gameNum++;
						btnNum.setText("" + gameNum);
						if (gameNum > 50) {
							gameNum = 50;
							name = JOptionPane.showInputDialog("이름을 입력해주세요 ");
							System.out.println(name);
							JOptionPane.showMessageDialog(null, name + "님 게임이 종료되었습니다. 클릭한 횟수는 " + clickNum + "입니다.  다시하시려면 리셋 버튼을 눌러주세요");
						}

					}
				}
			}
		}

		if (e.getSource() == resetBtn) {
			reset();
		}
		if (e.getSource() == exitBtn) {
			win.change("gameCenter", player);
		}

	}
	public void result () {
		
		total = clickNum;
	}

}

