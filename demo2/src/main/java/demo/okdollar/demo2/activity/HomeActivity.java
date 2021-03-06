package demo.okdollar.demo2.activity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.List;

import demo.okdollar.demo2.ECommerce;
import demo.okdollar.demo2.R;
import demo.okdollar.demo2.adapter.CategoryAdapterHolder;
import demo.okdollar.demo2.adapter.ProductAdapter;
import demo.okdollar.demo2.model.Category;
import demo.okdollar.demo2.model.Product;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ViewFlipper viewFlipper;
    private ECommerce eCommerce;
    private LinearLayout pagerIndicator;
    private int dotsCount;
    private ImageView[] dots;
    private List<String> bannerImages;
    private RecyclerView categoryRecyclerView;
    private RecyclerView productRecyclerView;
    private List<Category> categoryList;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("snapdeal");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewFlipper = (ViewFlipper) findViewById(R.id.image_flipper);
        eCommerce = new ECommerce(this);
        pagerIndicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        bannerImages = eCommerce.getListOfBannerImages();
        categoryRecyclerView = (RecyclerView) findViewById(R.id.category_view);
        categoryList = eCommerce.getCategoryList();
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        productRecyclerView = (RecyclerView) findViewById(R.id.product_list);
        customizeBanner();
        customizeProductList();
        customizeCategories();
        customizeTabLayout();
    }

    private void customizeProductList() {
        List<Product> products = eCommerce.getProductList();
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        productRecyclerView.setLayoutManager(mLinearLayoutManager);
        productRecyclerView.setAdapter(new ProductAdapter(this, products));
    }

    private void customizeTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_tab_home).setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_tab_category).setText("Categories"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_tab_service).setText("Services"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_tab_account).setText("Account"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(HomeActivity.this, R.color.colorAccent);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(HomeActivity.this, R.color.unselected_tab_color);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void customizeCategories() {
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(mLinearLayoutManager);
        CategoryAdapterHolder categoryAdapterHolder = new CategoryAdapterHolder(this, categoryList);
        categoryRecyclerView.setAdapter(categoryAdapterHolder);
    }

    private void customizeBanner() {
        for (String imageUrl : bannerImages) {
            addViewInViewFlipper(imageUrl);
        }
        dotsCount = bannerImages.size();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pagerIndicator.addView(dots[i], params);
        }

        viewFlipper.startFlipping();

        viewFlipper.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
                }
                int index = viewFlipper.getDisplayedChild();
                if (index >= 0)
                    dots[index].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
            }
        });
    }

    private void addViewInViewFlipper(String imageUrl) {
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setAdjustViewBounds(true);
        Picasso.with(this).load(imageUrl).into(imageView);
        viewFlipper.addView(imageView);
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
        getMenuInflater().inflate(R.menu.home, menu);
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

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
