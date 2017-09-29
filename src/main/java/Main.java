import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	 public static void main(String[] args) throws IOException {
	        Play play = new Play();
	        List<String> cityList = new ArrayList<String>();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	        while (true) {
	            System.out.println("��� ���");
	            String word = reader.readLine();
	            play.checkExitString(word);
	            boolean result = play.isCityUsed(word, cityList);

	            if (result) {// ����  System.out.println("����� ����� ��� ���");��������� ������������� � � ������ ��� ��������� ������� ��� ��������������
	                play.computersFindsCity(cityList, word);
	            } else {
	                System.out.println("����� ����� ��� ���");
	            }
	        }
	    }
}
