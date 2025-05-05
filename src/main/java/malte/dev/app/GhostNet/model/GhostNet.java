package malte.dev.app.GhostNet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ghostnet")
public class GhostNet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private double latitude;
    private double longitude;
    private String editor;
    private String editor_no;
    private int size;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEditor() {
        return editor;
    }
    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String getEditor_no() {
        return editor_no;
    }
    public void setEditor_no(String editor_no) {
        this.editor_no = editor_no;
    }
}