package com.example.seminar4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.seminar4.myclasses.ImagineAdapter;
import com.example.seminar4.myclasses.ImaginiDomeniu;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AfisareImagini extends AppCompatActivity {
    ArrayList<String> linkuriImagine=new ArrayList<>();

    ArrayList<ImaginiDomeniu> lista=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.afisareimagini);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        linkuriImagine.add("https://yotel-new-york.hotelmix.ro/data/Photos/OriginalPhoto/12106/1210664/1210664452/Yotel-New-York-Times-Square-Room.JPEG");
        linkuriImagine.add("https://static.leonardo-hotels.com/image/executive-room-with-king-bed_35ba711c8e3052877659372a86e4bb3a_1200x800_mobile_3.jpeg");
        linkuriImagine.add("https://media.architecturaldigest.com/photos/5783da093cba0f2e2ca06bab/master/w_1600%2Cc_limit/Shangri-La%25202.jpg");
        linkuriImagine.add("https://barcelonanavigator.com/wp-content/uploads/2015/04/Suite-Miramar-118-MB.jpg");
        linkuriImagine.add("https://photos.smugmug.com/Kyoto/Best-Japanese-Hotel-Chains/i-vV8J4Hn/0/efcd2d21/XL/ik-hotel-chains-okura-tokyo-XL.jpg");

        ArrayList<String> texts=new ArrayList<>();
        texts.add("Camera New York");
        texts.add("Camera London");
        texts.add("Camera Paris");
        texts.add("Camera Barcelona");
        texts.add("Camera Japonia");

        ListView lv =findViewById(R.id.listview_imagini);
        ImagineAdapter adapter=new ImagineAdapter(getApplicationContext(),lista,R.layout.lytemplate);
        lv.setAdapter(adapter);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i<linkuriImagine.size();i++){
                    HttpURLConnection con=null;
                    try {
                        URL url=new URL(linkuriImagine.get(i));
                        con= (HttpURLConnection) url.openConnection();
                        InputStream is=con.getInputStream();
                        Bitmap img = BitmapFactory.decodeStream(is);
                        ImaginiDomeniu imagine=new ImaginiDomeniu(texts.get(i),linkuriImagine.get(i),img);
                        lista.add(imagine);
                        System.out.println(imagine);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });


    }
}