package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class homeActivity extends AppCompatActivity {

    ImageButton today;
    ImageButton tomorrow;
    ImageButton love;
    LinearLayout linear;
    Button btncolor;

    int red = 255;
    int blue = 255;
    int green = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        today = findViewById(R.id.today_button);
        tomorrow = findViewById(R.id.tomorrow_button);
        love = findViewById(R.id.love_button);
        linear = findViewById(R.id.linear);
        btncolor = findViewById(R.id.btncolor);

        red = getIntent().getIntExtra("red",255);
        green = getIntent().getIntExtra("green",255);
        blue = getIntent().getIntExtra("blue",255);

        linear.setBackgroundColor(Color.rgb(red, green, blue));

        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this, MainActivity.class);
                intent.putExtra("red", red);
                intent.putExtra("green", green);
                intent.putExtra("blue", blue);
                startActivity(intent);
            }
        });

        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this, tomorrowActivity.class);
                intent.putExtra("red", red);
                intent.putExtra("green", green);
                intent.putExtra("blue", blue);
                startActivity(intent);
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this, loveActivity.class);
                intent.putExtra("red", red);
                intent.putExtra("green", green);
                intent.putExtra("blue", blue);
                startActivity(intent);
            }
        });

        btncolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red = (int)(Math.random() * 255);
                blue = (int)(Math.random() * 255);
                green = (int)(Math.random() * 255);

                linear.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });
    }
}