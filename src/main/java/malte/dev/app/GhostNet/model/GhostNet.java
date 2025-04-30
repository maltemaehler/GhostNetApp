package malte.dev.app.GhostNet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ghostnet")
public class GhostNet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    public Long getId() {
        return id;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}