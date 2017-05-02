package demo.okdollar.demo2;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ViewFlipper viewFlipper;
    private ECommerce eCommerce;
    private LinearLayout pagerIndicator;
    private int dotsCount;
    private ImageView[] dots;
    private List<String> bannerImages;
    private RecyclerView categoryRecyclerView;
    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        customizeBanner();
        customizeCategories();
    }

    private void customizeCategories() {
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(mLinearLayoutManager);
        CategoryAdapterHolder categoryAdapterHolder = new CategoryAdapterHolder(categoryList);
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

    class CategoryAdapterHolder extends RecyclerView.Adapter<CategoryAdapterHolder.ViewHolder> {
        List<Category> categories;

        public CategoryAdapterHolder(List<Category> categories) {
            this.categories = categories;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            final View sView = mInflater.inflate(R.layout.single_ccategory_view, parent, false);
            return new ViewHolder(sView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Category category = categories.get(position);
            Picasso.with(HomeActivity.this).load(category.getImageUrl()).error(category.getPlaceholder()).placeholder(category.getPlaceholder()).into(holder.categoryImage);
            holder.categoryNameTextView.setText(category.getName());
        }

        @Override
        public int getItemCount() {
            return categories.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView categoryImage;
            public TextView categoryNameTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                categoryImage = (ImageView) itemView.findViewById(R.id.category_image);
                categoryNameTextView = (TextView) itemView.findViewById(R.id.category_name);
            }
        }
    }
}
