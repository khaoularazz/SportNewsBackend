package fstt.lsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fstt.lsi.entities.Sportnews;
import fstt.lsi.service.SportNewsService;


@RestController
@CrossOrigin
public class controller {

	@Autowired
	private SportNewsService sportnewsservice;

	@CrossOrigin
	@GetMapping(value="/sportnews")
	public List<Sportnews>  sportnews() {
	return sportnewsservice.getNews();
	}
	@CrossOrigin
	@GetMapping(value="/Allsportnews")
	public List<Sportnews> Allsportnews() {
	return sportnewsservice.getAllNews();
	}
}
