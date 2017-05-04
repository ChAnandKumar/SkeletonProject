package com.anand.skeletonproject.ui.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.anand.skeletonproject.R;
import com.anand.skeletonproject.ui.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
//http://www.androidhive.info/2013/11/android-sliding-menu-using-navigation-drawer/
public class HomeActivity extends BaseActivity implements HomeMvpView {

    @Inject
    HomeMvpPresenter<HomeMvpView> homeMvpPresenter;


    private static final String urlNavHeaderBg = "http://api.androidhive.info/images/nav-menu-header-bg.jpg";
    private static final String urlProfileImg = "https://lh3.googleusercontent.com/eCtE_G34M9ygdkmOpYvCag1vBARCmZwnVS6rS5t4JLzJ6QgQSBquM0nuTsCpLhYbKljoyS-txg";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

   /* @BindView(R.id.name)
    TextView txtName;


    @BindView(R.id.website)
    TextView txtWebsite;

    @BindView(R.id.img_profile)
    ImageView imgProfile;

    @BindView(R.id.img_header_bg)
    ImageView imgNavHeaderBg;*/
    private View navHeader;
    private TextView txtName;
    private TextView txtWebsite;
    private ImageView imgNavHeaderBg;
    private ImageView imgProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        homeMvpPresenter.onAttach(this);
        setUp();


    }

    @Override
    protected void setUp() {

        setSupportActionBar(toolbar);
        navHeader = navView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);
        loadNavHeader();
    }

    private void loadNavHeader() {
        // name, website
        txtName.setText("Ravi Tamada");
        txtWebsite.setText("www.androidhive.info");

        // loading header background image
        Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);

        // Loading profile image
        Glide.with(this).load(urlProfileImg)
                .crossFade()
                .thumbnail(0.5f)
                //.bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);

        // showing dot next to notifications label
        navView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
    }
}
