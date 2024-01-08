import java.util.*;

public class TreeMapCities {
    public static void main(String[] args) {
        RunningApp();
    }
        public static void RunningApp(){

        // Tworzenie mapy TreeMap z nazwami miast i ilościami ludności
        Map<String, Integer> cityPopulationMap = new TreeMap<>();

        // Dodawanie danych do mapy
        cityPopulationMap.put("Warszawa", 1861975);
        cityPopulationMap.put("Kraków", 803352);
        cityPopulationMap.put("Wrocław", 673923);
        cityPopulationMap.put("Poznań", 534813);
        cityPopulationMap.put("Gdańsk", 470907);

        // Tworzenie komparatora do sortowania mapy według ilości ludności
        Comparator<String> populationComparator = new Comparator<String>() {
            public int compare(String city1, String city2) {
                int population1 = cityPopulationMap.get(city1);
                int population2 = cityPopulationMap.get(city2);
                return population1 - population2;
            }
        };

        // Tworzenie posortowanej mapy za pomocą komparatora
        Map<String, Integer> sortedCityPopulationMap = new TreeMap<>(populationComparator);
        sortedCityPopulationMap.putAll(cityPopulationMap);

        // Wyświetlanie posortowanej mapy
        for (Map.Entry<String, Integer> entry : sortedCityPopulationMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ludności");
        }
    }
}
