package com.example.user.myapp.estimote;

import android.graphics.Color;

import com.example.user.myapp.R;


//
// Running into any issues? Drop us an email to: contact@estimote.com
//

class Utils {

    static String getShortIdentifier(String deviceIdentifier) {
        return deviceIdentifier.substring(0, 4) + "..." + deviceIdentifier.substring(28, 32);
    }

    static int getEstimoteColor(String colorName) {
        switch (colorName) {
            case "ice":
                return Color.rgb(109, 170, 199);

            case "blueberry":
                return Color.rgb(36, 24, 93);

            case "candy":
                return Color.rgb(219, 122, 167);

            case "mint":
                return Color.rgb(100, 186, 160);

            case "beetroot":
                return Color.rgb(84, 0, 61);

            case "lemon":
                return Color.rgb(195, 192, 16);

            default:
                return R.color.googleRed;
        }
    }
}
