package Helper;

import Base.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper extends BaseClass {

    public static String date() {
        String pattern = "yyyy-MM-dd_HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }
}

