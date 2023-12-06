package com.example.tiendav1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Carrito extends AppCompatActivity {
    private RecyclerView recycler_C;
    private itemAdapter itemAdap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        recycler_C = (RecyclerView) findViewById(R.id.recycler_C);
        itemAdap = new itemAdapter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        itemAdap.setData(getData());
        recycler_C.setAdapter(itemAdap);
        recycler_C.setLayoutManager(llm);
    }
    private List<item> getData() {
        List<item> list = new ArrayList<>();
        list.add(new item(R.drawable.gtx1080ti, "GTX 1080 TI"));
        list.add(new item(R.drawable.rx270x, "RX 270X"));
        return list;
    }
}