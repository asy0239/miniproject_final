package frameChange.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;



public class Npc implements Runnable {
	private Image image;
	private Player player;
	private Maps maps;
	Thread th;
	final int npcPerMove = 10;
	
	private int x, y; // 좌표 
	private int status = 0;
	
	public Npc() {
		x = 500;
		y = 500;
		String path = System.getProperty("user.dir") + "\\images\\";
		image = new ImageIcon(path + "character\\downStand.png").getImage().getScaledInstance(50, 50, 0);
		th.start();
		
	}

	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
			try {
					Thread.sleep(500);
					goNpc();
					System.out.println("npc 쓰레드");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public void goNpc() {
		int gapX, gapY; // player 와의 좌표 차이
		gapX = player.getX() - x;
		gapY = player.getY() - y;
		
		if(gapX > 0) {
			if(maps.checkXY(x + npcPerMove, y)) {
				x += npcPerMove;
			} else if(gapX < 0) {
				if(maps.checkXY(x - npcPerMove, y)) {
					x -= npcPerMove;
				}
			}
		}
		
		if(gapY > 0) {
			if(maps.checkXY(x, y + npcPerMove)) {
				y += npcPerMove;
			} else if(gapY < 0) {
				if(maps.checkXY(x, y - npcPerMove)) {
					y -= npcPerMove;
				}
			}
		}
	}
}
