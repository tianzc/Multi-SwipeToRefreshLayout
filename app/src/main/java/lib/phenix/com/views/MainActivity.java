package lib.phenix.com.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import lib.phenix.com.views.fragments.NormalFragment;
import lib.phenix.com.views.fragments.RecyclerFragment;
import lib.phenix.com.views.fragments.RefreshFragment;
import lib.phenix.com.views.fragments.ScrollFragment;
import lib.phenix.com.views.fragments.ViewPagerFragment;
import lib.phenix.com.views.fragments.WebViewFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NormalFragment normal;
    ScrollFragment scroll;
    RecyclerFragment recycler;
    WebViewFragment web;
    ViewPagerFragment pager;
    RefreshFragment refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        normal = new NormalFragment();
        scroll = new ScrollFragment();
        recycler = new RecyclerFragment();
        web = new WebViewFragment();
        pager = new ViewPagerFragment();
        refresh = new RefreshFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container,normal).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_normal:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,normal).commit();
                break;
            case R.id.action_scroll:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,scroll).commit();
                break;
            case R.id.action_recycler:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,recycler).commit();
                break;
            case R.id.action_web:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,web).commit();
                break;
            case R.id.action_pager:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,pager).commit();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_refresh){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,refresh).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
