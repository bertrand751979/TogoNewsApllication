package com.example.togonewsapllication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.togonewsapllication.models.Article;

import java.util.List;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM Article ")
    LiveData<List<Article>> getFavArticle();

    @Insert
    void insertFavori(Article article);

    @Delete
    void deleteFavori(Article article );

}
