package de.jodamob.mockitoid;

import static org.mockito.Matchers.any;

import android.os.Bundle;
import android.os.Parcel;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AndroidMatchers {


    public static Button anyButton() {
        return any(Button.class);
    }

    public static View anyView() {
        return any(View.class);
    }

    public static MenuItem anyMenuItem() {
        return any(MenuItem.class);
    }

    public static Fragment anyFragment() {
        return any(Fragment.class);
    }

    public static Activity anyActivity() {
        return any(Activity.class);
    }

    public static Context anyContext() {
        return any(Context.class);
    }

    public static Intent anyIntent() {
        return any(Intent.class);
    }

    public static Bundle anyBundle() {
        return any(Bundle.class);
    }

    public static Parcel anyParcel() {
        return any(Parcel.class);
    }

    public static FragmentManager anyFragmentManager() {
        return any(FragmentManager.class);
    }


}
