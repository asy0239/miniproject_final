package frameChange.cardGame.controller;

import java.util.Timer;
import java.util.TimerTask;

import frameChange.cardGame.view.MiniPoker;


public class TrunTimer {
	
	public boolean turn = true;
	
	public TrunTimer() {
		
	}
	
	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public void TimerStart(MiniPoker mp) {
		
		Timer m_timer = new Timer();
		
		TimerTask m_task = new TimerTask() {

			@Override
			public void run() {
				turn = true;
				while(turn) {
					try {
						Thread.sleep(1000);
						
						mp.turnCho -= 1;
						mp.turnTimer.setText(mp.turnCho + "초");
						System.out.println(mp.turnCho);
						
						if(mp.turnCho == 0) {
							
							mp.turnTimer.setText(10 + "초");
							mp.turnCho = 10;
							turn = false;
							
							mp.myTurn = true;
							mp.comTurn = false;
							mp.sound("sound/music/die.wav");
							mp.setStop(false);
							mp.getDie().setEnabled(false);
							mp.getCall().setEnabled(false);
							mp.getDdable().setEnabled(false);
							mp.getHalf().setEnabled(false);
							
						} else if(mp.turnCho < 0){
							turn = false;
							mp.turnTimer.setText(10 + "초");
							mp.turnCho = 10;
						}
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
				

			}
			
		};
		
		m_timer.schedule(m_task, 1000);
		
	}
	
}
