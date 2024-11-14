package game01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class Way01 extends JFrame{
	JLabel GoldLabel;
	int GoldCounter;
	Font font1;
    ImageIcon[] gbb = {new ImageIcon(getClass().getClassLoader().getResource("img/kawi.jpg")),
    		new ImageIcon(getClass().getClassLoader().getResource("img/bawi.jpg")),
    		new ImageIcon(getClass().getClassLoader().getResource("img/bo.jpg"))};
    JButton[] btn = new JButton[gbb.length];
    JButton backtotitle = new JButton("캐릭터창");
    JLabel me= new JLabel("나");
    JLabel com= new JLabel("도박장 주인");
    JLabel win= new JLabel("준비");

    Way01(){
    	JFrame way1 = new JFrame("도박장");
        way1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GoldCounter = 500;
        createFont();
        
		JMenuBar way1menu = new JMenuBar(); //메뉴바 생성
        JMenu ScreenMenuway1 = new JMenu("메뉴"); //Screen 메뉴생성
		
		//상단 메뉴바
        ScreenMenuway1.add(new JMenuItem("저장"));
        ScreenMenuway1.add(new JMenuItem("불러오기"));
        ScreenMenuway1.addSeparator(); //분리선 삽입
        ScreenMenuway1.add(new JMenuItem("Exit"));
        
        way1menu.add(ScreenMenuway1);
        way1menu.add(new JMenu("편집"));
        way1menu.add(new JMenu("창조절"));
        way1menu.add(new JMenu("설정"));
        
        //메뉴바를 프레임에 부착
        way1.setJMenuBar(way1menu);
        
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.GRAY);
        
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.YELLOW);
        win.setForeground(Color.red);
        northPanel.add(me);
        northPanel.add(win);
        northPanel.add(com);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setBounds(100, 100, 200, 100);
		add(centerPanel);
		GoldLabel = new JLabel(GoldCounter + " Gold");
		GoldLabel.setFont(font1);
		centerPanel.add(GoldLabel);
        
		JLabel imgway01 = new JLabel();
		ImageIcon icon = new ImageIcon(Frame.class.getResource("/image/gambling.png"));
		imgway01.setIcon(icon);
		imgway01.setBounds(0, 25, 800, 450);
		way1.getContentPane().add(imgway01);
        
        for(int i=0; i<gbb.length; i++){
            btn[i]=new JButton(gbb[i]);
            btn[i].addActionListener(new MyActionListener());
            southPanel.add(btn[i]);
        }
        class MyActionListener1 implements ActionListener{

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			new Frame();
    			way1.setVisible(false);
    		}
        	
        }
        backtotitle.setSize(100,50);
        backtotitle.addActionListener(new MyActionListener1());
        southPanel.add(backtotitle);
        
        way1.add(southPanel, BorderLayout.SOUTH);
        way1.add(centerPanel,BorderLayout.CENTER);
        way1.add(northPanel,BorderLayout.NORTH);
        way1.setSize(800,600);
        way1.setVisible(true);
        way1.setLocationRelativeTo(null);
    }
    
	public void createFont() {
		font1 = new Font("MS949", Font.PLAIN, 32);
	}
    

    
    public void draw(Icon m, Icon c, String w){
        me.setIcon(m);
        com.setIcon(c);
        win.setText(w);
    }
    
    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String w;
            JButton b =(JButton)e.getSource();
            if(GoldCounter>=500) {
            int n=(int)(Math.random()*3);
            if(btn[0]==b){
                if(n==0){
                    w="비겼습니다";
                    draw(gbb[0],gbb[n],w);
                }
                else if(n==1){
                    w="<html><body><center>당신이 졌습니다..<br> <br>-500 Gold</center></body></html>";
                    draw(gbb[0],gbb[n],w);
                    if(GoldCounter>=500) {
                        GoldCounter = GoldCounter - 500;
                        GoldLabel.setText(GoldCounter + " Gold");
                    }
                }
                else if(n==2){
                    w="<html><body><center>당신이 이겼습니다!!<br> <br>+500 Gold</center></body></html>";
                    draw(gbb[0],gbb[n],w);
                    GoldCounter = GoldCounter + 500;
                    GoldLabel.setText(GoldCounter + " Gold");
                }
            }
            else if(btn[1]==b){
                if(n==0){
                    w="<html><body><center>당신이 이겼습니다!!<br> <br>+500 Gold</center></body></html>";
                    draw(gbb[1],gbb[n],w);
                    GoldCounter = GoldCounter + 500;
                    GoldLabel.setText(GoldCounter + " Gold");
                }
                else if(n==1){
                    w="비겼습니다";
                    draw(gbb[1],gbb[n],w);
                }
                else if(n==2){
                    w="<html><body><center>당신이 졌습니다..<br> <br>-500 Gold</center></body></html>";
                    draw(gbb[1],gbb[n],w);
                    if(GoldCounter>=500) {
                        GoldCounter = GoldCounter - 500;
                        GoldLabel.setText(GoldCounter + " Gold");
                    }
                }
            }
            else if(btn[2]==b){
                if(n==0){
                    w="<html><body><center>당신이 졌습니다..<br> <br>-500 Gold</center></body></html>";
                    draw(gbb[2],gbb[n],w);
                    if(GoldCounter>=500) {
                        GoldCounter = GoldCounter - 500;
                        GoldLabel.setText(GoldCounter + " Gold");
                    }
                }
                else if(n==1){
                    w="<html><body><center>당신이 이겼습니다!!<br> <br>+500 Gold</center></body></html>";
                    draw(gbb[2],gbb[n],w);
                    GoldCounter = GoldCounter + 500;
                    GoldLabel.setText(GoldCounter + " Gold");
                }
                else if(n==2){
                    w="비겼습니다";
                    draw(gbb[2],gbb[n],w);
                }
                else
                    return;
            }
            }
            else if(GoldCounter==0) {
            	GoldLabel.setText("골드가 부족합니다");
            }
        }
    }
    public static void main(String[] args) {
        new Way01();
    }
}

