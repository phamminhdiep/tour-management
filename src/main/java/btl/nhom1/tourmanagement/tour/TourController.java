package btl.nhom1.tourmanagement.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TourController {
	
	@Autowired
	private TourRepository tourRepository;
	
	@GetMapping("/tours")
	public List<Tour> findAll(){
		return tourRepository.findAll();
	}
	
	@GetMapping("/tour")
	public List<Tour> findTourByNameContaining(@Param("name") String name){
		return tourRepository.findByNameContaining(name);
	}
	
	@GetMapping("/tours/{id}")
	public Tour findTourById(@PathVariable Long id) {
		return tourRepository.findById(id).get();
	}
	
	@PostMapping("/tour")
	public void addTour(@RequestBody Tour tour) {
		tourRepository.save(tour);
	}
	
}
