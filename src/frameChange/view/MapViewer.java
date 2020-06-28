package frameChange.view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import frameChange.controller.ChangePanel;
import frameChange.controller.MapManager;
import frameChange.model.vo.Maps;
import frameChange.model.vo.Player;

public class MapViewer extends JPanel {

	private Image screenImage;
	private ChangePanel win;
	private Graphics screenGraphics;
	private MapManager mapManager;
	private Maps map;
	private Player player;
	public int check = 0;

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public MapViewer(ChangePanel win, Maps map, Player player) {
		super();
		this.win = win;
		this.map = map;
		this.player = player;
		// 맵 이름 전달받아야 함
		mapManager = new MapManager(win, map, player);

		this.setFocusable(true);
		this.requestFocus();
		this.setSize(1024, 768);
		this.setLayout(null);
		this.setVisible(true);

		addKeyListener(new KeyHandler());

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				win.setTitle(map.getTitle());
				win.setResizable(false); // 크기조정 불가
				win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				win.setBounds(0, 0, 1024, 768);
				win.setLocationRelativeTo(null);
				win.setVisible(true);
			}

		});

	}

	@Override
	public void paint(Graphics g) {
		setFocusable(true);
		requestFocus();
		screenImage = createImage(1024, 768);
		screenGraphics = screenImage.getGraphics();
		doubleBuffered(screenGraphics);
		g.drawImage(screenImage, 0, 0, null);

		g.drawImage(mapManager.getPlayer().getPlayerNow(), mapManager.getPlayer().getX(), mapManager.getPlayer().getY(),
				null);
	}

	public void doubleBuffered(Graphics g) {
		g.drawImage(mapManager.getPlayer().moveImage(), mapManager.getPlayer().getX(), mapManager.getPlayer().getY(),
				null);
		g.drawImage(map.getImgBackground(), 0, 0, null);
	}

	public class KeyHandler implements KeyListener, ActionListener {

		/**
		 * https://micropilot.tistory.com/2953 참조 keyPressed()에서 발생한 키코드를 아래의 HashSet에
		 * 저장하면 타이머 이벤트 핸들러에서 키코드를 확인하여 화면을 갱신하는 코드를 실행한다 여기서 컬렉션 중에서 Set을 선택한 이유는 키코드가
		 * 중복되어 저장하는 것을 막고 키를 뗄 때 HashSet에서 해당 키코드를 한개만 제거해주면 즉시 이벤트 효과가 제거되므로 이벤트에 즉시
		 * 반응하는 효과를 낼 수 있다
		 */
		HashSet<Integer> pressedKeys = new HashSet<Integer>();
		Timer timer;

		public KeyHandler() {
			timer = new Timer(50, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 50ms마다 발생한 액션 이벤트 처리

					if (!pressedKeys.isEmpty()) {
						Iterator<Integer> i = pressedKeys.iterator();

						// player의 좌표값 임시 저장
						int tempX = mapManager.getPlayer().getX();
						int tempY = mapManager.getPlayer().getY();
						int tempPerMove = mapManager.getPlayer().getPerMove();

						int n = 0;

						while (i.hasNext()) {
							n = i.next();

							switch (n) {

							case KeyEvent.VK_UP:
								System.out.print(tempX + " + " + tempY + " ");
								System.out.println(map.checkXY(tempX, tempY + tempPerMove));
								// player가 이동하려는 좌표의 location 값이 true인지 확인
								if (map.checkXY(tempX, tempY - tempPerMove)) {
									mapManager.getPlayer().setY(tempY - tempPerMove);
									mapManager.getPlayer().setPlayMove(true);
								}
								mapManager.getPlayer().setStatus(1);

								break;

							case KeyEvent.VK_DOWN:
								System.out.print(tempX + " + " + tempY + " ");
								System.out.println(map.checkXY(tempX, tempY + tempPerMove));
								if (map.checkXY(tempX, tempY + tempPerMove)) {
									mapManager.getPlayer().setY(tempY + tempPerMove);
									mapManager.getPlayer().setPlayMove(true);
								}
								mapManager.getPlayer().setStatus(2);
								break;

							case KeyEvent.VK_LEFT:
								System.out.print(tempX + " + " + tempY + " ");
								System.out.println(map.checkXY(tempX, tempY + tempPerMove));
								if (map.checkXY(tempX - tempPerMove, tempY)) {
									mapManager.getPlayer().setX(tempX - tempPerMove);
									mapManager.getPlayer().setPlayMove(true);
								}
								mapManager.getPlayer().setStatus(3);
								break;

							case KeyEvent.VK_RIGHT:
								System.out.print(tempX + " + " + tempY + " ");
								System.out.println(map.checkXY(tempX, tempY + tempPerMove));
								if (map.checkXY(tempX + tempPerMove, tempY)) {
									mapManager.getPlayer().setX(tempX + tempPerMove);
									mapManager.getPlayer().setPlayMove(true);
								}
								mapManager.getPlayer().setStatus(4);
								break;

							case KeyEvent.VK_BACK_SPACE:
								// 여긴 보류
								// 로그인 창으로 되돌아가기
								break;
							}
							repaint();
						}
					} else {
						timer.stop();
					}
				}
			});
			
			
			
		}

		@Override
		public void keyPressed(KeyEvent keyEvent) {
			// 발생한 키코드를 HsshSet에 저장한다
			int keyCode = keyEvent.getKeyCode();
			pressedKeys.add(keyCode);
			if (!timer.isRunning())
				timer.start();
		}

		@Override
		public void keyReleased(KeyEvent keyEvent) {
			player.setPlayMove(false);
			repaint();
			// HashSet에서 키코드를 제거한다
			int keyCode = keyEvent.getKeyCode();
			pressedKeys.remove(keyCode);
			// 맵 이동 가능한 좌표에 이르렀을 시 맵 이동
			mapManager.moveNextMap(map, player, win);
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
