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
import com.example.togonewsapllication.viewHolders.GlobalFranceNewsViewHolder;
import java.util.ArrayList;

public class GlobalFranceNewsAdapter extends RecyclerView.Adapter<GlobalFranceNewsViewHolder> {
    private ArrayList<Article> listGlobalNewsAdapter = new ArrayList<>();
    private OnFavoriteButtonClickedAction onFavoriteButtonClickedAction;
    private OnLinearClickedGoToDescription onLinearClickedGoToDescription;

    /*public GlobalFranceNewsAdapter(ArrayList<Article> listGlobalNewsAdapter, OnFavoriteButtonClickedAction onFavoriteButtonClickedAction) {
        this.listGlobalNewsAdapter = listGlobalNewsAdapter;
        this.onFavoriteButtonClickedAction = onFavoriteButtonClickedAction;
    }*/

    public GlobalFranceNewsAdapter(OnFavoriteButtonClickedAction onFavoriteButtonClickedAction, OnLinearClickedGoToDescription onLinearClickedGoToDescription) {
        this.onFavoriteButtonClickedAction = onFavoriteButtonClickedAction;
        this.onLinearClickedGoToDescription = onLinearClickedGoToDescription;
    }

    public void setListGlobalNewsAdapter(ArrayList<Article> listGlobalNewsAdapter) {
        this.listGlobalNewsAdapter = listGlobalNewsAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GlobalFranceNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_global_news_france, parent,false);
        return new GlobalFranceNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GlobalFranceNewsViewHolder holder, int position) {
        holder.bind(listGlobalNewsAdapter.get(position),onFavoriteButtonClickedAction, onLinearClickedGoToDescription);
    }

    @Override
    public int getItemCount() {
        return listGlobalNewsAdapter.size();
    }
}
