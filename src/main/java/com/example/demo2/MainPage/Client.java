package com.example.demo2.MainPage;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class Client extends ImageView {

    private int orderId;
    private Tooltip tooltip;
    public Client(int orderId) {
        super (new Image(Client.class.getResource("/MainPage/client.png").toExternalForm()));
        this.orderId = orderId;

        setFitHeight(60);
        setFitWidth(60);

    }

    public int getOrderId() {
        return orderId;
    }

    public void showDetailsPopup(String info) {
        tooltip = new Tooltip(info);
        Bounds bounds = localToScreen(getBoundsInLocal());

        tooltip.show(this, bounds.getMaxX(), bounds.getMinY());
    }

    public void hideTooltip(Tooltip t) {
        Platform.runLater(() -> {
            if (this.tooltip != null) {
                t.hide();
            }
        });
    }

    public Tooltip getTooltip() {
        return this.tooltip;
    }
}
