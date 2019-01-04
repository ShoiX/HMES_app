package com.example.alaba.retrofittest.models;

import java.util.List;

public class RoomsResponse {
    private boolean error;
    private List<Room> rooms;

    public RoomsResponse(boolean error, List<Room> rooms) {
        this.error = error;
        this.rooms = rooms;
    }

    public boolean isError() {
        return error;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
