package com.example.coachtp.vue;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coachtp.R;
import com.example.coachtp.controleur.controle;

public class MainActivity extends AppCompatActivity {
    private EditText poids;
    private EditText taille;
    private EditText age;
    private RadioButton homme;
    private TextView texte;
    private ImageView imgg;
    private controle controle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controle= controle.getInstance();

    }
    public void init(){
        poids = findViewById(R.id.txtpoids);
        taille = findViewById(R.id.txtTaille);
        age = findViewById(R.id.txtAge);
        texte = findViewById(R.id.ImgLabel);
        imgg = findViewById(R.id.imgEtat);
        homme =findViewById(R.id.rdhomme);
        ecouteCalcul();

    }
    public void ecouteCalcul(){
        ((Button) findViewById(R.id.btncalculer)).setOnClickListener(new Button.OnClickListener(){
            public  void  onClick(View v){
               // Toast.makeText(MainActivity.this, "test",Toast.LENGTH_SHORT).show();
                Log.d("message", "clic ok sur le bouton Calcul");

                Integer poidss = 0;
                Integer tailles = 0;
                Integer ages = 0;
                Integer sexes =0;

                try {
                    poidss = Integer.parseInt(poids.getText().toString());
                    tailles = Integer.parseInt(taille.getText().toString());
                    ages = Integer.parseInt(age.getText().toString());
                }catch(Exception e){};
                if(homme.isChecked()){
                    sexes =1;
                }
                if(poidss==0 || tailles==0 || ages==0){
                    Toast.makeText(MainActivity.this, "Saisie incorrecte",Toast.LENGTH_SHORT).show();
                }else {
                    afficheResult(poidss , tailles,ages, sexes);
                }
            }
        });
    }

    /**
     *
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void afficheResult (Integer poids, Integer taille , Integer age, Integer sexe){
        this.controle.creerProfil(poids , taille,age, sexe);
        float img = this.controle.getImg();
        String messag = this.controle.getMsg();
        if(messag  =="normal"){
            imgg.setImageResource(R.drawable.bon);
            texte.setTextColor(Color.GREEN);
        } else{
            if (messag=="trop faible") {
                imgg.setImageResource(R.drawable.triste);
                texte.setTextColor(Color.RED);
            }else {
                imgg.setImageResource(R.drawable.cool);
            }
        }
        texte.setText(String.format("0.01f", img)+":IMG "+ messag);
    }

}