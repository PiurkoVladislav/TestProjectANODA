package com.vse_vrut.testprojectanoda;

import android.support.test.rule.ActivityTestRule;
import android.support.v4.media.session.PlaybackStateCompat;
import android.test.ActivityUnitTestCase;
import android.view.View;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;



public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mMainActivity = null;

    @Before
    public void setUp() throws Exception{

        mMainActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchRecyclerView(){
        View view = mMainActivity.findViewById(R.id.item_recycler_view);
        Assert.assertNotNull(view);
    }

    @Test
    public void testJSONGetting(){
        Assert.assertNotNull(mMainActivity.getJSONItem());
    }

    @After
    public void tearDown() throws Exception{

        mMainActivity = null;
    }
}