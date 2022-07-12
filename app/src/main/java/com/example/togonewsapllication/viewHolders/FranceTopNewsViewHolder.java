package com.example.togonewsapllication.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.togonewsapllication.OnFavoriteButtonClickedAction;
import com.example.togonewsapllication.OnLinearClickedGoToDescription;
import com.example.togonewsapllication.R;
import com.example.togonewsapllication.models.Article;

public class FranceTopNewsViewHolder extends RecyclerView.ViewHolder {
    private ImageView vhImageTopNews;
    private TextView  vhTitleTopNews;
    private TextView  vhAuthorTopNews;
    private TextView  vhUrlTopNews;
    private TextView  vhDescriptionTopNews;
    private ImageView vhFavoriteTopNews;
    private LinearLayout vhLinearTop;

    public FranceTopNewsViewHolder(@NonNull View view) {
        super(view);
        vhImageTopNews = view.findViewById(R.id.rawFranceTopNewsImage);
        vhTitleTopNews = view.findViewById(R.id.rawFranceTopNewsTitle);
        vhAuthorTopNews = view.findViewById(R.id.rawFranceTopNewsAuthor);
        vhUrlTopNews = view.findViewById(R.id.rawFranceTopNewsUrl);
        vhDescriptionTopNews = view.findViewById(R.id.rawFranceTopNewsDescription);
        vhFavoriteTopNews = view.findViewById(R.id.rawFranceTopNewsGoToFavori);
        vhLinearTop = view.findViewById(R.id.raw_linear_top);
    }

    public ImageView getVhImageTopNews() {
        return vhImageTopNews;
    }

    public void setVhImageTopNews(ImageView vhImageTopNews) {
        this.vhImageTopNews = vhImageTopNews;
    }

    public TextView getVhTitleTopNews() {
        return vhTitleTopNews;
    }

    public void setVhTitleTopNews(TextView vhTitleTopNews) {
        this.vhTitleTopNews = vhTitleTopNews;
    }

    public TextView getVhAuthorTopNews() {
        return vhAuthorTopNews;
    }

    public void setVhAuthorTopNews(TextView vhAuthorTopNews) {
        this.vhAuthorTopNews = vhAuthorTopNews;
    }

    public TextView getVhUrlTopNews() {
        return vhUrlTopNews;
    }

    public void setVhUrlTopNews(TextView vhUrlTopNews) {
        this.vhUrlTopNews = vhUrlTopNews;
    }

    public TextView getVhDescriptionTopNews() {
        return vhDescriptionTopNews;
    }

    public void setVhDescriptionTopNews(TextView vhDescriptionTopNews) {
        this.vhDescriptionTopNews = vhDescriptionTopNews;
    }

    public ImageView getVhFavoriteTopNews() {
        return vhFavoriteTopNews;
    }

    public void setVhFavoriteTopNews(ImageView vhFavoriteTopNews) {
        this.vhFavoriteTopNews = vhFavoriteTopNews;
    }

    public LinearLayout getVhLinearTop() {
        return vhLinearTop;
    }

    public void setVhLinearTop(LinearLayout vhLinearTop) {
        this.vhLinearTop = vhLinearTop;
    }

    public void bind(Article article, OnFavoriteButtonClickedAction onFavoriteButtonClickedAction, OnLinearClickedGoToDescription onLinearClickedGoToDescription){
        vhTitleTopNews.setText(article.getTitle());
        vhAuthorTopNews.setText(article.getAuthor());
        vhUrlTopNews.setText(article.getUrl());
        vhDescriptionTopNews.setText(article.getDescription());
        Glide.with(vhImageTopNews.getContext())
                .load(article.getUrlToImage())
                .into(vhImageTopNews);
        vhFavoriteTopNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFavoriteButtonClickedAction.goToFavorite(article);
            }
        });
        vhLinearTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLinearClickedGoToDescription.goToDescription(article);
            }
        });

    }
}
