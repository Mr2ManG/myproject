package game01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Way02 extends JFrame{
	
    public Way02()
    {    
        
    	//부모 프레임 생성
		JFrame way2 = new JFrame("던전");
 
		//부모 프레임 크기 설정 (가로, 세로)
		way2.setSize(800, 600);
 
		//부모 프레임을 화면 가운데에 배치
		way2.setLocationRelativeTo(null);
 
		//부모 프레임을 닫았을 때 메모리에서 제거되도록 설정
		way2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		//부모 레이아웃 설정
		way2.getContentPane().setLayout(null);		
		
		JMenuBar way2menu = new JMenuBar(); //메뉴바 생성
        JMenu ScreenMenuway2 = new JMenu("메뉴"); //Screen 메뉴생성
        
		//상단 메뉴바
        ScreenMenuway2.add(new JMenuItem("저장"));
        ScreenMenuway2.add(new JMenuItem("불러오기"));
        ScreenMenuway2.addSeparator(); //분리선 삽입
        ScreenMenuway2.add(new JMenuItem("Exit"));
        
        way2menu.add(ScreenMenuway2);
        way2menu.add(new JMenu("편집"));
        way2menu.add(new JMenu("창조절"));
        way2menu.add(new JMenu("설정"));

        //메뉴바를 프레임에 부착
        way2.setJMenuBar(way2menu);
        
        //이미지 바탕화면 부착
		JLabel imgway02 = new JLabel();
		ImageIcon icon = new ImageIcon(Frame.class.getResource("/image/dungeon1.jpg"));
		imgway02.setIcon(icon);
		imgway02.setBounds(0, 0, 800, 450);
		way2.getContentPane().add(imgway02);
        

		//자식 컴포넌트 생성 [FlowLayout 첨부]
		JButton btn1 = new JButton("Level 1");
		JButton btn2 = new JButton("Level 2");
		JButton btn3 = new JButton("Level 3");
		JButton btn4 = new JButton("Level 4");
		JButton btn5 = new JButton("Level 5");
		JButton backtotitle = new JButton("캐릭터창");
		
		//버튼 부착
        btn1.setLocation(40,475);
        btn2.setLocation(190,475);
        btn3.setLocation(340,475);
        btn4.setLocation(490,475);
        btn5.setLocation(640,475);
        backtotitle.setLocation(650,20);

        btn1.setSize(100,30);
        btn2.setSize(100,30);
        btn3.setSize(100,30);
        btn4.setSize(100,30);
        btn5.setSize(100,30);
        backtotitle.setSize(100,30);

        way2.add(btn1);
        way2.add(btn2);
        way2.add(btn3);
        way2.add(btn4);
        way2.add(btn5);
        way2.add(backtotitle);

      	//부모 프레임이 보이도록 설정
        way2.setVisible(true);      
        way2.setSize(800, 600);
        way2.setLocationRelativeTo(null);
        way2.setLayout(null);
		
        //창화면 이동
		backtotitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame();
                way2.setVisible(false);}}); // 창 안보이게 하기
		
		btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Level1();
                way2.setVisible(false);}}); // 창 안보이게 하기
		
		btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Level2();
                way2.setVisible(false);}}); // 창 안보이게 하기
		
		btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Level3();
                way2.setVisible(false);}}); // 창 안보이게 하기
		
		btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Level4();
                way2.setVisible(false);}}); // 창 안보이게 하기
		
		btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Level5();
                way2.setVisible(false); }}); // 창 안보이게 하기
    }
    
	public static void main(String[] args)
	{
		new Way02();
	}
}
