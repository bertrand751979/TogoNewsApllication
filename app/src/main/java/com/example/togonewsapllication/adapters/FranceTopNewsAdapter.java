package com.example.togonewsapllication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togonewsapllication.OnFavoriteButtonClickedAction;
import com.example.togonewsapllication.OnLinearClickedGoToDescription;
import com.example.togonewsapllication.R;
import com.example.togonewsapllication.models.Article;
import com.example.togonewsapllication.viewHolders.FranceTopNewsViewHolder;

import java.util.ArrayList;

public class FranceTopNewsAdapter extends RecyclerView.Adapter<FranceTopNewsViewHolder> {
    private ArrayList<Article> listTopNewsAdapter = new ArrayList<>();
    private OnFavoriteButtonClickedAction onFavoriteButtonClickedAction;
    private OnLinearClickedGoToDescription onLinearClickedGoToDescription;

    public FranceTopNewsAdapter(OnFavoriteButtonClickedAction onFavoriteButtonClickedAction, OnLinearClickedGoToDescription onLinearClickedGoToDescription) {
        this.onFavoriteButtonClickedAction = onFavoriteButtonClickedAction;
        this.onLinearClickedGoToDescription = onLinearClickedGoToDescription;
    }

    public void setListTopNewsAdapter(ArrayList<Article> listTopNewsAdapter) {
        this.listTopNewsAdapter = listTopNewsAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FranceTopNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_top_news_france,parent,false);
        return new FranceTopNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FranceTopNewsViewHolder holder, int position) {
        holder.bind(listTopNewsAdapter.get(position), onFavoriteButtonClickedAction, onLinearClickedGoToDescription);
    }

    @Override
    public int getItemCount() {
        return listTopNewsAdapter.size();
    }
}
