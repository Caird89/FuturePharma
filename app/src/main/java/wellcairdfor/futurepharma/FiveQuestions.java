package wellcairdfor.futurepharma;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class FiveQuestions extends AppCompatActivity {


    //creates array to contain question texts and gives it a temporary blank to prevent crashes.
    //Does the same for answer texts.
    static ArrayList<String> questions_list = new ArrayList<String>(Arrays.asList("tempo"));
    static ArrayList<String> A1answers = new ArrayList<String>(Arrays.asList("tempo"));
    static ArrayList<String> A2answers = new ArrayList<String>(Arrays.asList("tempo"));
    static ArrayList<String> A3answers = new ArrayList<String>(Arrays.asList("tempo"));
    static ArrayList<String> A4answers = new ArrayList<String>(Arrays.asList("tempo"));
    static ArrayList<String> A5answers = new ArrayList<String>(Arrays.asList("tempo"));
    static ArrayList<String> A6answers = new ArrayList<String>(Arrays.asList("tempo"));

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //adds the questions and answers  to the respective arraylists, removes initial dummy entry.
        //Note: Could all possibly be looped into a neater few lines of code, but eh, maybe later. It it aint broken dont fix it.
        questions_list.remove(0);
        questions_list.add(getString(R.string.que1));
        questions_list.add(getString(R.string.que2));
        questions_list.add(getString(R.string.que3));
        questions_list.add(getString(R.string.que4));
        questions_list.add(getString(R.string.que5));

        A1answers.remove(0);
        A2answers.remove(0);
        A3answers.remove(0);
        A4answers.remove(0);
        A5answers.remove(0);
        A6answers.remove(0);

        A1answers.add(getString(R.string.q1a1));
        A1answers.add(getString(R.string.q2a1));
        A1answers.add(getString(R.string.q3a1));
        A1answers.add(getString(R.string.q4a1));
        A1answers.add(getString(R.string.q5a1));

        A2answers.add(getString(R.string.q1a2));
        A2answers.add(getString(R.string.q2a2));
        A2answers.add(getString(R.string.q3a2));
        A2answers.add(getString(R.string.q4a2));
        A2answers.add(getString(R.string.q5a2));

        A3answers.add(getString(R.string.q1a3));
        A3answers.add(getString(R.string.q2a3));
        A3answers.add(getString(R.string.q3a3));
        A3answers.add(getString(R.string.q4a3));
        A3answers.add(getString(R.string.q5a3));

        A4answers.add(getString(R.string.q1a4));
        A4answers.add(getString(R.string.q2a4));
        A4answers.add(getString(R.string.q3a4));
        A4answers.add(getString(R.string.q4a4));
        A4answers.add(getString(R.string.q5a4));

        A5answers.add(getString(R.string.q1a5));
        A5answers.add(getString(R.string.q2a5));
        A5answers.add(getString(R.string.q3a5));
        A5answers.add(getString(R.string.q4a5));
        A5answers.add(getString(R.string.q5a5));

        A6answers.add(getString(R.string.q1a6));
        A6answers.add(getString(R.string.q2a6));
        A6answers.add(getString(R.string.q3a6));
        A6answers.add(getString(R.string.q4a6));
        A6answers.add(getString(R.string.q5a6));
        //End of arraylist population.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_questions);

      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_five_questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_five_questions, container, false);

            //loads needed fragment/question specific stuff
            TextView questDisplay = rootView.findViewById(R.id.questionText);
            RadioGroup  answers = rootView.findViewById(R.id.Ans_group);
            RadioButton A1 = rootView.findViewById(R.id.A1);
            RadioButton A2 = rootView.findViewById(R.id.A2);
            RadioButton A3 = rootView.findViewById(R.id.A3);
            RadioButton A4 = rootView.findViewById(R.id.A4);
            RadioButton A5 = rootView.findViewById(R.id.A5);
            RadioButton A6 = rootView.findViewById(R.id.A6);
            Button submit_ans = rootView.findViewById(R.id.Q_Submit);

            //Sets the correct text displays for both the question and answer strings.
            questDisplay.setText(questions_list.get(getArguments().getInt(ARG_SECTION_NUMBER)-1));
            A1.setText(A1answers.get(getArguments().getInt(ARG_SECTION_NUMBER)-1));
            A2.setText(A2answers.get(getArguments().getInt(ARG_SECTION_NUMBER)-1));
            A3.setText(A3answers.get(getArguments().getInt(ARG_SECTION_NUMBER)-1));
            A4.setText(A4answers.get(getArguments().getInt(ARG_SECTION_NUMBER)-1));
            A5.setText(A5answers.get(getArguments().getInt(ARG_SECTION_NUMBER)-1));
            A6.setText(A6answers.get(getArguments().getInt(ARG_SECTION_NUMBER)-1));

            //Hides buttons that are unused, different questions have different numbers of answers.
            if(A5.getText().equals("x"))
            {
              A5.setVisibility(View.INVISIBLE);
            }
            if(A6.getText().equals("x"))
            {
                A6.setVisibility(View.INVISIBLE);
            }

            return rootView;
        }



    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }
    }
}
