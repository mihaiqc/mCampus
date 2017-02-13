package com.concordia.mcga.models;

import com.concordia.mcga.activities.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Campus extends POI {
    public static final Campus LOYOLA = new Campus(new LatLng(45.458563, -73.640156), "Loyola Campus", "LOY");
    public static final Campus SGW = new Campus(new LatLng(45.497100, -73.579077), "SGW Campus", "SGW");

    private String shortName;
    private ArrayList<Building> buildings;

    public Campus(LatLng mapCoordinates, String name, String shortName) {
        super(mapCoordinates, name);
        this.shortName = shortName;
        buildings = new ArrayList<>();
    }

    public void populateCampusWithBuildings() {
        if (shortName.equalsIgnoreCase("SGW")) {
            populateSGWCampusWithBuildings();
        } else {
            populateLOYCampusWithBuildings();
        }
    }

    private void populateLOYCampusWithBuildings() {


        //AD
        MarkerOptions adMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ad_building));
        buildings.add(new Building(new LatLng(45.458096, -73.639803), "Administration", "AD", adMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.458175, -73.640261),
                        new LatLng(45.458324, -73.640147),
                        new LatLng(45.458223, -73.639879),
                        new LatLng(45.458383, -73.639753),
                        new LatLng(45.458251, -73.639404),
                        new LatLng(45.457777, -73.639773),
                        new LatLng(45.457915, -73.640136),
                        new LatLng(45.458080, -73.640012)));

        //CC
        MarkerOptions ccMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_cc_building));
        buildings.add(new Building(new LatLng(45.458335, -73.640467), "Central", "CC", ccMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.458175, -73.640261),
                        new LatLng(45.458324, -73.640147),
                        new LatLng(45.458523, -73.640692),
                        new LatLng(45.458379, -73.640806)));

        //RF
        MarkerOptions rfMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_rf_building));
        buildings.add(new Building(new LatLng(45.458596, -73.641088), "Loyola Jesuit Hall And Conference Center", "RF", rfMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.458518, -73.640685),
                        new LatLng(45.458378, -73.640793),
                        new LatLng(45.458471, -73.641010),
                        new LatLng(45.458377, -73.641084),
                        new LatLng(45.458507, -73.641380),
                        new LatLng(45.458809, -73.641159),
                        new LatLng(45.458686, -73.640803),
                        new LatLng(45.458588, -73.640879)));

        // PY
        MarkerOptions pyMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_py_building));
        buildings.add(new Building(new LatLng(45.458994, -73.640456), "Psychology", "PY", pyMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459292, -73.640558),
                        new LatLng(45.459124, -73.640124),
                        new LatLng(45.458711, -73.640432),
                        new LatLng(45.458849, -73.640838),
                        new LatLng(45.459184, -73.640583),
                        new LatLng(45.459207, -73.640631)));

        // RA
        MarkerOptions raMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ra_building));
        buildings.add(new Building(new LatLng(45.456854, -73.637734), "Recreation And Athletics Complex", "RA", raMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.456963, -73.638570),
                        new LatLng(45.457260, -73.638329),
                        new LatLng(45.457103, -73.637885),
                        new LatLng(45.457129, -73.637860),
                        new LatLng(45.456828, -73.637089),
                        new LatLng(45.456494, -73.637359)));

        // PC
        MarkerOptions pcMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_pc_building));
        buildings.add(new Building(new LatLng(45.457074, -73.637313), "Perform Center", "PC", pcMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.457118, -73.637829),
                        new LatLng(45.457385, -73.637617),
                        new LatLng(45.457052, -73.636764),
                        new LatLng(45.456786, -73.636977)));

        // CJ
        MarkerOptions cjMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_cj_building));
        buildings.add(new Building(new LatLng(45.457491, -73.640380), "Communication Studies and Journalism Building", "CJ", cjMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.457334, -73.640717),
                        new LatLng(45.457597, -73.640502),
                        new LatLng(45.457650, -73.640632),
                        new LatLng(45.457831, -73.640486),
                        new LatLng(45.457754, -73.640294),
                        new LatLng(45.457726, -73.640315),
                        new LatLng(45.457618, -73.640038),
                        new LatLng(45.457480, -73.640144),
                        new LatLng(45.457435, -73.640032),
                        new LatLng(45.457446, -73.639945),
                        new LatLng(45.457468, -73.639955),
                        new LatLng(45.457484, -73.639825),
                        new LatLng(45.457429, -73.639772),
                        new LatLng(45.457384, -73.639762),
                        new LatLng(45.457333, -73.639769),
                        new LatLng(45.457280, -73.639804),
                        new LatLng(45.457259, -73.639829),
                        new LatLng(45.457230, -73.639885),
                        new LatLng(45.457212, -73.639990),
                        new LatLng(45.457215, -73.640030),
                        new LatLng(45.457302, -73.640083),
                        new LatLng(45.457311, -73.640049),
                        new LatLng(45.457354, -73.640071),
                        new LatLng(45.457404, -73.640204),
                        new LatLng(45.457175, -73.640388),
                        new LatLng(45.457279, -73.640657),
                        new LatLng(45.457304, -73.640639)
                ));

        // GE
        MarkerOptions geMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ge_building));
        buildings.add(new Building(new LatLng(45.456987, -73.640445), "Center For Structural And Functional Genomics", "GE", geMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.456945, -73.640740),
                        new LatLng(45.457174, -73.640570),
                        new LatLng(45.457131, -73.640452),
                        new LatLng(45.457142, -73.640442),
                        new LatLng(45.457041, -73.640167),
                        new LatLng(45.456799, -73.640347),
                        new LatLng(45.456896, -73.640612),
                        new LatLng(45.456872, -73.640629),
                        new LatLng(45.456893, -73.640688),
                        new LatLng(45.456919, -73.640670)));

        //SP
        MarkerOptions spMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_sp_building));
        buildings.add(new Building(new LatLng(45.457548, -73.641722), "Richard J. Renaud Science Complex", "SP", spMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.456983, -73.640829),
                        new LatLng(45.457024, -73.640936),
                        new LatLng(45.456997, -73.640959),
                        new LatLng(45.457017, -73.641012),
                        new LatLng(45.457042, -73.640994),
                        new LatLng(45.457159, -73.641297),
                        new LatLng(45.457150, -73.641305),
                        new LatLng(45.457180, -73.641384),
                        new LatLng(45.457169, -73.641392),
                        new LatLng(45.457185, -73.641432),
                        new LatLng(45.457210, -73.641413),
                        new LatLng(45.457439, -73.642003),
                        new LatLng(45.457641, -73.641845),
                        new LatLng(45.457672, -73.641926),
                        new LatLng(45.458326, -73.641412),
                        new LatLng(45.458277, -73.641285),
                        new LatLng(45.458209, -73.641338),
                        new LatLng(45.458179, -73.641262),
                        new LatLng(45.458255, -73.641202),
                        new LatLng(45.458193, -73.641039),
                        new LatLng(45.458339, -73.640922),
                        new LatLng(45.458316, -73.640862),
                        new LatLng(45.457999, -73.641115),
                        new LatLng(45.457979, -73.641065),
                        new LatLng(45.457893, -73.641133),
                        new LatLng(45.457908, -73.641170),
                        new LatLng(45.457525, -73.641473),
                        new LatLng(45.457251, -73.640766),
                        new LatLng(45.457246, -73.640769),
                        new LatLng(45.457202, -73.640657)));

        //PS
        MarkerOptions psMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ps_building));
        buildings.add(new Building(new LatLng(45.459658, -73.639771), "Physical Services Building", "PS", psMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459287, -73.639458),
                        new LatLng(45.459333, -73.639577),
                        new LatLng(45.459403, -73.639525),
                        new LatLng(45.459444, -73.639631),
                        new LatLng(45.459415, -73.639655),
                        new LatLng(45.459609, -73.640158),
                        new LatLng(45.459638, -73.640136),
                        new LatLng(45.459706, -73.640312),
                        new LatLng(45.459852, -73.640199),
                        new LatLng(45.459864, -73.640227),
                        new LatLng(45.459981, -73.640134),
                        new LatLng(45.459664, -73.639318),
                        new LatLng(45.459623, -73.639350),
                        new LatLng(45.459576, -73.639230)));

        //SC
        MarkerOptions scMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_sc_building));
        buildings.add(new Building(new LatLng(45.459153, -73.639173), "Student Center", "SC", scMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.458991, -73.639125),
                        new LatLng(45.459106, -73.639418),
                        new LatLng(45.459215, -73.639332),
                        new LatLng(45.459234, -73.639381),
                        new LatLng(45.459304, -73.639324),
                        new LatLng(45.459264, -73.639221),
                        new LatLng(45.459318, -73.639178),
                        new LatLng(45.459230, -73.638952),
                        new LatLng(45.459159, -73.639009),
                        new LatLng(45.459136, -73.638953),
                        new LatLng(45.459078, -73.638997),
                        new LatLng(45.459096, -73.639042)));

        //PT
        MarkerOptions ptMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_pt_building));
        buildings.add(new Building(new LatLng(45.459318, -73.638964), "Oscar Peterson Concert Hall", "PT", ptMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459163, -73.638780),
                        new LatLng(45.459335, -73.639221),
                        new LatLng(45.459351, -73.639208),
                        new LatLng(45.459361, -73.639231),
                        new LatLng(45.459483, -73.639136),
                        new LatLng(45.459301, -73.638672)));

        // VL
        MarkerOptions vlMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_vl_building));
        buildings.add(new Building(new LatLng(45.459073, -73.638395), "Vanier Library Building", "VL", vlMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.458825, -73.638271),
                        new LatLng(45.459090, -73.638969),
                        new LatLng(45.459195, -73.638887),
                        new LatLng(45.459156, -73.638786),
                        new LatLng(45.459312, -73.638663),
                        new LatLng(45.459133, -73.638196),
                        new LatLng(45.459212, -73.638133),
                        new LatLng(45.459138, -73.637939),
                        new LatLng(45.459131, -73.637944),
                        new LatLng(45.459122, -73.637919),
                        new LatLng(45.459128, -73.637915),
                        new LatLng(45.459102, -73.637846),
                        new LatLng(45.459075, -73.637868),
                        new LatLng(45.459082, -73.637889),
                        new LatLng(45.459046, -73.637916),
                        new LatLng(45.459038, -73.637895),
                        new LatLng(45.458902, -73.638001),
                        new LatLng(45.458910, -73.638026),
                        new LatLng(45.458882, -73.638050),
                        new LatLng(45.458902, -73.638101),
                        new LatLng(45.458869, -73.638127),
                        new LatLng(45.458887, -73.638175),
                        new LatLng(45.458853, -73.638203),
                        new LatLng(45.458866, -73.638237)));
        // VE
        MarkerOptions veMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ve_building));
        buildings.add(new Building(new LatLng(45.458848, -73.638634), "Vanier Extension", "VE", veMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.458825, -73.638271),
                        new LatLng(45.458704, -73.638363),
                        new LatLng(45.458718, -73.638399),
                        new LatLng(45.458631, -73.638468),
                        new LatLng(45.458829, -73.638981),
                        new LatLng(45.458836, -73.638976),
                        new LatLng(45.458854, -73.639019),
                        new LatLng(45.459050, -73.638865)));

        // FC
        MarkerOptions fcMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_fc_building));
        buildings.add(new Building(new LatLng(45.458588, -73.639350), "F.C. Smith Building", "FC", fcMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.458380, -73.639039),
                        new LatLng(45.458392, -73.639070),
                        new LatLng(45.458414, -73.639055),
                        new LatLng(45.458425, -73.639084),
                        new LatLng(45.458408, -73.639096),
                        new LatLng(45.458427, -73.639149),
                        new LatLng(45.458420, -73.639157),
                        new LatLng(45.458428, -73.639183),
                        new LatLng(45.458418, -73.639188),
                        new LatLng(45.458426, -73.639223),
                        new LatLng(45.458441, -73.639255),
                        new LatLng(45.458453, -73.639247),
                        new LatLng(45.458516, -73.639410),
                        new LatLng(45.458511, -73.639430),
                        new LatLng(45.458484, -73.639451),
                        new LatLng(45.458510, -73.639529),
                        new LatLng(45.458524, -73.639521),
                        new LatLng(45.458535, -73.639549),
                        new LatLng(45.458529, -73.639572),
                        new LatLng(45.458539, -73.639600),
                        new LatLng(45.458556, -73.639605),
                        new LatLng(45.458583, -73.639586),
                        new LatLng(45.458595, -73.639611),
                        new LatLng(45.458632, -73.639681),
                        new LatLng(45.458671, -73.639699),
                        new LatLng(45.458749, -73.639641),
                        new LatLng(45.458759, -73.639585),
                        new LatLng(45.458732, -73.639511),
                        new LatLng(45.458742, -73.639497),
                        new LatLng(45.458717, -73.639429),
                        new LatLng(45.458726, -73.639422),
                        new LatLng(45.458711, -73.639375),
                        new LatLng(45.458726, -73.639364),
                        new LatLng(45.458724, -73.639353),
                        new LatLng(45.458746, -73.639334),
                        new LatLng(45.458730, -73.639296),
                        new LatLng(45.458708, -73.639314),
                        new LatLng(45.458696, -73.639302),
                        new LatLng(45.458687, -73.639312),
                        new LatLng(45.458672, -73.639289),
                        new LatLng(45.458665, -73.639293),
                        new LatLng(45.458605, -73.639132),
                        new LatLng(45.458616, -73.639120),
                        new LatLng(45.458622, -73.639086),
                        new LatLng(45.458609, -73.639058),
                        new LatLng(45.458583, -73.639057),
                        new LatLng(45.458578, -73.639061),
                        new LatLng(45.458570, -73.639046),
                        new LatLng(45.458559, -73.639054),
                        new LatLng(45.458537, -73.639000),
                        new LatLng(45.458521, -73.639013),
                        new LatLng(45.458508, -73.638980),
                        new LatLng(45.458529, -73.638964),
                        new LatLng(45.458518, -73.638935)));

        // DO
        MarkerOptions doMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_do_building));
        buildings.add(new Building(new LatLng(45.457621, -73.636172), "Stinger Dome", "DO", doMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.456958, -73.636355),
                        new LatLng(45.457375, -73.637085),
                        new LatLng(45.458337, -73.635959),
                        new LatLng(45.457927, -73.635243)));

        // BB
        MarkerOptions bbMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bb_building));
        buildings.add(new Building(new LatLng(45.459753, -73.639166), "BB", "BB", bbMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459694, -73.639168),
                        new LatLng(45.459725, -73.639242),
                        new LatLng(45.459815, -73.639167),
                        new LatLng(45.459785, -73.639092)));

        // BH
        MarkerOptions bhMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bh_building));
        buildings.add(new Building(new LatLng(45.459727, -73.639093), "BH", "BH", bhMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459665, -73.639093),
                        new LatLng(45.459694, -73.639166),
                        new LatLng(45.459784, -73.639092),
                        new LatLng(45.459753, -73.639018)));

        // SI
        MarkerOptions siMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_si_building));
        buildings.add(new Building(new LatLng(45.457883, -73.642309), "St. Ignatius Of Loyaloa Church", "SI", siMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.457569, -73.642400),
                        new LatLng(45.457634, -73.642575),
                        new LatLng(45.457658, -73.642568),
                        new LatLng(45.457729, -73.642512),
                        new LatLng(45.457740, -73.642533),
                        new LatLng(45.457779, -73.642502),
                        new LatLng(45.457795, -73.642532),
                        new LatLng(45.457846, -73.642493),
                        new LatLng(45.457856, -73.642522),
                        new LatLng(45.457893, -73.642494),
                        new LatLng(45.457969, -73.642687),
                        new LatLng(45.458171, -73.642531),
                        new LatLng(45.458123, -73.642404),
                        new LatLng(45.458100, -73.642419),
                        new LatLng(45.458044, -73.642266),
                        new LatLng(45.458057, -73.642232),
                        new LatLng(45.457997, -73.642078),
                        new LatLng(45.457971, -73.642078),
                        new LatLng(45.457941, -73.642003),
                        new LatLng(45.457879, -73.642049),
                        new LatLng(45.457855, -73.641992),
                        new LatLng(45.457821, -73.642018),
                        new LatLng(45.457832, -73.642047),
                        new LatLng(45.457764, -73.642103),
                        new LatLng(45.457775, -73.642135),
                        new LatLng(45.457721, -73.642182),
                        new LatLng(45.457728, -73.642201),
                        new LatLng(45.457680, -73.642243),
                        new LatLng(45.457687, -73.642270),
                        new LatLng(45.457621, -73.642330),
                        new LatLng(45.457626, -73.642350)));

        // SH
        MarkerOptions shMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_sh_building));
        buildings.add(new Building(new LatLng(45.459370, -73.642453), "Solar House", "SH", shMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459335, -73.642363),
                        new LatLng(45.459341, -73.642547),
                        new LatLng(45.459409, -73.642543),
                        new LatLng(45.459405, -73.642359)));


        // HB
        MarkerOptions hbMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_hb_building));
        buildings.add(new Building(new LatLng(45.459300, -73.641901), "Hingston Hall, wing HB", "HB", hbMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459029, -73.641800),
                        new LatLng(45.459054, -73.641865),
                        new LatLng(45.459020, -73.641895),
                        new LatLng(45.459162, -73.642258),
                        new LatLng(45.459197, -73.642231),
                        new LatLng(45.459220, -73.642288),
                        new LatLng(45.459417, -73.642132),
                        new LatLng(45.459395, -73.642075),
                        new LatLng(45.459419, -73.642057),
                        new LatLng(45.459416, -73.642043),
                        new LatLng(45.459530, -73.641952),
                        new LatLng(45.459554, -73.642013),
                        new LatLng(45.459584, -73.641989),
                        new LatLng(45.459396, -73.641504)));

        // HA
        MarkerOptions haMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ha_building));
        buildings.add(new Building(new LatLng(45.459769, -73.642045), "Hingston Hall, wing HA", "HA", haMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459594, -73.642021),
                        new LatLng(45.459692, -73.642269),
                        new LatLng(45.459863, -73.642132),
                        new LatLng(45.459963, -73.642007),
                        new LatLng(45.459893, -73.641830),
                        new LatLng(45.459782, -73.641918),
                        new LatLng(45.459768, -73.641882)));

        // HC
        MarkerOptions hcMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_hc_building));
        buildings.add(new Building(new LatLng(45.459458, -73.641224), "Hingston Hall, wing HA", "HC", hcMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459253, -73.641071),
                        new LatLng(45.459277, -73.641133),
                        new LatLng(45.459261, -73.641145),
                        new LatLng(45.459395, -73.641496),
                        new LatLng(45.459410, -73.641485),
                        new LatLng(45.459431, -73.641542),
                        new LatLng(45.459676, -73.641352),
                        new LatLng(45.459652, -73.641289),
                        new LatLng(45.459663, -73.641281),
                        new LatLng(45.459528, -73.640932),
                        new LatLng(45.459514, -73.640943),
                        new LatLng(45.459492, -73.640883)));

        // TA
        MarkerOptions taMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ta_building));
        buildings.add(new Building(new LatLng(45.459987, -73.640898), "Terrebonne Building", "TA", taMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.459940, -73.640868),
                        new LatLng(45.459978, -73.640970),
                        new LatLng(45.460033, -73.640929),
                        new LatLng(45.459993, -73.640827)));



    }

    private void populateSGWCampusWithBuildings() {
        // H
        MarkerOptions hMarkerOptions = new MarkerOptions()
                .icon(BitmapDescriptorFactory
                        .fromResource(R.mipmap.ic_h_building));

        buildings.add(new Building(new LatLng(45.497289, -73.578932), "Hall", "H", hMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.497164, -73.579543),
                        new LatLng(45.497707, -73.579033),
                        new LatLng(45.497374, -73.578343),
                        new LatLng(45.496834, -73.578848)));
        // LB
        MarkerOptions lbMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_lb_building));
        buildings.add(new Building(new LatLng(45.496777, -73.577857), "J.W. McConnell", "LB", lbMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496686, -73.578550),
                        new LatLng(45.497246, -73.578023),
                        new LatLng(45.496879, -73.577268),
                        new LatLng(45.496555, -73.577579),
                        new LatLng(45.496485, -73.577440),
                        new LatLng(45.496248, -73.577665)));
        // GM
        MarkerOptions gmMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_gm_building));
        buildings.add(new Building(new LatLng(45.495870, -73.578755), "Guy-De Maisonneuve Building", "GM", gmMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.495796, -73.579094),
                        new LatLng(45.496117, -73.578779),
                        new LatLng(45.495944, -73.578421),
                        new LatLng(45.495625, -73.578736)));
        // EV
        MarkerOptions evMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ev_building));
        buildings.add(new Building(new LatLng(45.495466, -73.577946), "Engineering, Computer Science and Visual Arts Integrated Complex", "EV", evMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.495597, -73.578763),
                        new LatLng(45.495866, -73.578497),
                        new LatLng(45.495669, -73.578072),
                        new LatLng(45.496047, -73.577709),
                        new LatLng(45.495831, -73.577252),
                        new LatLng(45.495205, -73.577918)));
        // JM
        MarkerOptions jmMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_jm_building));
        buildings.add(new Building(new LatLng(45.495241, -73.578925), "John Molson", "JM", jmMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.495358, -73.579366),
                        new LatLng(45.495518, -73.579199),
                        new LatLng(45.495440, -73.578961),
                        new LatLng(45.495186, -73.578525),
                        new LatLng(45.495005, -73.578737),
                        new LatLng(45.495038, -73.578792),
                        new LatLng(45.495007, -73.578824),
                        new LatLng(45.495166, -73.579171),
                        new LatLng(45.495222, -73.579114)));
        // FB
        MarkerOptions fbMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_fb_building));
        buildings.add(new Building(new LatLng(45.494635, -73.577604), "Faubourg", "FB", fbMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.494695, -73.578040),
                        new LatLng(45.494911, -73.577785),
                        new LatLng(45.494654, -73.577219),
                        new LatLng(45.494397, -73.577521)));

        // FG
        MarkerOptions fgMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_fg_building));
        buildings.add(new Building(new LatLng(45.494170, -73.578351), "Faubourg Ste-Catherine", "FG", fgMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.493822, -73.579067),
                        new LatLng(45.494695, -73.578039),
                        new LatLng(45.494452, -73.577617),
                        new LatLng(45.494388, -73.577693),
                        new LatLng(45.494428, -73.577761),
                        new LatLng(45.494392, -73.577804),
                        new LatLng(45.494372, -73.577769),
                        new LatLng(45.494187, -73.577987),
                        new LatLng(45.493626, -73.578728)));
        // GA
        MarkerOptions gaMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ga_building));
        buildings.add(new Building(new LatLng(45.494096, -73.577944), "Grey Nuns Annex", "GA", gaMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.493851, -73.578354),
                        new LatLng(45.494134, -73.578012),
                        new LatLng(45.494119, -73.577986),
                        new LatLng(45.494345, -73.577737),
                        new LatLng(45.494285, -73.577622),
                        new LatLng(45.494056, -73.577871),
                        new LatLng(45.494076, -73.577908),
                        new LatLng(45.493790, -73.578253)));

        //GN
        MarkerOptions gnMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_gn_building));
        buildings.add(new Building(new LatLng(45.493687, -73.576280), "Grey Nuns", "GN", gnMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.493908, -73.577904),
                        new LatLng(45.494239, -73.577543),
                        new LatLng(45.494268, -73.577602),
                        new LatLng(45.494379, -73.577488),
                        new LatLng(45.494397, -73.577519),
                        new LatLng(45.494683, -73.577166),
                        new LatLng(45.493833, -73.575183),
                        new LatLng(45.492341, -73.576632),
                        new LatLng(45.492969, -73.577728),
                        new LatLng(45.493507, -73.577160)));

        //MT
        MarkerOptions mtMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_mt_building));
        buildings.add(new Building(new LatLng(45.494556, -73.576056), "Montefiore", "MT", mtMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.494421, -73.576380),
                        new LatLng(45.494711, -73.576123),
                        new LatLng(45.494679, -73.576009),
                        new LatLng(45.494823, -73.575883),
                        new LatLng(45.494752, -73.575719),
                        new LatLng(45.494448, -73.575984),
                        new LatLng(45.494298, -73.576131)));

        // CL
        MarkerOptions clMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_cl_building));
        buildings.add(new Building(new LatLng(45.494321, -73.579159), "Clinique de Médecine Industrielle et Préventive du Québec", "CL", clMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.494162, -73.579061),
                        new LatLng(45.494377, -73.579397),
                        new LatLng(45.494471, -73.579282),
                        new LatLng(45.494261, -73.578938)));

        // Q
        MarkerOptions qMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_q_building));
        buildings.add(new Building(new LatLng(45.496611, -73.579110), "Q", "Q", qMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496553, -73.579120),
                        new LatLng(45.496584, -73.579180),
                        new LatLng(45.496676, -73.579082),
                        new LatLng(45.496645, -73.579023)));

        // P
        MarkerOptions pMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_p_building));
        buildings.add(new Building(new LatLng(45.496653, -73.579176), "P", "P", pMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496583, -73.579180),
                        new LatLng(45.496630, -73.579269),
                        new LatLng(45.496722, -73.579173),
                        new LatLng(45.496677, -73.579082)));

        // T
        MarkerOptions tMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_t_building));
        buildings.add(new Building(new LatLng(45.496692, -73.579267), "T", "T", tMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496629, -73.579270),
                        new LatLng(45.496668, -73.579345),
                        new LatLng(45.496751, -73.579262),
                        new LatLng(45.496710, -73.579184)));

        // RR
        MarkerOptions rrMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_rr_building));
        buildings.add(new Building(new LatLng(45.496710, -73.579368), "RR", "RR", rrMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496612, -73.579401),
                        new LatLng(45.496651, -73.579480),
                        new LatLng(45.496799, -73.579332),
                        new LatLng(45.496759, -73.579255)));

        // R
        MarkerOptions rMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_r_building));
        buildings.add(new Building(new LatLng(45.496775, -73.579412), "R", "R", rMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496711, -73.579421),
                        new LatLng(45.496746, -73.579491),
                        new LatLng(45.496838, -73.579399),
                        new LatLng(45.496802, -73.579329)));

        // FA
        MarkerOptions faMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_fa_building));
        buildings.add(new Building(new LatLng(45.496803, -73.579499), "FA", "FA", faMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496736, -73.579503),
                        new LatLng(45.496775, -73.579585),
                        new LatLng(45.496871, -73.579490),
                        new LatLng(45.496831, -73.579407)));

        // EN
        MarkerOptions enMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_en_building));
        buildings.add(new Building(new LatLng(45.496862, -73.579566), "EN", "EN", enMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496676, -73.579734),
                        new LatLng(45.496700, -73.579784),
                        new LatLng(45.496931, -73.579553),
                        new LatLng(45.496892, -73.579471),
                        new LatLng(45.496788, -73.579574),
                        new LatLng(45.496803, -73.579607)));

        // X
        MarkerOptions xMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_x_building));
        buildings.add(new Building(new LatLng(45.496881, -73.579670), "X", "X", xMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496815, -73.579671),
                        new LatLng(45.496857, -73.579757),
                        new LatLng(45.496949, -73.579666),
                        new LatLng(45.496907, -73.579579)));

        // Z
        MarkerOptions zMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_z_building));
        buildings.add(new Building(new LatLng(45.496926, -73.579745), "Z", "Z", zMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496851, -73.579763),
                        new LatLng(45.496875, -73.579813),
                        new LatLng(45.496897, -73.579790),
                        new LatLng(45.496911, -73.579817),
                        new LatLng(45.496986, -73.579741),
                        new LatLng(45.496949, -73.579666)));

        // PR
        MarkerOptions prMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_pr_building));
        buildings.add(new Building(new LatLng(45.496956, -73.579837), "PR", "PR", prMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496895, -73.579833),
                        new LatLng(45.496934, -73.579914),
                        new LatLng(45.497018, -73.579829),
                        new LatLng(45.496979, -73.579749)));

        // V
        MarkerOptions vMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_v_building));
        buildings.add(new Building(new LatLng(45.497009, -73.579934), "V", "V", vMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.496927, -73.579921),
                        new LatLng(45.496986, -73.580043),
                        new LatLng(45.497089, -73.579941),
                        new LatLng(45.497030, -73.579817)));

        // M
        MarkerOptions mMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_m_building));
        buildings.add(new Building(new LatLng(45.497356, -73.579772), "M", "M", mMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.497291, -73.579781),
                        new LatLng(45.497327, -73.579854),
                        new LatLng(45.497427, -73.579755),
                        new LatLng(45.497390, -73.579681)));

        // S
        MarkerOptions sMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_s_building));
        buildings.add(new Building(new LatLng(45.497405, -73.579844), "S", "S", sMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.497327, -73.579855),
                        new LatLng(45.497367, -73.579937),
                        new LatLng(45.497490, -73.579815),
                        new LatLng(45.497460, -73.579752),
                        new LatLng(45.497436, -73.579773),
                        new LatLng(45.497427, -73.579756)));

        //CI
        MarkerOptions ciMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ci_building));
        buildings.add(new Building(new LatLng(45.497472, -73.579895), "CI", "CI", ciMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.497368, -73.579937),
                        new LatLng(45.497406, -73.580015),
                        new LatLng(45.497584, -73.579839),
                        new LatLng(45.497546, -73.579759)));

        // MU
        MarkerOptions muMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_mu_building));
        buildings.add(new Building(new LatLng(45.497853, -73.579579), "MU", "MU", muMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.497748, -73.579628),
                        new LatLng(45.497785, -73.579703),
                        new LatLng(45.497963, -73.579537),
                        new LatLng(45.497920, -73.579463)));

        // B
        MarkerOptions bMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_b_building));
        buildings.add(new Building(new LatLng(45.497809, -73.579503), "B", "B", bMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.497705, -73.579560),
                        new LatLng(45.497740, -73.579636),
                        new LatLng(45.497921, -73.579462),
                        new LatLng(45.497884, -73.579385)));

        // K
        MarkerOptions kMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_k_building));
        buildings.add(new Building(new LatLng(45.497748, -73.579485), "K", "K", kMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.497599, -73.579573),
                        new LatLng(45.497626, -73.579635),
                        new LatLng(45.497883, -73.579386),
                        new LatLng(45.497849, -73.579313),
                        new LatLng(45.497755, -73.579402),
                        new LatLng(45.497772, -73.579440),
                        new LatLng(45.497696, -73.579510),
                        new LatLng(45.497686, -73.579488)));

        // D
        MarkerOptions dMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_d_building));
        buildings.add(new Building(new LatLng(45.497776, -73.579325), "D", "D", dMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.497707, -73.579341),
                        new LatLng(45.497742, -73.579412),
                        new LatLng(45.497849, -73.579312),
                        new LatLng(45.497812, -73.579235)));


        // MI
        MarkerOptions miMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_mi_building));
        buildings.add(new Building(new LatLng(45.497741, -73.579263), "MI", "MI", miMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.497623, -73.579354),
                        new LatLng(45.497647, -73.579403),
                        new LatLng(45.497811, -73.579235),
                        new LatLng(45.497779, -73.579167),
                        new LatLng(45.497682, -73.579260),
                        new LatLng(45.497694, -73.579285)));

        // VA
        MarkerOptions vaMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_va_building));
        buildings.add(new Building(new LatLng(45.495650, -73.573885), "Visual Arts Building", "VA", vaMarkerOptions)
                .addEdgeCoordinate(new LatLng(45.495392, -73.573749),
                        new LatLng(45.495656, -73.574290),
                        new LatLng(45.496174, -73.573773),
                        new LatLng(45.496061, -73.573544),
                        new LatLng(45.495800, -73.573802),
                        new LatLng(45.495647, -73.573493)));

    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
