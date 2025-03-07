package com.psksoft;

import java.util.Objects;

public class Coordinates {

    private Integer p;
    private Integer q;

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getQ() {
        return q;
    }

    public void setQ(Integer q) {
        this.q = q;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (!Objects.equals(p, that.p)) return false;
        return Objects.equals(q, that.q);
    }

    @Override
    public int hashCode() {
        int result = p != null ? p.hashCode() : 0;
        result = 31 * result + (q != null ? q.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "p=" + p +
                ", q=" + q +
                '}';
    }

    public Coordinates(Integer p, Integer q) {
        this.p = p;
        this.q = q;
    }
}
