package gui;

import javax.swing.JFrame;

import core.GameWorld;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		new Frame();
	}

	public Frame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Candy Crush");
		this.setBounds(20, 20, 600, 600);
		this.setLocationRelativeTo(null);
		GameWorld gw = new GameWorld(6, 6);
		this.setContentPane(new Panel(gw));
		this.setVisible(true);

	}
}
