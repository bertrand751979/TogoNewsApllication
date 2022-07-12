package com.example.togonewsapllication.viewModels;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.togonewsapllication.GlobalFranceNewsApi;
import com.example.togonewsapllication.models.Article;
import com.example.togonewsapllication.models.Root;
import com.example.togonewsapllication.repository.RepositoryFranceNews;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GlobalFranceNewsFragmentViewModel extends ViewModel {
    private MutableLiveData<List<Article>> myListGlobalNews = new MutableLiveData();
    public LiveData<List<Article>> globalNewsDataList = myListGlobalNews;

    public void callService(){
        GlobalFranceNewsApi.GlobalFranceNewsService service = GlobalFranceNewsApi.getInstance().getClient().create(GlobalFranceNewsApi.GlobalFranceNewsService.class);
        Call<Root> call= service.getRoots("france","2022-07-02","2022-07-05","fr","general","cf5883a8ef6c4b25b2dde26488d5f680");
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                    processResponse(response);
            }
            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }
    private void processResponse(Response<Root> response) {
        if(response.body().getArticles().size()>0){
            RepositoryFranceNews.getInstance().globalNewsList = (ArrayList<Article>) response.body().getArticles();
            myListGlobalNews.postValue(response.body().getArticles());
        }
    }

    public void addToFavorite(Article article,Context context){
        RepositoryFranceNews.getInstance().add(article,context);
    }

}
