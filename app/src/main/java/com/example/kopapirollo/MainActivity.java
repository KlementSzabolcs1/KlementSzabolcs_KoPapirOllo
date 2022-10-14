package com.example.kopapirollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView jatekosKep;
    private ImageView gepKep;
    private TextView jatekosValasztas;
    private TextView gepValasztas;
    private TextView eredmeny;
    private Button ko;
    private Button papir;
    private Button ollo;
    private Toast toast;
    private int gyozelem = 0;
    private int vereseg = 0;
    private AlertDialog.Builder alert;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (gyozelem == 3 || vereseg == 3) {
            alert.setMessage("Szeretne új játékot kezdeni?");

            if (gyozelem == 3) {
                alert.setTitle("Győzelem");
                alert.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        reload();

                    }
                });
                alert.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

            } else {
                alert.setTitle("Vereség");
                alert.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        reload();

                    }
                });
                alert.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

            }

        }
        addListeners();
    }
    //1 - ko 2 - papir 3 - ollo
    private void addListeners() {
        ko.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                float veletlen = Math.round(Math.random()*3+1);
                jatekosKep.setImageResource(R.drawable.rock);
                if (veletlen == 1) {
                    gepKep.setImageResource(R.drawable.rock);
                    toast.setText("Döntetlen");
                } else if (veletlen == 2) {
                    gepKep.setImageResource(R.drawable.paper);
                    toast.setText("Vereség");
                    vereseg++;
                    eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                            vereseg);

                } else {
                    gepKep.setImageResource(R.drawable.scissors);
                    toast.setText("Győzelem");
                    gyozelem++;
                    eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                            vereseg);
                }



            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float veletlen = Math.round(Math.random()*3+1);
                jatekosKep.setImageResource(R.drawable.paper);
                if (veletlen == 1) {
                    gepKep.setImageResource(R.drawable.rock);
                    toast.setText("Győzelem");
                    gyozelem++;
                    eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                            vereseg);
                } else if (veletlen == 2) {
                    gepKep.setImageResource(R.drawable.paper);
                    toast.setText("Döntetlen");

                } else {
                    gepKep.setImageResource(R.drawable.scissors);
                    toast.setText("Vereség");
                    vereseg++;
                    eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                            vereseg);
                }

            }
        });

        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float veletlen = Math.round(Math.random()*3+1);
                jatekosKep.setImageResource(R.drawable.scissors);
                if (veletlen == 1) {
                    gepKep.setImageResource(R.drawable.rock);
                    toast.setText("Vereség");
                    vereseg++;
                    eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                            vereseg);
                } else if (veletlen == 2) {
                    gepKep.setImageResource(R.drawable.paper);
                    toast.setText("Győzelem");
                    gyozelem++;
                    eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                            vereseg);
                } else {
                    gepKep.setImageResource(R.drawable.scissors);
                    toast.setText("Döntetlen");

                }

            }
        });



    }

    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }


    public void init() {

    jatekosKep = findViewById(R.id.jatekosKep);
    gepKep = findViewById(R.id.gepKep);
    gepValasztas = findViewById(R.id.gepValasztas);
    jatekosValasztas = findViewById(R.id.jatekosValasztas);
    eredmeny = findViewById(R.id.eredmeny);
    ko = findViewById(R.id.gombKo);
    papir = findViewById(R.id.gombPapir);
    ollo = findViewById(R.id.gombOllo);
    alert = new AlertDialog.Builder(MainActivity.this);





    }
}