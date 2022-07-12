package com.example.togonewsapllication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.togonewsapllication.OnDeleteButtonActionClicked;
import com.example.togonewsapllication.R;
import com.example.togonewsapllication.adapters.FranceNewsFavoriAdapter;
import com.example.togonewsapllication.models.Article;
import com.example.togonewsapllication.repository.RepositoryFranceNews;
import com.example.togonewsapllication.viewModels.FranceNewsFavoriFragmentViewModel;
import java.util.ArrayList;
import java.util.List;

public class FranceNewsFavoriFragment extends Fragment {
    private RecyclerView recyclerView;
    private FranceNewsFavoriAdapter franceNewsFavoriAdapter;
    private ArrayList<Article> myListFavorite = new ArrayList<>();
    private FranceNewsFavoriFragmentViewModel franceNewsFavoriFragmentViewModel;
    private RelativeLayout visibilityListEmpty;
    private RelativeLayout visibilityListFull;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            franceNewsFavoriFragmentViewModel = new ViewModelProvider(this).get(FranceNewsFavoriFragmentViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_france_news_favori,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_france_news_favori);
        visibilityListEmpty = view.findViewById(R.id.relative_empty);
        visibilityListFull = view.findViewById(R.id.relative_full);
        visibilityListEmpty.setVisibility(visibilityListEmpty.INVISIBLE);
        setViewItem();
    }

    public void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OnDeleteButtonActionClicked onDeleteButtonActionClicked = new OnDeleteButtonActionClicked() {
            @Override
            public void delete(Article article) {
            franceNewsFavoriFragmentViewModel.deleteToFavorite(article,getContext());
            Toast.makeText(FranceNewsFavoriFragment.this.getContext(), "Supprimé", Toast.LENGTH_SHORT).show();
            }
        };
        franceNewsFavoriAdapter = new FranceNewsFavoriAdapter(onDeleteButtonActionClicked);
        recyclerView.setAdapter(franceNewsFavoriAdapter);
        franceNewsFavoriFragmentViewModel.getFavoriteList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                franceNewsFavoriAdapter.setListFavoriteNewsAdapter(new ArrayList<>(articles));
                     //RepositoryFranceNews.getInstance().favoriteList=(ArrayList<Article>)articles;
                     if(articles.size()==0){
                         visibilityListFull.setVisibility(View.INVISIBLE);
                         visibilityListEmpty.setVisibility(View.VISIBLE);
                     }else {
                         visibilityListFull.setVisibility(View.VISIBLE);
                         visibilityListEmpty.setVisibility(View.INVISIBLE);
                     }
            }
        });
    }
}

