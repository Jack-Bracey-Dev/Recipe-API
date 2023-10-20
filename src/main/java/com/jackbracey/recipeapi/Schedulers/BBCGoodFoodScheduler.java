package com.jackbracey.recipeapi.Schedulers;

import com.jackbracey.recipeapi.Helpers.NumberHelper;
import com.jackbracey.recipeapi.Helpers.RequestHelper;
import com.jackbracey.recipeapi.Services.RecipeOverviewService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class BBCGoodFoodScheduler {

    @Autowired
    private RecipeOverviewService recipeOverviewService;

    private final String BASE_URL = "https://www.bbcgoodfood.com/api/recipes-frontend/lists/card/recipe";

//    @Scheduled(fixedDelay = (10*1000*60), initialDelay = 200)
    public void CollectNewBBCGoodFoodBasicInfo() throws JSONException {
        Integer latestId = recipeOverviewService.getLatestId();
        RestTemplate template = RequestHelper.getBasicRestTemplate(BASE_URL);
        String url = RequestHelper.addMultipleParamToUrl(
                BASE_URL, "id[]", NumberHelper.getNumberRangeList(1, 19));
        String result = template.getForObject(url, String.class);

        JSONObject obj = new JSONObject(result);
//        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        log.info(url);
        log.info(result);
    }

}
