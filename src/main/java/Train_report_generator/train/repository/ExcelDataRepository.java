package Train_report_generator.train.repository;

import Train_report_generator.train.entity.Excel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcelDataRepository extends JpaRepository<Excel, Long> {
}
