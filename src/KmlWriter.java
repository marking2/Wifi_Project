import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

import de.micromata.opengis.kml.v_2_2_0.*;

public class KmlWriter {


	/**
	 * This class create Kml file from requested CSV.
	 * Using JAK library.
	 * @param LinkedList
	 * @return 
	 * @throws FileNotFoundException
	 */
	private LinkedList<Wifi> list; 
	/**Constructor for KmlWriter class.
	 * @param list
	 */
	public KmlWriter(LinkedList<Wifi> list,String INI){
		this.list = list;
		KMLWriter(list , INITIAL.getWritePathForKML());
	}
	/**Method that create document with all the points needed.
	 * Get LinkedList.
	 * @param ls
	 */

	public void KMLWriter(LinkedList<Wifi> ls,String WritePath) {
		Kml kml = new Kml();
		Document d = kml.createAndSetDocument().withName("My Locations");
		d.createAndSetTimeSpan().setBegin(ls.getFirst().StringToTime());
		d.createAndSetTimeSpan().setEnd(ls.getLast().StringToTime());
		Placemark p = null;

		Icon CellSignal = new Icon().withId("CellSignal");
		CellSignal.setHref("/Users/gal/git/Wifi_Project/Icons/Cellular.png");
		
		Icon FullSignal = new Icon().withId("FullSignal");
		FullSignal.setHref("/Users/gal/git/Wifi_Project/Icons/wifi-Full.png");
		
		Icon ThreeBarsSignal = new Icon().withId("3Signal");
		ThreeBarsSignal.setHref("/Users/gal/git/Wifi_Project/Icons/wifi-3-bars.png");
		
		Icon TwoBarsSignal = new Icon().withId("2Signal");
		TwoBarsSignal.setHref("/Users/gal/git/Wifi_Project/Icons/wifi-2-bars.png");
		
		Icon OneBarSignal = new Icon().withId("1Signal");
		OneBarSignal.setHref("/Users/gal/git/Wifi_Project/Icons/wifi-1-bar.png");
		
		Icon EmptySignal = new Icon().withId("NoSignal");
		EmptySignal.setHref("/Users/gal/git/Wifi_Project/Icons/wifi-Empty.png");
		for(int i=0; i<ls.size(); i++)
		{
	
			p = kml.createAndSetPlacemark();
			p.setName(ls.get(i).getSSID());
			p.withDescription("\n "+ls.get(i).ShortToString());
			p.createAndSetTimeSpan().withBegin(ls.get(i).StringToTime()).withEnd(ls.get(i).StringToTime());
			if(ls.get(i).getRssiInINT() < 70){//Good
				p.createAndAddStyle().createAndSetIconStyle().withScale(1.5).withIcon(FullSignal);				
			}
			if(ls.get(i).getRssiInINT() >= 70 && ls.get(i).getRssiInINT() < 75){//Normal
				p.createAndAddStyle().createAndSetIconStyle().withScale(1.4).withIcon(OneBarSignal);
			}
			else if(ls.get(i).getRssiInINT()>= 75 && ls.get(i).getRssiInINT() < 80){//Weak
				p.createAndAddStyle().createAndSetIconStyle().withScale(1.2).withIcon(TwoBarsSignal);
			}
			else if(ls.get(i).getRssiInINT()>= 80 && ls.get(i).getRssiInINT() < 85){//Weakest
				p.createAndAddStyle().createAndSetIconStyle().withScale(0.8).withIcon(ThreeBarsSignal);
			}
			else if (ls.get(i).getRssiInINT()>= 85 && ls.get(i).getRssiInINT() < 100){//Bad
				p.createAndAddStyle().createAndSetIconStyle().withScale(0.6).withIcon(EmptySignal);
			}
			else if(ls.get(i).getRssiInINT() >= 100){//Cellular
				p.createAndAddStyle().createAndSetIconStyle().withScale(0.45).withIcon(CellSignal);
			}
			p.createAndSetPoint()
			.addToCoordinates(Double.parseDouble(ls.get(i).getLON()), Double.parseDouble(ls.get(i).getLAT()), Double.parseDouble(ls.get(i).getALT()));
			d.addToFeature(p);
		}
		//marshals to console
		kml.setFeature(d);
//		kml.marshal();
		//marshals into file
		try {
			kml.marshal(new File(WritePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}	
}
