package cl.equipo11.lenderapp.repository;

import cl.equipo11.lenderapp.repository.domain.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, Long> {
}
