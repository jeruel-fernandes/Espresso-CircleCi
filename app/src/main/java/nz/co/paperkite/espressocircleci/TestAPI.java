package nz.co.paperkite.espressocircleci;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by jeruelfernandes1 on 29/10/15.
 */
public interface TestAPI {
    @GET("/get")
    public void getFeed(Callback<JSONObject> response);
}