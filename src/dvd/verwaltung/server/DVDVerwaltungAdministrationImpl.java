package dvd.verwaltung.server;

import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dvd.verwaltung.client.DVDVerwaltungAdministration;
import dvd.verwaltung.server.db.DVDMapper;
import dvd.verwaltung.server.db.GenreMapper;
import dvd.verwaltung.server.db.RegisseurMapper;
import dvd.verwaltung.server.db.SchauspielerMapper;
import dvd.verwaltung.server.db.SpracheMapper;
import dvd.verwaltung.server.db.StudioMapper;
import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Regisseur;
import dvd.verwaltung.shared.bo.Schauspieler;
import dvd.verwaltung.shared.bo.Sprache;
import dvd.verwaltung.shared.bo.Studio;

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
	public void delete (DVD dvd) throws IllegalArgumentException {		
		dvdMapper.delete(dvd);
	}

	@Override
	public void delete (Genre genre)throws IllegalArgumentException {
		genreMapper.delete(genre);
	}
	
	@Override
	public void delete (Regisseur regisseur) throws IllegalArgumentException {
		regisseurMapper.delete(regisseur);
	}
	
	@Override
	public void delete (Schauspieler schauspieler) throws IllegalArgumentException {
		schauspielerMapper.delete(schauspieler);
	}
	
	@Override
	public void delete (Sprache sprache) throws IllegalArgumentException {
		spracheMapper.delete(sprache);
	}
	
	@Override
	public void delete (Studio studio) throws IllegalArgumentException {
		studioMapper.delete(studio);
	}
	
	/*------------------------------------------------------------------------------------*/
	
	@Override
	public void save (DVD dvd) throws IllegalArgumentException {
		dvdMapper.update(dvd);
	}
	
	@Override
	public void save (Genre genre) throws IllegalArgumentException {
		genreMapper.update(genre);
	}
	
	@Override
	public void save (Regisseur regisseur) throws IllegalArgumentException {
		regisseurMapper.update(regisseur);
	}
	
	@Override
	public void save (Schauspieler schauspieler) throws IllegalArgumentException {
		schauspielerMapper.update(schauspieler);
	}
	
	@Override
	public void save (Sprache sprache) throws IllegalArgumentException {
		spracheMapper.update(sprache);
	}
	
	@Override
	public void save (Studio studio) throws IllegalArgumentException {
		studioMapper.update(studio);
	}
	
	@Override
	public Vector<DVD> getAllDVDs() throws IllegalArgumentException {
		return dvdMapper.findAll();
	}

	@Override
	public void deleteDVD(DVD dvd) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
	
	// Details von allen Zwischentabellen anzeigen
//	@Override
//	public 
	
	
	
	
}
