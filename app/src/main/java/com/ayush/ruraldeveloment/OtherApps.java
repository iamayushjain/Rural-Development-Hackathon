package com.ayush.ruraldeveloment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class OtherApps extends AppCompatActivity {

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherapp);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        String[] name = {"Digital india", "Kisan Suvidha", "Stoolie - Gov. Data Provider", "KHETI BADI", "Hello English: Learn English"};
        Integer[] image = {R.drawable.pic0, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};
        final String[] link = {"https://play.google.com/store/apps/details?id=com.wDigitalindia&hl=en", "https://play.google.com/store/apps/details?id=in.cdac.bharatd.agriapp&hl=en", "https://play.google.com/store/apps/details?id=com.ayush.infomationindia&hl=en", "https://play.google.com/store/apps/details?id=tetarwalsuren.khetibarikijankari&hl=en", "https://play.google.com/store/apps/details?id=com.CultureAlley.japanese.english&hl=en"};
        imagecustom ic = new imagecustom(this, name, image, link);
        gridview.setAdapter(ic);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link[position]));
                startActivity(browserIntent);

            }
        });
    }
}
