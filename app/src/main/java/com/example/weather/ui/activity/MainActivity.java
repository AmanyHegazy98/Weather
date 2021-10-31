package com.example.weather.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.data.models.ListModel;
import com.example.weather.data.models.WhetherModel;
import com.example.weather.ui.adapters.RecyclerViewAdapter;
import com.example.weather.ui.viewModel.WhetherViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView min,mix,description,time;
    ImageView imageView;
    List<ListModel> modelList;
    WhetherViewModel whetherViewModel;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    MutableLiveData<List<ListModel>> mutableLiveData;
    ConstraintLayout constraintLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        min=findViewById(R.id.min);
        mix=findViewById(R.id.mix);
        description=findViewById(R.id.description);
        time=findViewById(R.id.time);
        imageView=findViewById(R.id.icon);
        recyclerView=findViewById(R.id.recycler);
        constraintLayout=findViewById(R.id.constraintLayout);

        whetherViewModel= ViewModelProviders.of(MainActivity.this).get(WhetherViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        whetherViewModel.getWhether();
        adapter=new RecyclerViewAdapter(MainActivity.this,modelList);
        recyclerView.setAdapter(adapter);


        whetherViewModel.getWhether().observe(MainActivity.this, new Observer<WhetherModel>() {
            @Override
            public void onChanged(WhetherModel whetherModel) {
                List<ListModel> arrayList=whetherModel.getList();

                getData( whetherModel.getList().get(0));
                arrayList.remove(0);
                adapter.setWeather(arrayList);


            }
        });











    }


    private void getData(ListModel listModel){

        constraintLayout.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
            intent.putExtra("weather",listModel);
            startActivity(intent);

        });

        min.setText(((int)( listModel.getMain().getTempMin()-273.13))+"°C");
        mix.setText(((int)( listModel.getMain().getTempMax()-273.13))+"°C");
        description.setText(listModel.getWeather().get(0).getMain());
        String strDate =listModel.getDtTxt();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dt=null;
        String data="";
        try {
            dt = dateFormat.parse(strDate);
            DateFormat df2 = new DateFormat();
            data=df2.format(" MMM d  hh:mm  a",dt).toString();


        } catch (ParseException e) {
            e.printStackTrace();
        }
      time.setText(data);
        if(listModel.getWeather().get(0).getMain().equals("Clear")){
            imageView.setImageResource(R.drawable.ic_clear);
        }else if (listModel.getWeather().get(0).getMain().equals("Sunny")){
            imageView.setImageResource(R.drawable.ic_sun);
        }else if(listModel.getWeather().get(0).getMain().equals("Clouds")){
            imageView.setImageResource(R.drawable.ic_clouds);
        }else if (listModel.getWeather().get(0).getMain().equals("Rain")){
            imageView.setImageResource(R.drawable.ic_raining);
        }

    }




}