package core;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageLoader {
	private static Image candyYellow;
	private static Image candyOrange;
	private static Image candyGreen;
	private static Image candyBackground;
	private static Icon prova;

	static {
		try {
			candyYellow = ImageIO.read(ImageLoader.class.getClassLoader().getResource("assets/lollipopFruitYellow.png"));
			candyOrange = ImageIO.read(ImageLoader.class.getClassLoader().getResource("assets/lollipopFruitRed.png"));
			candyGreen = ImageIO.read(ImageLoader.class.getClassLoader().getResource("assets/lollipopFruitGreen.png"));
			candyBackground = ImageIO.read(ImageLoader.class.getClassLoader().getResource("assets/SfondoCandy.png"));
			prova = new ImageIcon(ImageLoader.class.getClassLoader().getResource("assets/soldi.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Image getCandyOrange() {
		return candyOrange;
	}

	public static Image getCandyYellow() {
		return candyYellow;
	}

	public static Image getCandyGreen() {
		return candyGreen;
	}

	public static Image getCandyBackground() {
		return candyBackground;
	}

	public static Icon getProva() {
		return prova;
	}

}
