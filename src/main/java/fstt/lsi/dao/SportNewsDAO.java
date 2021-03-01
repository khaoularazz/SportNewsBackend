package fstt.lsi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fstt.lsi.entities.Sportnews;

public interface SportNewsDAO extends CrudRepository<Sportnews, Integer>{
	@Query(value="select * From sportnews ORDER BY date DESC LIMIT 5", nativeQuery = true)
	List<Sportnews> findsportnews();
	@Query(value="select * From sportnews where url= ?1", nativeQuery = true)
	Sportnews findbyurl(String url);
	@Query(value="select * From sportnews ORDER BY date DESC ", nativeQuery = true)
	List<Sportnews> findallsportnews();
}
