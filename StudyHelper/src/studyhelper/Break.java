/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyhelper;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
/**
 *
 * @author willx
 */
public class Break {
    
        public static final Color DARK_RED = new Color(204,0,0);
        JFrame window;
	JLabel label;
        JLabel counterLabel;
        JLabel counterLabel2;
	Font font1 = new Font("Arial", Font.PLAIN, 35);	
	Font font2 = new Font("Arial", Font.PLAIN, 70);
        Timer timer;	
        Timer timer2;
	int second, minute, second2 = 0, minute2;
        String ddSecond, ddMinute, ddSecond2, ddMinute2;	
	DecimalFormat dFormat = new DecimalFormat("00");
	

	public static void main(String[] args) {
		
		new Break();		
	}
	
	public Break() {
		
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		
		counterLabel = new JLabel("");
		counterLabel.setBounds(10, 450, 300, 100);
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		counterLabel.setFont(font1);
                counterLabel.setForeground(Color.white);
                
                counterLabel2 = new JLabel("");
                counterLabel2.setBounds(200, 230, 400, 100);
                counterLabel2.setHorizontalAlignment(JLabel.CENTER);
                counterLabel2.setFont(font2);
                counterLabel2.setForeground(Color.white);
                
		label = new JLabel("Break Time");
		label.setBounds(200, 80, 400, 100);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(font2);
                label.setForeground(Color.white);
		
                window.add(label);
                window.add(counterLabel);
                window.add(counterLabel2);
                window.getContentPane().setBackground( DARK_RED );
		window.setVisible(true);
		
		
		// Countdown Timer
		if (StudyMethod.pomodoro == true){
                    minute2 = 5;
                }
                
                if (StudyMethod.desktime == true){
                    minute2 = 1;
                }
                
                if (StudyMethod.ultradian == true){
                    minute2 = 30;
                }
                
                counterLabel2.setText(minute2 + ":" + second2);
		countdownTimer2();
		timer2.start();	
                
                minute = Main.timeInSeconds / 60;
                second = Main.timeInSeconds % 60;
                counterLabel.setText(minute2 + ":" + second);
                countdownTimer();
                timer.start();
	}
    
	public void countdownTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
                                Main.timeInSeconds--;
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				counterLabel.setText(ddMinute + ":" + ddSecond + " left in total");
				
				if(second==-1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					counterLabel.setText(ddMinute + ":" + ddSecond + " left in total");
				}
				if(minute==0 && second==0) {
					timer.stop();
                                        timerOver();
				}
			}
		});		
	}
        
        public void countdownTimer2() {
		
		timer2 = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second2--;
				ddSecond2 = dFormat.format(second2);
				ddMinute2 = dFormat.format(minute2);	
				counterLabel2.setText(ddMinute2 + ":" + ddSecond2 + " left");
				
				if(second2==-1) {
					second2 = 59;
					minute2--;
					ddSecond2 = dFormat.format(second2);
					ddMinute2 = dFormat.format(minute2);	
					counterLabel.setText(ddMinute2 + ":" + ddSecond2 + " left");
				}
				if(minute2==0 && second2==0 && Main.timeInSeconds > 0) {
					timer.stop();
                                        timer2.stop();
                                        breakOver();
				}
			}
		});		
	}
        
        
        public void breakOver(){
            Main breakEnd = new Main();
            window.setVisible(false);
        }
        
        public void timerOver(){
            StudyEnd studyEnd = new StudyEnd();
            studyEnd.show();
            window.setVisible(false);
        }
        
    
}
