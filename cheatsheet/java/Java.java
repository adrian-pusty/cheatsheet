
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

class BigDecimalScaleAndPrecision
{
    BigDecimal withPrecision = new BigDecimal("12345.6789").round(new MathContext(3, RoundingMode.HALF_UP)); // 1.23E+4 - three significant digits
    BigDecimal withScale = new BigDecimal("12345.6789").setScale(3, RoundingMode.HALF_UP); // 12345.679 - three digits to the right of the decimal point
}

class NumbersJavaMiscellaneous
{
    public static int randomInteger(int min, int max)
    {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public int numberOfDigits(int n)
    {
        return (int) (Math.log10(n)+1);
    }
}

class AssertThrowsJunit5
{
    public void doThing() throws Exception
    {
        throw new Exception("Stuff");
    }

    @Test
    void exceptionTesting()
    {
        final AssertThrowsJunit5 myObject = new AssertThrowsJunit5();

        final Exception thrown = Assertions.assertThrows(
                Exception.class,
                myObject::doThing,
                "Expected doThing() to throw, but it didn't" //org.opentest4j.AssertionFailedError: Expected doThing() to throw, but it didn't ==> Expected java.lang.Exception to be thrown, but nothing was thrown.
        );

        Assertions.assertTrue(thrown.getMessage().contains("Stuff"));
    }

    @Test
    void floatingPointComparisons()
    {
        Assertions.assertEquals(0, Float.compare(1f, 1.0f));
        Assertions.assertEquals(-1, Double.compare(2.3, 3.1));
    }
}

@Entity
class SampleEntityWithId
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
