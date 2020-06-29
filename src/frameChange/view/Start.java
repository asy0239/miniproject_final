package frameChange.view;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import frameChange.controller.ChangePanel;

public class Start {

	public Start() {
		ChangePanel mf = new ChangePanel();

		mf.setSize(1024, 768);
		mf.startpage = new StartPage(mf);
		mf.setLocationRelativeTo(null);
		mf.add(mf.startpage);

		music();
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void music() {
		String path = System.getProperty("user.dir") + "\\sound\\music\\";		
		AudioInputStream audio;
		try {
			audio = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(path + "bgm.wav")));
			
			Clip clip;
			try {
				clip = AudioSystem.getClip();
				clip.open(audio);
				clip.start();
				clip.loop(-1);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
