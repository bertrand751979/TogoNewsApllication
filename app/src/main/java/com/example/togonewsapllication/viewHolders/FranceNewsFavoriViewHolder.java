package com.example.togonewsapllication.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.togonewsapllication.OnDeleteButtonActionClicked;
import com.example.togonewsapllication.R;
import com.example.togonewsapllication.models.Article;

public class FranceNewsFavoriViewHolder extends RecyclerView.ViewHolder {
    private ImageView vhImageFavoriteNews;
    private TextView vhTitleFavoriteNews;
    private TextView  vhAuthorFavoriteNews;
    private TextView  vhUrlFavoriteNews;
    private TextView  vhDescriptionFavoriteNews;
    private ImageView vhDeleteFavoriteNews;

    public FranceNewsFavoriViewHolder(@NonNull View view) {
        super(view);
        vhImageFavoriteNews = view.findViewById(R.id.rawFranceNewsFavoriImage );
        vhTitleFavoriteNews = view.findViewById(R.id.rawFranceNewsFavoriTitle );
        vhAuthorFavoriteNews = view.findViewById(R.id.rawFranceNewsFavoriAuthor );
        vhUrlFavoriteNews = view.findViewById(R.id.rawFranceNewsFavoriUrl );
        vhDescriptionFavoriteNews = view.findViewById(R.id.rawFranceNewsFavoriDescription );
        vhDeleteFavoriteNews = view.findViewById(R.id.rawFranceNewsFavoriDelete );
    }

    public ImageView getVhImageFavoriteNews() {
        return vhImageFavoriteNews;
    }

    public void setVhImageFavoriteNews(ImageView vhImageFavoriteNews) {
        this.vhImageFavoriteNews = vhImageFavoriteNews;
    }

    public TextView getVhTitleFavoriteNews() {
        return vhTitleFavoriteNews;
    }

    public void setVhTitleFavoriteNews(TextView vhTitleFavoriteNews) {
        this.vhTitleFavoriteNews = vhTitleFavoriteNews;
    }

    public TextView getVhAuthorFavoriteNews() {
        return vhAuthorFavoriteNews;
    }

    public void setVhAuthorFavoriteNews(TextView vhAuthorFavoriteNews) {
        this.vhAuthorFavoriteNews = vhAuthorFavoriteNews;
    }

    public TextView getVhUrlFavoriteNews() {
        return vhUrlFavoriteNews;
    }

    public void setVhUrlFavoriteNews(TextView vhUrlFavoriteNews) {
        this.vhUrlFavoriteNews = vhUrlFavoriteNews;
    }

    public TextView getVhDescriptionFavoriteNews() {
        return vhDescriptionFavoriteNews;
    }

    public void setVhDescriptionFavoriteNews(TextView vhDescriptionFavoriteNews) {
        this.vhDescriptionFavoriteNews = vhDescriptionFavoriteNews;
    }

    public ImageView getVhDeleteFavoriteNews() {
        return vhDeleteFavoriteNews;
    }

    public void setVhDeleteFavoriteNews(ImageView vhDeleteFavoriteNews) {
        this.vhDeleteFavoriteNews = vhDeleteFavoriteNews;
    }

    public void bind(Article article, OnDeleteButtonActionClicked onDeleteButtonActionClicked){
        Glide.with(vhImageFavoriteNews.getContext())
                .load(article.getUrlToImage())
                .into(vhImageFavoriteNews);
        vhTitleFavoriteNews.setText(article.getTitle());
        vhAuthorFavoriteNews.setText(article.getAuthor());
        vhUrlFavoriteNews.setText(article.getUrl());
        vhDescriptionFavoriteNews.setText(article.getDescription());
        vhDeleteFavoriteNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDeleteButtonActionClicked.delete(article);
            }
        });




    }
}
