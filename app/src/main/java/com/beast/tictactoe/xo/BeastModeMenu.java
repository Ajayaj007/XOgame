package com.beast.tictactoe.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeastModeMenu extends AppCompatActivity implements View.OnClickListener {

    Button onep, twop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode_menu);
        onep = (Button)findViewById(R.id.onep);
        onep.setOnClickListener(this);
        twop = (Button)findViewById(R.id.twop);
        twop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.onep:
                startActivity(new Intent(BeastModeMenu.this, BeastOnePMenu.class));
                break;
            case R.id.twop:
                startActivity(new Intent(BeastModeMenu.this, Beast.class));
                break;
        }
    }
}
