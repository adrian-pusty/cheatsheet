import org.apache.commons.lang.StringUtils;

class StringJavaMiscellaneous
{
    public String lastCharInString(String s)
    {
        return s.substring(s.length() - 1); // "Hello world" -> "d"
    }

    public String[] splitByNewLine(String s)
    {
        return s.split("\\r?\\n");
    }

    // import org.apache.commons.lang.StringUtils;
    public boolean notNullAndNotEmpty(String s)
    {
        // https://stackoverflow.com/questions/3598770/check-whether-a-string-is-not-null-and-not-empty
        return StringUtils.isNotBlank(s);
    }

    public String addLeadingZeros(Integer num)
    {
        //https://stackoverflow.com/questions/275711/add-leading-zeroes-to-number-in-java
        // 0 - to pad with zeros
        // 3 - to set width to 3
        return String.format("%03d", num);
    }
}
