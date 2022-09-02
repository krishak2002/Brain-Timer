 package com.example.braintimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

 public class MainActivity extends AppCompatActivity {
     int correctoption=0;int score=0;int noofques=0;   Button go;
    ConstraintLayout gamelayout;
     TextView sumtextview, clock;
     TextView ansis,scoreboard;
     Button button0;
     Button button1;
     Button button2;
     Button button3;
     ArrayList<Integer> options=new ArrayList<Integer>();
     public void markans(View view){
noofques++;
         if(Integer.toString(correctoption).equals( view.getTag().toString())){
             score++;
      ansis.setText("CORRECT!");
          nextques();
         }
         else {
             ansis.setText("Wrong!");

         }
  scoreboard.setText(Integer.toString(score) +"/"+Integer.toString(noofques));

         }
public void nextques(){
    Random rand =new Random();
    int a=rand.nextInt(21);
    int b=rand.nextInt(21);
    sumtextview.setText(Integer.toString(a)+" + "+Integer.toString(b));
    int correctanswer=a+b;
    int wrongans=0;
    correctoption =rand.nextInt(4);
    options.clear();
    for(int i=0;i<4;i++){
        if(i==correctoption){
            options.add(correctanswer);
        }
        else{
            wrongans=rand.nextInt(41);}
        while(wrongans==correctanswer){
            wrongans=rand.nextInt(41);
        }
        options.add(wrongans);}
        button0.setText(Integer.toString(options.get(0)));
        button1.setText(Integer.toString(options.get(1)));
        button2.setText(Integer.toString(options.get(2)));
        button3.setText(Integer.toString(options.get(3)));



}








    public void start(View view){

        go.setVisibility(View.INVISIBLE);
        gamelayout.setVisibility(View.VISIBLE);
        timer();
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go=(Button)findViewById(R.id.go);
        button0=(Button)findViewById(R.id.button0);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        ansis=(TextView)findViewById(R.id.ansis);
        scoreboard=(TextView)findViewById(R.id.scoreboard);
        sumtextview=(TextView)findViewById(R.id.sumtextview);
        clock=(TextView)findViewById(R.id.clock) ;
        gamelayout=findViewById(R.id.gamelayout);
        nextques();

    }

    public void timer(){
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                clock.setText( Integer.toString((int) (millisUntilFinished / 1000)));
            }

            public void onFinish() {
               clock.setText("done!");
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                go.setText("PLAY AGAIN!");
                go.setVisibility(View.VISIBLE);
                gamelayout.setVisibility(View.INVISIBLE);
                score=0;
                noofques=0;
                scoreboard.setText(Integer.toString(score) +"/"+Integer.toString(noofques));
            }
        }.start();
    }

    public void playagain(View view){

         go.setText("PLAY AGAIN!");
         go.setVisibility(View.VISIBLE);

    }
}