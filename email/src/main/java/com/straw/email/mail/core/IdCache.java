package com.straw.email.mail.core;

/**
 * @author fengzy
 * @date 2/12/2018
 */
public class IdCache {
    private static Integer idCursor = 1;
    private static Integer maxId = 1;

    public static Integer NextMaxId() {
        return maxId++;
    }

    public static void setMaxId(Integer maxId) {
        IdCache.maxId = maxId;
    }

    public static Integer getIdCursor() {
        return idCursor;
    }

    public void setIdCursor(Integer idCursor) {
        this.idCursor = idCursor;
    }

    public static Integer nextId() {
        if (idCursor >= maxId) {
            return idCursor;
        }
        idCursor++;
        return getIdCursor();
    }

    public static void reSetMaxId(Integer max) {
        maxId = max;
    }

}
