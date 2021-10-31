package com.example.weather.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;
import com.example.weather.data.models.ListModel;
import com.example.weather.data.models.Weather;
import com.example.weather.ui.activity.DetailsActivity;
import com.example.weather.ui.activity.MainActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    List<ListModel> listModels;
    Intent intent;


    public RecyclerViewAdapter(Context context, List<ListModel> listModels) {
        this.context = context;
        this.listModels = listModels;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        ListModel weather2=listModels.get(position);


            holder.min.setText(((int) (listModels.get(position).getMain().getTempMin()-273.13))+"°C");
            holder.mix.setText(((int) (listModels.get(position).getMain().getTempMax()-273.13))+"°C");
            holder.description.setText(listModels.get(position).getWeather().get(0).getMain());
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
            holder.data.setText(data);

            if(listModels.get(position).getWeather().get(0).getMain().equals("Clear")){
                holder.icon.setImageResource(R.drawable.ic_clear);
            }else if (listModels.get(position).getWeather().get(0).getMain().equals("Sunny")){
                holder.icon.setImageResource(R.drawable.ic_sun);
            }else if(listModels.get(position).getWeather().get(0).getMain().equals("Clouds")){
                holder.icon.setImageResource(R.drawable.ic_clouds);
            }else if (listModels.get(position).getWeather().get(0).getMain().equals("Rain")){
                holder.icon.setImageResource(R.drawable.ic_raining);
            }


        holder.itemView.setOnClickListener(v -> {
            intent=new Intent(context,DetailsActivity.class);
            intent.putExtra("weather",weather2);
            context.startActivity(intent);

        });








    }

    @Override
    public int getItemCount() {
       if(listModels==null){
           return 0;
       }else {
           return listModels.size();
       }
    }
    public void setWeather(List<ListModel>listModelList){
        listModels=listModelList;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView min,mix,description,data;
        ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            min=itemView.findViewById(R.id.min);
            mix=itemView.findViewById(R.id.mix);
            description=itemView.findViewById(R.id.description);
            data=itemView.findViewById(R.id.data);
            icon=itemView.findViewById(R.id.imageView);

        }
    }
}
