package frameChange.model.vo;

import javax.swing.ImageIcon;

import frameChange.controller.ChangePanel;
import frameChange.view.MapViewer;


public class Town extends Maps {

	private int userX = 10;	// 珥덇린�솕 �븷  player�쓽 x 醫뚰몴. 理쒖큹媛�: �씤�뒪�꽩�뒪 �깮�꽦 �떆 理쒖큹 �쐞移�
	private int userY = 10;	// 珥덇린�솕 �븷  player�쓽 y 醫뚰몴. 理쒖“媛�: �씤�뒪�꽩�뒪 �깮�꽦 �떆 理쒖큹 �쐞移�
	
	private int x, y;
	private final int npcPerMove = 10;
	Thread th;
	Player player;
	Maps maps;
	MapViewer mv;
	
	
	public Town() {
		String path = System.getProperty("user.dir") + "\\images\\";
		
		// "town.png"
		
		super.setImgBackground(new ImageIcon(path + "bg\\town.png").getImage());
		setXY();
		this.setTitle("town");
		
		
	}


	// 留듬쭏�떎 �씠�룞 媛��뒫�븳 �쐞移섏쓽 location 媛믪쓣 1濡� 蹂�寃�
	@Override
	public void setXY() {
		//1번 구역
//		for(int i = 10; i < 1010; i++) {			// 가로 좌표 범위: 10 < x < 50
//			for(int j=10; j< 700; j++) {		// 세로 좌표 범위: 100 < y < 200
//				this.inputLocation(i, j, true);
//	
		
//		}		
		
		// 2번 구역
		for(int i = 10; i < 60; i++) {			// 가로 좌표 범위: 10 < x < 50
			for(int j=10; j< 700; j++) {		// 세로 좌표 범위: 100 < y < 200
				this.inputLocation(i, j, true);
			}
		}
		
		for(int i = 10; i < 1010; i++) {
			for(int j = 300; j < 350; j++) {
				this.inputLocation(i, j, true);				
			}			
		}
		
		for(int i = 60; i < 130; i++) {
			for(int j = 350; j < 360; j++) {
				this.inputLocation(i, j, true);
			}
		}
		
		for(int i = 460; i < 1010; i++) {
			for(int j = 350; j < 360; j++) {
				this.inputLocation(i, j, true);
			}
		}
		
		for(int i = 530; i < 690; i++) {
			for(int j = 10; j < 700; j++) {
				this.inputLocation(i, j, true);
			}
		}
		
		for(int i = 10; i < 1010; i++) {
			for(int j = 680; j< 700; j++) {
				this.inputLocation(i, j, true);
			}
		}
		
		// 시네마 입구 
		for(int i = 170; i < 210; i++) {
			for(int j = 260; j < 300;j++) {
				this.inputLocation(i, j, true);
			}
		}
		
		// 마트 입구
		for(int i = 350; i < 400; i++) {
			for(int j = 270; j < 300; j++) {
				this.inputLocation(i, j, true);
			}
		}
		
		// 오락실 입구
		for(int i = 870; i < 880; i++) {
			for(int j = 270; j < 300; j++) {
				this.inputLocation(i, j, true);
			}
		}
		
		// 하단 왼쪽 입구
		for(int i = 280; i < 310; i++) {
			for(int j = 630; j < 680; j++) {
				this.inputLocation(i, j, true);
			}
		}
		
		
		// 하단 오른쪽 입구
		for(int i = 840; i < 850; i++) {
			for(int j = 650; j < 680; j++) {
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


	// Player媛� �쐞移섑븳 x,y 醫뚰몴瑜� 留ㅺ컻蹂��닔濡� 諛쏆븘
	// �씠�룞 媛��뒫�븳 醫뚰몴�씤吏� �뙋�떒�븯�뿬 boolean 媛믪쑝濡� 諛섑솚
	@Override
	public boolean checkXY(int x, int y) {
		
		return this.outputLocation(x, y);
	}


	@Override
	public void mapChange(int x, int y, ChangePanel win) {
		 if((x >= 170 && x <= 230) && (y >= 240 && y <= 270)) {
	         win.change("");	// 誘몄젙
	      }
	      
	      if((x >= 350 && x <= 400) && (y >= 260 && y <= 290)) {
	         win.change("market");
	      }

	      if((x >= 850 && x <= 900) && (y >= 270 && y <= 290)) {
	    	  win.change("gameCenter");
	      }
	}	

}
