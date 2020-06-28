package frameChange.model.vo;

import javax.swing.ImageIcon;

import frameChange.controller.ChangePanel;

public class Market extends Maps {
	private int userX = 850; // 초기화 할 player의 x 좌표. 최초값: 인스턴스 생성 시 최초 위치
	private int userY = 120; // 초기화 할 player의 y 좌표. 최조값: 인스턴스 생성 시 최초 위치

	public Market() {
		String path = System.getProperty("user.dir") + "\\images\\";

		// "town.png"
		super.setImgBackground(new ImageIcon(path + "bg\\market.png").getImage());
		setXY();

		this.setTitle("market");
	}

	// 맵마다 이동 가능한 위치의 location 값을 true로 변경
	@Override
	public void setXY() {

		// 카운터 위
		for (int i = 520; i <= 740; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 40; j <= 50; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}
		
		// 카운터 복도
		for (int i = 740; i <= 740; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 40; j <= 90; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}
		
		// 우상단
		for (int i = 740; i <= 910; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 90; j <= 190; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}
		// 좌상단
		for (int i = 70; i <= 290; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 120; j <= 210; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

		// 좌상단 복도
		for (int i = 290; i <= 430; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 190; j < 230; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

		// 중앙
		for (int i = 430; i <= 820; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 190; j <= 410; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}
		
		// 하단
		for (int i = 30; i <= 840; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 410; j <= 580; j++) { // 세로 좌표 범위: 100 < y < 200
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
		if ((x >= 910) && (y >= 90 && y <= 200)) {
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
