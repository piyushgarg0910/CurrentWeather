package com.gargpiyush.android.currentweather.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gargpiyush.android.currentweather.R;
import com.gargpiyush.android.currentweather.adapter.DailyListAdapter;
import com.gargpiyush.android.currentweather.adapter.HourlyListAdapter;
import com.gargpiyush.android.currentweather.model.CurrentWeather;
import com.gargpiyush.android.currentweather.model.WeatherResponse;
import com.gargpiyush.android.currentweather.repo.WeatherRepo;
import com.gargpiyush.android.currentweather.util.ConvertUnixTimeToDateTime;
import com.gargpiyush.android.currentweather.viewModel.WeatherViewModel;
import com.gargpiyush.android.currentweather.viewModel.WeatherViewModelFactory;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Piyush Garg
 * on 8/3/2019
 * at 11:40.
 */

public class WeatherFragment extends Fragment {

    FusedLocationProviderClient fusedLocationProviderClient;
    double lat = 0;
    double lng = 0;
    private WeatherViewModel viewModel;
    private String timeZone;

    @BindView(R.id.current_icon)
    ImageView icon;

    @BindView(R.id.current_weather_date)
    TextView date;

    @BindView(R.id.current_weather_real_feel)
    TextView realFeel;

    @BindView(R.id.current_weather_temp)
    TextView temp;

    @BindView(R.id.RefreshButton)
    ImageView refresh;

    @BindView(R.id.WeatherFragmentLayout)
    RelativeLayout relativeLayout;

    @BindView(R.id.hourly_recycler_view)
    RecyclerView hourlyRecyclerView;

    @BindView(R.id.daily_recycler_view)
    RecyclerView dailyRecyclerView;

    RecyclerView.LayoutManager hourlyLayoutManager =
            new LinearLayoutManager(getContext(),
                    LinearLayoutManager.HORIZONTAL,false);
    HourlyListAdapter hourlyListAdapter = new HourlyListAdapter();

    RecyclerView.LayoutManager dailyLayoutManager =
            new LinearLayoutManager(getContext(),
                    LinearLayoutManager.VERTICAL,false);
    DailyListAdapter dailyListAdapter = new DailyListAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_fragment,container,
                false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fusedLocationProviderClient = LocationServices.
                getFusedLocationProviderClient(getContext());
        WeatherViewModelFactory factory =
                new WeatherViewModelFactory(new WeatherRepo());
        viewModel = ViewModelProviders.of(this,factory)
                .get(WeatherViewModel.class);
        hourlyRecyclerView.setLayoutManager(hourlyLayoutManager);
        hourlyRecyclerView.setAdapter(hourlyListAdapter);
        dailyRecyclerView.setLayoutManager(dailyLayoutManager);
        dailyRecyclerView.setAdapter(dailyListAdapter);
        try {
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(getActivity(),
                            new OnSuccessListener<Location>() {
                                @Override
                                public void onSuccess(Location location) {
                                    if (location != null) {
                                        lat = location.getLatitude();
                                        lng = location.getLongitude();
                                    }
                                    loadFromDatabase();
                                }
                            });
        } catch (SecurityException e){
            Log.e("Operation failed","Read last known location");
        }
    }

    private void loadFromDatabase(){
        viewModel.getWeatherDataFromDatabase().observe(this,
                new Observer<WeatherResponse>() {
            @Override
            public void onChanged(@Nullable WeatherResponse weatherResponse) {
                Log.e("Repository Call","1");
                if (weatherResponse != null) {
                    Log.e("WeatherResponse", weatherResponse
                            .getCurrentWeather()
                            .getTime()
                            .toString());
                    timeZone = weatherResponse.getTimeZone();
                    loadCurrentWeather(weatherResponse.getCurrentWeather());
                    hourlyListAdapter
                            .setHourlyWeather(weatherResponse
                                    .getHourlyWeather().getData(), timeZone);
                    hourlyListAdapter.notifyDataSetChanged();
                    dailyListAdapter
                            .setDailyWeatherData(weatherResponse
                                    .getDailyWeather().getData(), timeZone);
                    dailyListAdapter.notifyDataSetChanged();
                }
                else {
                    makeCall();
                    loadFromDatabase();
                }
            }
        });
    }

    @OnClick(R.id.RefreshButton)
    void makeCall(){
        viewModel.getWeatherData(getResources().getString(R.string.api_key),
                lat,lng).observe(this, new Observer<WeatherResponse>() {
            @Override
            public void onChanged(@Nullable WeatherResponse weatherResponse) {
                Log.e("Network Call","2");
                if (weatherResponse != null)
                    Log.e("WeatherResponse",weatherResponse
                            .getCurrentWeather()
                            .getTime()
                            .toString());
            }
        });
    }

    private void loadCurrentWeather(CurrentWeather currentWeather){
        String temperature = Math.round(currentWeather.getTemperature())
                + "° F";
        temp.setText(temperature);
        String real = "Real Feel: "
                + Math.round(currentWeather.getApparentTemperature()) + "° F";
        realFeel.setText(real);
        String [] s = ConvertUnixTimeToDateTime.covert(currentWeather.getTime(),timeZone);
        String d = "at " + s[2] + " on " + s[0] + " " + s[1];
        date.setText(d);
        processIcon(currentWeather.getIcon());
    }

    private void processIcon(String iconString){
        switch (iconString) {
            case "clear-day":
                loadIcon(R.drawable.clear_day);
                loadBackground(R.drawable.clear_day_image);
                break;
            case "clear-night":
                loadIcon(R.drawable.clear_night);
                loadBackground(R.drawable.clear_night_image);
                break;
            case "rain":
                loadIcon(R.drawable.rain);
                loadBackground(R.drawable.rain_image);
                break;
            case "snow":
                loadIcon(R.drawable.snow);
                loadBackground(R.drawable.snow_image);
                break;
            case "sleet":
                loadIcon(R.drawable.sleet);
                loadBackground(R.drawable.sleet_image1);
                break;
            case "wind":
                loadIcon(R.drawable.wind);
                loadBackground(R.drawable.wind_image1);
                break;
            case "fog":
                loadIcon(R.drawable.fog);
                loadBackground(R.drawable.fog_image);
                break;
            case "cloudy":
                loadIcon(R.drawable.cloudy);
                loadBackground(R.drawable.cloudy_image);
                break;
            case "partly-cloudy-day":
                loadIcon(R.drawable.partly_cloudy_day);
                loadBackground(R.drawable.cloudy_day_image1);
                break;
            case "partly-cloudy-night":
                loadIcon(R.drawable.partly_cloudy_night);
                loadBackground(R.drawable.cloudy_night_image1);
                break;
            case "hail":
                loadIcon(R.drawable.hail);
                loadBackground(R.drawable.hail_image1);
                break;
            case "thunderstorm":
                loadIcon(R.drawable.thunderstorm);
                loadBackground(R.drawable.thunderstorm_image);
                break;
            case "tornado":
                loadIcon(R.drawable.tornado);
                loadBackground(R.drawable.tornado_image);
                break;
        }
    }

    private void loadIcon(int iconString){
        Picasso.with(getContext())
            .load(iconString)
            .error(R.drawable.weather_error)
            .placeholder(R.drawable.weather_error)
            .into(icon);
    }

    private void loadBackground(int background){
        Picasso.with(getContext())
                .load(background)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap,
                                               Picasso.LoadedFrom from) {
                        relativeLayout
                                .setBackground(new BitmapDrawable
                                        (getContext().getResources(),bitmap));
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
    }
}
