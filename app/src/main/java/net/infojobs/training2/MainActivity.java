package net.infojobs.training2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.image);

        Picasso picasso = Picasso.with(this);
        picasso.setLoggingEnabled(true);
        picasso.load("http://energiaysalud.org/wp-content/uploads/2015/01/benefits-of-eating-banana.jpg")
                .into(imageView);

        Log.d("IJ", "onCreate!");

        View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondaryActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("IJ", "onResume :D");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("IJ", "onPause");
        try {
            sendPrivateDataToServer();
        } catch (Exception e) {
            Log.e("IJ", "Erró de servidó", e);
        }
    }

    private void sendPrivateDataToServer() {
        throw new RuntimeException("Banana");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("IJ", "onDestroy");
    }
}
