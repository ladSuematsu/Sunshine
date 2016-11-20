package ladsoft.com.sunshine.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ladsoft.com.sunshine.R;
import ladsoft.com.sunshine.databinding.ActivityMainBinding;
import ladsoft.com.sunshine.fragment.ForecastFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if(savedInstanceState == null) {
            inflateFragment();
        }
    }

    private void inflateFragment() {
        getSupportFragmentManager().beginTransaction()
            .replace(binding.content.getId(), ForecastFragment.newInstance())
            .commit();
    }
}
