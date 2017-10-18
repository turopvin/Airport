package org.academy.projects.models;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city_from")
    private String cityFrom;

    @Column(name = "city_to")
    private String cityTo;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
    private Set<Ticket> ticketSet;


    public Integer getId(){
        return id;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(final String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(final String cityTo) {
        this.cityTo = cityTo;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(final Plane plane) {
        this.plane = plane;
    }

    @Override
    public String toString() {
        return "Flight{"
                + "cityFrom='" + cityFrom + '\''
                + ", cityTo='" + cityTo + '\''
                + ", departureDate=" + departureDate
                + ", arrivalDate=" + arrivalDate
                + ", price=" + price
                + ", plane=" + plane +
                '}';
    }
}
