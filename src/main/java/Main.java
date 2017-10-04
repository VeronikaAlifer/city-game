
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
			System.out.println("���� ���:");
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
					System.out.println("������������, �� ������, ����� �����, ������� ����� ���������� �� �� �����, "
							+ "������� ���� ��������� � ���� ������!!!!");
				} else {
					System.out.println("������������, ����� ����� ��� ���, ������� �������!!!!");
				}
			} else {
				System.out.println("������������, ��� �� ������ �� ������, ������ ������ �� ����������!!!!");
			}
		}
	}
}