package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.*;
import android.util.*;
public class MainActivity extends AppCompatActivity {
    private int point;
    private TextView inText;
    private TextView showText;
    private ImageButton up;
    private ImageButton dowm;
    private ImageButton sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inText=(TextView)findViewById(R.id.et1);
        showText=(TextView)findViewById(R.id.txt1);
        up=(ImageButton)findViewById(R.id.up);
        dowm=(ImageButton)findViewById(R.id.down);
        sub=(ImageButton)findViewById(R.id.sub);
        pickrandom();

        inText.addTextChangedListener(
                new TextWatcher(){
                    @Override
                    public  void beforeTextChanged(CharSequence s,int start,int count,int after){}

                    @Override
                    public void onTextChanged(CharSequence s,int start,int count,int after){
                        if(inText.length()!=0){
                            sub.setBackgroundResource(R.drawable.b);
                            sub.setEnabled(true);
                        }else{
                            sub.setBackgroundResource(R.drawable.a);
                            sub.setEnabled(false);
                        }
                    }
                    @Override
                    public void afterTextChanged(Editable s){}
                }
        );

    }
    private void pickrandom(){
        Random rand =new Random();
        point=rand.nextInt(10000);


    }
    public void click(View view){
        sub=(ImageButton)findViewById(R.id.sub);
        inText=(TextView)findViewById(R.id.et1);
        showText=(TextView)findViewById(R.id.txt1);
        int num=Integer.parseInt(inText.getText().toString());
        if(num==point){
            showText.setText("You got it!");
            inText.setEnabled(false);
            inText.getBackground().setAlpha(0);
            sub.setBackgroundResource(R.drawable.d);
            sub.setEnabled(false);
            pickrandom();
            //等待几秒后恢复
            Handler handler =new Handler();
            handler.postDelayed(new Runnable(){
                @Override
                public void run() {
                    showText.setText("The computer only considers a number from 1 to 9999");
                    up.getBackground().setAlpha(0);
                    dowm.getBackground().setAlpha(0);
                    inText.setEnabled(true);
                    inText.getBackground().setAlpha(200);
                    inText.setText("");
                    sub.setBackgroundResource(R.drawable.a);
                }
            },4010);

        }else{
            if(num>point){
                up.setBackgroundResource(R.drawable.e2);
                dowm.setBackgroundResource(R.drawable.f1);
                up.getBackground().setAlpha(200);
                dowm.getBackground().setAlpha(200);
                showText.setText("Lorem ipsum");
                inText.setEnabled(false);
                inText.getBackground().setAlpha(0);
                sub.setBackgroundResource(R.drawable.c);
                sub.setEnabled(false);

                //等待几秒后恢复
                Handler handler =new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        showText.setText("The computer only considers a number from 1 to 9999");
                        up.getBackground().setAlpha(0);
                        dowm.getBackground().setAlpha(0);
                        inText.setEnabled(true);
                        inText.getBackground().setAlpha(200);
                        inText.setText("");
                        sub.setBackgroundResource(R.drawable.a);
                    }
                },1010);


            }else{
                up.setBackgroundResource(R.drawable.e1);
                dowm.setBackgroundResource(R.drawable.f2);
                up.getBackground().setAlpha(200);
                dowm.getBackground().setAlpha(200);
                showText.setText("Lorem ipsum");
                inText.setEnabled(false);
                inText.getBackground().setAlpha(0);
                sub.setBackgroundResource(R.drawable.c);
                sub.setEnabled(false);



                //等待几秒后恢复
               Handler handler =new Handler();
               handler.postDelayed(new Runnable(){
                   @Override
                   public void run() {
                       showText.setText("The computer only considers a number from 1 to 9999");
                       up.getBackground().setAlpha(0);
                        dowm.getBackground().setAlpha(0);
                       inText.setEnabled(true);
                       inText.getBackground().setAlpha(200);
                       inText.setText("");
                       sub.setBackgroundResource(R.drawable.a);
                   }
               },1010);




            }

        }


    }
}
