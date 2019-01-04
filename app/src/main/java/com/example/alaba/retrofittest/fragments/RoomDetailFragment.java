package com.example.alaba.retrofittest.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.alaba.retrofittest.R;
import com.example.alaba.retrofittest.models.Room;

public class RoomDetailFragment extends Fragment {
    private Room CurRoom = null;
    private ImageView roomImg;
    private View Container;
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

        }
    }

    public void setCurRoom(Room curRoom) {
        CurRoom = curRoom;
    }


}
