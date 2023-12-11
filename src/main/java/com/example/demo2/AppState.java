package com.example.demo2;

import java.util.ArrayList;
import java.util.List;

public class AppState {
    private List<ClientPosition> clientPositions = new ArrayList<>();

    public List<ClientPosition> getClientPositions() {
        return clientPositions;
    }

    public void setClientPositions(List<ClientPosition> positions) {
        clientPositions = positions;
    }
}
