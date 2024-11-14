package game01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Way03 {
	
	JLabel counterLabel, perSecLabel, comentLabel;
	JButton button1, button2, button3, button4;
	int GoldCounter, timerSpeed, SmithyNumber, SmithyPrice;
	double perSecond;
	boolean timerOn;
	Font font1, font2;
	Mon1Handler cHandler = new Mon1Handler();
	Timer timer;
	JTextArea messageText;
	MouseHandler mHandler = new MouseHandler();
	
	int AlchemyNumber = 0;
	int AlchemyPrice = 100;
	boolean AlchemyUnlocked = false;
	
	int CircusNumber = 0;
	int CircusPrice = 300;
	boolean CircusUnlocked = false;
	
	int MarketNumber = 0;
	int MarketPrice = 500;
	boolean MarketUnlocked = false;
	
	public static void main(String[] args) {
		new Way03();
	}
	public Way03() {
		
		timerOn = false;
		perSecond = 0;
		GoldCounter = 1000;
		SmithyNumber = 0;
		SmithyPrice = 10;
		
		createFont();
		createUI();
	}
	
	public void createFont() {
		font1 = new Font("MS949", Font.PLAIN, 32);
		font2 = new Font("MS949", Font.PLAIN, 15);
		
	}
	
	public void createUI() {
		JFrame window = new JFrame("마을");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.getContentPane().setBackground(Color.lightGray);
		window.setLayout(null);
		
		JPanel Mon1Panel = new JPanel();
		Mon1Panel.setBounds(100, 220, 200, 200);
		Mon1Panel.setBackground(Color.black);
		window.add(Mon1Panel);
		
		ImageIcon Mon1 = new ImageIcon(getClass().getClassLoader().getResource("trash.png"));
		
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
    	ImageIcon icon1 = new ImageIcon(Frame.class.getResource("/image/town.jpg"));
    	imgmain1.setIcon(icon1);
    	imgmain1.setBounds(0, 0, 800, 550);
    	window.getContentPane().add(imgmain1);  //배경화면
        
        JButton backtotitle = new JButton("캐릭터창");
        backtotitle.setLocation(650,20);
        backtotitle.setSize(100,30);
        window.add(backtotitle);
        
        backtotitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame();
                window.setVisible(false);}});
		
		
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100, 100, 200, 100);
		counterPanel.setBackground(Color.black);
		counterPanel.setLayout(new GridLayout(3, 1));
		window.add(counterPanel);
		
		
		
		counterLabel = new JLabel(GoldCounter + " Gold");
		counterLabel.setForeground(Color.white);
		counterLabel.setFont(font1);
		counterPanel.add(counterLabel);
		
		comentLabel = new JLabel("Garbage Also Can Be Money");
		comentLabel.setForeground(Color.white);
		comentLabel.setFont(font2);
		counterPanel.add(comentLabel);	
		
		perSecLabel = new JLabel();
		perSecLabel.setForeground(Color.white);
		perSecLabel.setFont(font2);
		counterPanel.add(perSecLabel);	
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(500, 170, 250, 250);
		itemPanel.setBackground(Color.black);
		itemPanel.setLayout(new GridLayout(4, 1));
		window.add(itemPanel);
		
		button1 = new JButton("Smithy");
		button1.setFont(font1);
		button1.setFocusPainted(false);
		button1.addActionListener(cHandler);
		button1.setActionCommand("Smithy");
		itemPanel.add(button1);
		button1.addMouseListener(mHandler);
		
		button2 = new JButton("?");
		button2.setFont(font1);
		button2.setFocusPainted(false);
		button2.addActionListener(cHandler);
		button2.setActionCommand("Alchemy");
		itemPanel.add(button2);
		button2.addMouseListener(mHandler);
		
		button3 = new JButton("?");
		button3.setFont(font1);
		button3.setFocusPainted(false);
		button3.addActionListener(cHandler);
		button3.setActionCommand("Circus");
		itemPanel.add(button3);
		button3.addMouseListener(mHandler);
		
		button4 = new JButton("?");
		button4.setFont(font1);
		button4.setFocusPainted(false);
		button4.addActionListener(cHandler);
		button4.setActionCommand("Market");
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
				GoldCounter++;
				counterLabel.setText(GoldCounter + " Gold");
				
				if(AlchemyUnlocked==false) {
					if(GoldCounter>=100) {
						AlchemyUnlocked=true;
						button2.setText("mineral " + "(" + AlchemyNumber + ")");						
					}
				}
				if(CircusUnlocked==false) {
					if(GoldCounter>=300) {
						CircusUnlocked=true;
						button3.setText("farming " + "(" + CircusNumber + ")");						
					}
				}
				if(MarketUnlocked==false) {
					if(GoldCounter>=500) {
						MarketUnlocked=true;
						button4.setText("sale " + "(" + MarketNumber + ")");						
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
		
		double speed = 1/perSecond*1000;
		timerSpeed = (int)Math.round(speed);
		
		String s = String.format("%.2f", perSecond);
		perSecLabel.setText("초당 Gold 흭득: " + s + " Gold");
		
		setTimer();
		timer.start();
	}

	
	
	public class Mon1Handler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String action = event.getActionCommand();
			switch(action) {
			case "Mon1":
				GoldCounter++;
				counterLabel.setText(GoldCounter + " Gold");
				break;
			case "Smithy":
				if(GoldCounter>=SmithyPrice) {
					GoldCounter = GoldCounter - SmithyPrice;
					SmithyPrice = SmithyPrice + 5;
					counterLabel.setText(GoldCounter + " Gold");
					
					SmithyNumber++;
					button1.setText("Smithy " + "(" + SmithyNumber + ")");
					messageText.setText("대장장이\n[지불: "+ SmithyPrice +" Gold]\n10초 마다 1골드씩 얻습니다.");

					perSecond = perSecond + 0.1;
					timerUpdate();
				}
				else {
					messageText.setText("골드가 부족합니다!");
				}
				break;
				
			case "Alchemy":
				if(GoldCounter>=AlchemyPrice) {
					GoldCounter = GoldCounter - AlchemyPrice;
					AlchemyPrice = AlchemyPrice + 50;
					counterLabel.setText(GoldCounter + " Gold");
					
					AlchemyNumber++;
					button2.setText("mineral " + "(" + AlchemyNumber + ")");
					messageText.setText("광산캐기\n[지불: "+ AlchemyPrice +" Gold]\n1초 마다 1골드씩 얻습니다.");

					perSecond = perSecond + 1;
					timerUpdate();
				}
				else {
					messageText.setText("골드가 부족합니다!");
				}
				break;
				
			case "Circus":
				if(GoldCounter>=CircusPrice) {
					GoldCounter = GoldCounter - CircusPrice;
					CircusPrice = CircusPrice + 100;
					counterLabel.setText(GoldCounter + " Gold");
					
					CircusNumber++;
					button3.setText("farming " + "(" + CircusNumber + ")");
					messageText.setText("농사짓기\n[지불: "+ CircusPrice +" Gold]\n1초 마다 10골드씩 얻습니다.");

					perSecond = perSecond + 10;
					timerUpdate();
				}
				else {
					messageText.setText("골드가 부족합니다!");
				}
				break;
				
			case "Market":
				if(GoldCounter>=MarketPrice) {
					GoldCounter = GoldCounter - MarketPrice;
					MarketPrice = MarketPrice + 200;
					counterLabel.setText(GoldCounter + " Gold");
					
					MarketNumber++;
					button4.setText("sale " + "(" + MarketNumber + ")");
					messageText.setText("장사\n[지불: "+ MarketPrice +" Gold]\n1초 마다 20골드씩 얻습니다.");

					perSecond = perSecond + 20;
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
				messageText.setText("대장장이\n[지불: "+ SmithyPrice +" Gold]\n10초 마다 1골드씩 얻습니다.");
			}

			else if(button == button2) {
				if(AlchemyUnlocked==false) {
					messageText.setText("잠겨있습니다! 100 Gold 필요!");
				}
				else {
					messageText.setText("광산캐기\n[지불: "+ AlchemyPrice +" Gold]\n1초 마다 1골드씩 얻습니다.");
				}
			}

			else if(button == button3) {
				if(CircusUnlocked==false) {
					messageText.setText("잠겨있습니다! 300 Gold 필요!");
				}
				else {
					messageText.setText("농사짓기\n[지불: "+ CircusPrice +" Gold]\n1초 마다 10골드씩 얻습니다.");
				}
			}
						
			else if(button == button4) {
				if(MarketUnlocked==false) {
					messageText.setText("잠겨있습니다! 500 Gold 필요!");
				}
				else {
					messageText.setText("장사\n[지불: "+ MarketPrice +" Gold]\n1초 마다 20골드씩 얻습니다.");
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
