package com.example.user.myapp.estimote;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

class ProximityContent {

    private String title;
    private String subtitle;
    private String myName;



    public ProximityContent(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
        this.myName = myName;
    }


    String getTitle() {
        return title;
    }

    String getSubtitle() {
        return subtitle;
    }

    public String getMyName() {
        return myName;
    }
}
