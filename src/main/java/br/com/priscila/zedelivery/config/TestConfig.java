package br.com.priscila.zedelivery.config;

import br.com.priscila.zedelivery.model.Pdv;
import br.com.priscila.zedelivery.repository.PdvRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PdvRepository pdvRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void run(String... args) throws Exception {
//        Set<LngLatAlt> coordinates = new HashSet<>();
//
//        coordinates.add(new LngLatAlt(30, 20));
//        coordinates.add(new LngLatAlt(45, 40));
//        coordinates.add(new LngLatAlt(10, 40));
//        coordinates.add(new LngLatAlt(30, 20));
//        coordinates.add(new LngLatAlt(15, 5));
//        coordinates.add(new LngLatAlt(40, 10));
//        coordinates.add(new LngLatAlt(10, 20));
//        coordinates.add(new LngLatAlt(5, 10));
//        coordinates.add(new LngLatAlt(15, 5));
//
//
//        MultiPolygon geometry =  new MultiPolygon(new Polygon(new LngLatAlt(10, 20),
//                new LngLatAlt(30, 40), new LngLatAlt(10, 40),
//                new LngLatAlt(10, 20)));


        Point point = new Point(100, 0);

        Pdv pdv1 = new Pdv(null, "Adega da Cerveja - Pinheiros", "Zé da Silva", "1432132123891/0001");

        Pdv pdv2 = new Pdv(null, "Teste", "Teste", "98465484654/0002" );

        pdvRepository.saveAll(Arrays.asList(pdv1, pdv2));
    }
}
