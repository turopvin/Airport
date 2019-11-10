package org.academy.projects.service.planeManager;

import org.academy.projects.model.Plane;

public interface PlaneManagement {

    /**
     * Returns saved plane
     *
     * @param plane
     * @return
     */
    Plane create(Plane plane);

    /**
     * delete plane
     *
     * @param plane
     */
    void delete(Plane plane);

    /**
     * Returns plane by ID
     *
     * @param id
     * @return
     */
    Plane read(Integer id);

    /**
     * Returns updated plane
     *
     * @param plane
     * @return
     */
    Plane update(Plane plane);

}
