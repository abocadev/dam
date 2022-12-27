package dev.boca.recyclerview;

import java.util.ArrayList;

public class Contact {
    private String nName;
    private boolean mOnline;

    public Contact(String nName, boolean mOnline) {
        this.nName = nName;
        this.mOnline = mOnline;
    }

    public String getnName() {
        return nName;
    }

    public boolean ismOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts){
        ArrayList<Contact> contacts = new ArrayList<>();
        for (int i = 1; i <= numContacts; i++){
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts/2 ));
        }
        return contacts;
    }
}
