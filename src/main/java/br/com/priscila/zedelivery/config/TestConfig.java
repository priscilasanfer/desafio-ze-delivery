package br.com.priscila.zedelivery.config;

import br.com.priscila.zedelivery.domain.Address;
import br.com.priscila.zedelivery.domain.Pdv;
import br.com.priscila.zedelivery.domain.enums.Type;
import br.com.priscila.zedelivery.repository.PdvRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
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

        Point point = geometryFactory.createPoint(new Coordinate(1,1));

        Pdv pdv1 = Pdv.builder().id(null)
                .tradingName("Adega Osasco")
                .ownerName("Ze da Ambev")
                .document("02.453.716/000170")
//                .coverageArea(CoverageArea.builder()
//                        .id(1L)
//                        .type(Type.MULTIPOLYGON)
//                        .coordinates(coordinates)
//                        .build())
                .address(Address.builder()
                        .id(1L)
                        .type(Type.POINT)
                        .coordinates( point )
                        .build())
                .build();


        Pdv pdv2 = Pdv.builder().id(null)
                .tradingName("Festa Junina")
                .ownerName("Facebook Joao")
                .document("02.453.716/000170")
                .build();

        pdvRepository.saveAll(Arrays.asList(pdv1, pdv2));

    }
}
