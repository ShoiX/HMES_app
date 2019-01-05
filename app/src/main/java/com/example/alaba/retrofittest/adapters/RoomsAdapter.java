package com.example.alaba.retrofittest.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.alaba.retrofittest.R;
import com.example.alaba.retrofittest.activities.ProfileActivity;
import com.example.alaba.retrofittest.configs.Server;
import com.example.alaba.retrofittest.fragments.HomeFragment;
import com.example.alaba.retrofittest.models.Room;

import java.util.List;

/* ADAPTER CLASS FOR THE RECYCLERVIEW OF ROOMS */
public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.RoomsViewHolder> {

    private Context mCtx;
    private List<Room> roomList;

    public RoomsAdapter(Context mCtx, List<Room> roomList) {
        this.mCtx = mCtx;
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RoomsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_view_rooms, viewGroup,false);
        return new RoomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RoomsViewHolder roomsViewHolder, int i) {
        final Room room = roomList.get(i);

        roomsViewHolder.textViewRoomName.setText(room.getType());
        roomsViewHolder.textViewRoomDesc.setText(room.getDescription());

        // Set Click listener on each cardview
        roomsViewHolder.cardviewBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Open Room Description", room.getType());
                if (mCtx instanceof ProfileActivity){
                    ((ProfileActivity)mCtx).viewRoom(room);
                }
            }
        });

        // load image from the server and set to background
        Glide.with(mCtx)
                .load(Server.SYSTEM_ADDRESS + room.getPhoto())
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        BitmapDrawable bm = new BitmapDrawable(mCtx.getResources(), resource);
                        roomsViewHolder.cardviewBG.setBackground(bm);

                        room.setBmphoto(bm);
                    }
                });

    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    class RoomsViewHolder extends RecyclerView.ViewHolder{
        TextView textViewRoomDesc, textViewRoomName;
        private RelativeLayout cardviewBG;
        public RoomsViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewRoomName = itemView.findViewById(R.id.textViewRoomName);
            textViewRoomDesc = itemView.findViewById(R.id.textViewRoomDesc);
            cardviewBG = itemView.findViewById(R.id.cardviewBG);

        }
    }
}
