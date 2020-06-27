package frameChange.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frameChange.controller.ChangePanel;

public class StartPage extends JPanel {

	private JButton loginbtn, signupbtn;
	private ChangePanel win;

	public StartPage(ChangePanel win){
		this.win = win;
		this.setLayout(null);

		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/start.jpg").getImage().getScaledInstance(1024, 768, 0)));
		label.setBounds(0, 0, 1024, 768);

		loginbtn = new JButton(new ImageIcon(new ImageIcon("images/main/login.jpg").getImage().getScaledInstance(250, 90, 0)));
		loginbtn.setBounds(200, 530, 250, 90);
		this.add(loginbtn);

		signupbtn = new JButton(new ImageIcon(new ImageIcon("images/main/signup.jpg").getImage().getScaledInstance(250, 90, 0)));
		signupbtn.setBounds(560, 530, 250, 90);
		this.add(signupbtn);

		this.add(label);

		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("login");

			}
		});
		signupbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("newuser");

			}
		});

	}

}
