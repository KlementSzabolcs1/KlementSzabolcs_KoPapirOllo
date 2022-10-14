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
    private int gyozelem;
    private int vereseg;
    private AlertDialog.Builder alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();

    }

    //1 - ko 2 - papir 3 - ollo
    private void addListeners() {
        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    float veletlen = Math.round(Math.random() * 3 + 1);
                    jatekosKep.setImageResource(R.drawable.rock);
                    if (veletlen == 1) {
                        gepKep.setImageResource(R.drawable.rock);
                        Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();

                    } else if (veletlen == 2) {

                        gepKep.setImageResource(R.drawable.paper);
                        Toast.makeText(MainActivity.this, "Vereség", Toast.LENGTH_SHORT).show();
                        vereseg++;
                        eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                                vereseg);
                    } else {
                        gepKep.setImageResource(R.drawable.scissors);
                        gyozelem++;
                        Toast.makeText(MainActivity.this, "Győzelem", Toast.LENGTH_SHORT).show();
                        eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                                vereseg);

                    }
                if (gyozelem == 3 || vereseg == 3) {
                    if (gyozelem == 3) {
                        alert.setCancelable(false);
                        alert.create();
                        alert.setTitle("Győzelem");
                        alert.setMessage("Szeretne új játékot kezdeni?");
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

                        alert.show();
                    } else if (vereseg == 3) {
                        alert.setCancelable(false);
                        alert.create();
                        alert.setTitle("Vereség");
                        alert.setMessage("Szeretne új játékot kezdeni?");
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

                        alert.show();
                    }
                }
            }
             });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    float veletlen = Math.round(Math.random() * 3 + 1);
                    jatekosKep.setImageResource(R.drawable.paper);
                    if (veletlen == 1) {

                        gepKep.setImageResource(R.drawable.rock);
                        Toast.makeText(MainActivity.this, "Győzelem", Toast.LENGTH_SHORT).show();
                        gyozelem++;
                        eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                                vereseg);
                    } else if (veletlen == 2) {
                        gepKep.setImageResource(R.drawable.paper);
                        Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();

                    } else {
                        gepKep.setImageResource(R.drawable.scissors);
                        Toast.makeText(MainActivity.this, "Vereség", Toast.LENGTH_SHORT).show();
                        vereseg++;
                        eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                                vereseg);
                    }
                if (gyozelem == 3 || vereseg == 3) {
                    if (gyozelem == 3) {
                        alert.setCancelable(false);
                        alert.setTitle("Győzelem");
                        alert.setMessage("Szeretne új játékot kezdeni?");
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

                    } else if (vereseg == 3) {
                        alert.setCancelable(false);
                        alert.setTitle("Vereség");
                        alert.setMessage("Szeretne új játékot kezdeni?");
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
            }
        });

        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    float veletlen = Math.round(Math.random() * 3 + 1);
                    jatekosKep.setImageResource(R.drawable.scissors);
                    if (veletlen == 1) {
                        gepKep.setImageResource(R.drawable.rock);
                        Toast.makeText(MainActivity.this, "Vereség", Toast.LENGTH_SHORT).show();
                        vereseg++;
                        eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                                vereseg);
                    } else if (veletlen == 2) {
                        gepKep.setImageResource(R.drawable.paper);
                        Toast.makeText(MainActivity.this, "Győzelem", Toast.LENGTH_SHORT).show();
                        gyozelem++;
                        eredmeny.setText("Eredmény: Ember: " + gyozelem + " Computer: " +
                                vereseg);
                    } else {
                        gepKep.setImageResource(R.drawable.scissors);
                        Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();

                    }
                if (gyozelem == 3 || vereseg == 3) {
                    if (gyozelem == 3) {
                        alert.setCancelable(false);
                        alert.setTitle("Győzelem");
                        alert.setMessage("Szeretne új játékot kezdeni?");
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

                    } else if (vereseg == 3) {
                        alert.setCancelable(false);
                        alert.setTitle("Vereség");
                        alert.setMessage("Szeretne új játékot kezdeni?");
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
        gyozelem = 0;
        vereseg = 0;


    }
}