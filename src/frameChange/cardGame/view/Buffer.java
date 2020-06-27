package frameChange.cardGame.view;

import frameChange.cardGame.TrunTimer.TrunTimer;

public class Buffer{
	private int data;
	private boolean empty = true;
	private int i = 1;
	private int random = 0;
	private int startStop = 0;
	private TrunTimer tTimer = new TrunTimer();
	
	//유저
	public synchronized void myTurn(MiniPoker mp) {
		
		while(empty) {
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		tTimer.TimerStart(mp);
		
		mp.getDie().setEnabled(true);
		mp.getCall().setEnabled(true);
		mp.getDdable().setEnabled(true);
		mp.getHalf().setEnabled(true);
		empty = true;
		System.out.println("유저: " + data + " 턴");
		
		try {
			
			while(mp.isStop()) {
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
		
	}
	
	//컴퓨터
	public synchronized void comTurn(int data, MiniPoker mp) {
		while(!empty) {
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.data = data;
		empty = false;
		mp.getDie().setEnabled(false);
		mp.getCall().setEnabled(false);
		mp.getDdable().setEnabled(false);
		mp.getHalf().setEnabled(false);
		System.out.println("컴퓨터: " + data + " 턴");
		mp.setStop(true);
		
		random = (int) (Math.random() * 3) + 1;
		int comSecond = (int) (Math.random() * 3) + 1;
		int second = 0;
		
		startStop+=1;
		System.out.println(startStop);
		if( startStop  >= 2) {
			
			if(comSecond == 1) {
				second = 1000;
				
			} else if (comSecond == 2) {
				second = 2000;
				
			} else if (comSecond == 3) {
				second = 3000;
			}
			
			try {
				Thread.sleep(second);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			////////////////////////////////콜
			if(random == 1) {
				mp.sound("sound/music/call.wav");
				mp.panDon1 += mp.panDon2;
				mp.comMoney1 -= mp.panDon2;
				mp.getPanDon().setText(Integer.toString(mp.panDon1));
				mp.comMoney.setText(Integer.toString(mp.comMoney1));
				mp.panDon2 += mp.panDon2;
				
			} else if (random == 2) {
				///////////////////////////더블
				mp.sound("sound/music/ddable.wav");
				mp.panDon1 += mp.panDon2 * 2;
				mp.comMoney1 -= mp.panDon2 * 2;
				mp.getPanDon().setText(Integer.toString(mp.panDon1));
				mp.comMoney.setText(Integer.toString(mp.comMoney1));
				mp.panDon2 += mp.panDon2 * 2;
				
			} else if (random == 3) {
				///////////////////////////하프
				mp.sound("sound/music/half.wav");
				mp.panDon1 += mp.panDon2 / 2;
				mp.comMoney1 -= mp.panDon2 / 2;
				mp.getPanDon().setText(Integer.toString(mp.panDon1));
				mp.comMoney.setText(Integer.toString(mp.comMoney1));
				mp.panDon2 += mp.panDon2 / 2;
				
			} else if (random == 0) {
				int dieRandom = (int) (Math.random() * 10) + 1;
				
				if(dieRandom == 3) {
					///////////////////////////다이
					mp.sound("sound/music/die.wav");	
					
				} else {
					
					random = (int) (Math.random() * 3) + 1;
					
				}
				
			}
			
		}
		

		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		notify();

	}
}

