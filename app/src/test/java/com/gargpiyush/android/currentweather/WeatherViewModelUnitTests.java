package com.gargpiyush.android.currentweather;

import com.gargpiyush.android.currentweather.repo.WeatherRepo;
import com.gargpiyush.android.currentweather.viewModel.WeatherViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Piyush Garg
 * on 8/6/2019
 * at 21:43.
 */

public class WeatherViewModelUnitTests {

    @Mock
    private WeatherRepo weatherRepo;

    private WeatherViewModel weatherViewModel;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        weatherViewModel = Mockito.spy(new WeatherViewModel(weatherRepo));
    }

    @Test
    public void test_getWeatherData(){
        String key = "sdaihgdsaiuhygduisaygidasghiyuagydgauib";
        double lat = 40.546146;
        double lng = -72.651455;
        String blocks = "minutely,alerts,flags";
        weatherViewModel.getWeatherData(key,lat,lng);
        Mockito.verify(weatherRepo,Mockito.times(1))
                .getWeather(key,String.valueOf(lat),String.valueOf(lng),
                        blocks);
    }

    @Test
    public void test_getWeatherDataFromDatabase(){
        weatherViewModel.getWeatherDataFromDatabase();
        Mockito.verify(weatherRepo,Mockito.times(1))
                .getWeatherFromDatabase();
    }
}
