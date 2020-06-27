package frameChange.model.vo;

import javax.swing.ImageIcon;

import frameChange.controller.ChangePanel;
import frameChange.view.MapViewer;

public class GameCenter extends Maps{

	private int userX = 440;	// 초기화 할  player의 x 좌표. 최초값: 인스턴스 생성 시 최초 위치
	private int userY = 660;	// 초기화 할  player의 y 좌표. 최조값: 인스턴스 생성 시 최초 위치
	
	MapViewer mv;
	public GameCenter() {
		String path = System.getProperty("user.dir") + "\\images\\";
		
		// "town.png"
		super.setImgBackground(new ImageIcon(path + "bg\\gameCenter.png").getImage());
		setXY();
		this.setTitle("gameCenter");
	}


	// 맵마다 이동 가능한 위치의 location 값을 1로 변경
	@Override
	public void setXY() {
		// 1번 구역
		for(int i = 410; i < 520; i++) {			// 가로 좌표 범위: 10 < x < 50
			for(int j=250; j< 700; j++) {		// 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}		
		
		// 2번 구역
		for(int i = 20; i < 930; i++) {			// 가로 좌표 범위: 10 < x < 50
			for(int j=250; j< 590; j++) {		// 세로 좌표 범위: 100 < y < 200
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

	// 출입구 재설정 필요!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@Override
	public void mapChange(int x, int y, ChangePanel win) {
	      if((x >= 420 && x <= 480) && (y >= 680 && y<= 700)) {
		         win.change("town");
		      }
	      
		   if((x >= 240 && x <= 280) && ( y == 260)) {
			   win.change("oneTo50");
		   }
		   
		   if((x >= 560 && x <= 700) && (y == 260)) {
			   win.change("miniPoker");
			   
		   }
		   
	}

}
