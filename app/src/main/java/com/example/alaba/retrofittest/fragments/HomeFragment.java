package com.example.alaba.retrofittest.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alaba.retrofittest.R;
import com.example.alaba.retrofittest.adapters.RoomsAdapter;
import com.example.alaba.retrofittest.api.RetrofitClient;
import com.example.alaba.retrofittest.models.Room;
import com.example.alaba.retrofittest.models.RoomsResponse;
import com.example.alaba.retrofittest.storage.SPManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private RoomsAdapter adapter;
    private List<Room> roomList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<RoomsResponse> call = RetrofitClient.getInstance().getApi().getRooms();
        call.enqueue(new Callback<RoomsResponse>() {
            @Override
            public void onResponse(Call<RoomsResponse> call, Response<RoomsResponse> response) {
                roomList = response.body().getRooms();

                adapter = new RoomsAdapter(getActivity(), roomList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RoomsResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}
