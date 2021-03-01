package main.java.dao;

import java.util.*;

public interface Dao<T> {
    public List<T> getAllEntities();
    public void addEntity(T Entity);
    public void deleteEntity(T Entity);
    public void updateEntity(T Entity);
}
