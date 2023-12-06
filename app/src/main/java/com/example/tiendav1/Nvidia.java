package com.example.tiendav1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Nvidia extends AppCompatActivity {
    private RecyclerView recycler_N;
    private itemAdapter itemAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nvidia);
        recycler_N = (RecyclerView) findViewById(R.id.recycler_N);
        itemAdap = new itemAdapter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        itemAdap.setData(getData());
        recycler_N.setAdapter(itemAdap);
        recycler_N.setLayoutManager(llm);
    }
    private List<item> getData() {
        List<item> list = new ArrayList<>();
        list.add(new item(R.drawable.gtx1080ti, "GTX 1080TI precio: $400.000"));
        list.add(new item(R.drawable.rtx4090, "RTX 4090 precio: $2.000.000"));
        return list;
    }
}