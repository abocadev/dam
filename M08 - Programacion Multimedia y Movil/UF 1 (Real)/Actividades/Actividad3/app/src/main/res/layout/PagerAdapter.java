package layout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int nNumOfTabs;
    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.nNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new AboutMeFragment();
            case 1: return new ProjectsFragment();
            case 2: return new ContactmeFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
