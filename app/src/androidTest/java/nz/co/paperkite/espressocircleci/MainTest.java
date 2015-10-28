package nz.co.paperkite.espressocircleci;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by jeruelfernandes1 on 15/10/15.
 */
@RunWith(AndroidJUnit4.class)
public class MainTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void displayDialogWhenEmptyFields(){
        onView(withId(R.id.button)).perform(click());
        onView(withText("Please fill in all fields")).check(matches(isDisplayed()));
    }

    @Test
    public void displayResultsWhenValidData() {
        onView(withId(R.id.editText)).perform(typeText("John"));
        onView(withId(R.id.editText2)).perform(typeText("Doe"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
    }

    private static int getResourceId(String s) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        String packageName = targetContext.getPackageName();
        return targetContext.getResources().getIdentifier(s, "id", packageName);
    }
}
