package org.academy.projects.service.planeManager;

import org.academy.projects.model.Plane;
import org.academy.projects.repository.plane.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PlaneManager implements PlaneManagement {

    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneManager(final PlaneRepository planeRepository){
        this.planeRepository = planeRepository;
    }

    @Override
    public Plane create(Plane plane) {
        if (plane == null){
            throw new IllegalArgumentException("plane can't be empty");
        }
        return planeRepository.save(plane);
    }

    @Override
    public void delete(Plane plane) {
        if (plane == null){
            throw new IllegalArgumentException("plane can't be empty");
        }
        planeRepository.delete(plane);

    }

    @Override
    public Plane read(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id can't be null");
        }
        return planeRepository.findOne(id);
    }

    @Override
    public Plane update(Plane plane) {
        if (plane == null){
            throw new IllegalArgumentException("plane can't be empty");
        }
        return planeRepository.saveAndFlush(plane);
    }

}
