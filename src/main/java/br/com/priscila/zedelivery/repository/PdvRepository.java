package br.com.priscila.zedelivery.repository;

import br.com.priscila.zedelivery.model.Pdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdvRepository extends JpaRepository<Pdv, Long> {

}
