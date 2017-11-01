package org.academy.projects.service.planeManager;

import org.academy.projects.model.Plane;
import org.academy.projects.repository.plane.PlaneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PlaneManager implements PlaneManagement {

    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneManager(final PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    @Override
    public Plane create(final Plane plane) {

        if (plane == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return planeRepository.save(plane);
    }

    @Override
    public void delete(final Plane plane) {

        if (plane == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        planeRepository.delete(plane);

    }

    @Override
    public Plane read(final Integer id) {

        if (id == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return planeRepository.findOne(id);
    }

    @Override
    public Plane update(final Plane plane) {

        if (plane == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return planeRepository.saveAndFlush(plane);
    }

}
