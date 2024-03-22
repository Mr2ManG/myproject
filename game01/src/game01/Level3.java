package game01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Level3 {
	
	JLabel HPLabel, GoldLabel, perSecLabel;
	JButton button1, button2, button3, button4;
	int Mon1HP, timerSpeed, SlashNumber, SlashPrice, GoldCounter, ClearCounter;
	double perDmgSecond;
	boolean timerOn;
	Font font1, font2;
	Mon1Handler cHandler = new Mon1Handler();
	Timer timer;
	JTextArea messageText;
	MouseHandler mHandler = new MouseHandler();
	
	int SmashNumber = 0;
	int SmashPrice = 100;
	boolean SmashUnlocked = false;
	
	int StingNumber = 0;
	int StingPrice = 300;
	boolean StingUnlocked = false;
	
	int StrikeNumber = 0;
	int StrikePrice = 500;
	boolean StrikeUnlocked = false;
	
	public static void main(String[] args) {
		new Level3();
	}
	public Level3() {
		
		timerOn = false;
		perDmgSecond = 0;
		Mon1HP = 10;
		SlashNumber = 0;
		SlashPrice = 10;
		GoldCounter = 2000;
		
		createFont();
		createUI();
	}
	
	public void createFont() {
		font1 = new Font("MS949", Font.PLAIN, 32); //폰트 종류 및 크기 지정
		font2 = new Font("MS949", Font.PLAIN, 15);
		
	}
	
	public void createUI() {
		JFrame window = new JFrame("던전 Lv.3");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		JPanel Mon1Panel = new JPanel();
		Mon1Panel.setBounds(100, 220, 200, 200);
		Mon1Panel.setBackground(Color.black);
		window.add(Mon1Panel);
		
		ImageIcon Mon1 = new ImageIcon(getClass().getClassLoader().getResource("Mon3.png"));
		
		JButton Mon1Button = new JButton();
		Mon1Button.setBackground(Color.black);
		Mon1Button.setFocusPainted(false);
		Mon1Button.setBorder(null);
		Mon1Button.setIcon(Mon1);
		Mon1Button.addActionListener(cHandler);
		Mon1Button.setActionCommand("Mon1");
		Mon1Panel.add(Mon1Button);
		

		JMenuBar waymenu = new JMenuBar();
		JMenu ScreenMenu = new JMenu("메뉴");
		
		ScreenMenu.add(new JMenuItem("저장"));
        ScreenMenu.add(new JMenuItem("불러오기"));
        ScreenMenu.add(new JMenuItem("Exit"));
        
        waymenu.add(ScreenMenu);
        waymenu.add(new JMenu("편집"));
        waymenu.add(new JMenu("창조절"));
        waymenu.add(new JMenu("설정"));
        
        window.setJMenuBar(waymenu);

    	JLabel imgmain1 = new JLabel();
    	ImageIcon icon1 = new ImageIcon(Frame.class.getResource("/image/dungeon4.jpg"));
    	imgmain1.setIcon(icon1);
    	imgmain1.setBounds(0, 0, 800, 550);
    	window.getContentPane().add(imgmain1);  //배경화면
		
        JButton backtotitle = new JButton("던전으로");
        backtotitle.setLocation(660,10);
        backtotitle.setSize(100,30);
        window.add(backtotitle);
        
        backtotitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Way02();
                window.setVisible(false);}});
		
		
		
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100, 100, 200, 100);
		counterPanel.setBackground(Color.black);
		counterPanel.setLayout(new GridLayout(3, 1));
		window.add(counterPanel);
		
		HPLabel = new JLabel(Mon1HP + " HP");
		HPLabel.setForeground(Color.white);
		HPLabel.setFont(font1);
		counterPanel.add(HPLabel);
		
		GoldLabel = new JLabel(GoldCounter + " Gold");
		GoldLabel.setForeground(Color.white);
		GoldLabel.setFont(font1);
		counterPanel.add(GoldLabel);
		
		perSecLabel = new JLabel();
		perSecLabel.setForeground(Color.white);
		perSecLabel.setFont(font2);
		counterPanel.add(perSecLabel);	
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(500, 170, 250, 250);
		itemPanel.setBackground(Color.black);
		itemPanel.setLayout(new GridLayout(4, 1));
		window.add(itemPanel);
		
		button1 = new JButton("Slash");
		button1.setFont(font1);
		button1.setFocusPainted(false);
		button1.addActionListener(cHandler);
		button1.setActionCommand("Slash");
		itemPanel.add(button1);
		button1.addMouseListener(mHandler);
		
		button2 = new JButton("?");
		button2.setFont(font1);
		button2.setFocusPainted(false);
		button2.addActionListener(cHandler);
		button2.setActionCommand("Smash");
		itemPanel.add(button2);
		button2.addMouseListener(mHandler);
		
		button3 = new JButton("?");
		button3.setFont(font1);
		button3.setFocusPainted(false);
		button3.addActionListener(cHandler);
		button3.setActionCommand("Sting");
		itemPanel.add(button3);
		button3.addMouseListener(mHandler);
		
		button4 = new JButton("?");
		button4.setFont(font1);
		button4.setFocusPainted(false);
		button4.addActionListener(cHandler);
		button4.setActionCommand("Strike");
		itemPanel.add(button4);
		button4.addMouseListener(mHandler);
		
		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(500, 70, 250, 250);
		messagePanel.setBackground(Color.black);
		window.add(messagePanel);		
		
		messageText = new JTextArea();
		messageText.setBounds(500, 70, 250, 250);
		messageText.setBackground(Color.white);
		messageText.setBackground(Color.black);
		messageText.setFont(font2);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setEditable(false);
		messagePanel.add(messageText);
		
		window.setVisible(true);
	}
	
	public void setTimer() {
		timer = new Timer(timerSpeed, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Mon1HP--;
				if(Mon1HP == 0) {
					GoldCounter = GoldCounter + 10;
					Mon1HP = Mon1HP + 10;
					GoldLabel.setText(GoldCounter + " Gold");
					ClearCounter++;
					if(ClearCounter==10) {
						new win();
					}
				}
				
				HPLabel.setText(Mon1HP + " HP");
				if(SmashUnlocked==false) {
					if(GoldCounter>=100) {
						SmashUnlocked=true;
						button2.setText("Smash " + "(" + SmashNumber + ")");						
					}
				}
				if(StingUnlocked==false) {
					if(GoldCounter>=300) {
						StingUnlocked=true;
						button3.setText("Sting " + "(" + StingNumber + ")");						
					}
				}
				if(StrikeUnlocked==false) {
					if(GoldCounter>=500) {
						StrikeUnlocked=true;
						button4.setText("Strike " + "(" + StrikeNumber + ")");						
					}
				}
			}
		});
	}
	
	public void timerUpdate() {
		if(timerOn == false) {
			timerOn = true;
		}
		else if(timerOn==true) {
			timer.stop();
		}
		
		double speed = 1/perDmgSecond*1000;
		timerSpeed = (int)Math.round(speed);
		
		String s = String.format("%.2f", perDmgSecond);
		perSecLabel.setText("초당 대미지: " + s);
		
		setTimer();
		timer.start();
	}

	
	
	public class Mon1Handler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String action = event.getActionCommand();
			switch(action) {
			case "Mon1":
				Mon1HP--;
				HPLabel.setText(Mon1HP + " HP");
				if(Mon1HP==0)
					{
						GoldCounter = GoldCounter + 10;
						Mon1HP = Mon1HP + 10;
						GoldLabel.setText(GoldCounter + " Gold");
					}
				break;
				
			case "Slash":
				if(GoldCounter>=SlashPrice) {
					GoldCounter = GoldCounter - SlashPrice;
					SlashPrice = SlashPrice + 5;
					HPLabel.setText(Mon1HP + " HP");
					GoldLabel.setText(GoldCounter + " Gold");
					
					SlashNumber++;
					button1.setText("Slash " + "(" + SlashNumber + ")");
					messageText.setText("슬래쉬\n[지불: "+ SlashPrice +" Gold]\n10초당 대미지 + 1");
					perDmgSecond = perDmgSecond + 0.1;
					timerUpdate();
				}
				else {
					messageText.setText("골드가 부족합니다!");
				}
				break;
			case "Smash":
				if(GoldCounter>=SmashPrice) {
					GoldCounter = GoldCounter - SmashPrice;
					SmashPrice = SmashPrice + 50;
					HPLabel.setText(Mon1HP + " HP");
					GoldLabel.setText(GoldCounter + " Gold");
					
					SmashNumber++;
					button2.setText("Smash " + "(" + SmashNumber + ")");
					messageText.setText("스매쉬\n[지불: "+ SmashPrice +" Gold]\n1초당 대미지 + 1");

					perDmgSecond = perDmgSecond + 1;
					timerUpdate();
				}
				else {
					messageText.setText("골드가 부족합니다!");
				}
				break;
			case "Sting":
				if(GoldCounter>=SmashPrice) {
					GoldCounter = GoldCounter - StingPrice;
					StingPrice = StingPrice + 100;
					HPLabel.setText(Mon1HP + " HP");
					GoldLabel.setText(GoldCounter + " Gold");
					
					StingNumber++;
					button3.setText("Sting " + "(" + StingNumber + ")");
					messageText.setText("스팅\n[지불: "+ StingPrice +" Gold]\n1초당 대미지 + 5");

					perDmgSecond = perDmgSecond + 5;
					timerUpdate();
				}
				else {
					messageText.setText("골드가 부족합니다!");
				}
				break;
			case "Strike":
				if(GoldCounter>=StrikePrice) {
					GoldCounter = GoldCounter - StrikePrice;
					StrikePrice = StrikePrice + 200;
					HPLabel.setText(Mon1HP + " HP");
					GoldLabel.setText(GoldCounter + " Gold");
					
					StrikeNumber++;
					button4.setText("Strike " + "(" + StrikeNumber + ")");
					messageText.setText("스트라이크\n[지불: "+ StrikePrice +" Gold]\n1초당 대미지 + 10");

					perDmgSecond = perDmgSecond + 10;
					timerUpdate();
				}
				else {
					messageText.setText("골드가 부족합니다!");
				}
				break;
				
			}
		}
	}
	
	
	public class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			if(button == button1) {
				messageText.setText("슬래쉬\n[지불: "+ SlashPrice +" Gold]\n10초당 대미지 + 1");
			}

			else if(button == button2) {
				if(SmashUnlocked==false) {
					messageText.setText("잠겨있습니다! 100 Gold 필요!");
				}
				else {
					messageText.setText("스매쉬\n[지불: "+ SmashPrice +" Gold]\n1초당 대미지 + 1");
				}
			}

			else if(button == button3) {
				if(StingUnlocked==false) {
					messageText.setText("잠겨있습니다! 300 Gold 필요!");
				}
				else {
					messageText.setText("스팅\n[지불: "+ StingPrice +" Gold]\n1초당 대미지 + 5");
				}
			}
						
			else if(button == button4) {
				if(StrikeUnlocked==false) {
					messageText.setText("잠겨있습니다! 500 Gold 필요!");
				}
				else {
					messageText.setText("스트라이크\n[지불: "+ StrikePrice +"] Gold]\n1초당 대미지 + 10");
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			if(button == button1) {
				messageText.setText(null);
			}
			else if(button == button2) {
				messageText.setText(null);
			}
			else if(button == button3) {
				messageText.setText(null);
			}
			else if(button == button4) {
				messageText.setText(null);
			}
			
		}
		
	}
	
	
	
	
}
