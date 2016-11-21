package ladsoft.com.sunshine.adapter;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ladsoft.com.sunshine.R;
import ladsoft.com.sunshine.databinding.ListItemForecastBinding;

public class ForecastAdapter<T extends Object> extends RecyclerView.Adapter<ForecastAdapter.ForecastViewholder> {

    private final Resources resources;
    private final LayoutInflater inflater;
    private List<T> dataSource;

    public ForecastAdapter(LayoutInflater inflater, Resources resources) {
        this.inflater = inflater;
        this.resources = resources;
        this.dataSource = new ArrayList<>();
    }


    @Override
    public ForecastAdapter.ForecastViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemForecastBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item_forecast, parent, false);
        return new ForecastViewholder(binding);
    }

    @Override
    public void onBindViewHolder(ForecastAdapter.ForecastViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public void setDataSource(List<T> dataSource) {
        this.dataSource = dataSource;
    }

    public class ForecastViewholder extends RecyclerView.ViewHolder {
        ListItemForecastBinding binding;

        public ForecastViewholder(ListItemForecastBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
