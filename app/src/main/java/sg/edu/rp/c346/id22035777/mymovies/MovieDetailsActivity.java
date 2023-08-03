package sg.edu.rp.c346.id22035777.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {

    TextView tvTitle, tvGenre, tvYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row);

        tvTitle = findViewById(R.id.tvTitle);
        tvGenre = findViewById(R.id.tvGenre);
        tvYear = findViewById(R.id.tvYear);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("movie")) {
            Movie movie = intent.getParcelableExtra("movie");

            if (movie != null) {
                tvTitle.setText(movie.getTitle());
                tvGenre.setText(movie.getGenre());
                tvYear.setText(String.valueOf(movie.getYear()));
            }
        }
    }
}
