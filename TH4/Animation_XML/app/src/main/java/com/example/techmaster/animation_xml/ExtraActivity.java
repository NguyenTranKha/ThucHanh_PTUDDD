package com.example.techmaster.animation_xml;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ExtraActivity extends AppCompatActivity {
    Button buttonWayBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        buttonWayBackHome = findViewById(R.id.waybaclhome);
        buttonWayBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNewActivity = new Intent(ExtraActivity.this, MainActivity.class);
                startActivity(iNewActivity);
                overridePendingTransition(R.anim.anim_move_left, R.anim.anim_move_right);
            }
        });
    }
}
