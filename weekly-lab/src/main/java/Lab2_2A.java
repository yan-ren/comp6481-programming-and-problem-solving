
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Scanner;

public class Lab2_2A {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		int lineNumber = Integer.parseInt(sc.nextLine());
		while (lineNumber > 0) {
			checkAge(sc.nextLine());
			lineNumber--;
		}
	}

	public static void checkAge(String input) throws ParseException {
		String baseLineDateStr = "2022-04-18";
		String[] inputs = input.split(" ");
		String checkDateStr = inputs[2] + "-" + inputs[1] + "-" + inputs[0];

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date baseline = dateFormat.parse(baseLineDateStr);
		Date checkDate = dateFormat.parse(checkDateStr);
		OffsetDateTime startOdt = checkDate.toInstant().atOffset(ZoneOffset.UTC);
		OffsetDateTime endOdt = baseline.toInstant().atOffset(ZoneOffset.UTC);

		int year = Period.between(startOdt.toLocalDate(), endOdt.toLocalDate()).getYears();
		if (year >= 13) {
			System.out.println("old enough");
		} else {
			System.out.println("too young");
		}
	}

}
