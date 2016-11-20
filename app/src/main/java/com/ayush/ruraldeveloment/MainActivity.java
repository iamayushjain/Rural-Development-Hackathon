package com.ayush.ruraldeveloment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        ListView gridview = (ListView) findViewById(R.id.listView);
        String[] name = {"MANDI", "HOSPITALS", "Elections", "Others Apps"};
        Integer[] image = {R.drawable.egov0, R.drawable.egov1, R.drawable.egov4, R.drawable.egov3};
        final String[] link = {"https://play.google.com/store/apps/details?id=com.wDigitalindia&hl=en", "https://play.google.com/store/apps/details?id=in.cdac.bharatd.agriapp&hl=en", "https://play.google.com/store/apps/details?id=com.ayush.infomationindia&hl=en", "https://play.google.com/store/apps/details?id=tetarwalsuren.khetibarikijankari&hl=en"};
        imagecustom ic = new imagecustom(this, name, image, link);
        gridview.setAdapter(ic);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, Register.class));
                   //     finish();
                        break;

                    case 1:
                        startActivity(new Intent(MainActivity.this, com.ayush.ruraldeveloment.Hospitals.hospitals.class));
                      //  finish();
                        break;

                    case 2:
                        startActivity(new Intent(MainActivity.this, ElectionDetails.class));
                        finish();
                        break;

                    case 3:
                        startActivity(new Intent(MainActivity.this, OtherApps.class));
                        finish();
                        break;
                }
            }
        });
    }
}
