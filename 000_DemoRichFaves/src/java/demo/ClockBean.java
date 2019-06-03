package demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ClockBean {

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getNow() {
        LocalDateTime d = LocalDateTime.now();
        DateTimeFormatter dtf = 
                DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        return dtf.format(d);
    }

    public void stopClock() {
        enabled = false;
    }

    public void startClock() {
        enabled = true;
    }
}
