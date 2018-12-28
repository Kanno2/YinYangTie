package com.example.porridge.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.porridge.myapplication.R;

import java.util.*;

public class Counter extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    private Map currentMap;
    private Spinner mGunSpinner = null;
    private ArrayList<Map> data_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_counter);

            View v1 = findViewById(R.id.counter_table);
            v1.getBackground().setAlpha(100);

        View v2 = findViewById(R.id.Counter_Title);
        v2.getBackground().setAlpha(100);

            mGunSpinner = (Spinner) findViewById(R.id.spinner);
            ArrayList<String> arr = new ArrayList<>();
            for (int i=0;i<data_list.size();i++){
                arr.add(data_list.get(i).getCode());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);

            mGunSpinner.setAdapter(adapter);

            mGunSpinner.setOnItemSelectedListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent,View view,int position,long id){
        String name=parent.getItemAtPosition(position).toString();
        for (int i=0;i<data_list.size();i++){
            if(data_list.get(i).getCode().equals(name))
                currentMap=data_list.get(i);
        }
        TextView v1=(TextView)findViewById(R.id.expView);
        v1.setText(currentMap.getXP()+"xp");
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView){

    }

    public void back(View view){
        Intent i = new Intent(this,RoomList.class);
        startActivity(i);
        this.finish();
    }

    public int[] uplevelexp={180,240,420,630,1040,1440,2160,2790,3900,4800,6380,7590,
    9720,11280,14040,15990,19460,21840,26100,28950,34080,37440,43520,47430,54540,59040,67260,
    72390,81800,87600,98280,104790,116820,124080,137540,151920,167250,183560,200880};

    public int caculateEXP(int low,int high) {
        int sum = 0;
        for (int i = low - 1; i < high-1; i++) {
            sum += uplevelexp[i];
        }
        return sum;
    }

    public void begin(View view){
        EditText et1 = (EditText)findViewById(R.id.first);
        EditText et2 = (EditText)findViewById(R.id.end);
        int low=Integer.parseInt(et1.getText().toString());
        int high=Integer.parseInt(et2.getText().toString());
        int times=0;
        int xp=Integer.parseInt(currentMap.getXP());
        if ((high-low)%xp!=0){
            times=caculateEXP(low,high)/xp+1;
        }
        else
            times=caculateEXP(low,high)/xp;
        TextView tv = findViewById(R.id.leftBattle);
        tv.setText(times+"");
    }
}
