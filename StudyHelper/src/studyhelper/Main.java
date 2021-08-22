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

public class Main {
	
        public static final Color DARK_GREEN = new Color(0,153,0);
        static int timeInSeconds;
        boolean noMoreInterval = false;
	JFrame window;
	JLabel counterLabel;
        JLabel counterLabel2;
        JLabel label;
	Font font1 = new Font("Arial", Font.PLAIN, 35);	
        Font font2 = new Font("Arial", Font.PLAIN, 70);
	Timer timer;
        static Timer timer2;
	static int second, minute;
        int second2, minute2;
	String ddSecond, ddMinute;	
        String ddSecond2, ddMinute2;
	DecimalFormat dFormat = new DecimalFormat("00");
	
	public static void main(String[] args) {
		
		new Main();		
	}
	
	public Main() {
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		
		counterLabel = new JLabel("");
		counterLabel.setBounds(10, 450, 300, 100);
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		counterLabel.setFont(font1);
                counterLabel.setForeground(Color.white);
                
                label = new JLabel("Study Time");
		label.setBounds(200, 80, 400, 100);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(font2);
                label.setForeground(Color.white);
                
                counterLabel2 = new JLabel("");
		counterLabel2.setBounds(200, 230, 400, 100);
		counterLabel2.setHorizontalAlignment(JLabel.CENTER);
		counterLabel2.setFont(font2);
                counterLabel2.setForeground(Color.white);
		
                window.add(label);
		window.add(counterLabel);
                window.add(counterLabel2);
                window.getContentPane().setBackground(DARK_GREEN);
		window.setVisible(true);
		
		
		// Countdown Timer
                if (numberHolder.counter == 0){
                    timeInSeconds = StudyMethod.studyPeriod;
                    numberHolder.counter++;
                }
                minute = timeInSeconds / 60;
                second = timeInSeconds%60;
                
                counterLabel.setText(minute + ":" + second);
		countdownTimer();
		timer.start();
                
                
                
                if(StudyMethod.desktime == true){
                    
                    if(timeInSeconds/3120 > 0){
                        minute2 = 52;
                        second2 = 0;
                    } else {
                        minute2 = timeInSeconds / 60;
                        second2 = timeInSeconds % 60;
                        noMoreInterval = true;
                    }
                    counterLabel2.setText(minute2 + ":" + second2 + "0 left");
                    countdownBreakTimer();
                    timer2.start();
                }
                
                if(StudyMethod.pomodoro == true){
                    if(timeInSeconds/1500 > 0){
                        minute2 = 25;
                        second2 = 0;
                    } else {
                        minute2 = timeInSeconds / 60;
                        second2 = timeInSeconds % 60;
                        noMoreInterval = true;
                    }
                    counterLabel2.setText(minute2 + ":" + second2 + "0 left");
                    countdownBreakTimer();
                    timer2.start();
                }
                
                if(StudyMethod.ultradian == true){
                    if(timeInSeconds/5400 > 0){
                        minute2 = 90;
                        second2 = 0;
                    } else {
                        minute2 = timeInSeconds / 60;
                        second2 = timeInSeconds % 60;
                        noMoreInterval = true;
                    }
                    counterLabel2.setText(minute2 + ":" + second2 + "0 left");
                    countdownBreakTimer();
                    timer2.start();
                }
	}
    

	public void countdownTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
                                timeInSeconds--;
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
				}
			}
		});		
	}
        
        public void countdownBreakTimer() {
		
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
					counterLabel2.setText(ddMinute2 + ":" + ddSecond2 + " left");
				}
				
                                
                                if(minute2<=0 && second2<=0){
                                    timer.stop();
                                    timer2.stop();
                                    if(noMoreInterval == true){
                                        timerOver();
                                    } else {
                                        breakScreen();
                                    }
                                }
			}
		});		
	}
        
        public void breakScreen(){
            Break breakTimer = new Break();
            window.setVisible(false);
        }
        
        public void timerOver(){
            StudyEnd studyEnd = new StudyEnd();
            studyEnd.show();
            window.setVisible(false);
        }
}