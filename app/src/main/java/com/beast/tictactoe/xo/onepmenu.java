package com.beast.tictactoe.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class onepmenu extends AppCompatActivity implements View.OnClickListener {
    Button easyb, mediumb, hardb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onepmenu);
        easyb = (Button)findViewById(R.id.easyb);
        mediumb = (Button)findViewById(R.id.mediumb);
        hardb = (Button) findViewById(R.id.hardb);
        easyb.setOnClickListener(this);
        mediumb.setOnClickListener(this);
        hardb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.easyb:
                startActivity(new Intent(onepmenu.this, onepeasygame.class));
                break;
            case R.id.mediumb:
                startActivity(new Intent(onepmenu.this, onepMediumGame.class));
                break;
            case R.id.hardb:
                startActivity(new Intent(onepmenu.this, onepHardGame.class));
                break;
        }
    }
}
