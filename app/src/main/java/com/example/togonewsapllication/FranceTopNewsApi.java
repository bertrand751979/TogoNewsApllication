package com.example.togonewsapllication;

import com.example.togonewsapllication.models.Root;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class FranceTopNewsApi {
    public interface FranceTopNewsService{
        @GET("top-headlines")
        Call<Root> getRoot(@Query("country") String country, @Query("apiKey")String apiKey);
    }
    private final static String BASE_URL ="https://newsapi.org/v2/";
    private static FranceTopNewsApi INSTANCE = null;
    private FranceTopNewsApi(){}
    public static FranceTopNewsApi getInstance(){
        if(INSTANCE == null){
            INSTANCE = new FranceTopNewsApi();
        }
        return INSTANCE;
    }
    public Retrofit getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

}
