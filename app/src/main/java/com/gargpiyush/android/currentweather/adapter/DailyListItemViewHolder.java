package com.gargpiyush.android.currentweather.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gargpiyush.android.currentweather.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 23:42.
 */

class DailyListItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.daily_weather_icon)
    ImageView icon;

    @BindView(R.id.daily_weather_day)
    TextView day;

    @BindView(R.id.daily_weather_date)
    TextView date;

    @BindView(R.id.daily_weather_temp)
    TextView temp;

    DailyListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
