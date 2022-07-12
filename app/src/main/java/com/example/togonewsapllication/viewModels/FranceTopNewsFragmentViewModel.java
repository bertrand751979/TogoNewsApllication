package com.example.togonewsapllication.viewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.togonewsapllication.FranceTopNewsApi;
import com.example.togonewsapllication.models.Article;
import com.example.togonewsapllication.models.Root;
import com.example.togonewsapllication.repository.RepositoryFranceNews;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FranceTopNewsFragmentViewModel extends ViewModel {
    private MutableLiveData<List<Article>> myTopNewsList = new MutableLiveData();
    public LiveData<List<Article>> topNewsDataList = myTopNewsList;

    public void callService(){

        FranceTopNewsApi.FranceTopNewsService service =FranceTopNewsApi.getInstance().getClient().create(FranceTopNewsApi.FranceTopNewsService.class);
        Call<Root> call = service.getRoot("fr","cf5883a8ef6c4b25b2dde26488d5f680");
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
            RepositoryFranceNews.getInstance().topNewsList = (ArrayList<Article>) response.body().getArticles();
            myTopNewsList.postValue(response.body().getArticles());
        }
    }

    public void addToFavorite(Article article, Context context){
        RepositoryFranceNews.getInstance().add(article,context);
        //RepositoryFranceNews.getInstance().addToTheFavoryList(article);
    }
}
