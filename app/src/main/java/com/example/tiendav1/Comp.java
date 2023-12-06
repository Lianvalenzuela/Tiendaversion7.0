package com.example.tiendav1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Comp extends AppCompatActivity {
    private ImageButton btn_AMD;
    private ImageButton btn_Nvidia;

    private ImageButton btn_carrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp);
        btn_Nvidia = findViewById(R.id.btn_nvidia);
        btn_AMD = findViewById(R.id.btn_AMD);
        btn_carrito=findViewById(R.id.btn_carrito);
        btn_AMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_A = new Intent(Comp.this, AMD.class);
                startActivity(intent_A);
            }
        });
        btn_Nvidia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_N = new Intent(Comp.this, Nvidia.class);
                startActivity(intent_N);
            }
        });
        btn_carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_C = new Intent(Comp.this, Carrito.class);
                startActivity(intent_C);
            }
        });
    }
}