package com.example.togonewsapllication.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.togonewsapllication.ApplicationDatabase;
import com.example.togonewsapllication.models.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class RepositoryFranceNews {
    public ArrayList<Article> globalNewsList = new ArrayList<>();
    public ArrayList<Article> topNewsList = new ArrayList<>();
    public ArrayList<Article> favoriteList = new ArrayList<>();

    private RepositoryFranceNews(){}
    public static RepositoryFranceNews INSTANCE = null;
    public static RepositoryFranceNews getInstance(){
        if(INSTANCE ==null){
            INSTANCE = new RepositoryFranceNews();
        }
        return INSTANCE;
    }

    public ArrayList<Article> getGlobalNewsList() {
        return globalNewsList;
    }

    public void setGlobalNewsList(ArrayList<Article> globalNewsList) {
        this.globalNewsList = globalNewsList;
    }

    public ArrayList<Article> getTopNewsList() {
        return topNewsList;
    }

    public void setTopNewsList(ArrayList<Article> topNewsList) {
        this.topNewsList = topNewsList;
    }

    public ArrayList<Article> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(ArrayList<Article> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public void deleteFavory(Article article){
        favoriteList.remove(article);
    }
    public  void addToTheFavoryList(Article article){
        favoriteList.add(article);
    }


    public void add(Article article, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDatabase.getInstance(context).getArticleDao().insertFavori(article);
            }
        });
    }

    public void delete(Article article, Context context){
       Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDatabase.getInstance(context).getArticleDao().deleteFavori(article);
            }
        });
    }

    public LiveData<List<Article>> getFavoriteArticles (Context context){
        return ApplicationDatabase.getInstance(context).getArticleDao().getFavArticle();

    }

}
