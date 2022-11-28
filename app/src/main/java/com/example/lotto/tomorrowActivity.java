package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class tomorrowActivity extends AppCompatActivity {

    ImageButton button;
    TextView txtnum, txtval;
    ImageButton home;
    LinearLayout linear;

    List<String> cardValues,cardnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomorrow);

        int red = getIntent().getIntExtra("red",255);
        int green = getIntent().getIntExtra("green",255);
        int blue = getIntent().getIntExtra("blue",255);

        linear = findViewById(R.id.linear);
        button = findViewById(R.id.button);
        txtnum = findViewById(R.id.txtnum);
        txtval = findViewById(R.id.txtval);
        home = findViewById(R.id.home_btn);

        linear.setBackgroundColor(Color.rgb(red, green, blue));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tomorrowActivity.this, homeActivity.class);
                intent.putExtra("red", red);
                intent.putExtra("green", green);
                intent.putExtra("blue", blue);
                startActivity(intent);
            }
        });

        cardValues = new ArrayList<>();
        cardnumber = new ArrayList<>();

        cardValues.add("더 신중해지세요!");
        cardValues.add("주위 사람들에게 다정해져보세요!");
        cardValues.add("당신의 선택이 중요합니다!");
        cardValues.add("자신에게 더 집중해보세요!");
        cardValues.add("무엇이든 다 잘 될 겁니다!");
        cardValues.add("자신과 가까운 사람을 조심하세요!");
        cardValues.add("불안해 하지 마세요!");
        cardValues.add("집중하세요!");
        cardValues.add("누군가가 다가올 겁니다!");
        cardValues.add("주위를 둘러보세요!");
        cardValues.add("귀인이 찾아올 겁니다!");
        cardValues.add("모두에게 친절하지 마세요!");
        cardValues.add("물을 조심하세요!");
        cardValues.add("뭐든지 조심!");
        cardValues.add("오늘은 쉬는게 좋아요!");

        for(int i = 0; i<100; i++){
            cardnumber.add(Integer.toString(i));
        }

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Random r = new Random();
                String randomValue = cardValues.get(r.nextInt(cardValues.size()));
                String randomnumbers = cardnumber.get(r.nextInt(cardnumber.size()));

                txtnum.setText("행운의 숫자 : " + randomnumbers);
                txtval.setText(randomValue);
            }
        });
    }

}