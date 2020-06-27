package frameChange.controller;

import javax.swing.JFrame;

import frameChange.PlayerGame;
import frameChange.PlayerMain;
import frameChange.PlayerMart;
import frameChange.cardGame.view.MiniPoker;
import frameChange.model.vo.GameCenter;
import frameChange.model.vo.Maps;
import frameChange.model.vo.Market;
import frameChange.model.vo.Town;
import frameChange.view.Login;
import frameChange.view.MapViewer;
import frameChange.view.NewUser;
import frameChange.view.StartPage;


public class ChangePanel extends JFrame{
	
	public StartPage startpage;
	
	private NewUser newuser;
	private Login login;
//	public FindPage findpage;
//	public MainTown maintown;
	private ChangePanel mf;
	private PlayerMain playerMain;
	private PlayerGame playerGame;
	private PlayerMart playerMart;
	private MiniPoker miniPoker;
	private oneTo50 oneTo50;
	
	private MapViewer mapViewer;
	private Maps map;
	
	public void change(String panelName) {
		
		if(panelName.equals("town")) {
			getContentPane().removeAll();
			// 다형성 이용을 위해 하위클래스인 Town을 업캐스팅하여 객체 생성
			map = (Maps) new Town();
			// 매개변수로 '프레임'과 '맵이름' 전달
			mapViewer = new MapViewer(this, map);
			getContentPane().add(mapViewer);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("market")) {
			getContentPane().removeAll();
			// 다형성 이용을 위해 하위클래스인 Market을 업캐스팅하여 객체 생성
			map = (Maps) new Market();
			// 매개변수로 '프레임'과 '맵이름' 전달
			mapViewer = new MapViewer(this, map);
			getContentPane().add(mapViewer);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("gameCenter")) {
			getContentPane().removeAll();
			// 다형성 이용을 위해 하위클래스인 Market을 업캐스팅하여 객체 생성
			map = (Maps) new GameCenter();
			// 매개변수로 '프레임'과 '맵이름' 전달
			mapViewer = new MapViewer(this, map);
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
//		if(panelName.equals("FindPage")) {
//			findpage = new FindPage(this);
//			getContentPane().removeAll();
//			getContentPane().add(findpage);
//			revalidate();
//			repaint();
//		}
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
