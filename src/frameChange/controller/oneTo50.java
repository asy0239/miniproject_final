package frameChange.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import frameChange.model.vo.Player;

public class oneTo50 extends JPanel implements ActionListener {
	
	class timeCheck implements Runnable {  //인터페이스구성 추상메소드 재정의함

		@Override
		public void run() {
			while(timec) {            //timec boolean임 false되면 종료.
				try {
					Thread.sleep(1000);
					timecheck++;
					cntcount.setText("" + timecheck); 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	String path = System.getProperty("user.dir") + "\\images\\";
	private ChangePanel win;
	private Player player;
	Random ran = new Random(); //랜덤함수
	ArrayList<ranking> rankPg = new ArrayList<ranking>(); //제너릭 어레이리스트 선언함
	
	JButton gameBtn[][];   //게임버튼
	JButton resetBtn;       //리셋버튼
	JButton exitBtn;       //나가기(전맵으로 돌아가기 버튼)
	JButton startBtn;      //시작버튼
	JButton rankBtn;         //랭킹 버튼
	
	JLabel btnNum = new JLabel();      //눌러야하는 버튼  숫자 출력해줌
	JLabel numClick = new JLabel();       // 버튼을 몇번 눌렀는지 보여줌(오클릭도)
	JLabel cnttime;
	JLabel cntcount = new JLabel();    //시간초 카운트해줌
	JLabel nextNum;
	JLabel manyClick;
	JLabel ranke1;           
	JLabel ranke2;
	JLabel ranke3;
	JLabel ranke4;
	JLabel ranke5;
	JLabel ranke6;
	JLabel ranktext;
	
	JDialog dlog;
	
	String name;
	boolean timec = true;
	int front[][];     //1~25까지의 출력을 위해 이차원배열
	int back[][];      //26~50까지의 출력을 위해 이차원배열
	int gameNum; // 맞춰야하는 숫자
	int clickNum; //클릭 수. 잘못 클릭한것도 세준다
	int timecheck; //시간 체크부분
	int total;       //총점비교부분
	
	ImageIcon backG = new ImageIcon(path + "bg\\1to50bg.png");

	public oneTo50(ChangePanel win, Player player) {
		this.win = win;
		this.player = player;
		setLayout(null);
		
		timecheck = 0; //초기화
		gameNum = 1; //초기화
		clickNum = 0; //초기화
		
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		
		
		JLabel cnttime = new JLabel("시간초 : ", JLabel.LEFT);
		cnttime.setFont(font);
		cnttime.setForeground(Color.white);
		cnttime.setBounds(600, 50, 150, 50);
		
		cntcount.setBounds(700, 50, 100, 50);
		cntcount.setText("" + timecheck);
		cntcount.setFont(font);
		cntcount.setForeground(Color.white);
		
		
		JLabel nextNum = new JLabel("다음 번호", JLabel.LEFT);
		nextNum.setFont(font);
		nextNum.setForeground(Color.white);
		nextNum.setBounds(700, 100, 150, 50);
		
		btnNum.setBounds(700, 150, 100, 50);
		btnNum.setText("" + gameNum);
		btnNum.setFont(font);
		btnNum.setForeground(Color.black);
		btnNum.setOpaque(true);
		
		JLabel manyClick = new JLabel("클릭한 횟수", JLabel.LEFT);
		manyClick.setFont(font);
		manyClick.setForeground(Color.white);
		manyClick.setBounds(700, 200, 150, 50);
		
	
		numClick.setBounds(700, 250, 100, 50);     //클릭 숫자부분
		numClick.setText("" + clickNum);
		numClick.setFont(font);
		numClick.setForeground(Color.black);
		numClick.setOpaque(true);
		
		startBtn = new JButton("start");         //시작버튼
		startBtn.setBounds(700, 350, 100, 50);
		startBtn.setBorder(null);
		startBtn.addActionListener(this);
		
		exitBtn = new JButton("exit");          //오락실 화면으로 돌아감 나가는버튼
		exitBtn.setBounds(700, 450, 100, 50);
		exitBtn.setBorder(null);
		exitBtn.addActionListener(this);

		resetBtn = new JButton("reset");  //게임판 초기화
		resetBtn.setBorder(null); 
		resetBtn.setBounds(700, 550, 100, 50);
		resetBtn.addActionListener(this);
		
		rankBtn = new JButton("Ranking");
		rankBtn.setBorder(null);
		rankBtn.setBounds(700, 650, 100, 50);
		rankBtn.addActionListener(this);
		
		ranktext =new JLabel();
		ranke1 = new JLabel();
		ranke2 = new JLabel();
		ranke3 = new JLabel();
		ranke4 = new JLabel();
		ranke5 = new JLabel();
		ranke6 = new JLabel();
	
		dlog = new JDialog(win,"랭킹페이지");
		dlog.add(ranktext);
		dlog.add(ranke1);
		dlog.add(ranke2);
		dlog.add(ranke3);
		dlog.add(ranke4);
		dlog.add(ranke5);
		dlog.add(ranke6);
		dlog.setLayout(null);
		dlog.setSize(600,600);
		
		add(nextNum);
		add(cntcount);
		add(btnNum);
		add(manyClick);
		add(cnttime);
		add(numClick);
		add(startBtn);
		add(exitBtn);
		add(resetBtn);
		add(rankBtn);
		
		gameBtn = new JButton[5][5];      //버튼배열 초기화
		front = new int[5][5];            //앞단 초기화
		back = new int[5][5];			//뒷단 초기화
		setNumber();
		setButton();
		
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
		for (int i = 0; i < 300; i++) { //i의 값으로 숫자를 섞는다
			int r1 = ran.nextInt(5); // 0~4 의 배열 내에서 섞기 위해 랜덤값 지정
			int r2 = ran.nextInt(5); // 0~4 의 배열 내에서 섞기 위한 랜덤값 지정

			int temp = front[0][0]; // temp값에 0 0 값 담음
			front[0][0] = front[r1][r2]; //r1 r2에 담긴값 가지고옴
			front[r1][r2] = temp; // r1 r2엔 0 0 에 담긴 값을 가지고온다

			r1 = ran.nextInt(5);
			r2 = ran.nextInt(5);

			temp = back[0][0];         //후열도 마찬가지로 진행한다
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
				gameBtn[i][j].setText("" + front[i][j]); //버튼부에 숫자 출력하기
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
		timec = false; 
		timecheck = 0;
		cntcount.setText("" + timecheck); //버튼에 들어가있는값들 초기화
		numClick.setText("" + clickNum);
		btnNum.setText("" + gameNum);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				gameBtn[i][j].setText("" + front[i][j]);
				gameBtn[i][j].setBackground(Color.lightGray); //배경색을 다시 원점으로 돌려준다
				
				

			}
		}
	}
	public void ranker() { //다이얼로그 부분에 출력하는 부분
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		ranktext.setText("등수        이름      시간(초)   총합(클릭+시간) ");
		ranktext.setBounds(50, 0, 550, 100);
		ranktext.setFont(font);
		//문제점이있는데 6개이상의 데이터가 들어가있지않으면 실행이 불가능함.
		ranke1.setText("1 :       " + rankPg.get(0).toString());
		ranke1.setBounds(50, 100, 550, 100);
		ranke1.setFont(font);
		ranke2.setText("2 :       " + rankPg.get(1).toString());
		ranke2.setBounds(50, 170, 550, 100);
		ranke2.setFont(font);
		ranke3.setText("3 :       " + rankPg.get(2).toString());
		ranke3.setBounds(50, 240, 550, 100);
		ranke3.setFont(font);
		ranke4.setText("4 :       " + rankPg.get(3).toString());
		ranke4.setBounds(50, 310, 550, 100);
		ranke4.setFont(font);
		ranke5.setText("5 :       " + rankPg.get(4).toString());
		ranke5.setBounds(50, 380, 550, 100);
		ranke5.setFont(font);
		ranke6.setText("6 :       " + rankPg.get(5).toString());
		ranke6.setBounds(50, 450, 550, 100);
		ranke6.setFont(font);
		rankPg.clear();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (e.getSource() == gameBtn[i][j]) { //버튼부에 입력 액션을 가했을 경우 (클릭)
					clickNum++;
					numClick.setText("" + clickNum); //클릭숫자를 올린다.
					
				
					if (front[i][j] == gameNum) {     //버튼의 번호와 내가 눌러야할 숫자가 같은경우
						
						if (0 < gameNum && gameNum < 26) {       //0~25사이인 경우    
							front[i][j] = back[i][j];          //back에 있는 값을 눌렸던곳에 담음
							gameBtn[i][j].setText("" + front[i][j]);      //back에 있던 숫자가 front에 담겨서 텍스트 재셋팅
							gameBtn[i][j].setBackground(Color.orange); //다음 뒷부분의 숫자는 배경색을 칠해서 표현
						} else {
							front[i][j] = 0;              //25~50엔 이제 눌리면 프론트부분 숫자에 0넣음
							gameBtn[i][j].setText("");   //게임 버튼에 아무것도 표시하지않음
							gameBtn[i][j].setBackground(Color.darkGray); //어두운 배경색을 칠해 이 부분은 숫자가끝남을 보여줌
						}
						gameNum++; //맞췄으니까 다음숫자부분 
						btnNum.setText("" + gameNum); //다음 숫자부분 다시 불러와서 바로바로 변경하게끔 구성
						if (gameNum > 50) { 
							gameNum = 50; //숫자가 50까지인 게임이기에 50에서 종료
							timec = false; //50번까지 눌렀을때 타이머 종료시킴
							name = JOptionPane.showInputDialog("이름을 입력해주세요 "); //이름입력받는 다이얼로그
							total = clickNum + timecheck; //총점값 구함
							rank(name, clickNum, total); //파일 입력부분에 값 넘김
							
							JOptionPane.showMessageDialog(null, name + "님 게임이 종료되었습니다. 클릭한 횟수는 " + clickNum + "이며 클리어 시간은  "+ timecheck  +  " 입니다  다시하시려면 리셋 버튼을 눌러주세요"); //게임 종료와 동시 메시지창
							
						}

					}
					
				}
			}
		}

		if (e.getSource() == resetBtn) {
			reset();                //게임판을 초기화한다
		}
		if (e.getSource() == exitBtn) {
			
			win.change("gameCenter", player);      //게임센터로 되돌아감
		}
		if (e.getSource() == startBtn) {
			timecheck = 0;
			timec = true;  //boolean부분을 true로 바꿔서 작동하게끔
			timeCheck tck = new timeCheck();
			Thread t = new Thread(tck);           //위에서 재정의한것을 스레드로 넣어서 사용.
			t.start(); //스레드 실행시킴
		}
		if(e.getSource() == rankBtn) {
			rankread(); //출력부분을 읽어옴
			ranker(); //다이얼로그에 띄워준다
			dlog.setVisible(true); 
			
		}
	
	}
	
	
	public class ranking implements Comparable<ranking>{  //인터페이스로 상속 정의는 위쪽 ArrayList쪽에서했음.

