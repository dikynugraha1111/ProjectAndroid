package com.example.projectandroid.risandio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.projectandroid.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity4 extends AppCompatActivity {

    ViewFlipper gbr1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        int images[] = {R.drawable.bs41, R.drawable.bs42};
        gbr1 = findViewById(R.id.gbr1);

        for (int i =0; i<images.length; i++){
            gmbr(images[i]);
        }
        for (int image: images)
            gmbr(image);


        Adapter4 adapter = new Adapter4(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view);
        viewPager.setAdapter(adapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



    }

    public  void  gmbr(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        gbr1.addView(imageView);
        gbr1.setFlipInterval(4000);
        gbr1.setAutoStart(true);

        gbr1.setInAnimation(this,android.R.anim.slide_in_left);
        gbr1.setOutAnimation(this,android.R.anim.slide_out_right);

    }
}
