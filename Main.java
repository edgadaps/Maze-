import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	static JPanel panel;
	static Graphics g;
	public static int x;
	public static int y;
	public static int timer=0;
	public static int totalTime = 1000;
	static int used = 0;
	/**
	 * Launch the application.
	 */
	public static void update(Beyblade bey1,Beyblade bey2){
		Boolean collision = false;
		while(true){
			if (timer == totalTime){
				return;
			}
			
			bey1.fight();
			bey2.fight();
			if (!collision){
				bey1.prevX = bey1.xPos;
				bey1.prevY = bey1.yPos;
				bey2.prevX = bey2.xPos;
				bey2.prevY = bey2.yPos;		
			}
			
			bey1.xPos = bey1.xPos + (int)bey1.xSpeed;
			bey2.xPos = bey2.xPos + (int)bey2.xSpeed;
			bey1.yPos = bey1.yPos + (int)bey1.ySpeed;
			bey2.yPos = bey2.yPos + (int)bey2.ySpeed;

//			System.out.println(bey1.xPos);
//			System.out.println(bey2.xPos);
//			System.out.println(collision);
//			System.out.println(bey1.xSpeed);
			
			collision = false;
			
//			if(Math.max(bey1.xPos, bey2.xPos)-Math.min(bey1.xPos, bey2.xPos)<50 && 
//					Math.max(bey1.yPos, bey2.yPos)-Math.min(bey1.yPos, bey2.yPos)<50){
			
			if(Math.pow(Math.abs(bey1.xPos-bey2.xPos),2)+Math.pow(Math.abs(bey1.yPos-bey2.yPos),2)<2500){
				bey1.spdX = bey1.xSpeed;
				bey1.spdY = bey1.ySpeed;
				bey1.xSpeed = bey2.xSpeed+5;
				bey1.ySpeed = bey2.ySpeed+5;
				bey2.xSpeed = bey1.spdX+5;
				bey2.ySpeed = bey1.spdY+5;
				collision = true;
			}
			g.clearRect(0,0,600,400);
			g.drawLine(x/2,0,x/2, y);
			g.drawLine(0,y/2,x, y/2);
			g.setColor(Color.BLUE);
			g.fillOval(bey1.xPos-25,bey1.yPos-25,50,50);
			g.setColor(Color.RED);
			g.fillOval(bey2.xPos-25,bey2.yPos-25,50,50);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(collision){
				bey1.xPos = bey1.prevX;
				bey1.yPos = bey1.prevY;
				bey2.xPos = bey2.prevX;
				bey2.yPos = bey2.prevY;
			}
			timer++;
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Beyblades 0.0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(10, 10, 600, 400);
		contentPane.add(panel);
		
		JButton btnS = new JButton("S");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g = panel.getGraphics();
				x = panel.getWidth();
				y = panel.getHeight();
				Beyblade bey1 = new Beyblade(30,30);
				Beyblade bey2 = new Beyblade(570,370);
				update(bey1,bey2);

			}
		});
		btnS.setBounds(620, 10, 58, 23);
		contentPane.add(btnS);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(620, 46, 58, 23);
		contentPane.add(btnNewButton_1);
	}
}
