package ru.mail.park.firstcontrol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import ru.mail.park.articlelistlib.Article;

public class ArticleFragment extends Fragment {
    public static final String KEY = "article";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_article, container, false);

        Article article = (Article) getArguments().getSerializable(KEY);
        assert article != null;

        TextView titleView = result.findViewById(R.id.article_title);
        titleView.setText(article.getTitle());

        TextView dateView = result.findViewById(R.id.article_date);
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z", Locale.ENGLISH);
        dateView.setText(dateFormat.format(article.getDate()));

        TextView contentView = result.findViewById(R.id.article_content);
        contentView.setText(article.getContent());

        return result;
    }
}
