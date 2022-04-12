package com.example.week13_quiz5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ImageButton likeButton;
    TextView tvCount;

    ArrayList<StadiumData> stadiumDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);
        tvCount = (TextView) findViewById(R.id.tvCount);

        stadiumDataArrayList = new ArrayList<>();
        stadiumDataArrayList.add(new StadiumData("Lusail Iconic Stadium", "Lusail", "86.250","https://iftm.tmgrup.com.tr/album/2018/07/09/1531118756167.png"));
        stadiumDataArrayList.add(new StadiumData("Khalifa Stadium","Doha", "68.030", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118750633.png"));
        stadiumDataArrayList.add(new StadiumData("Sports City Stadium","Doha", "47.560", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118753997.png"));
        stadiumDataArrayList.add(new StadiumData("Education City Stadium","Doha", "45.350", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118744118.png"));
        stadiumDataArrayList.add(new StadiumData("Al-Khor Stadium","Al-Khor", "45.330", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118747189.png"));
        stadiumDataArrayList.add(new StadiumData("Al-Shamal Stadium","Medinet eş Şemal", "45.120", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118751674.png"));
        stadiumDataArrayList.add(new StadiumData("Al-Wakrah Stadium","Al-Wakrah", "45.120", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118747476.png"));
        stadiumDataArrayList.add(new StadiumData("Umm Salal Stadium","Umm Salal", "45.120", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118748372.png"));
        stadiumDataArrayList.add(new StadiumData("Doha Port Stadium","Doha", "44.950", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118743078.png"));
        stadiumDataArrayList.add(new StadiumData("Thani bin Jassim Stadium","Doha", "44.740", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118748755.png"));
        stadiumDataArrayList.add(new StadiumData("Ahmed bin Ali Stadium","Al Rayyan", "44.740", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118748888.png"));
        stadiumDataArrayList.add(new StadiumData("Qatar University Stadium","Doha", "43.520", "https://iftm.tmgrup.com.tr/album/2018/07/09/1531118755424.png"));

        StadiumAdapter adapter = new StadiumAdapter(stadiumDataArrayList, this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(adapter);
        int counter = stadiumDataArrayList.size();
        tvCount.setText(Integer.toString(counter));
    }
}