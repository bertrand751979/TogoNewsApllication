package com.example.togonewsapllication.activities;

import static com.example.togonewsapllication.activities.MainActivity.ARTICLE_EXTRA;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.togonewsapllication.R;
import com.example.togonewsapllication.models.Article;

public class ScrollingActivity extends AppCompatActivity {
    private TextView scrTitle;
    private TextView scrWriter;
    private TextView scrDescription;
    private ImageView scrPhoto;
    private TextView scrUrl;
    private TextView scrContent;
    private Article article;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        article = (Article) getIntent().getSerializableExtra(ARTICLE_EXTRA);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        setViewItem();
    }
    private void setViewItem(){
        scrTitle = findViewById(R.id.desc_title);
        scrWriter = findViewById(R.id.desc_writer);
        scrDescription =findViewById(R.id.desc_description);
        scrPhoto = findViewById(R.id.desc_photo);
        scrUrl = findViewById(R.id.desc_url) ;
        scrContent = findViewById(R.id.desc_content);

        scrTitle.setText(article.getTitle());
        scrWriter.setText(article.getAuthor());
        scrDescription.setText(article.getDescription());
        scrUrl.setText(article.getUrl());
        scrContent.setText(article.getContent());
        Glide.with(this)
                .load(article.getUrlToImage())
                .into(scrPhoto);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();}
        return super.onOptionsItemSelected(item);
    }

}
