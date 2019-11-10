package org.academy.projects.flightManager;

import org.academy.projects.repository.flight.FlightRepository;
import org.academy.projects.service.flightManager.FlightManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.security.auth.login.Configuration;

/*@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightManagerTest {


    @TestConfiguration
    static class FlightManagerTestContextConfiguration {

        @Bean
        public FlightManager flightManager(FlightRepository flightRepository) {
            return new FlightManager(flightRepository);
        }
    }

    @Autowired
    private FlightManager flightManager;

    @MockBean
    private  FlightRepository flightRepository;
}
*/