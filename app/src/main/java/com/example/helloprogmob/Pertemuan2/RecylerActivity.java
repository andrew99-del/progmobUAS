package com.example.helloprogmob.Pertemuan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloprogmob.Adapter.MahasiswaCRUDRecyclerAdapter;
import com.example.helloprogmob.Adapter.MahasiswaRecyclerAdapter;
import com.example.helloprogmob.Model.Mahasiswa;
import com.example.helloprogmob.R;

import java.util.ArrayList;
import java.util.List;

public class RecylerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihan);
        MahasiswaRecyclerAdapter MahasiswaRecyclerAdapter;

        //data
        List<Mahasiswa> mahasiswaList =new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Melsiora","72170101","085243266278");
        Mahasiswa m2 = new Mahasiswa("Saniba","72170102","08545326633");
        Mahasiswa m3 = new Mahasiswa("Fernandes","72170103","088533266459");
        Mahasiswa m4 = new Mahasiswa("Zefanya","72170104","087603266923");
        Mahasiswa m5 = new Mahasiswa("Nana","72170105","089543266567");
        Mahasiswa m6 = new Mahasiswa("Clara","72170106","085934266841");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);
        mahasiswaList.add(m6);

        MahasiswaRecyclerAdapter = new MahasiswaRecyclerAdapter(RecylerActivity.this);
        MahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(RecylerActivity.this));
        rv.setAdapter(MahasiswaRecyclerAdapter);
    }
}