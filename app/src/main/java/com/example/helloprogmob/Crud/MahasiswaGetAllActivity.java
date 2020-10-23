package com.example.helloprogmob.Crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.widget.Toast;

import com.example.helloprogmob.Adapter.MahasiswaCRUDRecyclerAdapter;
import com.example.helloprogmob.Model.Mahasiswa;
import com.example.helloprogmob.Network.GetDataService;
import com.example.helloprogmob.Network.RetrofitClientInstance;
import com.example.helloprogmob.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaGetAllActivity extends AppCompatActivity {

    RecyclerView rvMhs;
    MahasiswaCRUDRecyclerAdapter mhsAdapter;
    ProgressDialog pd;
    List<Mahasiswa> mahasiswaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_get_all);

        rvMhs = (RecyclerView)findViewById(R.id.rvGetMhsAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Hello");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Mahasiswa>> call = service.getMahasiswa("721170109");

        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                pd.dismiss();
                mahasiswaList = response.body();
                mhsAdapter = new MahasiswaCRUDRecyclerAdapter( mahasiswaList);
            }

            @Override
            public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MahasiswaGetAllActivity.this, "Error", Toast.LENGTH_LONG);

            }
        });







    }
}