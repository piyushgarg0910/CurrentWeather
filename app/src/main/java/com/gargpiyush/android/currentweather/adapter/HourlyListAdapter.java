package com.gargpiyush.android.currentweather.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gargpiyush.android.currentweather.R;
import com.gargpiyush.android.currentweather.model.HourlyWeatherData;
import com.gargpiyush.android.currentweather.util.ConvertUnixTimeToDateTime;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 23:40.
 */

public class HourlyListAdapter extends RecyclerView
        .Adapter<RecyclerView.ViewHolder> {

    private ArrayList<HourlyWeatherData> hourlyWeatherData = new ArrayList<>();
    private Context context;
    private String timeZone;

    public void setHourlyWeather
            (ArrayList<HourlyWeatherData> hourlyWeatherData,
                                 String timeZone){
        this.hourlyWeatherData = hourlyWeatherData;
        this.timeZone = timeZone;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder
            (@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.hourly_weather_item_layout,viewGroup,
                        false);
        context = viewGroup.getContext();
        return new HourlyListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder
            (@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        String [] d = ConvertUnixTimeToDateTime
                .covert(hourlyWeatherData.get(i).getTime(),timeZone);
        String day = d[2];
        String date = d[1] + " " + d[0];
        String temp = Math.round(hourlyWeatherData.get(i).getTemperature())
                + "° F";
        String icon = hourlyWeatherData.get(i).getIcon();
        ((HourlyListItemViewHolder)viewHolder).date.setText(date);
        ((HourlyListItemViewHolder)viewHolder).day.setText(day);
        ((HourlyListItemViewHolder)viewHolder).temp.setText(temp);
        processImage(icon, viewHolder);
    }

    @Override
    public int getItemCount() {
        if(hourlyWeatherData == null)
            return 10;
        else
            return (hourlyWeatherData.size()>12)?12:hourlyWeatherData.size();
    }

    private void processImage
            (String icon, @NonNull RecyclerView.ViewHolder view){
        ImageView imageView = ((HourlyListItemViewHolder)view).icon;
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