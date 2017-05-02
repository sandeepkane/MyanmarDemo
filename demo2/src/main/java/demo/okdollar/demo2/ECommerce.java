package demo.okdollar.demo2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELTA on 5/2/2017.
 */

public class ECommerce {
    private Context context;

    public ECommerce(Context context) {
        this.context = context;
    }

    public List<String> getListOfBannerImages() {
        List<String> imageList = new ArrayList<>();
        imageList.add("http://n1.sdlcdn.com/imgs/f/o/m/monthlybazaarweb-c638d.jpg");
        imageList.add("http://n2.sdlcdn.com/imgs/f/o/m/dns1aprilweb-1b303.jpg");
        imageList.add("http://n4.sdlcdn.com/imgs/f/o/s/Leweb24thmarch-c1ca3.jpg");
        imageList.add("http://n3.sdlcdn.com/imgs/f/o/r/KitchenWEB-91036.jpg");
        imageList.add("http://n3.sdlcdn.com/imgs/f/o/r/FormalShoesWEB-028ce.jpg");
        imageList.add("http://n2.sdlcdn.com/imgs/f/o/r/CombosWEB-928f2.jpg");
        imageList.add("http://n1.sdlcdn.com/imgs/f/o/r/MensInnerWearWEB-c3c82.jpg");
        imageList.add("http://n1.sdlcdn.com/imgs/f/o/m/monthlybazaarweb-c638d.jpg");
        imageList.add("http://n2.sdlcdn.com/imgs/f/o/r/FitnessStoreWEB-a5ba2.jpg");
        return imageList;
    }

    public List<Category> getCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("All\nCategories", "http://n1.sdlcdn.com/imgs/f/o/r/MensInnerWearWEB-c3c82.j", R.drawable.tab_bar_category_ic));
       /* categoryList.add(new Category("Fashion", ""));
        categoryList.add(new Category("Mobile &\nElectronics", ""));
        categoryList.add(new Category("Home &\nLiving", ""));
        categoryList.add(new Category("Daily Needs", ""));*/
        return categoryList;
    }
}
