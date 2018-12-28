package com.example.porridge.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import com.example.porridge.myapplication.R;

public class BattleMapRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_map_room);

        View title = findViewById(R.id.STitle);
        title.getBackground().setAlpha(150);

        View v0 = findViewById(R.id.battle0);
        v0.getBackground().setAlpha(150);

        View v1 = findViewById(R.id.battle1);
        v1.getBackground().setAlpha(150);

        View v2 = findViewById(R.id.battle2);
        v2.getBackground().setAlpha(150);

        View v3 = findViewById(R.id.battle3);
        v3.getBackground().setAlpha(150);

        View v4 = findViewById(R.id.battle4);
        v4.getBackground().setAlpha(150);

    }

    public void back(View view) {
        Intent i = new Intent(this, RoomList.class);
        startActivity(i);
        this.finish();
    }

    public void onClickM_1(View view){
        Intent i =new Intent(this,SingleBattleRoom.class);
        i.putExtra("Battle",1);
        startActivity(i);
    }
}
