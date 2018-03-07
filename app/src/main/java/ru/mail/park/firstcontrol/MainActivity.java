package ru.mail.park.firstcontrol;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenOrientation = getResources().getConfiguration().orientation;

        switch (screenOrientation) {
            case ORIENTATION_PORTRAIT:
                showOnPortrait();
                break;
            case ORIENTATION_LANDSCAPE:
                showOnLandscape();
        }
    }


    private void showOnPortrait() {
        final ArticleListFragment articleListFragment = new ArticleListFragment();
        articleListFragment.setOnArticleClickListener(new OnArticleClickListener() {
            @Override
            public void onArticleClick(Article article) {
                Bundle articleBundle = new Bundle();
                articleBundle.putSerializable("article", article);

                ArticleFragment articleFragment = new ArticleFragment();
                articleFragment.setArguments(articleBundle);

                FragmentTransaction transaction = getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.article_list_container, articleFragment);

                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.article_list_container, articleListFragment);
        transaction.commit();
    }

    private void showOnLandscape() {
        final ArticleListFragment articleListFragment = new ArticleListFragment();
        articleListFragment.setOnArticleClickListener(new OnArticleClickListener() {
            @Override
            public void onArticleClick(Article article) {
                Bundle articleBundle = new Bundle();
                articleBundle.putSerializable("article", article);

                ArticleFragment articleFragment = new ArticleFragment();
                articleFragment.setArguments(articleBundle);

                FragmentTransaction transaction = getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.article_container, articleFragment);
                transaction.commit();
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.article_list_container, articleListFragment);
        transaction.commit();
    }
}
