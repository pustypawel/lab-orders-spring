package pl.edu.wszib.labordersspring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Objects;

@ConstructorBinding
@ConfigurationProperties("orders")
public class OrderConfig {
    private UI ui;

    public OrderConfig(UI ui) {
        this.ui = ui;
    }

    public UI getUi() {
        return ui;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderConfig that = (OrderConfig) o;
        return Objects.equals(ui, that.ui);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ui);
    }

    @Override
    public String toString() {
        return "OrderConfig{" +
                "ui=" + ui +
                '}';
    }

    public static class UI {
        private Boolean enabled;

        public UI(Boolean enabled) {
            this.enabled = enabled;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UI ui = (UI) o;
            return Objects.equals(enabled, ui.enabled);
        }

        @Override
        public String toString() {
            return "UI{" +
                    "enabled=" + enabled +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(enabled);
        }
    }
}
