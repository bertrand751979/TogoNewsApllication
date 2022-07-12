package com.example.togonewsapllication;

import com.example.togonewsapllication.models.Root;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class GlobalFranceNewsApi {
    public interface GlobalFranceNewsService{
        @GET("everything")
        Call<Root> getRoots(@Query("q") String q, @Query("from")String from, @Query("to")String to,@Query("language")String language, @Query("sortBy")String sort, @Query("apiKey")String apiKey);
        //Call<Root> getRoots(@Query("q") String q, @Query("from")String from, @Query("to")String to,@Query("sortBy")String sort, @Query("apiKey")String apiKey);

    }
    private final static String BASE_URL ="https://newsapi.org/v2/";
    private static GlobalFranceNewsApi INSTANCE = null;
    private GlobalFranceNewsApi(){}
    public static GlobalFranceNewsApi getInstance(){
        if(INSTANCE == null){
            INSTANCE = new GlobalFranceNewsApi();
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
