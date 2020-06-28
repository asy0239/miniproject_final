package frameChange.controller;

import javax.swing.JFrame;

import frameChange.cardGame.view.MiniPoker;
import frameChange.model.vo.GameCenter;
import frameChange.model.vo.Maps;
import frameChange.model.vo.Market;
import frameChange.model.vo.Player;
import frameChange.model.vo.Town;
import frameChange.view.FindPage;
import frameChange.view.Login;
import frameChange.view.MapViewer;
import frameChange.view.NewUser;
import frameChange.view.StartPage;


public class ChangePanel extends JFrame{
	
	public StartPage startpage;
	
	private NewUser newuser;
	private Login login;
	public FindPage findpage;
	private ChangePanel mf;
	private MiniPoker miniPoker;
	private oneTo50 oneTo50;
	
	private MapViewer mapViewer;
	private Maps map;
	private Maps mapTown;
	private Maps mapMarket;
	private Maps mapGameCenter;
	private Player player;
	
	public ChangePanel() {}
	
	public void change(String panelName, Player player) {
		// 기존에 생성된 player를 인자로 전달받아 맵 이동시에도 게임의 연속성 유지
		// 이미 생성된 맵 객체를 번갈아가며 이용
		
				if(panelName.equals("town")) {
					getContentPane().removeAll();
					// 다형성 이용을 위해 하위클래스인 Town을 업캐스팅하여 객체 생성
					mapViewer = new MapViewer(this, mapTown, player);
					getContentPane().add(mapViewer);
					revalidate();
					repaint();
				}
				
				if(panelName.equals("market")) {
					getContentPane().removeAll();
					// 매개변수로 '프레임'과 '맵이름' 전달
					mapViewer = new MapViewer(this, mapMarket, player);
					getContentPane().add(mapViewer);
					revalidate();
					repaint();
				}
				
				if(panelName.equals("gameCenter")) {
					getContentPane().removeAll();
					map = (Maps) new GameCenter();
					// 매개변수로 '프레임'과 '맵이름' 전달
					mapViewer = new MapViewer(this, mapGameCenter, player);
					getContentPane().add(mapViewer);
					revalidate();
					repaint();
				}
	}
	
	
	public void change(String panelName) {
		
		// 최초로 마을 입장 시에는 전달받을 Player가 없으므로
		// 1회에 한하여 player를 새로 생성해 전달
		if(panelName.equals("town")) {
			getContentPane().removeAll();
			// 다형성 이용을 위해 하위클래스(Town, Market, GameCenter)를 업캐스팅하여 객체 생성
			mapTown = (Maps) new Town();
			mapMarket = (Maps) new Market();
			mapGameCenter = (Maps) new GameCenter();
			player = new Player();
			mapViewer = new MapViewer(this, mapTown, player);
			getContentPane().add(mapViewer);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("startpage")) {
			getContentPane().removeAll();
			getContentPane().add(startpage);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("newuser")) {
			newuser = new NewUser(this);
			getContentPane().removeAll();
			getContentPane().add(newuser);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("login")) {
			login = new Login(this);
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("FindPage")) {
			findpage = new FindPage(this);
			getContentPane().removeAll();
			getContentPane().add(findpage);
			revalidate();
			repaint();
		}
		
//		if(panelName.equals("maintown")) {
//			maintown = new MainTown(this);
//			getContentPane().removeAll();
//			getContentPane().add(maintown);
//			revalidate();
//			repaint();
//		}
//		
//		if(panelName.equals("martin")) {
//			martin = new MartIn(this);
//			getContentPane().removeAll();
//			getContentPane().add(martin);
//			revalidate();
//			repaint();
//		}
//		if(panelName.equals("playerMain")) {
//			playerMain = new PlayerMain(this);
//			getContentPane().removeAll();
//			getContentPane().add(playerMain);
//			revalidate();
//			repaint();
//		}
//		if(panelName.equals("playerMart")) {
//			playerMart = new PlayerMart(this);
//			getContentPane().removeAll();
//			getContentPane().add(playerMart);
//			revalidate();
//			repaint();
//		}
//		if(panelName.equals("playerGame")) {
//			playerGame = new PlayerGame(this);
//			getContentPane().removeAll();
//			getContentPane().add(playerGame);
//			revalidate();
//			repaint();
//		}
		if(panelName.equals("miniPoker")) {
			miniPoker = new MiniPoker(this);
			getContentPane().removeAll();
			getContentPane().add(miniPoker);
			revalidate();
			repaint();
		}
		if(panelName.equals("oneTo50")) {
			oneTo50 = new oneTo50(this);
			getContentPane().removeAll();
			getContentPane().add(oneTo50);
			revalidate();
			repaint();
		}
	}
	
}
