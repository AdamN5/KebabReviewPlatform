package ie.atu.kebabreviewplatform.repository;

import ie.atu.kebabreviewplatform.model.KebabReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<KebabReview, Long> {
}