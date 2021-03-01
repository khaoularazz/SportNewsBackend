package fstt.lsi.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import fstt.lsi.dao.SportNewsDAO;
import fstt.lsi.entities.Sportnews;
@Service
@EnableScheduling
public class SportNewsService {
	
	@Autowired
	SportNewsDAO sportnewsdao;
	@Scheduled(fixedRate = 180000)
	public void datascrapping() throws ParseException {
		
	 try {
	           Elements footrepositories = Jsoup.connect("http://www.msport.ma/Rubrique/football/").get().select("div[class=td_module_11 td_module_wrap td-animation-stack]");
	       Elements tennisrepositories = Jsoup.connect("http://www.msport.ma/Rubrique/tennis/").get().select("div[class=td_module_11 td_module_wrap td-animation-stack]");
	       Elements golfrepositories = Jsoup.connect("http://www.msport.ma/Rubrique/golf/").get().select("div[class=td_module_11 td_module_wrap td-animation-stack]");
	       Elements cyclrepositories = Jsoup.connect("http://www.msport.ma/Rubrique/cyclisme/").get().select("div[class=td_module_11 td_module_wrap td-animation-stack]");
			      
	       
	       for (Element repository : footrepositories) {
	    	   String repositorylink = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").attr("href");
	    	   String repositoryTitle = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").text();
	    	   String repositoryimage = repository.select("div[class=td-module-thumb]").first().select("a").select("img").attr("src");
	    	   String repositorycat = repository.select("div[class=item-details]").select("a[class=td-post-category]").text();
	    	   String repositorydate = repository.select("div[class=item-details]").select("div[class=td-module-meta-info]").first().select("span[class=td-post-date]").select("time").attr("datetime");
	    	   SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS");
	    	    Date parsedDate = inputFormat.parse(repositorydate); 
	    	     if(sportnewsdao.findbyurl(repositorylink)==null)
	           CreateNews(repositoryTitle, repositoryimage, repositorylink, repositorycat, parsedDate);
	         }
	       
	       
	       for (Element repository : tennisrepositories) {
	    	   String repositorylink = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").attr("href");
	    	   String repositoryTitle = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").text();
	    	   String repositoryimage = repository.select("div[class=td-module-thumb]").first().select("a").select("img").attr("src");
	    	   String repositorycat = repository.select("div[class=item-details]").select("a[class=td-post-category]").text();
	    	   String repositorydate = repository.select("div[class=item-details]").select("div[class=td-module-meta-info]").first().select("span[class=td-post-date]").select("time").attr("datetime");
	    	   	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS");
	    	    Date parsedDate = inputFormat.parse(repositorydate); 
	 	           if(sportnewsdao.findbyurl(repositorylink)==null)
	 	           CreateNews(repositoryTitle, repositoryimage, repositorylink, repositorycat, parsedDate);
	           }
	       
	       
	       for (Element repository : golfrepositories) {
	    	   String repositorylink = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").attr("href");
	    	   String repositoryTitle = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").text();
	    	   String repositoryimage = repository.select("div[class=td-module-thumb]").first().select("a").select("img").attr("src");
	    	   String repositorycat = repository.select("div[class=item-details]").select("a[class=td-post-category]").text();
	    	   String repositorydate = repository.select("div[class=item-details]").select("div[class=td-module-meta-info]").first().select("span[class=td-post-date]").select("time").attr("datetime");
	    	   	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS");
	    	    Date parsedDate = inputFormat.parse(repositorydate); 
	 	           if(sportnewsdao.findbyurl(repositorylink)==null)
	 	           CreateNews(repositoryTitle, repositoryimage, repositorylink, repositorycat, parsedDate);
	           }
	       
	       for (Element repository : cyclrepositories) {
	    	   String repositorylink = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").attr("href");
	    	   String repositoryTitle = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").text();
	    	   String repositoryimage = repository.select("div[class=td-module-thumb]").first().select("a").select("img").attr("src");
	    	   String repositorycat = repository.select("div[class=item-details]").select("a[class=td-post-category]").text();
	    	   String repositorydate = repository.select("div[class=item-details]").select("div[class=td-module-meta-info]").first().select("span[class=td-post-date]").select("time").attr("datetime");
	    	   SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS");
	    	    Date parsedDate = inputFormat.parse(repositorydate); 
	    	     if(sportnewsdao.findbyurl(repositorylink)==null)
	           CreateNews(repositoryTitle, repositoryimage, repositorylink, repositorycat, parsedDate);
	         }
	       
	     } catch (IOException e) {
	       e.printStackTrace();
	     }
	 
	}
	public void CreateNews(String title, String image, String url, String cat, Date date) {
		Sportnews n= new Sportnews(0, title, image, url, cat, date);
	
		sportnewsdao.save(n);
	}
	public List<Sportnews> getNews() {
		List<Sportnews> sportnews=(List<Sportnews>) sportnewsdao.findsportnews();
		return sportnews;	
	}
	
	public List<Sportnews> getAllNews() {
		List<Sportnews> sportnews=(List<Sportnews>) sportnewsdao.findallsportnews();
		return sportnews;	
	}
	

}
