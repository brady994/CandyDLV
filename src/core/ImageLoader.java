package core;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	private static Image candyYellow;
	private static Image candyOrange;
	private static Image candyGreen;

	static {
		try {
			candyYellow = ImageIO.read(ImageLoader.class.getClassLoader().getResource("assets/lollipopFruitYellow.png"));
			candyOrange = ImageIO.read(ImageLoader.class.getClassLoader().getResource("assets/lollipopFruitRed.png"));
			candyGreen = ImageIO.read(ImageLoader.class.getClassLoader().getResource("assets/lollipopFruitGreen.png"));
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

}
