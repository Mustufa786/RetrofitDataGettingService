package com.example.mustafaansari.syncfunction;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mustafaansari.syncfunction.model.Cluster;
import com.example.mustafaansari.syncfunction.model.User;
import com.example.mustafaansari.syncfunction.responses.ClusterResponse;
import com.example.mustafaansari.syncfunction.responses.UserResponse;
import com.example.mustafaansari.syncfunction.services.RetrofitClient;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button sync;
    KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitClient.getInstance();

        sync = findViewById(R.id.sync);
        hud = KProgressHUD.create(this).setCancellable(false).setStyle(KProgressHUD.Style.ANNULAR_DETERMINATE).setMaxProgress(100);


        sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                getPosts();


            }
        });
    }

    private void getPosts() {
        hud.show();
        Call<ResponseBody> call = RetrofitClient.api.getPosts();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                dismissProgress();
                Toast.makeText(MainActivity.this, "Users synced!", Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {

                    try {
                        String data = response.body().string();
                        JSONArray jsonArray = new JSONArray(data);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Log.d(TAG, "onResponse: posts " + jsonArray.get(i));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

//    private void getClusters() {
//
//
//        Call<ResponseBody> call2 = RetrofitClient.api.getClusters();
//        call2.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Toast.makeText(MainActivity.this, "Clusters synced..", Toast.LENGTH_SHORT).show();
//                dismissProgress();
//                getUsers();
//                if (response.isSuccessful()) {
//
//                    try {
//                        String data = response.body().string();
//                        JSONArray jsonArray = new JSONArray(data);
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            Log.d(TAG, "onResponse: clusters " + jsonArray.get(i));
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//
//            }
//        });
//
//    }

    private void dismissProgress() {
        hud.dismiss();
    }
}
