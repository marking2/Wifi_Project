import java.io.File;
//import java.util.LinkedList;


public class INITIAL {
	/**This file represents the Settings of the user to initialize the program s.t
	 * figure set the folder that he wants to read , the folder where to write the new csv (sorted) file
	 *Also this file contains some parametters of the program s.t the header of right csv file .
	 
	 * Description:
	 * ReadPath = the Root / file.csv
	 * WritePath = the path to write file.
	 * 
	 */
	
	private static String ReadPath = "toRead";
	private static String WritePath = "toWrite//File19112017.csv";
	private static String suffix = ".csv";
	private static String csvHeader = "MAC,SSID,AuthMode,FirstSeen,Channel,RSSI,CurrentLatitude,CurrentLongitude,AltitudeMeters,AccuracyMeters,Type";
	private static String modelName = "model=";
	private static String csvClientHeader = "TIME,ID,LAT,LON,ALT,Number Of Networks";
	private static String csvClientWifiParameters = "SSID,MAC,Frequency,Signal";
	
	private static File fileReadPath = new File(ReadPath);
	public static File fileWritePath = new File(WritePath);
	
	private static int OneLineWifiCount = 10;
	
	//Filters input:
		//filter by location // TEST: from the writed file line 6 
	private static double inputLAT = 32.16737112;
	private static double inputLON = 34.80947136;
	private static double inputRadius = 4;

	
	public static String getCsvHeader() {
		return csvHeader;
	}
	public static void setCsvHeader(String csvHeader) {
		INITIAL.csvHeader = csvHeader;
	}
	
	public static File getFileReadPath() {
		return fileReadPath;
	}
	public static File getFileWritePath() {
		return fileWritePath;
	}
	public static void setFileReadPath(File fileReadPath) {
		INITIAL.fileReadPath = fileReadPath;
	}
	public static void setFileWritePath(File fileWritePath) {
		INITIAL.fileWritePath = fileWritePath;
	}
	
	
	public static String getSuffix() {
		return suffix;
	}
	public static void setSuffix(String suffix) {
		INITIAL.suffix = suffix;
	}
	public static String getReadPath() {
		return ReadPath;
	}
	public static String getWritePath() {
		return WritePath;
	}
	public static void setReadPath(String readPath) {
		ReadPath = readPath;
	}
	public static void setWritePath(String writePath) {
		WritePath = writePath;
	}
	public static String getModelName() {
		return modelName;
	}
	public static void setModelName(String modelName) {
		INITIAL.modelName = modelName;
	}
	public static int getOneLineWifiCount() {
		return OneLineWifiCount;
	}
	public static void setOneLineWifiCount(int oneLineWifiCount) {
		OneLineWifiCount = oneLineWifiCount;
	}
	public static String getCsvClientHeader() {
		return csvClientHeader;
	}
	public static void setCsvClientHeader(String csvClientHeader) {
		INITIAL.csvClientHeader = csvClientHeader;
	}
	public static String getCsvClientWifiParameters() {
		return csvClientWifiParameters;
	}
	public static void setCsvClientWifiParameters(String csvClientWifiParameters) {
		INITIAL.csvClientWifiParameters = csvClientWifiParameters;
	}
	public static double getInputLAT() {
		return inputLAT;
	}
	public static void setInputLAT(double inputLAT) {
		INITIAL.inputLAT = inputLAT;
	}
	public static double getInputLON() {
		return inputLON;
	}
	public static void setInputLON(double inputLON) {
		INITIAL.inputLON = inputLON;
	}
	public static  double getInputRadius() {
		return inputRadius;
	}
	public static void setInputRadius(double inputRadius) {
		INITIAL.inputRadius = inputRadius;
	}
	public static double getInputRadius_Cube() {
		return inputRadius*inputRadius;
	}
	
}
