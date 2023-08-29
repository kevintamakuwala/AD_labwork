package com.example.lab6;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
    private static final int Image_Capture_Code=1;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button capture = (Button) findViewById(R.id.capture);
        img = (ImageView) findViewById(R.id.imageView);

        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, Image_Capture_Code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==Image_Capture_Code){
            if(resultCode==RESULT_OK) {
                Bitmap pic=(Bitmap) data.getExtras().get("data");
                img.setImageBitmap(pic);
                MediaStore.Images.Media.insertImage(getContentResolver(),pic,"Image","Image Description");
            }else if(resultCode==RESULT_CANCELED){
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }
}