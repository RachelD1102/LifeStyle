package com.example.lifestyle;

import android.app.Activity;
import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lifestyle.data.WeatherData;
import com.example.lifestyle.WeatherRepository;

public class WeatherViewModel extends AndroidViewModel {
    private MutableLiveData<WeatherData> jsonData;
    private WeatherRepository mWeatherRepository;

    public WeatherViewModel(Application application){
        super(application);
        mWeatherRepository = new WeatherRepository(application);
        jsonData = mWeatherRepository.getData();
    }

    public void setLocation(double latitude, double longitude){
        mWeatherRepository.setLocation(latitude, longitude);
    }

    public LiveData<WeatherData> getData(){
        return jsonData;
    }

}