		String name;		//변수선언
		int num1;
		int num2;
		
		public ranking(String name, int num1, int num2) {	//필드 생성자 작성
			super();
			this.name = name;
			this.num1 = num1;
			this.num2 = num2;
		}

		@Override
		public int compareTo(ranking o) {       //비교함수 num2값 = total이란 값을 비교. 내림차순으로 구현하였음.
			if(this.num2 > o.num2) {
				return 1;
			}else if(this.num2 == o.num2) {
				return 0;
			}else {
				return -1;
			}
		}
		@Override
		public String toString() {
			return  name + "           " + num1 + "          " + num2;
		}
		
		
	}
	
	public void rank(String name, int num1, int num2 ) {
		try {
			FileWriter fw = new FileWriter("rank.txt", true); //파일이 있는지 확인 true일시 이어쓰기가된다.)
			fw.write(name + "/");	//split을 위해 / 작성함
			fw.write(num1 + "/");
			fw.write(num2 + "/");
			fw.write("\r\n");   //캐리지리턴해줌.
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public void rankread() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("rank.txt"));
			while(true) {
				String s = br.readLine();     //줄단위로 읽어들인다
				if(s  == null) break;        //줄단위로 읽는게 비게 되면 탈출
				String[] sts = s.split("/"); //스트링 배열에 /를 제거하면서 담는다
				rankPg.add(new ranking(sts[0], Integer.parseInt(sts[1]), Integer.parseInt(sts[2])));	//위에서 선언한 어레이 리스트부분에 값을 담음.
				// Integer를 인트형으로 변경
			}
			br.close();
			Collections.sort(rankPg);
			//내림차순으로 소팅한다.
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


