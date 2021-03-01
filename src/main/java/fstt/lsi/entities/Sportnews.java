package fstt.lsi.entities;
import java.util.Date;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
@Entity
@Table(name="sportnews")

public class Sportnews {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(nullable = false, unique = true )
		private int id ;
		private String title;
		private String image;
		@Column(nullable = false, unique = true )
		private String url;
		private String categorie;
		private Date date;
		
		public Sportnews() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Sportnews(int id, String title, String image, String url, String categorie, Date date) {
			super();
			this.id = id;
			this.title = title;
			this.image = image;
			this.url = url;
			this.categorie = categorie;
			this.date = date;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getCategorie() {
			return categorie;
		}
		public void setCategorie(String categorie) {
			this.categorie = categorie;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		@Override
		public String toString() {
			return "Sportnews [id=" + id + ", title=" + title + ", image=" + image + ", url=" + url + ", categorie="
					+ categorie + ", date=" + date + "]";
		}
}
