package org.academy.projects.service.planeManager;

import org.academy.projects.model.Plane;

public interface PlaneManagement {

    Plane create(Plane plane);
    void delete(Plane plane);
    Plane read(Integer id);
    Plane update(Plane plane);

}
