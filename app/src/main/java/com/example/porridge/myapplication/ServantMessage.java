package com.example.porridge.myapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import java.util.*;
public class ServantMessage {
    private ArrayList<Servant> Servant_List =new ArrayList<Servant>();
    public ServantMessage(){
        Servant_List.add(new Servant("大天狗","SSR",3136,10026,10,419,110,"Saru","田野智昭","输出式神","普通召唤、现实召唤获得","一技能：\n聚风形成旋转风刃袭向1名敌人，造成攻击100%的伤害。\n" +
                "被动：\n自身回合中攻击力和暴击伤害提升5%。在自身回合外，大天狗环绕一层风暴之羽，可抵消1次控制效果\n三技能：\n耗费：3火，召唤飓风形成大型的羽刃漩涡攻击敌方全体，形成4次连续攻击，每次造成大天狗攻击37%的伤害。","针女：\n暴击时有40%概率造成目标最大生命值10伤害，最大造成自身攻击120%伤害"));
        Servant_List.add(new Servant("玉藻前","SSR",3350,12532,12,353,110,"spirtie","朴璐美","输出式神","普通召唤、现实召唤获得","一技能：\n使用灵气攻击目标，造成玉藻前攻击100%的伤害，并有10%（+效果命中）的概率使目标混乱一回合" +
                "二技能：\n对敌方单体全体造成攻击131%的伤害，若目标生命值低于50%，则伤害减少15%\n三技能：\n对目标造成自身攻击263%的伤害，若目标生命值高于80%，则伤害减少15%","对生命值高于70%单位造成额外40%伤害"));
    }
    public Servant getServantMessage(int n){
        return Servant_List.get(n-1);
    }
    public ArrayList<Servant> getList(){
        return Servant_List;
    }
    //bingo目前是暴击
    //evade目前是防御
    //speed目前是速度
}
