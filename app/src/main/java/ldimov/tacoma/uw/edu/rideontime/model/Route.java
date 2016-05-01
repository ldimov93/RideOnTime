package ldimov.tacoma.uw.edu.rideontime.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Lachezar Dimov on 4/30/2016.
 */
public class Route {


    public static final String ROUTE_NAME = "route_short_name";
    public static final String DEPARTURE_TIME = "departure_time";
    public static final String MINUTES = "minutes";

    String mRouteName;
    String mDepartureTime;
    String mMinutes;

    public Route(String routeName, String departureTime, String minutes) {
        mRouteName = routeName;
        mDepartureTime = departureTime;
        mMinutes = minutes;
    }

    public String getRouteName() {
        return mRouteName;
    }
    public String getDepartureTime() {
        return mDepartureTime;
    }
    public String getMinutes() {
        return mMinutes;
    }


    /**  Parses the json string, returns an error message if unsuccessful.
     *
     * Returns stops list if successful.
     * @param courseJSON  * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Route> routesList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Route route = new Route(obj.getString(Route.ROUTE_NAME), obj.getString(Route.DEPARTURE_TIME)
                                            , obj.getString(Route.MINUTES));
                    routesList.add(route);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data. Reason: " + e.getMessage();
            }
        }
        return reason;
    }
}
