package com.concordia.mcga.activities;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import com.concordia.mcga.adapters.POISearchAdapter;
import com.concordia.mcga.exceptions.MCGADatabaseException;
import com.concordia.mcga.factories.BuildingFactory;
import com.concordia.mcga.fragments.IndoorMapFragment;
import com.concordia.mcga.fragments.NavigationFragment;
import com.concordia.mcga.helperClasses.DatabaseConnector;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    enum NavigationState {
        START_INDOOR_BUILDING,
        OUTDOOR,
        DEST_INDOOR_BUILDING
    }
    public enum SearchState {
        NONE, LOCATION, DESTINATION, LOCATION_DESTINATION
    }

    private NavigationState currentState;
    private GlobalPathFinder finder;
    private Handler handler;
    private DrawerLayout drawerLayout;
    private NavigationFragment navigationFragment;

    // Search
    private View toolbarView;
    private View parentView;

    private SearchView search;
    private Dialog searchDialog;
    private ExpandableListView searchList;

    private POISearchAdapter poiSearchAdapter;

    // Directions
    private SearchState searchState;

    private GPSManager gpsManager;

    private POI location;
    private POI destination;

>>>>>>> master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BuildingFactory.setResources(getApplicationContext().getResources());

        // Initialize side drawer
        parentView = findViewById(R.id.drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationFragment = new NavigationFragment();
        // Setup GPS
        setUpGPS();

        // Search setup
        toolbarView = findViewById(R.id.nav_toolbar);
        setUpSearchBarButtons();
        setupSearchAttributes();
        setupSearchList();

        // Setup navigation fragment
        navigationFragment = new NavigationFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, navigationFragment, "MAIN_NAV");
        fragmentTransaction.commit();
        initDatabase();

        // Setup side drawer callbacks
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    if (menuItem.isChecked()) {
                        menuItem.setChecked(false);
                    }
                    else {
                        menuItem.setChecked(true);
                    }

                    drawerLayout.closeDrawers();

                    switch (menuItem.getItemId()) {
                        case R.id.next_class:
                            Toast.makeText(getApplicationContext(), "Next Class", Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.shuttle_schedule:
                            Toast.makeText(getApplicationContext(), "Shuttle Schedule", Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.settings:
                            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.student_spots:
                            Toast.makeText(getApplicationContext(), "Student Spots", Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.about:
                            Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            Toast.makeText(getApplicationContext(), "Error - Navigation Drawer", Toast.LENGTH_SHORT).show();
                            return false;
                    }
                }
            }
        );

        drawerLayout = (DrawerLayout) parentView;
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(getApplicationContext(), "Done finding", Toast.LENGTH_SHORT).show();

                if(null != finder.getStartBuildingDirections()){
                    loadStartIndoor(null);
                } else {
                    loadOutdoor(null);
                }
            }
        };
    }

    public void createToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void initDatabase() {
        DatabaseConnector.setupDatabase(this);
        DatabaseConnector myDbHelper;
        try {
            myDbHelper = DatabaseConnector.getInstance();
        } catch (MCGADatabaseException e) {
            throw new Error("Database incorrectly initialized");
        }
        try {
            myDbHelper.createDatabase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
    }

    public void testGeneration(View v) throws MCGADatabaseException {
        Floor testMap = Campus.SGW.getBuilding("H").getFloorMap(4);
        testMap.populateTiledMap();
        testMap.getIndoorPOIs().get(0);
        generateDirections(testMap.getIndoorPOIs().get(3), Campus.SGW.getBuildings().get(3), MCGATransportMode.WALKING);
    }
    public void generateDirections(POI start, POI dest, String mode){
        finder = new GlobalPathFinder(this, start, dest, mode);
        Thread finderThread = new Thread(finder);
        finderThread.start();
    }

    public void notifyPathfindingComplete(){
        if (finder.getOutDoorCoordinates() != null){
            Context context = getApplicationContext();
            OutdoorDirections outdoorDirections = navigationFragment.getOutdoorDirections();
            LatLng[] coords = finder.getOutDoorCoordinates();
            outdoorDirections.setOrigin(coords[0]);
            outdoorDirections.setSelectedTransportMode(finder.getMode());
            outdoorDirections.setDestination(coords[1]);
            outdoorDirections.setContext(context);
            outdoorDirections.setServerKey(getResources().getString(R.string.google_maps_key));
            outdoorDirections.setMap(navigationFragment.getMap());
            outdoorDirections.requestDirections();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putSerializable("finder", finder);
        message.setData(bundle);
        handler.sendMessage(message);
    }

    public void loadStartIndoor(View v) {
        currentState = NavigationState.START_INDOOR_BUILDING;
        navigationFragment.showIndoorMap();
        final IndoorMapFragment indoorMapFragment = navigationFragment.getIndoorMapFragment();
        indoorMapFragment.setCurrentPathTiles(finder.getStartBuildingDirections());
        indoorMapFragment.setCurrentFloor(finder.getStartBuildingDirections().keySet().iterator().next());
        indoorMapFragment.drawCurrentWalkablePath();
    }

    public void loadOutdoor(View v) {
        currentState = NavigationState.OUTDOOR;
        navigationFragment.showOutdoorMap();
        OutdoorDirections outdoorDirections = navigationFragment.getOutdoorDirections();
        outdoorDirections.drawPathForSelectedTransportMode();
    }

    public void loadDestIndoor(View v) {
        currentState = NavigationState.DEST_INDOOR_BUILDING;
        navigationFragment.showIndoorMap();
        final IndoorMapFragment indoorMapFragment = navigationFragment.getIndoorMapFragment();
        indoorMapFragment.setCurrentPathTiles(finder.getDestBuildingDirections());
        indoorMapFragment.setCurrentFloor(finder.getDestBuildingDirections().keySet().iterator().next());
        indoorMapFragment.drawCurrentWalkablePath();
    }

    @Override
    public boolean onClose() {
        search.setQuery("", false);
        search.clearFocus();
        parentView.requestFocus();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        poiSearchAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        poiSearchAdapter.filterData(newText);
        expandAll();
        return false;
    }

    /**
     * Expands all the view result groups (showing the POIs under the campus search results)
     */
    private void expandAll() {
        if (poiSearchAdapter.getGroupCount() == 0) {
            searchDialog.dismiss();
        } else {
            searchDialog.show();
            for (int i = 0; i < poiSearchAdapter.getGroupCount(); i++) {
                if (i != POISearchAdapter.MY_LOCATION_GROUP_POSITION) {
                    searchList.expandGroup(i);
                }
            }
        }
    }

    private void setUpSearchBarButtons() {
        AppCompatImageButton locationCancelButton;
        locationCancelButton = (AppCompatImageButton)toolbarView.findViewById(
                R.id.search_location_button);
        locationCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocation(null);
                if (getDestination() == null) {
                    setSearchState(SearchState.NONE);
                } else {
                    setSearchState(SearchState.DESTINATION);
                }
                updateSearchUI();
            }
        });

        AppCompatImageButton destinationCancelButton;
        destinationCancelButton = (AppCompatImageButton)toolbarView.findViewById(
                R.id.search_destination_button);
        destinationCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDestination(null);
                if (getLocation() == null) {
                    setSearchState(SearchState.NONE);
                } else {
                    setSearchState(SearchState.LOCATION);
                }
                updateSearchUI();
            }
        });
    }

    /**
     * Constructor helper function to set up the search functionality of the view
     */
    private void setupSearchAttributes() {
        //Search
        SearchManager searchManager = (SearchManager) this.getSystemService(
                Context.SEARCH_SERVICE);
        search = (SearchView) findViewById(R.id.navigation_search);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);
        search.setQueryHint("Enter destination");

        //Custom search dialog
        searchDialog = new Dialog(this);
        searchDialog.setCanceledOnTouchOutside(true);
        searchDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        searchDialog.setContentView(R.layout.search_dialog);
        final Window window = searchDialog.getWindow();
        window.setGravity(Gravity.TOP);
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        window.setFlags(WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH);
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        window.setLayout(LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT);

        parentView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        // Set dialog window offset and height
                        WindowManager.LayoutParams wmlp = window.getAttributes();
                        int xy[] = new int[2];
                        parentView.findViewById(R.id.navigation_search).getLocationOnScreen(xy);
                        wmlp.y = xy[1] + 20;

                        Rect r = new Rect();
                        parentView.getWindowVisibleDisplayFrame(r);
                        wmlp.height = (r.bottom - r.top) - wmlp.y;
                        window.setAttributes(wmlp);
                    }
                }
        );
    }

    /**
     * Constructor helper function to set up the list and listener for the navigation search
     */
    private void setupSearchList() {
        searchList = (ExpandableListView) searchDialog.findViewById(R.id.expandableList);
        poiSearchAdapter = new POISearchAdapter(this, Campus.SGW, Campus.LOY);
        searchList.setAdapter(poiSearchAdapter);

        searchList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                POI poi = (POI)poiSearchAdapter.getChild(groupPosition, childPosition);
                setNavigationPOI(poi);

                if (!(poi instanceof Room)) {
                    // call navigationfragment
                    navigationFragment.camMove(poi.getMapCoordinates());
                } else {
                    // call indoormapfragment
                    navigationFragment.onRoomSearch((Room) poi);
                }

                onClose();
                return true;
            }
        });

        searchList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (groupPosition == POISearchAdapter.MY_LOCATION_GROUP_POSITION) {
                    LatLng location = gpsManager.getLocation();
                    if (location != null) {
                        POI myPOI = new POI(location, "My Location");
                        setNavigationPOI(myPOI);
                        onClose();
                        return true;
                    }
                }
                return false;
            }
        });

        // Display no location/destination by default
        setSearchState(SearchState.NONE);
        updateSearchUI();
    }

    private void setUpGPS() {
        LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {}
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}
        };
        gpsManager = new GPSManager(locationManager, locationListener, this);
    }

    /**
     * Sets the navigation state and location/destination for internal use
     * @param poi The {@link POI} location to be added to the search state
     * @return Whether the state was updated or not
     */
    public boolean setNavigationPOI(POI poi) {
        if (searchState == SearchState.NONE) {
            location = poi;
            searchState = SearchState.LOCATION;
        } else if (searchState == SearchState.DESTINATION) {
            if (poi == destination) {
                return false;
            }
            location = poi;
            searchState = SearchState.LOCATION_DESTINATION;
        } else if (searchState == SearchState.LOCATION) {
            if (poi == location) {
                return false;
            }
            destination = poi;
            searchState = SearchState.LOCATION_DESTINATION;
        } else { // if searchState == SearchState.LOCATION_DESTINATION
            return false;
        }
        updateSearchUI();
        return true;
    }

    /**
     * Updates the UI elements associated with the search state.
     * If no location or destination has been selected, hide the elements.
     * If a location has been specified, hide the destination element but update the location label.
     * If a destination has been specified, hide the location element but update destination label.
     * If both have been specified, show everything and update both labels.
     */
    public void updateSearchUI() {
        LinearLayoutCompat locationLayout = (LinearLayoutCompat)
                toolbarView.findViewById(R.id.search_location);
        LinearLayoutCompat destinationLayout = (LinearLayoutCompat)
                toolbarView.findViewById(R.id.search_destination);

        if (location != null) {
            AppCompatTextView locationText = (AppCompatTextView)
                    toolbarView.findViewById(R.id.search_location_text);
            setDisplayName(location, locationText);
        }
        if (destination != null) {
            AppCompatTextView destinationText = (AppCompatTextView)
                    toolbarView.findViewById(R.id.search_destination_text);
            setDisplayName(destination, destinationText);
        }

        // Always clear the directions first
        if (navigationFragment != null) {
            navigationFragment.clearAllPaths();
        }

        if (getSearchState() == SearchState.NONE) {
            locationLayout.setVisibility(View.GONE);
            destinationLayout.setVisibility(View.GONE);
            search.setQueryHint("Enter location...");
            search.setVisibility(View.VISIBLE);
        } else if (getSearchState() == SearchState.LOCATION) {
            locationLayout.setVisibility(View.VISIBLE);
            destinationLayout.setVisibility(View.GONE);
            search.setQueryHint("Enter destination...");
            search.setVisibility(View.VISIBLE);
        } else if (getSearchState() == SearchState.DESTINATION) {
            locationLayout.setVisibility(View.GONE);
            destinationLayout.setVisibility(View.VISIBLE);
            search.setQueryHint("Enter location...");
            search.setVisibility(View.VISIBLE);
        } else { // SearchState.LOCATION_DESTINATION
            locationLayout.setVisibility(View.VISIBLE);
            destinationLayout.setVisibility(View.VISIBLE);
            search.setVisibility(View.GONE);

            // Set up directions. Here is where indoor/outdoor comes to play.
            // For now we only handle purely outdoor or purely indoor paths
            if (!(location instanceof IndoorPOI) && !(destination instanceof IndoorPOI)) {
                navigationFragment.generateOutdoorPath(location, destination);
            } else if (location instanceof IndoorPOI && destination instanceof IndoorPOI) {
                navigationFragment.generateIndoorPath((IndoorPOI)location, (IndoorPOI)destination);
            } else {
                // TODO: Indoor/outdoor integration
            }
        }
    }

    /**
     * Sets the display name for a label from a POI.
     * If the POI is a building, use the short name instead of the long one ("H" vs. "Hall")
     * Else, use the full POI name
     * @param poi Point of interest to display on the text view
     * @param textView Text view to set text on
     */
    private void setDisplayName(POI poi, AppCompatTextView textView) {
        if (poi instanceof Building) {
            textView.setText(((Building) poi).getShortName());
        } else {
            textView.setText(poi.getName());
        }
    }

    public SearchState getSearchState() {
        return searchState;
    }

    public void setSearchState(SearchState searchState) {
        this.searchState = searchState;
    }

    public POI getLocation() {
        return location;
    }

    public void setLocation(POI location) {
        this.location = location;
    }

    public POI getDestination() {
        return destination;
    }

    public void setDestination(POI destination) {
        this.destination = destination;
    }

    public GPSManager getGpsManager() {
        return gpsManager;
    }
}
