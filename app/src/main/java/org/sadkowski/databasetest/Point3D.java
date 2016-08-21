package org.sadkowski.databasetest;

/**
 * Created by sadko on 02.05.2016.
 */
public class Point3D {
    private int id;
    private int x;
    private int y;
    private int z;
    private int telefon;

    public Point3D(int x, int y, int z, int telefon) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.telefon = telefon;
    }
    public Point3D() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
