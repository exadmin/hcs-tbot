import com.github.exadmin.hcstbot.model.auth.UserModel;
import com.github.exadmin.hcstbot.services.impl.IvSbytService;
import com.github.exadmin.hcstbot.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.List;

public class TestAppForWebDriver {
    public static void main(String[] args) {
        String fileContent = FileUtils.readFromFile(Paths.get("./data/auth/authentication_test.json"));
        if (fileContent == null) {
            System.out.println("Can't find json-file with authentication data at ./data/auth/authentication_test.json");
            return;
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<UserModel>>(){}.getType();
        List<UserModel> usersList = gson.fromJson(fileContent, type);

        UserModel testModel = usersList.get(0);
        IvSbytService ivsbytService = new IvSbytService(testModel);
        ivsbytService.performAuthentication();
        String info = ivsbytService.getInfo();
        System.out.println("Info = " + info);
        ivsbytService.logout();
    }
}
