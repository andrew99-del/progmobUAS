package com.example.helloprogmob.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloprogmob.Model.DefaultResult;
import com.example.helloprogmob.Network.GetDataService;
import com.example.helloprogmob.Network.RetrofitClientInstance;
import com.example.helloprogmob.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaAddActivity extends AppCompatActivity {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_add);

        final EditText edNama = (EditText)findViewById(R.id.editTextInput);
        final EditText edNim = (EditText)findViewById(R.id.editTextInput);
        final EditText edAlamat = (EditText)findViewById(R.id.editTextInput);
        final EditText edEmail = (EditText)findViewById(R.id.editTextInput);
        Button btnSimpan = (Button)findViewById(R.id.buttonSimpanMhs);
        pd = new ProgressDialog(MahasiswaAddActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("mohon menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_mhs(
                        edNama.getText().toString(),
                        edNim.getText().toString(),
                        edAlamat.getText().toString(),
                        edEmail.getText().toString(),
                        "Kosongkan Saja disini dirandom sistem",
                        "72170109"



                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText( MahasiswaAddActivity.this, "DATA BERHASIL DISIMPAN",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaAddActivity.this, "GAGAL", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });




    }
}