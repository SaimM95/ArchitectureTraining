package td.training.linkedinsenior;

import java.util.Date;

public class DateUtils {

    private Date date;

    public DateUtils(Date date) {
        this.date = date;
    }

    public String formatDate(Date originDate) {
        String relativeDate;
        Long daysAgo = differenceInDays(originDate, date);
        if (daysAgo < 0) {
            relativeDate = "In the future";
        } else if (daysAgo < 1) {
            relativeDate = "Today";
        } else if (daysAgo < 7) {
            relativeDate = "Less than a week ago";
        } else if (daysAgo < 30) {
            relativeDate = "Less than a month ago";
        } else if (daysAgo < 365) {
            relativeDate = "Less than a year ago";
        } else {
            relativeDate = "Long ago";
        }
        return relativeDate;
    }

    private Long differenceInDays(Date date1, Date date2) {
        final Integer MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;
        return (date1.getTime() - date2.getTime()) / MILLISECONDS_IN_A_DAY;
    }
}
