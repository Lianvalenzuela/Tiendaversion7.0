package com.example.tiendav1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AMD extends AppCompatActivity {
    private RecyclerView recycler_A;
    private itemAdapter itemAdap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amd);
        recycler_A = (RecyclerView) findViewById(R.id.recycler_A);
        itemAdap = new itemAdapter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        itemAdap.setData(getData());
        recycler_A.setAdapter(itemAdap);
        recycler_A.setLayoutManager(llm);
    }
    private List<item> getData() {
        List<item> list = new ArrayList<>();
        list.add(new item(R.drawable.r9_290, "R9 290 precio: $375.000"));
        list.add(new item(R.drawable.rx270x, "RX 270X precio: $150.000"));
        return list;
    }
}