package ahmet.diet.com.dietfb;

/**
 * Created by MONSTER on 10.05.2017.
 */

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CalculateVKI extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vki);



        final EditText boy = (EditText) findViewById(R.id.editText7);
        final EditText kilo = (EditText) findViewById(R.id.editText6);
        final EditText yas = (EditText) findViewById(R.id.editText);
        final TextView sonuc = (TextView) findViewById(R.id.textView3);
        final TextView detay = (TextView) findViewById(R.id.textView4);

        TextView name = (TextView)findViewById(R.id.textView);
        name.setText(getIntent().getExtras().getString("veri"));


                Button islem = (Button) findViewById(R.id.islem);

                final String deneme;

                islem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        float Length = Float.parseFloat(boy.getText().toString());
                        float Weigth = Float.parseFloat(kilo.getText().toString());
                        float Age = Float.parseFloat(yas.getText().toString());
                        float VKI;
                        if (Length > 3) {
                            Length = Length / 100;
                        }
                        sonuc.setText("Vucut Kutle Indeksin:" + String.valueOf(Weigth / (Length * Length)));
                        VKI = Weigth / (Length * Length);
                        // devamÄ±nada morbÄ±d obezsÄ±n zayÄ±fsÄ±n flnla Ä±lgÄ±lÄ± bÄ± bÄ±lgÄ± gelcek bÄ±de yas Ä±cÄ±n bÄ± edÄ±ttext olcak

                        if (Age >= 19 && Age <= 24) {
                            if (VKI <= 20) {
                                detay.setText("ZayÄ±f");
                            } else if (VKI > 20 && VKI <= 24.9) {
                                detay.setText("Normal");
                            } else if (VKI > 24.9 && VKI <= 29.9) {
                                detay.setText("Hafif Sisman");
                            } else if (VKI > 29.9 && VKI <= 34.9) {
                                detay.setText("SÄ±sman");
                            } else if (VKI > 34.9 && VKI <= 44.9) {
                                detay.setText("SqglÄ±k acÄ±sÄ±ndan onemlÄ±");
                            } else if (VKI > 44.9 && VKI <= 49.9) {
                                detay.setText("AsÄ±rÄ± SÄ±sman");
                            } else if (VKI > 49.9) {
                                detay.setText("Morbid (Olumcul) SÄ±sman");
                            }
                        } else if (Age >= 25 && Age <= 34) {
                            if (VKI <= 21) {
                                detay.setText("ZayÄ±f");
                            } else if (VKI > 21 && VKI <= 25.9) {
                                detay.setText("Normal");
                            } else if (VKI > 25.9 && VKI <= 30.9) {
                                detay.setText("Hafif Sisman");
                            } else if (VKI > 30.9 && VKI <= 35.9) {
                                detay.setText("SÄ±sman");
                            } else if (VKI > 35.9 && VKI <= 45.9) {
                                detay.setText("SqglÄ±k acÄ±sÄ±ndan onemlÄ±");
                            } else if (VKI > 45.9 && VKI <= 50.9) {
                                detay.setText("AsÄ±rÄ± SÄ±sman");
                            } else if (VKI > 50.9) {
                                detay.setText("Morbid (Olumcul) SÄ±sman");
                            }
                        } else if (Age >= 35 && Age <= 44) {
                            if (VKI <= 22) {
                                detay.setText("ZayÄ±f");
                            } else if (VKI > 22 && VKI <= 26.9) {
                                detay.setText("Normal");
                            } else if (VKI > 26.9 && VKI <= 31.9) {
                                detay.setText("Hafif Sisman");
                            } else if (VKI > 31.9 && VKI <= 36.9) {
                                detay.setText("SÄ±sman");
                            } else if (VKI > 36.9 && VKI <= 46.9) {
                                detay.setText("SqglÄ±k acÄ±sÄ±ndan onemlÄ±");
                            } else if (VKI > 46.9 && VKI <= 51.9) {
                                detay.setText("AsÄ±rÄ± SÄ±sman");
                            } else if (VKI > 51.9) {
                                detay.setText("Morbid (Olumcul) SÄ±sman");
                            }
                        } else if (Age >= 45 && Age <= 54) {
                            if (VKI <= 23) {
                                detay.setText("ZayÄ±f");
                            } else if (VKI > 23 && VKI <= 27.9) {
                                detay.setText("Normal");
                            } else if (VKI > 27.9 && VKI <= 32.9) {
                                detay.setText("Hafif Sisman");
                            } else if (VKI > 32.9 && VKI <= 37.9) {
                                detay.setText("SÄ±sman");
                            } else if (VKI > 37.9 && VKI <= 47.9) {
                                detay.setText("SqglÄ±k acÄ±sÄ±ndan onemlÄ±");
                            } else if (VKI > 47.9 && VKI <= 52.9) {
                                detay.setText("AsÄ±rÄ± SÄ±sman");
                            } else if (VKI > 52.9) {
                                detay.setText("Morbid (Olumcul) SÄ±sman");
                            }
                        } else if (Age >= 55 && Age <= 64) {
                            if (VKI <= 24) {
                                detay.setText("ZayÄ±f");
                            } else if (VKI > 24 && VKI <= 28.9) {
                                detay.setText("Normal");
                            } else if (VKI > 28.9 && VKI <= 33.9) {
                                detay.setText("Hafif Sisman");
                            } else if (VKI > 33.9 && VKI <= 38.9) {
                                detay.setText("SÄ±sman");
                            } else if (VKI > 38.9 && VKI <= 48.9) {
                                detay.setText("SqglÄ±k acÄ±sÄ±ndan onemlÄ±");
                            } else if (VKI > 48.9 && VKI <= 53.9) {
                                detay.setText("AsÄ±rÄ± SÄ±sman");
                            } else if (VKI > 53.9) {
                                detay.setText("Morbid (Olumcul) SÄ±sman");
                            }
                        } else if (Age >= 65) {
                            if (VKI <= 25) {
                                detay.setText("Zayif");
                            } else if (VKI > 25 && VKI <= 29.9) {
                                detay.setText("Normal");
                            } else if (VKI > 29.9 && VKI <= 34.9) {
                                detay.setText("Hafif Sisman");
                            } else if (VKI > 34.9 && VKI <= 39.9) {
                                detay.setText("Sisman");
                            } else if (VKI > 39.9 && VKI <= 49.9) {
                                detay.setText("Saglik acisindan onemli");
                            } else if (VKI > 49.9 && VKI <= 54.9) {
                                detay.setText("AsÄ±rÄ± SÄ±sman");
                            } else if (VKI > 54.9) {
                                detay.setText("Morbid (Olumcul) Sisman");
                            }
                        } else {
                            detay.setText("19 yasÄ±ndan kucuksun bu hesaplama 19 yasÄ±ndan Ä±tÄ±baren hesaplÄ±yor");
                        }

                        Button next = (Button) findViewById(R.id.btnNextPage);
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent nextpage = new Intent(CalculateVKI.this, DiyetListesi.class);
                                startActivity(nextpage);

                            }
                        });
                    }
                });

            }

        }

