package sg.edu.rp.c346.id22035777.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etTitle, etGenre, etYear;
    Spinner spinnerRating;
    Button btnInsert, btnShow;
    ListView lvMovies;
    ArrayList<Movie> alMovies;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spinnerRating = findViewById(R.id.spinnerRating);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);

        String[] ratingOptions = {"G", "PG", "PG13", "NC16", "M18", "R21"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ratingOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRating.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString().trim();
                String genre = etGenre.getText().toString().trim();
                String yearString = etYear.getText().toString().trim();
                String rating = spinnerRating.getSelectedItem().toString().trim();

                if (!title.isEmpty() && !genre.isEmpty() && !yearString.isEmpty()) {
                    int year = Integer.parseInt(yearString);

                    DBHelper db = new DBHelper(MainActivity.this);
                    db.insertMovie(title, genre, year, rating);
                    etTitle.setText("");
                    etGenre.setText("");
                    etYear.setText("");
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
