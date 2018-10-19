package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		//fail("Not yet implemented");
		DateTime date = new DateTime(2018, 12, 31, 23, 0, 0);
		
		//%04d-%02d-%02d %02d:%02d:%02d string format.
		String stringDate = "2019-01-01 01:00:00";
		
		DateTime dateString = new DateTime("2019-01-01 01:00:00");
		
		date = TimeZoneTranslator.shiftTimeZone(date, 0, 2);
		
		assertEquals(stringDate, dateString.toString());
		assertEquals(stringDate, date.toString());
	}

	@Test
	public void testShiftEventTimeZone() {
		//fail("Not yet implemented");
		DateTime mathLectureStart = new DateTime(2018, 10, 16, 8, 0, 0);
		DateTime mathLectureEnd = new DateTime(2018, 10, 16, 9, 45, 0);
		Person peter = new Person("Peter");
		Place E1429 = new Place("E1429", 0.0, 0.0, 0.0);
		
		DateTime mathLectureStart2 = new DateTime(2018, 10, 16, 9, 0, 0);
		DateTime mathLectureEnd2 = new DateTime(2018, 10, 16, 10, 45, 0);
		Person peter2 = new Person("Peter");
		Place E14292 = new Place("E1429", 0.0, 0.0, 0.0);
		
		Event mathLecture01 = new Event("Mathlecture 01", mathLectureStart, mathLectureEnd, new HashSet<>(Arrays.asList(peter)), E1429);
		Event mathLecture02 = new Event("Mathlecture 01", mathLectureStart2, mathLectureEnd2, new HashSet<>(Arrays.asList(peter2)),E14292);
		
		mathLecture01 = TimeZoneTranslator.shiftEventTimeZone(mathLecture01, TimeZone.GREENWICH_UTC, TimeZone.CENTRAL_EUROPEAN_TIME);
		
		assertEquals(mathLecture02.toString(), mathLecture01.toString());
	}

}