package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.GameWorld;
import core.ImageLoader;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Frame frame;
	private JButton buttonStart;
	private GameWorld gw;
	private GridBagConstraints constraint;

	public MenuPanel(Frame frame, GameWorld gw) {
		this.frame = frame;
		this.gw = gw;

		this.constraint = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);

		buttonStart = new JButton(ImageLoader.getProva());
		buttonStart.setRolloverEnabled(true);
		buttonStart.setRolloverIcon(ImageLoader.getRollstart());
		buttonStart.setBorderPainted(false);

		setListener();
		constraint.insets.set(20, 20, 20, 20);
		constraint.gridx = 0;
		constraint.gridy = 0;
		this.add(buttonStart, constraint);

	}

	private void setListener() {
		buttonStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel game = new Panel(gw);
				game.setBounds(900, 900, 100, 100);
				JPanel p = new JPanel();
				p.setLayout(new BorderLayout());
				p.add(game, BorderLayout.CENTER);
				frame.setContentPane(p);
				game.requestFocus();
				game.updateUI();
				frame.setVisible(true);

			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageLoader.getCandyBackground(), 0, 0, null);
	}
}
