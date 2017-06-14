package com.beast.tictactoe.xo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    Button nMode, bMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        nMode = (Button) findViewById(R.id.normalMode);
        nMode.setOnClickListener(this);
        bMode = (Button) findViewById(R.id.beast_mode);
        bMode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.normalMode:
                startActivity(new Intent(Menu.this, NormalModeMenu.class));
                break;
            case R.id.beast_mode:
                /*String names[] = {"Local", "Online"};
                AlertDialog.Builder mode = new AlertDialog.Builder(Menu.this);
                LayoutInflater inflater = getLayoutInflater();
                View convertView = inflater.inflate(R.toast.mode_of_beast, null);
                mode.setView(convertView);
                ListView lv = (ListView) convertView.findViewById(R.id.mode);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.toast.simple_list_item_1, names);
                lv.setAdapter(adapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i) {
                            case 0:*/
                startActivity(new Intent(Menu.this, BeastModeMenu.class));
                break;
                            /*case 1:
                                M.tl(getApplicationContext(),"Dont rush! first complete Local!!");
                                break;
                        }
                    }
                });
                mode.show();
            break;*/
        }
    }

}
