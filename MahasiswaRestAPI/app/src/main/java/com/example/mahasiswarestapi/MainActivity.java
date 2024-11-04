package com.example.mahasiswarestapi;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.mahasiswarestapi.model.Mahasiswa;
import com.example.mahasiswarestapi.service.ApiClient;
import com.example.mahasiswarestapi.service.ApiService;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    ApiService apiService;


    TextView mNama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mNama = findViewById(R.id.tvNama);


        retrofit = ApiClient.getRetrofitInstance();
        apiService = retrofit.create(ApiService.class);


    }


    public void onButtonCick(View v){


        Call<Mahasiswa> call = apiService.getMahasiswa(1);
        call.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {


                Mahasiswa mh = response.body();
                String nama = mh.getNama();
                mNama.setText(nama);


            }


            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable throwable) {


            }
        });
    }
}
