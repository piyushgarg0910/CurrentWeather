package com.gargpiyush.android.currentweather.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gargpiyush.android.currentweather.R;
import com.gargpiyush.android.currentweather.model.DailyWeatherData;
import com.gargpiyush.android.currentweather.util.ConvertUnixTimeToDateTime;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 23:42.
 */

public class DailyListAdapter extends RecyclerView
        .Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DailyWeatherData> dailyWeatherData = new ArrayList<>();
    private Context context;
    private String timeZone;

    public void setDailyWeatherData
            (ArrayList<DailyWeatherData> dailyWeatherData, String timeZone){
        this.dailyWeatherData = dailyWeatherData;
        this.timeZone = timeZone;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder
            (@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.daily_weather_item_layout,
                        viewGroup,false);
        context = viewGroup.getContext();
        return new DailyListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder
            (@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        String [] d = ConvertUnixTimeToDateTime
                .covert(dailyWeatherData.get(i).getTime(),timeZone);
        String day = d[0];
        String date = d[1];
        String temp = Math.round(dailyWeatherData.get(i).getTemperatureMax())
                + "° F \n"
                + Math.round(dailyWeatherData.get(i).getTemperatureMin())
                + "° F";
        String icon = dailyWeatherData.get(i).getIcon();
        ((DailyListItemViewHolder)viewHolder).date.setText(date);
        ((DailyListItemViewHolder)viewHolder).day.setText(day);
        ((DailyListItemViewHolder)viewHolder).temp.setText(temp);
        processImage(icon, viewHolder);
    }

    @Override
    public int getItemCount() {
        if(dailyWeatherData == null)
            return 0;
        else
            return (dailyWeatherData.size()>10)?10:dailyWeatherData.size();
    }

    private void processImage
            (String icon, @NonNull RecyclerView.ViewHolder view){
        ImageView imageView = ((DailyListItemViewHolder)view).icon;
        switch (icon) {
            case "clear-day":
                loadImage(R.drawable.clear_day,imageView);
                break;
            case "clear-night":
                loadImage(R.drawable.clear_night,imageView);
                break;
            case "rain":
                loadImage(R.drawable.rain,imageView);
                break;
            case "snow":
                loadImage(R.drawable.snow,imageView);
                break;
            case "sleet":
                loadImage(R.drawable.sleet,imageView);
                break;
            case "wind":
                loadImage(R.drawable.wind,imageView);
                break;
            case "fog":
                loadImage(R.drawable.fog,imageView);
                break;
            case "cloudy":
                loadImage(R.drawable.cloudy,imageView);
                break;
            case "partly-cloudy-day":
                loadImage(R.drawable.partly_cloudy_day,imageView);
                break;
            case "partly-cloudy-night":
                loadImage(R.drawable.partly_cloudy_night,imageView);
                break;
            case "hail":
                loadImage(R.drawable.hail,imageView);
                break;
            case "thunderstorm":
                loadImage(R.drawable.thunderstorm,imageView);
                break;
            case "tornado":
                loadImage(R.drawable.tornado,imageView);
                break;
        }
    }

    private void loadImage(int drawable, ImageView view){
        Picasso.with(context)
                .load(drawable)
                .error(R.drawable.weather_error)
                .placeholder(R.drawable.weather_error)
                .into(view);
    }
}
