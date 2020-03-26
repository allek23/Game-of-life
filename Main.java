import javax.swing.JFrame;

public class Main {
	
	static int frameHeight = 700;
	static int frameWidth = 700;
	
	public static void main(String[] args) {
		
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay();
		obj.setBounds(10, 10, 750, 750);
		//obj.setBounds(10, 10, frameHeight, frameWidth);
		obj.setTitle("Game of life");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
	}
	
	public int getFrameHeight() {
		//int frameHeight = this.frameHeight;
		return frameHeight;
	}

}
