package dvd.verwaltung.server.db;

import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Regisseur;
import dvd.verwaltung.shared.bo.Schauspieler;
import dvd.verwaltung.shared.bo.Sprache;
import dvd.verwaltung.shared.bo.Studio;

public class TestDB {
	
	public static void main (String[] args) {
		
		DVDMapper dMapper = new DVDMapper();
		GenreMapper gMapper = new GenreMapper();
		RegisseurMapper rMapper = new RegisseurMapper();
		SchauspielerMapper sMapper = new SchauspielerMapper();
		SpracheMapper sprMapper = new SpracheMapper();
		StudioMapper studMapper = new StudioMapper();
		
		/*			Test der Mapper an sich					*/
		
		DVD dvd = new DVD();
		dvd.setId(2);
		/*dvd.setTitel("test");
		dvd.setFSK(12);
		dvd.setProduktionsjahr(2016);
		dvd.setErscheinungsjahr(2016);
		dvd.setBeschreibung("test");
		dvd.setFilmlaenge(124);
		dvd.setStichwort("test");
		dvd.setAnzahlDisc(1);
		dvd.setArtDVD("normal");
		dvd.setSerieFilm("Film");*/
		
		//System.out.println(dMapper.findByFSKGroesser(6));
		//System.out.println(dMapper.findByFSKKleiner(12));
		//System.out.println(dMapper.findByLaengeGroesser(90));
		//System.out.println(dMapper.findByLaengeKleiner(140));
		System.out.println(dMapper.getDetailsOfDVDGenre(dvd));
			
		//dMapper.findByKey(1);
		
		//System.out.println(dMapper.findByKey(1));
		//System.out.println(dMapper.findAll());
		//System.out.print(dMapper.findByArtDVD("DVD"));
		//System.out.print(dMapper.findByErschjahr(2016));
		//System.out.println(dMapper.findByFSK(12));
		//System.out.println(dMapper.findByLaenge(124));
		//System.out.println(dMapper.findByProdjahr(2004));
		//System.out.println(dMapper.findBySerieFilm("Spielfilm"));
		//System.out.println(dMapper.findByStichwort("Tierwesen"));
		//System.out.println(dMapper.findByTitel("Troja"));
		
		
		//Genre genre = new Genre();
		//genre.setId(24);
		//genre.setGenre("test2");
		
		//System.out.println(gMapper.update(genre));
		//System.out.println(gMapper.findAll());
		//System.out.println(gMapper.findByKey(20));
		//System.out.println(gMapper.findByGenre("test2"));
		//gMapper.delete(genre);
		
		
		//Regisseur reg = new Regisseur();
		//reg.setId(3);
		//reg.setRegisseur("Wolfgang");
		//System.out.println(rMapper.insert(reg));
		//System.out.println(rMapper.findAll());
		//System.out.println(rMapper.findByKey(1));
		//System.out.println(rMapper.findByName("Wolfgang Petersen"));
		//System.out.println(rMapper.update(reg));
		//rMapper.delete(reg);
		//System.out.println(rMapper.findAll());
		
		//Schauspieler s = new Schauspieler();
		//s.setId(41);
		//s.setGeburtsjahr(0000);
		//s.setNachname("test2");
		//s.setVorname("test2");
		//s.setNationalitaet("test2");
		//System.out.println(sMapper.insert(s));
		//System.out.println(sMapper.findAll());
		//System.out.println(sMapper.findByKey(10));
		//System.out.println(sMapper.findByNachname("Amft"));
		//System.out.println(sMapper.findByNationalitaet("Perth, Australien"));
		//System.out.println(sMapper.update(s));
		//System.out.println(sMapper.findByKey(41));
		
		//sMapper.delete(s);
		
		//Sprache sp = new Sprache();
		//sp.setId(45);
		//sp.setSprache("testtest");
		//System.out.println(sprMapper.insert(sp));
		//System.out.println(sprMapper.findAll());
		//System.out.println(sprMapper.findByKey(5));
		//System.out.println(sprMapper.findBySprache("deutsch"));
		//System.out.println(sprMapper.update(sp));
		//sprMapper.delete(sp);
		//System.out.println(sprMapper.findByKey(45));
		
		//Studio st = new Studio();
		//st.setId(1);
		//st.setName("testtesttest");
		//st.setSitz("test, test");
		//System.out.println(studMapper.insert(st));
		//System.out.println(studMapper.findAll());
		//System.out.println(studMapper.findByKey(1));
		//System.out.println(studMapper.findByName("test"));
		//System.out.println(studMapper.update(st));
		//studMapper.delete(st);
		//System.out.println(studMapper.findAll());
		
		
		
		/*					Test der Mapperbeziehungen und -belegungen					*/
		
		
		
		
	}

}
