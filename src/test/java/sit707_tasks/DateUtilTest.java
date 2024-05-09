package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "222342946";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Vishal Kumar";
		Assert.assertNotNull("Student name is null", studentName);
	}

    @Test
    public void testIncrement() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testDecrement() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDay() {
        new DateUtil(32, 1, 2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonth() {
        new DateUtil(31, 13, 2024);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYear() {
        new DateUtil(31, 12, 999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate() {
        new DateUtil(31, 2, 2024);
    }

    @Test
    public void testMonthDuration() {
        Assert.assertEquals(31, DateUtil.monthDuration(1, 2024));
        Assert.assertEquals(29, DateUtil.monthDuration(2, 2024)); // Leap year
        Assert.assertEquals(28, DateUtil.monthDuration(2, 2023)); // Non-leap year
        Assert.assertEquals(31, DateUtil.monthDuration(3, 2024));
        Assert.assertEquals(30, DateUtil.monthDuration(4, 2024));
        Assert.assertEquals(31, DateUtil.monthDuration(5, 2024));
        Assert.assertEquals(30, DateUtil.monthDuration(6, 2024));
        Assert.assertEquals(31, DateUtil.monthDuration(7, 2024));
        Assert.assertEquals(31, DateUtil.monthDuration(8, 2024));
        Assert.assertEquals(30, DateUtil.monthDuration(9, 2024));
        Assert.assertEquals(31, DateUtil.monthDuration(10, 2024));
        Assert.assertEquals(30, DateUtil.monthDuration(11, 2024));
        Assert.assertEquals(31, DateUtil.monthDuration(12, 2024));
    }

    @Test
    public void testIsLeapYear() {
        Assert.assertTrue(DateUtil.isLeapYear(2024));
        Assert.assertFalse(DateUtil.isLeapYear(2023));
    }
}
