package com.demo.searchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>  {
    private List<ExampleItem> exampleList;
    Context context;
    RecyclerView recyclerView;
    private List<ExampleItem> exampleListFull;


    final View.OnClickListener onClickListener = new MyOnClickListner();


//     void playaudio(){
//
//        mediaPlayer = new MediaPlayer();
//
//        String audioUrl = "http://djbloom.info/Music/My%20Music/Billy%20Joel/billyjoel_pianoman.mp3";
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        try {
//            mediaPlayer.setDataSource(audioUrl);
//
//        } catch (IOException e) {
//            Toast.makeText(context,"Error found is " + e, Toast.LENGTH_SHORT).show();
//            e.printStackTrace();
//        }
//
//
//         mediaPlayer.start();
//    }




    public static class ExampleViewHolder extends ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;

       public ExampleViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.image_app);
            this.textView1 = (TextView) itemView.findViewById(R.id.textview);
            this.textView2 = (TextView) itemView.findViewById(R.id.textview2);
        }
    }

    ExampleAdapter(Context context,List<ExampleItem> exampleList2,RecyclerView recyclerView) {
        this.context = context;
        this.exampleList = exampleList2;
        this.exampleListFull = new ArrayList(exampleList2);
        this.recyclerView = recyclerView;
    }


    @NonNull
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new ExampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_apps, parent, false));
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_my_apps,parent,false);
        view.setOnClickListener(onClickListener);
        ExampleViewHolder viewHolder = new ExampleViewHolder(view);

        return viewHolder;

    }

    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = (ExampleItem) this.exampleList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
    }

    public int getItemCount() {
        return this.exampleList.size();
    }

    /* access modifiers changed from: 0000 */
    public void setFilter(List<ExampleItem> filterdNames) {
        this.exampleList = filterdNames;
        notifyDataSetChanged();
    }



    private class MyOnClickListner implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int itemPosition = recyclerView.getChildAdapterPosition(view);
            String item =  exampleList.get(itemPosition).getText1();

            if(itemPosition == 0){
                Toast.makeText(context, "This", Toast.LENGTH_SHORT).show();
            }

            if(itemPosition == 1){
                Toast.makeText(context, "WHOAAAAAAAa", Toast.LENGTH_SHORT).show();
            }

            if (itemPosition == 2){


            }

            if (itemPosition == 3){

            }


        }




    }



}

