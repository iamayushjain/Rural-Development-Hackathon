package com.ayush.ruraldeveloment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ayush on 20/11/16.
 */

public class ElectionDetails extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electiondetials);
        final EditText text=(EditText)findViewById(R.id.number);
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.prsindia.org/mptrack/16loksabha/list?query="+text.getText().toString().trim()));
                startActivity(browserIntent);
                finish();

            }
        });

    }
}
