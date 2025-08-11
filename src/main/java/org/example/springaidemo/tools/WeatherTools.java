package org.example.springaidemo.tools;

import org.springframework.ai.tool.annotation.Tool;

public class WeatherTools {

    @Tool(description="Get the current weather for a given zip code")
    public String getWeatherForZipcode(String zipCode) {
        // Simulate a weather service call
        return "Weather for zip code " + zipCode + " is Sunny, 75°F";
    }
}
