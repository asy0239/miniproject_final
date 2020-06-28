package frameChange.model.vo;

import javax.swing.ImageIcon;

import frameChange.controller.ChangePanel;
import frameChange.view.MapViewer;

public class Town extends Maps {

	private int userX = 10; // 초기화 할 player의 x 좌표. 최초값: 인스턴스 생성 시 최초 위치
	private int userY = 10; // 초기화 할 player의 y 좌표. 최초값: 인스턴스 생성 시 최초 위치

	public Town() {
		String path = System.getProperty("user.dir") + "\\images\\";

		super.setImgBackground(new ImageIcon(path + "bg\\town.png").getImage());
		setXY();
		this.setTitle("town");

	}

	// 맵마다 이동 가능한 위치의 location 값을 true로 변경
	@Override
	public void setXY() {

		for (int i = 10; i < 60; i++) { // 가로 좌표 범위: 10 < x < 50
			for (int j = 10; j < 700; j++) { // 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}

		for (int i = 10; i < 1010; i++) {
			for (int j = 300; j < 350; j++) {
				this.inputLocation(i, j, true);
			}
		}

		for (int i = 60; i < 130; i++) {
			for (int j = 350; j < 360; j++) {
				this.inputLocation(i, j, true);
			}
		}

		for (int i = 460; i < 1010; i++) {
			for (int j = 350; j < 360; j++) {
				this.inputLocation(i, j, true);
			}
		}

		for (int i = 530; i < 690; i++) {
			for (int j = 10; j < 700; j++) {
				this.inputLocation(i, j, true);
			}
		}

		for (int i = 10; i < 1010; i++) {
			for (int j = 680; j < 700; j++) {
				this.inputLocation(i, j, true);
			}
		}

		// 시네마 입구
		for (int i = 160; i <= 200; i++) {
			for (int j = 260; j < 300; j++) {
				this.inputLocation(i, j, true);
			}
		}

		// 마트 입구
		for (int i = 340; i <= 370; i++) {
			for (int j = 260; j < 300; j++) {
				this.inputLocation(i, j, true);
			}
		}

		// 오락실 입구
		for (int i = 850; i <= 890; i++) {
			for (int j = 260; j < 300; j++) {
				this.inputLocation(i, j, true);
			}
		}

		// 하단 왼쪽 입구
		for (int i = 280; i < 310; i++) {
			for (int j = 630; j < 680; j++) {
				this.inputLocation(i, j, true);
			}
		}

		// 하단 오른쪽 입구
		for (int i = 840; i < 850; i++) {
			for (int j = 650; j < 680; j++) {
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
		if ((x >= 160 && x <= 200) && (y == 260)) {
			return ""; // 미설정 값
		} else if ((x >= 340 && x <= 370) && (y == 260)) {
			return "market";
		} else if ((x >= 850 && x <= 890) && (y == 260)) {
			return "gameCenter";
		} else {
			return "";
		}
	}

	@Override
	public void saveLocation(Player player) {
		this.userX = player.getX();
		// 건물에서 나왔을 때 한 칸 아래로 초기화되어 건물에 재입장 되는 것 방지
		this.userY = player.getY() + player.perMove;
	}

}
