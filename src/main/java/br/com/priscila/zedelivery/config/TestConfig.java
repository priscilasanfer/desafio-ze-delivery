package br.com.priscila.zedelivery.config;

import br.com.priscila.zedelivery.domain.Pdv;
import br.com.priscila.zedelivery.repository.PdvRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.transaction.Transactional;
import java.util.Arrays;

@Transactional
@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    private PdvRepository pdvRepository;

    @Autowired
    public TestConfig(PdvRepository pdvRepository) {
        this.pdvRepository = pdvRepository;
    }

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void run(String... args) throws Exception {
        GeometryFactory geometryFactory = new GeometryFactory();

//        PDV 1
        Point address1 = geometryFactory.createPoint(new Coordinate(-43.297337, -23.013538));
        Coordinate[] coordinates1 = new Coordinate[]{
                new Coordinate(-46.61026, -23.66622),
                new Coordinate(-46.62596, -23.66985),
                new Coordinate(-46.63481, -23.6749),
                new Coordinate(-46.64012, -23.69742),
                new Coordinate(-46.63566, -23.71857),
                new Coordinate(-46.63154, -23.74041),
                new Coordinate(-46.63078, -23.75411),
                new Coordinate(-46.61701, -23.75216),
                new Coordinate(-46.59878, -23.74832),
                new Coordinate(-46.58076, -23.73916),
                new Coordinate(-46.56257, -23.73662),
                new Coordinate(-46.55038, -23.73378),
                new Coordinate(-46.54404, -23.73016),
                new Coordinate(-46.53368, -23.72612),
                new Coordinate(-46.52488, -23.71453),
                new Coordinate(-46.52502, -23.70481),
                new Coordinate(-46.52786, -23.69098),
                new Coordinate(-46.5573, -23.66818),
                new Coordinate(-46.57335, -23.66606),
                new Coordinate(-46.61026, -23.66622)
        };

        MultiPolygon coverageArea1 = geometryFactory.createMultiPolygon(new Polygon[]{geometryFactory.createPolygon(coordinates1)});

//        PDV2
        Point address2 = geometryFactory.createPoint(new Coordinate(-38.59826, -3.774186));
        Coordinate[] coordinates2 = new Coordinate[]{
                new Coordinate(-38.6577, -3.7753),
                new Coordinate(-38.63212, -3.81418),
                new Coordinate(-38.61925, -3.82873),
                new Coordinate(-38.59762, -3.84004),
                new Coordinate(-38.58727, -3.84345),
                new Coordinate(-38.58189, -3.8442),
                new Coordinate(-38.57667, -3.84573),
                new Coordinate(-38.56706, -3.85015),
                new Coordinate(-38.56637, -3.84937),
                new Coordinate(-38.56268, -3.84286),
                new Coordinate(-38.56148, -3.83772),
                new Coordinate(-38.55881, -3.82411),
                new Coordinate(-38.55577, -3.81507),
                new Coordinate(-38.55258, -3.80674),
                new Coordinate(-38.54968, -3.80222),
                new Coordinate(-38.53406, -3.79495),
                new Coordinate(-38.52894, -3.77718),
                new Coordinate(-38.52517, -3.76313),
                new Coordinate(-38.53118, -3.76203),
                new Coordinate(-38.53968, -3.76126),
                new Coordinate(-38.54577, -3.76151),
                new Coordinate(-38.55344, -3.76102),
                new Coordinate(-38.56327, -3.76029),
                new Coordinate(-38.58118, -3.75907),
                new Coordinate(-38.60079, -3.75423),
                new Coordinate(-38.60671, -3.74772),
                new Coordinate(-38.61787, -3.7431),
                new Coordinate(-38.62577, -3.7472),
                new Coordinate(-38.63332, -3.7496),
                new Coordinate(-38.65049, -3.76057),
                new Coordinate(-38.6577, -3.7753)
        };

        MultiPolygon coverageArea2 = geometryFactory.createMultiPolygon(new Polygon[]{geometryFactory.createPolygon(coordinates2)});


//      PDV 3
        Point address3 = geometryFactory.createPoint(new Coordinate(-43.432034, -22.747707));
        Coordinate[] coordinates3 = new Coordinate[]{
                new Coordinate(-43.50404, -22.768366),
                new Coordinate(-43.45254, -22.775646),
                new Coordinate(-43.429195, -22.804451),
                new Coordinate(-43.38422, -22.788942),
                new Coordinate(-43.390743, -22.764568),
                new Coordinate(-43.355724, -22.739239),
                new Coordinate(-43.403446, -22.705671),
                new Coordinate(-43.440525, -22.707571),
                new Coordinate(-43.4752, -22.698704),
                new Coordinate(-43.514683, -22.742722),
                new Coordinate(-43.50404, -22.768366)
        };

        MultiPolygon coverageArea3 = geometryFactory.createMultiPolygon(new Polygon[]{geometryFactory.createPolygon(coordinates3)});

        Pdv pdv1 = Pdv.builder().id(null)
                .tradingName("Adega da Cerveja - Pinheiros")
                .ownerName("Zé da Silva")
                .document("1432132123891/0001")
                .coverageArea(coverageArea1)
                .address(address1)
                .build();

        Pdv pdv2 = Pdv.builder().id(null)
                .tradingName("Adega Sao Paulo")
                .ownerName("Pedro Silva")
                .document("04666182390")
                .coverageArea(coverageArea2)
                .address(address2)
                .build();

        Pdv pdv3 = Pdv.builder().id(null)
                .tradingName("Bar Legal")
                .ownerName("Fernando Silva")
                .document("05202839000126")
                .coverageArea(coverageArea3)
                .address(address3)
                .build();

        pdvRepository.saveAll(Arrays.asList(pdv1, pdv2, pdv3));


    }
}
