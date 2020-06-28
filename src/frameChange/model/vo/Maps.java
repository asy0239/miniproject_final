package frameChange.model.vo;

import java.awt.Image;

import javax.swing.JPanel;

import frameChange.controller.ChangePanel;

public abstract class Maps extends JPanel {

	private String title;
	private final int WIDTH = 1024; // 맵의 가로크기
	private final int HEIGHT = 768; // 맵의 세로크기
	private Image imgBackground; // 배경 이미지
	private boolean[][] location = new boolean[WIDTH][HEIGHT]; // 맵 좌표정보

	public Maps() {
		initLocation();
	}
	
	// 이동 가능한 장소 '없음'으로 초기화 메소드
	// false: 이동불가지역
	// true: 이동가능지역
	
	public void initLocation() {
		for (int i = 0; i < this.location.length; i++) {
			for (int j = 0; j < this.location[i].length; j++) {
				this.location[i][j] = false;
			}
		}
	}	
	
	// 맵마다 고유의 좌표정보를 입력받도록 상속 강제
	public abstract void setXY();
	
	// 맵 고유 좌표에서 이동 가능한 부분 확인
	public abstract boolean checkXY(int x, int y);

	// 맵 to 맵으로 이동 가능한 좌표인지 확인
	// checkXY내에서 사용
	public abstract String mapChange(int x, int y);
	
	// 캐릭터가 다른 맵으로 이동 시 기존의 좌표를 맵 객체에 저장
	public abstract void saveLocation(Player player);
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Image getImgBackground() {
		return imgBackground;
	}

	public void setImgBackground(Image imgBackground) {
		this.imgBackground = imgBackground;
	}

	
	// outLocation으로 대체
//	public boolean[][] getLocation() {
//		return location;
//	}

	public void setLocation(boolean[][] location) {
		this.location = location;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void inputLocation(int x, int y, boolean b) {
		
		this.location[x][y] = b;
	}
	
	public boolean outputLocation(int x, int y) {
		return this.location[x][y];
	}
	
}
