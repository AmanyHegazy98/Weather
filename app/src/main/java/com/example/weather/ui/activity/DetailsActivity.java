package com.example.weather.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.data.models.ListModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailsActivity extends AppCompatActivity {
    TextView min,mix,time,humidity,pressure,wind,description;
    ImageView imageView;
    ListModel weather2,weather3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        min=findViewById(R.id.textView12);
        mix=findViewById(R.id.textView11);
        time=findViewById(R.id.textView10);
        imageView=findViewById(R.id.imageView4);
        humidity=findViewById(R.id.textView13);
        pressure=findViewById(R.id.textView14);
        wind=findViewById(R.id.textView15);
        description=findViewById(R.id.textView2);

        weather2=getIntent().getExtras().getParcelable("weather");
        min.setText((int)(weather2.getMain().getTempMin()-273.13)+"°C");
        mix.setText((int)(weather2.getMain().getTempMax()-273.13)+"°C");
        description.setText(weather2.getWeather().get(0).getMain());
        String strDate = weather2.getDtTxt();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date  dt=null;
        String data="";
        try {
            dt = dateFormat.parse(strDate);
            DateFormat df2 = new DateFormat();
            data=df2.format(" MMM d  hh:mm  a",dt).toString();


        } catch (ParseException e) {
            e.printStackTrace();
        }
       time.setText(data);



        if(weather2.getWeather().get(0).getMain().equals("Clear"))
        {
            imageView.setImageResource(R.drawable.ic_clear);
        }else if(weather2.getWeather().get(0).getMain().equals("Sunny"))
        {
            imageView.setImageResource(R.drawable.ic_sun);
        }
        else if(weather2.getWeather().get(0).getMain().equals("Clouds"))
        {
            imageView.setImageResource(R.drawable.ic_clouds);
        }
        else if(weather2.getWeather().get(0).getMain().equals("Rain"))
        {
            imageView.setImageResource(R.drawable.ic_raining);
        }
        humidity.setText("Humidity:"+weather2.getMain().getHumidity()+" %");
        pressure.setText("Pressure:"+weather2.getMain().getPressure()+" hpa");
        wind.setText("Wind:"+weather2.getWind().getSpeed()+" km/h SW");

    }
}