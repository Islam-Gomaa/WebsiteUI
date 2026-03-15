package dataReader;

import com.google.gson.Gson;
import data.DataModel;
import utilities.ConfigReader;

import java.io.FileReader;

public class ReadDataFromJson {

    private static DataModel data;

    public DataModel readJsonFile() {

        try {

            String env = ConfigReader.get("environment");

            String filePath =
                    "src/test/resources/TestData/" + env + "/testData.json";

            FileReader fileReader = new FileReader(filePath);

            return new Gson().fromJson(fileReader, DataModel.class);

        } catch (Exception e) {

            throw new RuntimeException("Failed to read test data JSON file", e);

        }
    }

    public static DataModel dataModel() {

        if (data == null) {
            data = new ReadDataFromJson().readJsonFile();
        }

        return data;
    }
}