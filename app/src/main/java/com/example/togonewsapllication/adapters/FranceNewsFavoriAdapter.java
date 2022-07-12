package com.example.togonewsapllication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togonewsapllication.OnDeleteButtonActionClicked;
import com.example.togonewsapllication.R;
import com.example.togonewsapllication.models.Article;
import com.example.togonewsapllication.viewHolders.FranceNewsFavoriViewHolder;

import java.util.ArrayList;

public class FranceNewsFavoriAdapter extends RecyclerView.Adapter<FranceNewsFavoriViewHolder> {

    private ArrayList<Article> listFavoriteNewsAdapter = new ArrayList<>();
    private OnDeleteButtonActionClicked onDeleteButtonActionClicked;

    public FranceNewsFavoriAdapter(OnDeleteButtonActionClicked onDeleteButtonActionClicked) {
        this.onDeleteButtonActionClicked = onDeleteButtonActionClicked;
    }

    public void setListFavoriteNewsAdapter(ArrayList<Article> listFavoriteNewsAdapter) {
        this.listFavoriteNewsAdapter = listFavoriteNewsAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FranceNewsFavoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_france_news_favori,parent,false);
        return new FranceNewsFavoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FranceNewsFavoriViewHolder holder, int position) {
        holder.bind(listFavoriteNewsAdapter.get(position),onDeleteButtonActionClicked);
    }

    @Override
    public int getItemCount() {
        return listFavoriteNewsAdapter.size();
    }
}
