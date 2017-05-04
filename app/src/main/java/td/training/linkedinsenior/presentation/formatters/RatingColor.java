package td.training.linkedinsenior.presentation.formatters;

import td.training.linkedinsenior.R;

public class RatingColor {
    public static int getColor(int rating) {
        switch (rating) {
            case 4:
                return R.color.colorBest;
            case 3:
                return R.color.colorGood;
            case 2:
                return R.color.colorAverage;
            case 1:
                return R.color.colorBad;
            case 0:
            default:
                return R.color.colorWorst;
        }

    }
}
