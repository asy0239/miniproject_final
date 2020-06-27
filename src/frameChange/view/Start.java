package frameChange.view;

import javax.swing.JFrame;

import frameChange.controller.ChangePanel;

public class Start {

	public Start() {
		ChangePanel mf = new ChangePanel();
		
		mf.setSize(1024, 768);
		mf.startpage = new StartPage(mf);

		mf.add(mf.startpage);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
