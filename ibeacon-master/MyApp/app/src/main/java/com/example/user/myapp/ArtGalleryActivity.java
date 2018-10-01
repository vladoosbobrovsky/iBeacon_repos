package com.example.user.myapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ArtGalleryActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private RecyclerView recyclerView;
    private LinearLayoutManager verticalLinearLayoutManager;
    private LinearLayoutManager horizontalLinearLayoutManager;
    private RecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_gallery);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setOnClickListener(this);
        verticalLinearLayoutManager = new LinearLayoutManager(this);
        horizontalLinearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false );
        recyclerView.setLayoutManager(verticalLinearLayoutManager);
        adapter = new RecycleAdapter();
        recyclerView.setAdapter(adapter);
        adapter.addAll(ModelItem.getFakeItems());


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            recyclerView.setLayoutManager(horizontalLinearLayoutManager);
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(verticalLinearLayoutManager);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView:
                Intent intentimageuser = new Intent(ArtGalleryActivity.this, BLEA1.class);
                startActivity(intentimageuser);
                break;

        }

    }

    private class RecycleAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
        private ArrayList<ModelItem> items = new ArrayList<>();



        public void addAll(List<ModelItem> fakeItems) {

            int pos = getItemCount();
            this.items.addAll(fakeItems);
            notifyItemRangeInserted(pos,this.items.size());

        }


        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);


            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bind(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }


    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            image = (ImageView)itemView.findViewById(R.id.image);
        }

        public void bind(ModelItem modelItem) {
            image.setImageBitmap(BitmapFactory.decodeResource(itemView.getResources(),modelItem.getImgId()));
            title.setText(modelItem.getAuthor());
        }
    }
}

