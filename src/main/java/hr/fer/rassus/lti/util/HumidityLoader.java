package hr.fer.rassus.lti.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class HumidityLoader {
    private static final String PATH = "/measurements.csv";
    private List<Integer> humidities;

    public void load() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(PATH)))) {
            humidities = csvToBean(reader)
                    .parse()
                    .stream()
                    .map(HumidityHolder::getHumidity)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.warn("Something went wrong while parsing measurements.csv", e);
        }
    }

    public List<Integer> getHumidities() {
        return humidities;
    }

    private CsvToBean<HumidityHolder> csvToBean(BufferedReader reader) {
        return new CsvToBeanBuilder<HumidityHolder>(reader)
                .withType(HumidityHolder.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(makeMappingStrategy())
                .build();
    }

    private HeaderColumnNameTranslateMappingStrategy<HumidityHolder> makeMappingStrategy() {
        Map<String, String> columnMappings = new HashMap<>();
        columnMappings.put("Humidity", "humidity");

        HeaderColumnNameTranslateMappingStrategy<HumidityHolder> mappingStrategy =
                new HeaderColumnNameTranslateMappingStrategy<>();
        mappingStrategy.setColumnMapping(columnMappings);
        mappingStrategy.setType(HumidityHolder.class);

        return mappingStrategy;
    }
}
