
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Play play = new Play();
		List<String> usedCityList = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Твой ход:");
			String userCity = reader.readLine();
			play.checkExitString(userCity);

			boolean isCityExist = play.isCityInDictionary(userCity);
			boolean isCityUsed = play.isCityUsed(userCity, usedCityList);
			boolean isFirstLetterAppropriate = play.isFirstLetterAppropriate(userCity);

			if (isCityExist) {
				if (!isCityUsed && isFirstLetterAppropriate) {
					usedCityList.add(userCity.toUpperCase());
					play.computersFindsCity(usedCityList, userCity);
				} else if (!isFirstLetterAppropriate) {
					System.out.println("Пользователь, не мухлюй, введи город, который будет начинаться на ту букву, "
							+ "которая была последней в моем городе!!!!");
				} else {
					System.out.println("Пользователь, такой город уже был, повтори попытку!!!!");
				}
			} else {
				System.out.println("Пользователь, что за ерунду ты пишешь, такого города не существует!!!!");
			}
		}
	}
}