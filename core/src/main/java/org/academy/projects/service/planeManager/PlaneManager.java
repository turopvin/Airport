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

    private final static Logger log = LoggerFactory.getLogger(PlaneManager.class);

    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneManager(final PlaneRepository planeRepository){
        this.planeRepository = planeRepository;
    }

    /**
     * Returns saved plane
     * @param plane
     * @return
     */
    @Override
    public Plane create(Plane plane) {

        if (plane == null){

            log.error("Plane can't be null in"+PlaneManager.class.getName());

            throw new IllegalArgumentException();
        }

        return planeRepository.save(plane);
    }


    /**
     * delete plane
     * @param plane
     */
    @Override
    public void delete(Plane plane) {

        if (plane == null){

            log.error("Plane can't be null in"+PlaneManager.class.getName());

            throw new IllegalArgumentException();
        }

        planeRepository.delete(plane);

    }


    /**
     * Returns plane by ID
     * @param id
     * @return
     */
    @Override
    public Plane read(Integer id) {

        if (id == null) {

            log.error(" Id can't be null in"+PlaneManager.class.getName());

            throw new IllegalArgumentException();
        }

        return planeRepository.findOne(id);
    }


    /**
     * Returns updated plane
     * @param plane
     * @return
     */
    @Override
    public Plane update(Plane plane) {

        if (plane == null){

            log.error("Plane can't be null in"+PlaneManager.class.getName());

            throw new IllegalArgumentException();
        }

        return planeRepository.saveAndFlush(plane);
    }

}
