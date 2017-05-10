package ahmet.diet.com.dietfb;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Created by MONSTER on 4.04.2017.
 */

public class DiyetListesi extends Activity {

    private String[] ulkeler =
                    {"Türkiye", "Almanya", "Avusturya", "Amerika","İngiltere",
                    "Macaristan", "Yunanistan", "Rusya", "Suriye", "İran", "Irak",
                    "Şili", "Brezilya", "Japonya", "Portekiz", "İspanya",
                    "Makedonya", "Ukrayna", "İsviçre"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diyet_listesi);

        //(A) adımı
        ListView listemiz=(ListView) findViewById(R.id.listView1);

        //(B) adımı
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);

        //(C) adımı
        listemiz.setAdapter(veriAdaptoru);


        listemiz.setOnItemClickListener(new OnItemClickListener() {//burda ulkeler [position] dakı posıtıonun datası nı baska bı classa atcaz ıntentle 3. sayfaya gecıcez

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                AlertDialog.Builder diyalogOlusturucu =
                        new AlertDialog.Builder(DiyetListesi.this);

                diyalogOlusturucu.setMessage(ulkeler[position])
                        .setCancelable(false)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                diyalogOlusturucu.create().show();

            }
        });

    }
}