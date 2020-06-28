package frameChange.model.vo;

import javax.swing.ImageIcon;

import frameChange.controller.ChangePanel;
import frameChange.view.MapViewer;

public class GameCenter extends Maps {

	private int userX = 410; // 초기화 할 player의 x 좌표. 최초값: 인스턴스 생성 시 최초 위치
	private int userY = 600; // 초기화 할 player의 y 좌표. 최조값: 인스턴스 생성 시 최초 위치

	MapViewer mv;

	public GameCenter() {
		String path = System.getProperty("user.dir") + "\\images\\";

		// "town.png"
		super.setImgBackground(new ImageIcon(path + "bg\\gameCenter.png").getImage());
		setXY();
		this.setTitle("gameCenter");
	}
	
	public void playArcade(Player player, ChangePanel win) {
		
		System.out.println("dkjflsdjkfsafjl");
		
		if( player.getStatus() == 1
				&& (player.getX() >= 560 && player.getX() <= 690)
				&&  player.getY() == 250) {
			
			win.change("miniPoker", player);
			
		} else if(player.getStatus() == 1
				&& (player.getX() >= 220 && player.getX() <= 300)
				&&  player.getY() == 250) {
			
			win.change("oneTo50", player);
		}		
		
	}

	// 맵마다 이동 가능한 위치의 location 값을 true로 변경
	@Override
	public void setXY() {
		// 1번 구역
		for (int i = 410; i < 520; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 250; j < 700; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

		// 2번 구역
		for (int i = 20; i < 930; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 250; j < 590; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}
	}

	public int getUserX() {
		return userX;
	}

	public void setUserX(int userX) {
		this.userX = userX;
	}

	public int getUserY() {
		return userY;
	}

	public void setUserY(int userY) {
		this.userY = userY;
	}

	// Player가 위치한 x,y 좌표를 매개변수로 받아
	// 이동 가능한 좌표인지 판단하여 boolean 값으로 반환
	@Override
	public boolean checkXY(int x, int y) {

		return this.outputLocation(x, y);
	}

	@Override
	public String mapChange(int x, int y) {
		if ((x >= 390 && x <= 510) && (y >= 620)) {
			return "town";
		} else {
			return "";
		}

	}

	@Override
	public void saveLocation(Player player) {
		this.userX = player.getX();
		this.userY = player.getY();
	}

}
