package com.example.semestalnapraca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Kalkulacna je zlozena pomocou 16 tlacitok a 2 TextView co je  displej na vypis
 * Pomocou tlacitok naklikavam do displejov cisla a pocitam
 * V tejto triede som robil vsetky operacie
 * Robil som to pomocou jedneho stringu pri kliknuti sa zapisovali cisla alebo operacie
 * Ked sa kliklo na operaciu pomocou tried boolean pri bodke alebo stlacenej operacii som zadaval errory do displejov
 */
public class Kalkulacka extends AppCompatActivity {

    private boolean operaciaStlacena = false;
    private double prveCislo =0;
    private int druheCisloIndex =0;
    private String aktualnaOperacia ="";
    private boolean jeBodka = false;

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnMinus,btnPlus,btnKrat,btnDeleno,btnMocnina,btnVysledok,btnC,btnCos,btnSin,btnCiarka;
    TextView prikladTV,vysledokTV;
    String priklad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulacka);

        btn0 = findViewById(R.id.nulaBtn);
        btn1 = findViewById(R.id.jednaBtn);
        btn2 = findViewById(R.id.dvaBtn);
        btn3 = findViewById(R.id.trojkaBtn);
        btn4 = findViewById(R.id.styriBtn);
        btn5 = findViewById(R.id.petBtn);
        btn6 = findViewById(R.id.sestBtn);
        btn7 = findViewById(R.id.sedemBtn);
        btn8 = findViewById(R.id.osemBtn);
        btn9 = findViewById(R.id.devetBtn);
        btnMinus = findViewById(R.id.minusBtn);
        btnPlus = findViewById(R.id.plusBtn);
        btnDeleno = findViewById(R.id.delenoBtn);
        btnKrat = findViewById(R.id.kratBtn);
        btnSin = findViewById(R.id.sinBtn);
        btnCos = findViewById(R.id.cosBtn);
        btnCiarka = findViewById(R.id.ciarkaBtn);
        btnMocnina = findViewById(R.id.mocninaBtn);
        btnC = findViewById(R.id.cBtn);
        btnVysledok = findViewById(R.id.rovnasaBtn);

        prikladTV = findViewById(R.id.prikladTV);
        vysledokTV = findViewById(R.id.vysledokTV);


        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prikladTV.setText("");
                vysledokTV.setText("");
                jeBodka = false;
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priklad = prikladTV.getText().toString();
                prikladTV.setText(priklad + "9");
            }
        });
        btnCiarka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jeBodka) {
                    vysledokTV.setText("ERROR");
                    prikladTV.setText("");

                } else {
                    priklad = prikladTV.getText().toString();
                    prikladTV.setText(priklad + ".");
                    jeBodka = true;

                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaciaStlacena){
                    error();
                } else {
                    if (prikladTV.getText().toString().length()>0) {
                    String screen = prikladTV.getText().toString();
                    druheCisloIndex = screen.length();
                    prveCislo = Double.parseDouble(prikladTV.getText().toString());
                    priklad = prikladTV.getText().toString();
                    prikladTV.setText(priklad + "+");
                    operaciaStlacena = true;
                    aktualnaOperacia = "+";
                    jeBodka=false;
                    }else {
                        error();
                    }

                }

            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaciaStlacena){
                    error();
                } else {
                    if (prikladTV.getText().toString().length()>0) {
                        String screen = prikladTV.getText().toString();
                        druheCisloIndex = screen.length();
                        prveCislo = Double.parseDouble(prikladTV.getText().toString());
                        priklad = prikladTV.getText().toString();
                        prikladTV.setText(priklad + "-");
                        operaciaStlacena = true;
                        aktualnaOperacia = "-";
                        jeBodka=false;
                    }else {
                        error();
                    }
                }
            }
        });
        btnKrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaciaStlacena){
                    error();
                } else {
                    if (prikladTV.getText().toString().length()>0) {

                        String screen = prikladTV.getText().toString();
                        druheCisloIndex = screen.length();
                        prveCislo = Double.parseDouble(prikladTV.getText().toString());
                        priklad = prikladTV.getText().toString();
                        prikladTV.setText(priklad + "*");
                        operaciaStlacena = true;
                        aktualnaOperacia = "*";
                        jeBodka=false;
                    }else {
                        error();
                    }
                }
            }
        });
        btnDeleno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaciaStlacena){
                    error();
                } else {
                    if (prikladTV.getText().toString().length()>0) {

                        String screen = prikladTV.getText().toString();
                        druheCisloIndex = screen.length();
                        prveCislo = Double.parseDouble(prikladTV.getText().toString());
                        priklad = prikladTV.getText().toString();
                        prikladTV.setText(priklad + "/");
                        operaciaStlacena = true;
                        aktualnaOperacia = "/";
                        jeBodka=false;
                    }else {
                        error();
                    }
                }
            }
        });

        btnMocnina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaciaStlacena){
                    error();
                } else {
                    if (prikladTV.getText().toString().length()>0) {

                        String screen = prikladTV.getText().toString();
                        druheCisloIndex = screen.length();
                        prveCislo = Double.parseDouble(prikladTV.getText().toString());
                        priklad = prikladTV.getText().toString();
                        prikladTV.setText(priklad + "^");
                        operaciaStlacena = true;
                        aktualnaOperacia = "^";
                        jeBodka=false;
                    }else {
                        error();
                    }
                }
            }
        });

        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaciaStlacena){
                    error();
                } else {
                    if (prikladTV.getText().toString().length()>0) {

                        String screen = prikladTV.getText().toString();
                        prveCislo = Double.parseDouble(prikladTV.getText().toString());
                        double cislo = Math.toRadians(prveCislo);
                        vysledokTV.setText(String.valueOf((Math.sin(cislo))));
                        jeBodka=false;
                    }else {
                        error();
                    }
                }
            }
        });

        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaciaStlacena){
                    error();
                } else {
                    if (prikladTV.getText().toString().length()>0) {

                        String screen = prikladTV.getText().toString();
                        prveCislo = Double.parseDouble(prikladTV.getText().toString());
                        double cislo = Math.toRadians(prveCislo);
                        vysledokTV.setText(String.valueOf((Math.cos(cislo))));
                        jeBodka=false;
                    }else {
                        error();
                    }
                }
            }
        });

        btnVysledok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaciaStlacena){
                    String screen = prikladTV.getText().toString();
                    String druheCisloString = screen.substring(druheCisloIndex+1,screen.length());
                    //vysledokTV.setText(druheCisloString);
                    double druheCislo = Double.parseDouble(druheCisloString);
                    switch (aktualnaOperacia) {
                        case "+" :
                            druheCislo+=prveCislo;
                            vysledokTV.setText(String.valueOf(druheCislo));
                            prikladTV.setText("");
                            operaciaStlacena = false;
                            break;
                        case "-":
                            druheCislo = prveCislo - druheCislo;
                            vysledokTV.setText(String.valueOf(druheCislo));
                            prikladTV.setText("");
                            operaciaStlacena = false;
                            break;
                        case "*":
                            druheCislo = druheCislo * prveCislo;
                            vysledokTV.setText(String.valueOf(druheCislo));
                            prikladTV.setText("");
                            operaciaStlacena = false;
                            break;
                        case "/":
                            druheCislo = prveCislo / druheCislo;
                            vysledokTV.setText(String.valueOf(druheCislo));
                            prikladTV.setText("");
                            operaciaStlacena = false;
                            break;
                        case"^":
                            druheCislo = Math.pow(prveCislo,druheCislo);
                            vysledokTV.setText(String.valueOf(druheCislo));
                            prikladTV.setText("");
                            operaciaStlacena = false;
                            break;
                        default:
                            error();
                            break;

                    }
                } else {
                    vysledokTV.setText("Zadaj operaciu");
                }

            }
        });


    }

    /**
     * metoda sluzi na vypisanie erroru
     */
    public void error() {
        prikladTV.setText("");
        vysledokTV.setText("ERROR");
        operaciaStlacena = false;
    }

    /**
     * pomocou tejto metody ukladam všetky potrebne udaje aby pri otoveni sa nestratili
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("prikladTV",prikladTV.getText().toString());
        outState.putString("vysledokTV", vysledokTV.getText().toString());
        outState.putDouble("prveCislo", prveCislo);
        outState.putBoolean("jeStlacene" , operaciaStlacena);
        outState.putString("operacia" , aktualnaOperacia);
        outState.putBoolean("jeBodka" , jeBodka);
        super.onSaveInstanceState(outState);
    }

    /**
     * pomocou tejto metody nacitavam vsetky ulozene veci a nacitavam ich do povodneho stavu
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        prikladTV.setText(savedInstanceState.getString("prikladTV"));
        vysledokTV.setText(savedInstanceState.getString("vysledokTV"));
        prveCislo = savedInstanceState.getDouble("prveCislo");
        operaciaStlacena = savedInstanceState.getBoolean("jeStlacene");
        aktualnaOperacia = savedInstanceState.getString("operacia");
        jeBodka = savedInstanceState.getBoolean("jeBodka");
    }
}
