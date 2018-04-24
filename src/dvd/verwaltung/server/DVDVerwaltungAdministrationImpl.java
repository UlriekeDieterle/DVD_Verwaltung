package dvd.verwaltung.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dvd.verwaltung.client.DVDVerwaltungAdministration;
import dvd.verwaltung.server.db.DVDMapper;
import dvd.verwaltung.server.db.GenreMapper;
import dvd.verwaltung.server.db.RegisseurMapper;
import dvd.verwaltung.server.db.SchauspielerMapper;
import dvd.verwaltung.server.db.SpracheMapper;
import dvd.verwaltung.server.db.StudioMapper;
import dvd.verwaltung.shared.bo.DVD;

public class DVDVerwaltungAdministrationImpl extends RemoteServiceServlet implements DVDVerwaltungAdministration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DVDMapper dvdMapper = null;
	private GenreMapper genreMapper = null;
	private RegisseurMapper regisseurMapper = null;
	private SchauspielerMapper schauspielerMapper = null;
	private SpracheMapper spracheMapper = null;
	private StudioMapper studioMapper = null;
	
	//Konstruktor
	public DVDVerwaltungAdministrationImpl() throws IllegalArgumentException {}
	
	@Override
	public void init() throws IllegalArgumentException {
		dvdMapper = DVDMapper.dvdMapper();
		genreMapper = GenreMapper.genreMapper();
		regisseurMapper = RegisseurMapper.regisseurMapper();
		schauspielerMapper = SchauspielerMapper.schauspielerMapper();
		spracheMapper = SpracheMapper.spracheMapper();
		studioMapper = StudioMapper.studioMapper();
	}
	
	@Override
	public DVD createDVD (String titel, int fsk, int prodjahr, int erschjahr, String beschreibung, 
			int filmlaenge, String stichwort, int anzahlDisc, String artDVD, String filmSerie) throws IllegalArgumentException{
		
		DVD dvd = new DVD();
		dvd.setTitel(titel);
		dvd.setAnzahlDisc(anzahlDisc);
		dvd.setArtDVD(artDVD);
		dvd.setBeschreibung(beschreibung);
		dvd.setErscheinungsjahr(erschjahr);
		dvd.setFilmlaenge(filmlaenge);
		dvd.setFSK(fsk);
		dvd.setProduktionsjahr(prodjahr);
		dvd.setSerieFilm(filmSerie);
		dvd.setStichwort(stichwort);
		
		
		return dvdMapper.insert(dvd);
	}
	
	@Override
	public void deleteDVD (DVD dvd) throws IllegalArgumentException {
		
	}
	
}
