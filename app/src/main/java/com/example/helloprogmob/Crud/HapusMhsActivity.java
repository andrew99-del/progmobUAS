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

public class HapusmMhsActivity extends AppCompatActivity {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_mhs);
        final EditText edNimYangAkanDiHapus = (EditText)findViewById(R.id.editTextInput);
        Button btnHapus = (Button)findViewById(R.id.buttonHapusMhs);
        pd = new ProgressDialog(HapusmMhsActivity.this);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("mohon menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.hapusm_mhs(
                        edNimYangAkanDiHapus.getText().toString(),
                        "Kosongkan Saja disini dirandom sistem",
                        "72170109"



                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText( HapusmMhsActivity.this, "DATA BERHASIL DIHAPUS",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(HapusmMhsActivity.this, "GAGAL", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });



    }
}