package ro.uaic.info.pa.model;

public class Chart {

    private int albumId;
    private int orderNumber;

    public Chart() {}

    public Chart(int albumId, int orderNumber) {
        this.albumId = albumId;
        this.orderNumber = orderNumber;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "albumId=" + albumId +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
