
import java.util.Arrays;
import java.util.List;

public class Play {

    private static final String EXIT = "exit";
    private List<City> cities = Arrays.asList(City.values());

    public boolean isCityUsed(String word, List<String> cityList) {
        boolean result = true;

        for (int a = 0; a < cityList.size(); a++) {
            if (word.equalsIgnoreCase(cityList.get(a))) {
                result = false;
                break;
            } else {
                result = true;
            }
        }

        return result;
    }

    private boolean compareLastLetterWithFirsLetter(String previousCity, String nextCity) {
        return String.valueOf(previousCity.charAt(previousCity.length() - 1))
                .equalsIgnoreCase(String.valueOf(nextCity.charAt(0)));
    }

    public void computersFindsCity(List<String> cityList, String word){
        cityList.add(word);

        for (int i = 0; i < cities.size(); i++) {
            String city = String.valueOf(cities.get(i));

            if (isCityUsed(city, cityList) && compareLastLetterWithFirsLetter(word, city)) {
                System.out.println("Компьютер: "+'\n'+ city);
                cityList.add(city);
                break;
            }
        }
    }

    public void checkExitString(String inputString) {
        if (inputString.equalsIgnoreCase(EXIT)) {
            System.out.println("The game has been interrupted by the user.");
            System.exit(0);
        }
    }

//    public void insertCity() {
//        System.out.println("Название города");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String word = null;
//        try {
//            word = reader.readLine();
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public void checkCityInArray(String word){
//        for (int i = 0; i < cityList.size();i++){
//            if(word.equalsIgnoreCase(cityList.get(i))){
//                System.out.println("такой город уже был");
//            }
//        }
//    }
//
//    public String checkCityInEnum(String word) {
//        for (int a = 0; a < cities.length; a++) {
//            if (word.equalsIgnoreCase(String.valueOf(cities[a]))) {
//                return word;
//            }
//        }
//        System.out.println("такого города не существует ");
//        return null;
//    }
//
//    public void  reverseString(String word) {
//        StringBuilder stringBuilder = new StringBuilder(word);
//        stringBuilder.reverse();
//        String w = new String(stringBuilder);
//        word = w;
//        findCityByLastLetter(word);
//    }
//
//    public void findCityByLastLetter(String word) {
//        for (int i = 0; i < cities.length; i++) {
//            String city = String.valueOf(cities[i]);
//            if (String.valueOf(word.charAt(0)).equalsIgnoreCase(String.valueOf(city.charAt(0)))) {
//                System.out.println(city);
//                break;
//            }
//        }
//    }
}
