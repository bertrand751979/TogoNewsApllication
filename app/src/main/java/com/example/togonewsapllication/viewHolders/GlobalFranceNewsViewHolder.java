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

public class GlobalFranceNewsViewHolder extends RecyclerView.ViewHolder {
    private ImageView vhImageGlobalNews;
    private TextView vhTitleGlobalNews;
    private TextView  vhAuthorGlobalNews;
    private TextView  vhUrlGlobalNews;
    private TextView vhDescriptionGlobalNews;
    private ImageView vhFavoriteGlobalNews;
    private LinearLayout vhLinearLayoutGlobal;

    public GlobalFranceNewsViewHolder(@NonNull View view) {
        super(view);
        vhImageGlobalNews = view.findViewById(R.id.rawGlobalFranceNewsImage);
        vhTitleGlobalNews = view.findViewById(R.id.rawGlobalFranceNewsTitle);
        vhAuthorGlobalNews = view.findViewById(R.id.rawGlobalFranceNewsAuthor);
        vhUrlGlobalNews = view.findViewById(R.id.rawGlobalFranceNewsUrl);
        vhDescriptionGlobalNews = view.findViewById(R.id.rawGlobalFranceNewsDescription);
        vhFavoriteGlobalNews = view.findViewById(R.id.rawGlobalFranceNewsGoToFavorite);
        vhLinearLayoutGlobal = view.findViewById(R.id.raw_linear_global);
    }

    public ImageView getVhImageGlobalNews() {
        return vhImageGlobalNews;
    }

    public void setVhImageGlobalNews(ImageView vhImageGlobalNews) {
        this.vhImageGlobalNews = vhImageGlobalNews;
    }

    public TextView getVhTitleGlobalNews() {
        return vhTitleGlobalNews;
    }

    public void setVhTitleGlobalNews(TextView vhTitleGlobalNews) {
        this.vhTitleGlobalNews = vhTitleGlobalNews;
    }

    public TextView getVhAuthorGlobalNews() {
        return vhAuthorGlobalNews;
    }

    public void setVhAuthorGlobalNews(TextView vhAuthorGlobalNews) {
        this.vhAuthorGlobalNews = vhAuthorGlobalNews;
    }

    public TextView getVhUrlGlobalNews() {
        return vhUrlGlobalNews;
    }

    public void setVhUrlGlobalNews(TextView vhUrlGlobalNews) {
        this.vhUrlGlobalNews = vhUrlGlobalNews;
    }

    public TextView getVhDescriptionGlobalNews() {
        return vhDescriptionGlobalNews;
    }

    public void setVhDescriptionGlobalNews(TextView vhDescriptionGlobalNews) {
        this.vhDescriptionGlobalNews = vhDescriptionGlobalNews;
    }

    public ImageView getVhFavoriteGlobalNews() {
        return vhFavoriteGlobalNews;
    }

    public void setVhFavoriteGlobalNews(ImageView vhFavoriteGlobalNews) {
        this.vhFavoriteGlobalNews = vhFavoriteGlobalNews;
    }

    public LinearLayout getVhLinearLayoutGlobal() {
        return vhLinearLayoutGlobal;
    }

    public void setVhLinearLayoutGlobal(LinearLayout vhLinearLayoutGlobal) {
        this.vhLinearLayoutGlobal = vhLinearLayoutGlobal;
    }

    public void bind (Article article, OnFavoriteButtonClickedAction onFavoriteButtonClickedAction, OnLinearClickedGoToDescription onLinearClickedGoToDescription){
        vhTitleGlobalNews.setText(article.getTitle());
        vhAuthorGlobalNews.setText(article.getAuthor());
        vhUrlGlobalNews.setText(article.getUrl());
        vhDescriptionGlobalNews.setText(article.getDescription());
        Glide.with(vhImageGlobalNews.getContext())
                .load(article.getUrlToImage())
                .into(vhImageGlobalNews);
        vhFavoriteGlobalNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFavoriteButtonClickedAction.goToFavorite(article);
            }
        });
        vhLinearLayoutGlobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLinearClickedGoToDescription.goToDescription(article);
            }
        });
    }
}
