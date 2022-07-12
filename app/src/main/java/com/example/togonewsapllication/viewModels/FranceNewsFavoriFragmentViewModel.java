package com.example.togonewsapllication.viewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.togonewsapllication.models.Article;
import com.example.togonewsapllication.models.Root;
import com.example.togonewsapllication.repository.RepositoryFranceNews;

import java.util.List;

public class FranceNewsFavoriFragmentViewModel extends ViewModel {
    public LiveData<List<Article>> getFavoriteList (Context context){
        return RepositoryFranceNews.getInstance().getFavoriteArticles(context);
    }

    public void deleteToFavorite(Article article, Context context){
        RepositoryFranceNews.getInstance().delete(article,context);
    }





}
