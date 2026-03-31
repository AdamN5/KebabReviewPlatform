package ie.atu.kebabreviewplatform.controller;

import ie.atu.kebabreviewplatform.model.KebabReview;
import ie.atu.kebabreviewplatform.repository.ReviewRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewRepo repo;

    public ReviewController(ReviewRepo repo) {
        this.repo = repo;
    }

    @PostMapping
    public KebabReview create(@RequestBody KebabReview review) {
        return repo.save(review);
    }

    @GetMapping
    public List<KebabReview> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody KebabReview updated) {
        Optional<KebabReview> optional = repo.findById(id);

        if (optional.isPresent()) {
            KebabReview r = optional.get();
            r.setUsername(updated.getUsername());
            r.setRestaurant(updated.getRestaurant());
            r.setComment(updated.getComment());
            r.setRating(updated.getRating());
            repo.save(r);
            return "Updated";
        }

        return "Not found";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted";
        }
        return "Not found";
    }
}