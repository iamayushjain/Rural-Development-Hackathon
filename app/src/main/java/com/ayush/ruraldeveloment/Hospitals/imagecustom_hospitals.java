package com.ayush.ruraldeveloment.Hospitals;



import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ayush.ruraldeveloment.R;

public class imagecustom_hospitals extends ArrayAdapter<String> {
private final Activity context;
private final String[] web1;
private final String[] web2;
private final String[] web3;
private final String[] web4;
private final String[] web5;
private final String[] web6;
private final String[] web7;
private final String[] web8;
//private final String[] web3;

public imagecustom_hospitals(Activity context,
String[] web1, String[] web2, String[] web3 ,String[] web4 ,String[] web5 ,String[] web6 ,String[] web7 ,String[] web8  ) {
super(context, R.layout.imagelayout_hospital, web1);
this.context = context;
this.web1 = web1;
this.web2 = web2;
this.web3 = web3;
this.web4 = web4;
this.web5 = web5;
this.web6 = web6;
this.web8 = web8;
this.web7 = web7;

}
@Override
public View getView(int position, View view, ViewGroup parent) {
LayoutInflater inflater = context.getLayoutInflater();
View rowView= inflater.inflate(R.layout.imagelayout_hospital, null, true);
//TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
//ImageView imageView = (ImageView) rowView.findViewById(R.id.listImage);
//TextView txtTitle=(TextView)rowView.findViewById(R.id.textView1);
//txtTitle.setText(web[position]);
//imageView.setImageResource(imageId[position]);
TextView t1,t2,t3;
t1=(TextView)rowView.findViewById(R.id.textView1);
t2=(TextView)rowView.findViewById(R.id.textView2);
t3=(TextView)rowView.findViewById(R.id.textView3);

t1.setText(web1[position]);
t2.setText(web2[position]);
t3.setText(web3[position]);

return rowView;
}
}
