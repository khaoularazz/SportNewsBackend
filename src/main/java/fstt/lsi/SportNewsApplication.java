package fstt.lsi;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fstt.lsi.dao.SportNewsDAO;
import fstt.lsi.service.SportNewsService;


@SpringBootApplication
public class SportNewsApplication  implements CommandLineRunner {
	@Autowired
	SportNewsDAO sportnewsdao;
	@Autowired
	private SportNewsService sportnewsservice;
	public static void main(String[] args)  {
		SpringApplication.run(SportNewsApplication.class, args);
		
	}
	public void run(String... args) throws Exception {
		 
		for(int i=2;i<6;i++)
		try {
	           Elements footrepositories = Jsoup.connect("http://www.msport.ma/Rubrique/football/page/"+i).get().select("div[class=td_module_11 td_module_wrap td-animation-stack]");
	       Elements tennisrepositories = Jsoup.connect("http://www.msport.ma/Rubrique/tennis/page/"+i).get().select("div[class=td_module_11 td_module_wrap td-animation-stack]");
	       Elements golfrepositories = Jsoup.connect("http://www.msport.ma/Rubrique/golf/page/"+i).get().select("div[class=td_module_11 td_module_wrap td-animation-stack]");
	       Elements cyclrepositories = Jsoup.connect("http://www.msport.ma/Rubrique/cyclisme/page/"+i).get().select("div[class=td_module_11 td_module_wrap td-animation-stack]");
	       for (Element repository : footrepositories) {
	    	   String repositorylink = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").attr("href");
	    	   String repositoryTitle = repository.select("div[class=item-details]").select("h3[class=entry-title td-module-title]").first().select("a").text();
	    	   String repositoryimage = repository.select("div[class=td-module-thumb]").first().select("a").select("img").attr("src");
	    	   String repositorycat = repository.select("div[class=item-details]").select("a[class=td-post-category]").text();
	    	   String repositorydate = repository.select("div[class=item-details]").select("div[class=td-module-meta-info]").first().select("span[class=td-post-date]").select("time").attr("datetime");
	    	   SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS");
	    	    Date parsedDate = inputFormat.parse(repositorydate); 
	    	     if(sportnewsdao.findbyurl(repositorylink)==null)
	    	    	 sportnewsservice.CreateNews(repositoryTitle, repositoryimage, repositorylink, repositorycat, parsedDate);
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
	 	        	  sportnewsservice.CreateNews(repositoryTitle, repositoryimage, repositorylink, repositorycat, parsedDate);
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
	 	        	  sportnewsservice.CreateNews(repositoryTitle, repositoryimage, repositorylink, repositorycat, parsedDate);
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
	    	    	 sportnewsservice.CreateNews(repositoryTitle, repositoryimage, repositorylink, repositorycat, parsedDate);
	         }
	       
	     } catch (IOException e) {
	       e.printStackTrace();
	     }
	}
}
