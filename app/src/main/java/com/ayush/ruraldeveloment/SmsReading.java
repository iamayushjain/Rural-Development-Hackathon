package com.ayush.ruraldeveloment;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayush on 20/11/16.
 */

public class SmsReading extends Activity {

    List<String> distict, price, category, type, place;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        distict = new ArrayList<String>();
        price = new ArrayList<String>();
        category = new ArrayList<String>();
        type = new ArrayList<String>();
        place = new ArrayList<String>();
        listView = (ListView) findViewById(R.id.listView);
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        int flag = 0;
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                String msgData = "";
                for (int idx = 0; idx < cursor.getColumnCount(); idx++) {
                    msgData += " " + cursor.getColumnName(idx) + ":" + cursor.getString(idx);
                }
                // use msgData
                System.out.print(msgData);
                if (msgData.contains("HACK-J")) {
                    System.out.print("Hello");
                    String[] split = msgData.substring(msgData.indexOf("HACK-J"),msgData.indexOf("service_center")).split("\\n");
                    flag = 1;

                    System.out.print("Array" + split.toString());

                    for (int i = 2; i < split.length; i++) {

                        String s = split[i];
                        System.out.print(s);
                        String[] split1 = s.split(",");
                        System.out.println("Distict" + split1[0]);
                        System.out.println("Smmm" + split1[1]);
                        System.out.println("Typr" + split1[2]);
                        System.out.println("C" + split1[3]);
                        System.out.println("Price" + split1[4]);
                        distict.add(split1[0]);
                        place.add(split1[1]);
                        category.add(split1[2]);
                        type.add(split1[3]);
                        price.add(split1[4]);
                    }


                    ImageCustomLibraryFine ic = new ImageCustomLibraryFine(this, distict.toArray(new String[distict.size()]),place.toArray(new String[place.size()]),category.toArray(new String[category.size()]),type.toArray(new String[type.size()]),price.toArray(new String[price.size()]));
                    //list.setAdapter(ic);
                    listView.setAdapter(ic);

                    break;

                    //cursor.moveToLast();
                }
            } while (flag == 0 && cursor.moveToNext());
        } else {
            // empty box, no SMS
        }

    }
}
