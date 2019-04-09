package com.example.hp.mail;

/**
 * Created by HP on 7/15/2017.
 */
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;


public class QRcode extends AppCompatActivity  {
    String qrInputText;
    Bitmap qrBitmap ;
    Button save, share;
    ImageView myImage;

    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcode);
//        Button button1 = (Button) findViewById(R.id.button1);
//        button1.setOnClickListener(this);
         qrInputText=getIntent().getStringExtra("QR").toString();
         save = (Button)findViewById(R.id.save);
         share = (Button)findViewById(R.id.share);
         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 File Directory = new File(Environment.getExternalStorageDirectory()+"/Click Eve/QR_Code");
                 if(Directory.mkdirs()){
                     System.out.println("Directory created");
                 }
                 String filename = "QR_"+qrInputText+".jpeg";
                 File newFile  = new File(Directory,filename);
                 if(newFile.exists()){
                     Toast.makeText(QRcode.this, "File Already Exists...", Toast.LENGTH_SHORT).show();
                 }else {
                     try {
                         FileOutputStream fis = new FileOutputStream(newFile);
                         qrBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fis);
                         fis.flush();
                         fis.close();
                     } catch (FileNotFoundException e) {
                         e.printStackTrace();
                     } catch (IOException e) {


                     }
                 }
             }
         });
         share.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent shareIntent = new Intent();
                 shareIntent.setAction(Intent.ACTION_SEND);
                 //shareIntent.putExtra(Intent.EXTRA_STREAM,uri );
                 shareIntent.putExtra(Intent.EXTRA_TEXT, qrInputText);
                 shareIntent.setType("text/plain");
                 shareIntent.setType("Image/jpeg");
                 File Directory = new File(Environment.getExternalStorageDirectory()+"/Click Eve/QR_Code");
                 if(Directory.mkdirs()){
                     System.out.println("Directory created");
                 }
                 String filename = "QR_"+qrInputText+".jpeg";
                 File newFile  = new File(Directory,filename);
                 if(newFile.exists()){
                     Toast.makeText(QRcode.this, "File Already Exists...", Toast.LENGTH_SHORT).show();
                 }else {
                     try {
                         FileOutputStream fis = new FileOutputStream(newFile);
                         qrBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fis);
                         fis.flush();
                         fis.close();
                     } catch (FileNotFoundException e) {
                         e.printStackTrace();
                     } catch (IOException e) {


                     }
                 }
                 shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(String.valueOf(newFile)));
                 startActivity(Intent.createChooser(shareIntent,"Share Image to...."));

             }
         });
        Toast.makeText(this,qrInputText , Toast.LENGTH_SHORT).show();



        Log.v("LOG_TAG", qrInputText);

        //Find screen size
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3/4;

        //Encode with a QR Code image
        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(qrInputText,
        null,
        Contents.Type.TEXT,
        BarcodeFormat.QR_CODE.toString(),
        smallerDimension);
        try {
        Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
        myImage = (ImageView)findViewById(R.id.imageView4);
        qrBitmap = bitmap;
        myImage.setDrawingCacheEnabled(true);
        myImage.setImageBitmap(bitmap);

        } catch (Exception e) {
        e.printStackTrace();
        }






        }
        }




