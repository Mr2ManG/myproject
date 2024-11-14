package game01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class win {
		JLabel HPLabel, GoldLabel, perSecLabel;


		public win() {

			// 부모 프레임 생성
			JFrame win = new JFrame("클리어!");
	 
			// 부모 프레임 크기 설정 (가로, 세로)
			win.setSize(800, 600);
	 
			// 부모 프레임을 화면 가운데에 배치
			win.setLocationRelativeTo(null);
	 
			// 부모 프레임을 닫았을 때 메모리에서 제거되도록 설정
			win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
			// 부모 레이아웃 설정
			win.getContentPane().setLayout(null);	
			
			JMenuBar frmmenu = new JMenuBar(); //메뉴바 생성
	        JMenu ScreenMenu = new JMenu("메뉴"); //Screen 메뉴생성
	        
	        //상단 메뉴바
	        ScreenMenu.add(new JMenuItem("저장"));
	        ScreenMenu.add(new JMenuItem("불러오기"));
	        ScreenMenu.addSeparator(); //분리선 삽입
	        ScreenMenu.add(new JMenuItem("Exit"));
	        
	        frmmenu.add(ScreenMenu);
	        frmmenu.add(new JMenu("편집"));
	        frmmenu.add(new JMenu("창조절"));
	        frmmenu.add(new JMenu("설정"));
	        
	        //메뉴바를 프레임에 부착
	        win.setJMenuBar(frmmenu);
	 
	        //이미지 바탕화면 부착
			JLabel imgmain = new JLabel();
			ImageIcon icon = new ImageIcon(Frame.class.getResource("/image/winthegame.png"));
			imgmain.setIcon(icon);
			imgmain.setBounds(0, 0, 800, 450);
			win.getContentPane().add(imgmain);
			

			
			// 부모 프레임이 보이도록 설정
	        win.setVisible(true);
	        win.setLocationRelativeTo(null);
	        win.setLayout(null);
			
	        JButton backtotitle = new JButton("던전으로");
	        backtotitle.setLocation(660,10);
	        backtotitle.setSize(100,30);
	        win.add(backtotitle);
	        
	        backtotitle.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new Way02();
	                win.setVisible(false);}});
	        

			
			JLabel winlabel = new JLabel("Just Keep Going");
			winlabel.setBounds(570, 150, 200, 200);
			winlabel.setFont(new Font("Serif", Font.BOLD, 20));
			win.add(winlabel);

		}

		
		
		public static void main(String[] args)
		{
			new win();
		}
		

		
	}//클래스 종료