package com.example.porridge.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import java.util.ArrayList;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.porridge.myapplication.R;

public class SingleBattleRoom extends AppCompatActivity {

    static int Battle_id=1;
    static Battle currentBattle=null;
    static boolean[] AbleToShowMap={true,true,true,true,true,true,true};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_battle_room);

        View title = findViewById(R.id.Btitle);
        title.getBackground().setAlpha(100);


        View v1 = findViewById(R.id.Text_drawable);
        v1.getBackground().setAlpha(100);


        Intent i =getIntent();
        Battle_id=i.getIntExtra("Battle",1);
        ArrayList<Battle> LoadBattle= onCreateBattles();
        currentBattle = LoadBattle.get(Battle_id);
        DisplayBattleMassage(currentBattle);
    }

    public void ShowMap1(View view){
        if (AbleToShowMap[0]){
            ImageView M1_image=(ImageView)findViewById(R.id.Map1_image);
            M1_image.setImageDrawable(currentBattle.getOrigin().get(0).getMapimage());
            AbleToShowMap[0]=false;
        }
        else{
            ImageView M1_image=(ImageView)findViewById(R.id.Map1_image);
            M1_image.setImageDrawable(null);
            AbleToShowMap[0]=true;
        }
    }

    public void ShowMap2(View view){
        if (AbleToShowMap[1]) {
            ImageView M2_image = (ImageView) findViewById(R.id.Map2_image);
            M2_image.setImageDrawable(currentBattle.getOrigin().get(1).getMapimage());
            AbleToShowMap[1]=false;

        }
        else{
            ImageView M2_image=(ImageView)findViewById(R.id.Map2_image);
            M2_image.setImageDrawable(null);
            AbleToShowMap[1]=true;
        }
    }

    public void ShowMap3(View view){
        if (AbleToShowMap[2]) {
            ImageView M3_image = (ImageView) findViewById(R.id.Map3_image);
            M3_image.setImageDrawable(currentBattle.getOrigin().get(2).getMapimage());
            AbleToShowMap[2]=false;
        }
        else{
            ImageView M3_image=(ImageView)findViewById(R.id.Map3_image);
            M3_image.setImageDrawable(null);
            AbleToShowMap[2]=true;
        }
    }

    public void ShowMap4(View view){
        if (AbleToShowMap[3]) {
            ImageView M4_image = (ImageView) findViewById(R.id.Map4_image);
            M4_image.setImageDrawable(currentBattle.getOrigin().get(3).getMapimage());
            AbleToShowMap[3]=false;
        }
        else{
            ImageView M4_image=(ImageView)findViewById(R.id.Map4_image);
            M4_image.setImageDrawable(null);
            AbleToShowMap[3]=true;
        }
    }



    public void DisplayBattleMassage(Battle battle) {

        TextView title = (TextView) findViewById(R.id.Btitle);
        title.setText(battle.getBattle_Title());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(battle.getDescription());

        TextView M1_Title = (TextView) findViewById(R.id.map_1title);
        M1_Title.setText(battle.getOrigin().get(0).getCode() + " " + battle.getOrigin().get(0).getName());


        TextView M1_drop = (TextView) findViewById(R.id.Map1_drop);
        M1_drop.setText(battle.getOrigin().get(0).getDrop());

        TextView M1_enemy = (TextView) findViewById(R.id.enemy1);
        M1_enemy.setText(battle.getOrigin().get(0).getEnemy());


        TextView M2_Title = (TextView) findViewById(R.id.map_2title);
        M2_Title.setText(battle.getOrigin().get(1).getCode() + " " + battle.getOrigin().get(1).getName());


        TextView M2_drop = (TextView) findViewById(R.id.Map2_drop);
        M2_drop.setText(battle.getOrigin().get(1).getDrop());

        TextView M2_enemy = (TextView) findViewById(R.id.enemy2);
        M2_enemy.setText(battle.getOrigin().get(1).getEnemy());


        TextView M3_Title = (TextView) findViewById(R.id.map_3title);
        M3_Title.setText(battle.getOrigin().get(2).getCode() + " " + battle.getOrigin().get(2).getName());


        TextView M3_drop = (TextView) findViewById(R.id.Map3_drop);
        M3_drop.setText(battle.getOrigin().get(2).getDrop());

        TextView M3_enemy = (TextView) findViewById(R.id.enemy3);
        M3_enemy.setText(battle.getOrigin().get(2).getEnemy());


        TextView M4_Title = (TextView) findViewById(R.id.map_4title);
        M4_Title.setText(battle.getOrigin().get(3).getCode() + " " + battle.getOrigin().get(3).getName());


        TextView M4_drop = (TextView) findViewById(R.id.Map4_drop);
        M4_drop.setText(battle.getOrigin().get(3).getDrop());

        TextView M4_enemy = (TextView) findViewById(R.id.enemy4);
        M4_enemy.setText(battle.getOrigin().get(3).getEnemy());
    }





    public void back(View view) {
        Intent i = new Intent(this, BattleMapRoom.class);
        startActivity(i);
        this.finish();
    }

    public ArrayList<Battle> onCreateBattles() {

        ArrayList<Battle> Battles = new ArrayList<>();

        ArrayList<Map> Battle1_MapList = new ArrayList();
        ArrayList<Map> Battle1_EliteMapList = new ArrayList<>();
        ArrayList<Map> Battle1_NightMapList = new ArrayList<>();

        Battle Battle0 = new Battle();
        Battle Battle1 = new Battle(Battle1_MapList,Battle1_EliteMapList,Battle1_NightMapList,"   ","         ，\n                 ");

        Battles.add(Battle0);
        Battles.add(Battle1);

        return Battles;

    }
}