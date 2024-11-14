package game01;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame {

	public Frame() {
		
		// 부모 프레임 생성
		JFrame frm = new JFrame("던전 대장장이");
 
		// 부모 프레임 크기 설정 (가로, 세로)
		frm.setSize(800, 600);
 
		// 부모 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);
 
		// 부모 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		// 부모 레이아웃 설정
		frm.getContentPane().setLayout(null);	
		
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
        frm.setJMenuBar(frmmenu);
 
        //이미지 바탕화면 부착
		JLabel imgmain = new JLabel();
		ImageIcon icon = new ImageIcon(Frame.class.getResource("/image/start.png"));
		imgmain.setIcon(icon);
		imgmain.setBounds(0, 0, 800, 450);
		frm.getContentPane().add(imgmain);
		
		// 자식 컴포넌트 생성 [FlowLayout 첨부]
		JButton btn1 = new JButton("도박장");
		JButton btn2 = new JButton("던전");
		JButton btn3 = new JButton("마을");

		//버튼 부착
        btn1.setLocation(100,475);
        btn2.setLocation(350,475);
        btn3.setLocation(600,475);

        btn1.setSize(100,30);
        btn2.setSize(100,30);
        btn3.setSize(100,30);

        frm.add(btn1);
        frm.add(btn2);
        frm.add(btn3);
		
		// 부모 프레임이 보이도록 설정
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
		frm.setLayout(null);
		
		//창화면 이동
		btn1.addActionListener(new ActionListener()
		{
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Way01();
                frm.setVisible(false); // 창 안보이게 하기 
            }
        });
        
        btn2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Way02();
                frm.setVisible(false); // 창 안보이게 하기 
            }
        });
        
        btn3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Way03();
                frm.setVisible(false); // 창 안보이게 하기 
            }
        });
	}//메인 종료
	
	public static void main(String[] args)
	{
		new Frame();
	}
	

	
}//클래스 종료