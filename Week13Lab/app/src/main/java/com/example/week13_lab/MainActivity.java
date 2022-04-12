package com.example.week13_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_UI();
    }

    private ListElement[] generate_person_data() {
        ListElement[] elements = {
                new ListElement(ListElement.ElementType.HEADER, "Regular"),
                new ListElement(ListElement.ElementType.ITEM, "Seth Powell", "seth.powell@example.com", "https://randomuser.me/api/portraits/men/9.jpg"),
                new ListElement(ListElement.ElementType.ITEM, "Dana Beck", "dana.beck@example.com", "https://randomuser.me/api/portraits/women/70.jpg"),
                new ListElement(ListElement.ElementType.ITEM, "Rita Butler", "rita.butler@example.com", "https://randomuser.me/api/portraits/women/37.jpg"),
                new ListElement(ListElement.ElementType.HEADER, "Other"),
                new ListElement(ListElement.ElementType.ITEM, "Tracey Graves", "tracey.graves@example.com", "https://randomuser.me/api/portraits/women/54.jpg"),
                new ListElement(ListElement.ElementType.ITEM, "Sonia Davidson", "sonia.davidson@example.com", "https://randomuser.me/api/portraits/women/2.jpg")
        };
        return elements;
    }

    private void init_UI() {
        rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.Adapter adapter = new PersonAdapter(this,generate_person_data());
        rv.setAdapter(adapter);
    }
}