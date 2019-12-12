package com.chutzpah.simplemovieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    private MovieAdapter adapter;
    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataRuntime;
    private String[] dataLanguage;
    private int[] dataUserScore;
    private TypedArray dataPhoto;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare(){
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataUserScore = getResources().getIntArray(R.array.data_user_score);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataLanguage = getResources().getStringArray(R.array.data_language);
    }

    private void addItem(){
        movies = new ArrayList<>();


        for (int i = 0; i > dataTitle.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i,-1));
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setUser_score(dataUserScore[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setLanguage(dataLanguage[i]);

            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
}
