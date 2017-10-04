
import java.util.Arrays;
import java.util.List;

public class Play {

	private static final String EXIT = "exit";
	private List<City> cityDictionary = Arrays.asList(City.values());
	private String computerCity;

	public boolean isCityUsed(String cityToCheck, List<String> cityList) {
		return cityList.contains(cityToCheck.toUpperCase());
	}

	public boolean isFirstLetterAppropriate(String userCity) {
		return computerCity == null || compareLastLetterWithFirstLetter(computerCity, userCity);

	}

	private boolean compareLastLetterWithFirstLetter(String previousCity, String nextCity) {
		return String.valueOf(previousCity.charAt(previousCity.length() - 1))
				.equalsIgnoreCase(String.valueOf(nextCity.charAt(0)));
	}

	public void computersFindsCity(List<String> usedCityList, String previousCity) {
		for (int i = 0; i < cityDictionary.size(); i++) {
			String city = String.valueOf(cityDictionary.get(i));

			if (!isCityUsed(city, usedCityList) && compareLastLetterWithFirstLetter(previousCity, city)) {
				System.out.println("Ход компьютера: " + '\n' + city);
				computerCity = city.toUpperCase();
				usedCityList.add(computerCity);
				break;
			}
		}
	}

	public void checkExitString(String inputString) {
		if (EXIT.equalsIgnoreCase(inputString)) {
			System.out.println("Игра была прервана ползователем!!!");
			System.exit(0);
		}
	}

	public boolean isCityInDictionary(String city) {
		try {
			City.valueOf(city.toUpperCase());
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
