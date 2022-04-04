package com.example.aplikasiets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter mAdapter;
    ArrayList<Klub> listK;
    String[] name;
    int[] rank;
    int[] poin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listK = new ArrayList<>();

        Klub persib = new Klub("Persib",2, 69,31,20,6,5,46,20,26);
        //Klub persib = new Klub("Persib",2, 69);
        listK.add(persib);

//        name = new String[]{"Bali United"};
//        rank = new int[]{1};
//        poin = new int[]{69};
        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        mAdapter = new Adapter(this, listK);
//        mAdapter = new Adapter(this,name,rank,poin);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}