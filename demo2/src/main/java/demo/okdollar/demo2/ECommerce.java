package demo.okdollar.demo2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import demo.okdollar.demo2.model.Category;
import demo.okdollar.demo2.model.Product;

/**
 * Created by DELTA on 5/2/2017.
 */

public class ECommerce {
    private Context context;

    public ECommerce(Context context) {
        this.context = context;
    }

    public List<String> getComponentList() {
        List<String> componentList = new ArrayList<>();
        componentList.add("BannerAndCategories");
        return componentList;
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
        categoryList.add(new Category("All\nCategories", "http://n1.sdlcdn.com/imgs/f/o/r/MensInnerWearWEB-c3c82.j", R.drawable.ic_category));
        categoryList.add(new Category("Fashion", "http://n1.sdlcdn.com/imgs/f/o/r/MensInnerWearWEB-c3c82.j", R.drawable.ic_category));
        categoryList.add(new Category("Mobile &\nElectronics", "http://n1.sdlcdn.com/imgs/f/o/r/MensInnerWearWEB-c3c82.j", R.drawable.ic_category));
        categoryList.add(new Category("Home &\nLiving", "http://n1.sdlcdn.com/imgs/f/o/r/MensInnerWearWEB-c3c82.j", R.drawable.ic_category));
        categoryList.add(new Category("Daily Needs", "http://n1.sdlcdn.com/imgs/f/o/r/MensInnerWearWEB-c3c82.j", R.drawable.ic_category));
        return categoryList;
    }

    public List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("", "599.00", ""));
        products.add(new Product("", "599.00", ""));
        products.add(new Product("", "599.00", ""));
        products.add(new Product("", "599.00", ""));
        return products;
    }
}
