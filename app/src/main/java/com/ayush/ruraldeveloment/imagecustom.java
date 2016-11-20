package com.ayush.ruraldeveloment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ayush on 20/11/16.
 */

public class imagecustom extends ArrayAdapter<String> {

    final Activity context;
    final String[] web;
    final Integer[] web1;
    final String[] web2;


    public imagecustom(Activity context,
                       String[] web, Integer[] web1, String[] web2) {
        super(context, R.layout.image_custom, web);
        this.context = context;
        this.web = web;

        this.web1 = web1;
        this.web2 = web2;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.image_custom, null, true);
        int color_id[] = {Color.DKGRAY, Color.WHITE};
        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
        ImageView iv = (ImageView) rowView.findViewById(R.id.listImage);
        iv.setImageResource(web1[position]);
        int pos = randomWithRange(0, 1);
//iv.setBackgroundColor(color_id[pos]);


//ImageView imageView = (ImageView) rowView.findViewById(R.id.listImage);
        txtTitle.setText(web[position]);
//        txtTitle.setTypeface(Typeface
//                .createFromAsset(context.getAssets(), "robotothin.ttf"));
//

        txtTitle.setSelected(true);
//tv.setSelected(true);
        txtTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        txtTitle.setSingleLine(true);
//txtTitle1.setWidth(.getLayoutParams().width/2);

        return rowView;
    }

    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}





