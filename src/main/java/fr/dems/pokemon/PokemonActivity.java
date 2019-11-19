package fr.dems.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PokemonActivity extends AppCompatActivity {

    private String nom;
    private int baseAttack;
    private int baseDefense;
    private int baseHP;
    private int baseSpAtt;
    private int baseSpeed;
    private String [] type;

    private TextView typePoke;
    private TextView pokeName;
    private TextView Att;
    private TextView Def;
    private TextView HP;
    private TextView AttackSP;
    private TextView Speed;
    private TextView infoType;
    private TextView infoHP;
    private TextView infoDef;
    private TextView infoAttackSP;
    private TextView infoAtt;
    private TextView infoName;
    private TextView infoSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        Intent intent = getIntent();

        baseAttack = intent.getIntExtra("baseAttack", 0);
        baseDefense = intent.getIntExtra("baseDefense", 0);
        baseHP = intent.getIntExtra("baseHP", 0);
        baseSpAtt = intent.getIntExtra("baseSpAtt", 0);
        baseSpeed = intent.getIntExtra("baseSpeed", 0);
        nom = intent.getStringExtra("name");
        type = intent.getStringArrayExtra("type") ;
        StringBuilder builder = new StringBuilder();

        infoType = findViewById(R.id.infoType);
        infoDef = findViewById(R.id.infoDef);
        infoHP = findViewById(R.id.infoHP);
        infoAttackSP = findViewById(R.id.infoAttackSP);
        infoSpeed = findViewById(R.id.infoSpeed);
        infoAtt = findViewById(R.id.infoAtt);
        infoName = findViewById(R.id.infoName);

        typePoke = findViewById(R.id.typePoke);
        for (String infoType : type){
            builder.append(infoType + "\n");
        }
        typePoke.setText(builder.toString());
        infoType.setText("Type : ");

        Def = findViewById(R.id.baseDefense);
        Def.setText(String.valueOf(baseDefense));
        infoDef.setText("Defense : ");

        HP = findViewById(R.id.baseHP);
        HP.setText(String.valueOf(baseHP));
        infoHP.setText("HP : ");

        AttackSP = findViewById(R.id.attackSP);
        AttackSP.setText(String.valueOf(baseSpAtt));
        infoAttackSP.setText("Attack SP : ");

        Speed = findViewById(R.id.speed);
        Speed.setText(String.valueOf(baseSpeed));
        infoSpeed.setText("Speed : ");

        Att = findViewById(R.id.baseAttack);
        Att.setText(String.valueOf(baseAttack));
        infoAtt.setText("Attack : ");

        pokeName = findViewById(R.id.name);
        pokeName.setText(nom);
        infoName.setText("Name : ");


    }
}
