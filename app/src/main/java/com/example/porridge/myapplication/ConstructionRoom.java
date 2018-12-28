package com.example.porridge.myapplication;

import android.content.DialogInterface;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;

import com.example.porridge.myapplication.R;

import org.w3c.dom.Text;

public class ConstructionRoom extends AppCompatActivity {

    public int Bai = 0;//ManPower
    public int Lan = 0;//Ammunition


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_construction_room);

        View v1 = findViewById(R.id.addResource);//找到你要设透明背景的layout 的id
        v1.getBackground().setAlpha(100);//0~255透明度值

        View v2 = findViewById(R.id.BuildSort);//找到你要设透明背景的layout 的id
        v2.getBackground().setAlpha(100);//0~255透明度值
    }

    public void onClickShowFuc(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("公式一览");
        ImageView table = null;
        table.setImageDrawable(getResources().getDrawable(R.drawable.drawing));
        dialog.setView(table);
        dialog.setPositiveButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();

    }

    public void StartBuild(View view) {
        String Result = " ";
        loadAmmunition();
        loadManPower();

        if (Bai == 0 && Lan == 0) {
            Result = "不囤票怎么可能出货？？！！";
        }

        if (Bai > 0 && Lan == 0) {
            Result = Bai * 0.87 + "张N卡  " + Bai * 0.13 + "张R卡";
        }

        if (Bai == 0 && Lan > 0) {
            Result = Lan * 0.788 + "张卡  " + Lan * 0.2 + "张SR卡 " + Lan * 0.012 + "张SRR卡";
        }

        if (Bai > 0 && Lan > 0) {
            Result = (Bai * 0.87) + "张N卡 " + (Bai * 0.23 + Lan * 0.788) + "张R卡 " + (Lan * 0.2) + "张SR卡 " + (Lan * 0.012) + "张SSR卡";
        }

       /* if(Lan==0&&Bai==0){
            //Result="高星手枪 二星冲锋枪 二星突击步枪 ";
            if(Ration>=400&&Lan>=400){
                Result+="高星突击步枪 ";
            }
            if(Bai>=400&&Ration>=400){
                Result+="步枪 ";
            }
            if(ManPower>=400&&Ammunition>=400){
                Result+="高星冲锋枪 ";
            }
            if (ManPower>=600&&Ammunition>=400&&Ration>=400){
                Result+="机枪";
            }
        }
        */
        TextView v1 = (TextView) findViewById(R.id.BuildSort);
        v1.setText(Result);
    }

    public void loadManPower() {
        TextView v1 = (TextView) findViewById(R.id.manPower0);
        TextView v2 = (TextView) findViewById(R.id.manPower1);
        TextView v3 = (TextView) findViewById(R.id.manPower2);
        this.Bai = Integer.parseInt(v1.getText() + "") + Integer.parseInt(v2.getText() + "") * 10 + Integer.parseInt(v3.getText() + "") * 100;
    }

    public void loadAmmunition() {
        TextView v1 = (TextView) findViewById(R.id.Ammunition0);
        TextView v2 = (TextView) findViewById(R.id.Ammunition1);
        TextView v3 = (TextView) findViewById(R.id.Ammunition2);
        this.Lan = Integer.parseInt(v1.getText() + "") + Integer.parseInt(v2.getText() + "") * 10 + Integer.parseInt(v3.getText() + "") * 100;
    }


    public void Manadd0(View view) {
        TextView v1 = (TextView) findViewById(R.id.manPower0);
        Add(v1);
    }

    public void Manadd1(View view) {
        TextView v1 = (TextView) findViewById(R.id.manPower1);
        Add(v1);
    }

    public void Manadd2(View view) {
        TextView v1 = (TextView) findViewById(R.id.manPower2);
        Add(v1);
    }

    public void Aadd0(View view) {
        TextView v1 = (TextView) findViewById(R.id.Ammunition0);
        Add(v1);
    }

    public void Aadd1(View view) {
        TextView v1 = (TextView) findViewById(R.id.Ammunition1);
        Add(v1);
    }

    public void Aadd2(View view) {
        TextView v1 = (TextView) findViewById(R.id.Ammunition2);
        Add(v1);
    }


    public void Add(TextView view) {
        int value = Integer.parseInt(view.getText() + "");
        if (value < 9) {
            value++;
            view.setText(value + "");
        } else {
            value = 0;
            view.setText(value + "");
        }
    }
}


