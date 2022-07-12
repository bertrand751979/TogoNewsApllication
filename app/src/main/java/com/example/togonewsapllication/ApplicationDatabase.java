package com.example.togonewsapllication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.togonewsapllication.converters.SourceConverter;
import com.example.togonewsapllication.models.Article;
import com.example.togonewsapllication.models.Root;


@Database(entities = {Article.class},version = 1)
@TypeConverters({SourceConverter.class})
public abstract class ApplicationDatabase extends RoomDatabase {
    private static ApplicationDatabase INSTANCE;
    public abstract ArticleDao getArticleDao();
    public static synchronized ApplicationDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ApplicationDatabase.class, "article_app").build();
        }
        return INSTANCE;
    }
}
