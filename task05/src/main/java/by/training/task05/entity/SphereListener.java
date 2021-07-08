package by.training.task05.entity;

import java.math.BigDecimal;

public interface SphereListener {
    public void update(double radius);

    public BigDecimal getSquare();

    public BigDecimal getVolume();
}
