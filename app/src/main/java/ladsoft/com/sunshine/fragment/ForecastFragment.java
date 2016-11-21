package ladsoft.com.sunshine.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ladsoft.com.sunshine.R;
import ladsoft.com.sunshine.adapter.ForecastAdapter;
import ladsoft.com.sunshine.databinding.FragmentMainBinding;

public class ForecastFragment extends Fragment implements Toolbar.OnMenuItemClickListener{

    private FragmentMainBinding binding;
    private ForecastAdapter<Object> adapter;

    public static ForecastFragment newInstance() {
        return new ForecastFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toolbar.inflateMenu(R.menu.menu_main);
        binding.toolbar.setOnMenuItemClickListener(this);

        adapter = new ForecastAdapter<>(getLayoutInflater(savedInstanceState));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.forecastList.setLayoutManager(layoutManager);
        binding.forecastList.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //TODO: load stub data
        adapter.setDataSource(new ArrayList<>());
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
