package com.example.alaba.retrofittest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alaba.retrofittest.R;
import com.example.alaba.retrofittest.models.Room;
import com.example.alaba.retrofittest.storage.SPManager;

public class RoomDetailFragment extends Fragment {
    private Room CurRoom = null;
    private ImageView roomImg;
    private TextView RoomTitle;
    private View Container;
    private Button buttonBookNow;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.room_detail_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Container = view;

        if (CurRoom != null){
            roomImg = Container.findViewById(R.id.roomImg);
            roomImg.setImageDrawable(CurRoom.getBmphoto());

            RoomTitle = Container.findViewById(R.id.RoomTitle);
            RoomTitle.setText(CurRoom.getType());

            // disale book button if not logged in
            if (!SPManager.getInstance(Container.getContext()).isLogged()){
                buttonBookNow = Container.findViewById(R.id.buttonBookNow);
                buttonBookNow.setText("Log In first to Book");
                buttonBookNow.setEnabled(false);
            }

        }
    }

    public void setCurRoom(Room curRoom) {
        CurRoom = curRoom;
    }


}
