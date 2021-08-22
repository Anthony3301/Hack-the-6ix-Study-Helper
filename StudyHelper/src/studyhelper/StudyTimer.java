/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyhelper;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author willx
 */
public class StudyTimer {
    
    
    static int secondsPassed = StudyMethod.studyPeriod;
    static Timer myTimer = new Timer();
    static boolean timerOn = false;
    
    public void pause(){
        this.myTimer.cancel();
    }
    
    public void resume(){
        this.myTimer = new Timer();
        this.myTimer.schedule(task, 1000, 1000);
    }
    
    TimerTask task = new TimerTask(){
        public void run(){
            secondsPassed--;
            System.out.println(secondsPassed);
        }
    };
 
    public void start() {
        myTimer.scheduleAtFixedRate(task, 1000, 1000);
    }
    
    public static void main(String[] args){
        StudyTimer startTimer = new StudyTimer();
        startTimer.start();
    }
}
