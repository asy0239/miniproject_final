package frameChange.model.vo;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Npc extends JPanel implements Runnable {
	private Image screenImage;
	private Graphics screenGraphics;

	private Image image;
	private Player player;
	private Maps map;
	Thread th;
	final int npcPerMove = 10;

	private int x, y; // 좌표
	private int status = 0;
	private boolean stopSign = true;

	public Npc(Maps map, Player player) {
		this.map = map;
		this.player = player;
		
		x = ((Town)map).getNpcX();
		y = ((Town)map).getNpcY();
		String path = System.getProperty("user.dir") + "\\images\\";
		image = new ImageIcon(path + "character\\downStand.png").getImage().getScaledInstance(50, 50, 0);

		th = new Thread(this);
		th.start();
	}
	
	public void start() {
		while(!stopSign) {
			run();
		}
	}

	public boolean isStopSign() {
		return stopSign;
	}

	public void setStopSign(boolean stopSign) {
		this.stopSign = stopSign;
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
	public void paint(Graphics g) {
		g.drawImage(this.image, this.x, this.y, null);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
			try {
				Thread.sleep(100);
				goNpc();
				System.out.println("npc 쓰레드");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void goNpc() {
		int gapX, gapY; // player 와의 좌표 차이

		gapX = player.getX() - this.x;
		gapY = player.getY() - this.y;

		System.out.println("gapX: " + gapX + "  gapY:" + gapY);
		System.out.println("x: " + this.x + "  y:" + this.y);

		if (gapX > 0) {
			if (((Town) map).checkXY(this.x + npcPerMove, y)) {
				this.x += npcPerMove;
			} else {
			}

		} else if (gapX < 0) {
			if (((Town) map).checkXY(x - npcPerMove, y)) {
				x -= npcPerMove;
			} else {
			}
		}

		if (gapY > 0)

		{
			if (((Town) map).checkXY(x, y + npcPerMove)) {
				y += npcPerMove;
			} else {
			}

		} else if (gapY < 0) {
			if (((Town) map).checkXY(x, y - npcPerMove)) {
				y -= npcPerMove;
			} else {
			}
		}
	}
}
