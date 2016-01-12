package net.infojobs.training2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        View moarBananas = findViewById(R.id.moar_bananas);
        moarBananas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:rafael.vazquez@gmail.com"));
//                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"rafael.vazquez@infojobs.net"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Moar Bananas");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Sir.\n\nI'd like moar bananas.\n\nThanks");
//                startActivity(emailIntent);
                startActivity(Intent.createChooser(emailIntent, "Enviar vía…"));
            }
        });

        Button pyjamasButton = (Button) findViewById(R.id.pyjamas);
        pyjamasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("text", "Bananas in pyjamas");
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }

}
