package com.example.helloprogmob.Network;

import com.example.helloprogmob.Model.DefaultResult;
import com.example.helloprogmob.Model.Mahasiswa;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetDataService {
    @GET("/api/progmob/mhs/{nim_progmob}")
    Call<List<Mahasiswa>> getMahasiswa(@Path("nim_progmob") String nim_progmob);

@FormUrlEncoded
    @POST("/api/progmob/mhs/delete")
    Call<DefaultResult>delete_mhs(
            @Field("id") String id,
            @Field("nim_progmob") String nim_progmob
);
 @FormUrlEncoded
 @POST("/api/progmob/mhs/create")
 Call<DefaultResult> add_mhs(
         @Field("nama") String nama,
         @Field("nim") String nim,
         @Field("alamat") String alamat,
         @Field("email") String email,
         @Field("foto") String foto,
         @Field("nim_progmob") String nim_progmob

         );
    @FormUrlEncoded
    @POST("/api/progmob/mhs/update")
    Call<DefaultResult> update_mhs(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("nim") String nim,
            @Field("alamat") String alamat,
            @Field("email") String email,
            //@Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
            );

}
