package com.vse_vrut.testprojectanoda;


import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView itemRecyclerView;
    private List<Item> mItems = new ArrayList<>();
    private JSONHalper mJSONHalper;
    private Item mItem;
    private ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemRecyclerView = (RecyclerView) findViewById(R.id.item_recycler_view);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        mJSONHalper = new JSONHalper();

        setAdapter();
    }

    private void setAdapter(){
        String json = getJSONItem();
        mItem = mJSONHalper.parseJSON(json);
        mItems.add(mItem);
        mItems.add(mItem);
        mItemAdapter = new ItemAdapter(mItems);
        itemRecyclerView.setAdapter(mItemAdapter);
    }

    public String getJSONItem(){
        String json;
        AssetManager manager = this.getAssets();
        try {
            InputStream is = manager.open("information.json");
            StringBuffer buffer = new StringBuffer();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }
            json = buffer.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Log.e("parseJSON", json);
        return json;
    }

    public void onClickButton(View v) {
        switch (v.getId()){
            case R.id.photo_camera_image_view:
                Toast.makeText(this,R.string.photo_camera_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_name_text_view:
                Toast.makeText(this,R.string.app_name,Toast.LENGTH_SHORT).show();
                break;
            case R.id.send_message_image_view:
                Toast.makeText(this,R.string.send_message_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_image_view:
                Toast.makeText(this,R.string.person_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.more_details_image_view:
                Toast.makeText(this,R.string.more_details_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.like_image_view:
                Toast.makeText(this,R.string.like_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.comments_image_view:
                Toast.makeText(this,R.string.comments_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.send_photo_image_view:
                Toast.makeText(this,R.string.send_photo_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.save_image_viev:
                Toast.makeText(this,R.string.save_image_viev_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_image_view:
                Toast.makeText(this,R.string.home_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_image_view:
                Toast.makeText(this,R.string.search_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_box_image_view:
                Toast.makeText(this,R.string.add_box_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.favorite_image_view:
                Toast.makeText(this,R.string.favorite_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_image_view:
                Toast.makeText(this,R.string.person_bottom_image_view_toast,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder{

        ImageView mUserImageView;
        TextView mUserNameTextView;
        TextView mUserLocationtextView;
        ImageView mMoreDetailsImageView;
        ImageView mItemImageView;
        ImageView mLikeImageView;
        ImageView mCommentsImageView;
        ImageView mSendPhotoImageView;
        ImageView mChoiceFirstImageView;
        ImageView mSaveImageView;
        TextView mLikesTextView;
        TextView mInformationTextView;
        TextView mTimeAfterPublicationTextView;

        Item mItem;

        public ItemHolder(View itemView) {
            super(itemView);

            mUserImageView = (ImageView)itemView.findViewById(R.id.user_image_view);
            mUserNameTextView = (TextView) itemView.findViewById(R.id.user_name_text_view);
            mUserLocationtextView = (TextView) itemView.findViewById(R.id.uset_location_text_viev);
            mMoreDetailsImageView = (ImageView)itemView.findViewById(R.id.more_details_image_view);
            mItemImageView = (ImageView)itemView.findViewById(R.id.item_image_view);
            mLikeImageView = (ImageView)itemView.findViewById(R.id.like_image_view);
            mCommentsImageView = (ImageView)itemView.findViewById(R.id.comments_image_view);
            mSendPhotoImageView = (ImageView)itemView.findViewById(R.id.send_photo_image_view);
            mChoiceFirstImageView = (ImageView)itemView.findViewById(R.id.choice_first_image_view);
            mSaveImageView = (ImageView)itemView.findViewById(R.id.save_image_viev);
            mLikesTextView = (TextView) itemView.findViewById(R.id.likes_text_viev);
            mInformationTextView = (TextView) itemView.findViewById(R.id.information_image_viev);
            mTimeAfterPublicationTextView = (TextView) itemView.findViewById(R.id.time_after_publication_text_view);

        }

        public void bindItem(Item item){
            mItem = item;

            mUserNameTextView.setText(mItem.getUserName());
            mUserLocationtextView.setText(mItem.getLocation());
            Picasso.get()
                    .load("file:///android_asset/"+mItem.getUrl())
//                    .placeholder(R.drawable.image)
                    .into(mItemImageView);
            mLikesTextView.setText(mItem.getLikes());
            mInformationTextView.setText(mItem.getInformation());
            mTimeAfterPublicationTextView.setText(mItem.getTimeAfterPublication());
        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder>{

        private List<Item> mItems;

        public ItemAdapter(List<Item> items){
            mItems = items;
        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            View view = layoutInflater.inflate(R.layout.item, parent,false);

            return new ItemHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
            Item item = mItems.get(position);

            holder.bindItem(item);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }
}
