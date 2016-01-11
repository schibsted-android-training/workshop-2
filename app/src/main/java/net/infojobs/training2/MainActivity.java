package net.infojobs.training2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private File photoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);

        Picasso picasso = Picasso.with(this);
        picasso.load("http://energiaysalud.org/wp-content/uploads/2015/01/benefits-of-eating-banana.jpg")
                .into(imageView);

        Log.d("IJ", "onCreate!");

        View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, SecondaryActivity.class), 2);
            }
        });

        View newBananaButton = findViewById(R.id.new_banana);
        newBananaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchCamera();
            }
        });
    }

    private void launchCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File photoDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//        File photoDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        try {
            photoFile = File.createTempFile("banana", "jpg", photoDir);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
            startActivityForResult(cameraIntent, 1);
        } catch (IOException e) {
            Log.e("IJ", "Error", e);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==2 && resultCode == Activity.RESULT_OK) {
            String text = data.getStringExtra("text");
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        } else if (requestCode == 666 && resultCode == AppCompatActivity.RESULT_OK) {
            Picasso.with(this).load(photoFile).into(imageView);
        }
    }
}
