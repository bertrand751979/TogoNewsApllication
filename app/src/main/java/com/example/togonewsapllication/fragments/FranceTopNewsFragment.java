package com.example.togonewsapllication.fragments;

import static com.example.togonewsapllication.activities.MainActivity.ARTICLE_EXTRA;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.togonewsapllication.OnFavoriteButtonClickedAction;
import com.example.togonewsapllication.OnLinearClickedGoToDescription;
import com.example.togonewsapllication.R;
import com.example.togonewsapllication.activities.ScrollingActivity;
import com.example.togonewsapllication.adapters.FranceTopNewsAdapter;
import com.example.togonewsapllication.models.Article;
import com.example.togonewsapllication.repository.RepositoryFranceNews;
import com.example.togonewsapllication.viewModels.FranceTopNewsFragmentViewModel;
import java.util.ArrayList;
import java.util.List;

public class FranceTopNewsFragment extends Fragment {
    private RecyclerView recyclerView;
    private FranceTopNewsAdapter franceTopNewsAdapter;
    private FranceTopNewsFragmentViewModel franceTopNewsFragmentViewModel;
    private ArrayList<Article> topNewsList= new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        franceTopNewsFragmentViewModel = new ViewModelProvider(this).get(FranceTopNewsFragmentViewModel.class);
        topNewsList = RepositoryFranceNews.getInstance().topNewsList;
        franceTopNewsFragmentViewModel.callService();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_news_france, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_france_top_news);
        setViewItem();
    }

    public void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OnFavoriteButtonClickedAction onFavoriteButtonClickedAction = new OnFavoriteButtonClickedAction() {
            @Override
            public void goToFavorite(Article article) {
                franceTopNewsFragmentViewModel.addToFavorite(article, getContext());
                Toast.makeText(FranceTopNewsFragment.this.getContext(), "Ajouté", Toast.LENGTH_SHORT).show();
            }
        };
        OnLinearClickedGoToDescription onLinearClickedGoToDescription = new OnLinearClickedGoToDescription() {
            @Override
            public void goToDescription(Article article) {
                Intent intent = new Intent(FranceTopNewsFragment.this.getContext(), ScrollingActivity.class);
                intent.putExtra(ARTICLE_EXTRA, article);
                startActivity(intent);
            }
        };
        franceTopNewsAdapter = new FranceTopNewsAdapter(onFavoriteButtonClickedAction, onLinearClickedGoToDescription);
        recyclerView.setAdapter(franceTopNewsAdapter);
        franceTopNewsFragmentViewModel.topNewsDataList.observe(getViewLifecycleOwner(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                franceTopNewsAdapter.setListTopNewsAdapter(new ArrayList<>(articles));
                RepositoryFranceNews.getInstance().favoriteList = (ArrayList<Article>) articles;
                Toast.makeText(FranceTopNewsFragment.this.getContext(), "Taille"+topNewsList.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
