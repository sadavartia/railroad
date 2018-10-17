package com.kiwiland;

import java.util.List;

import com.kiwiland.exception.NoSuchRouteException;
import com.kiwiland.model.Graph;

public interface Commuter {

    int routeDistance(String startingCity, String destinationCity, List<String> intermediateCities) throws NoSuchRouteException;

    int numberOfPathsWithMaxStops(String startingCity, String destinationCity, int stops) throws NoSuchRouteException;

    int numberOfPathsWithMaxWeight(String startingCity, String destinationCity, int weight) throws NoSuchRouteException;

    int numberOfPathsWithExactStops(String startingCity, String destinationCity, int stops) throws NoSuchRouteException;

    int shortestDistance(String startingCity, String destinationCity) throws NoSuchRouteException;

    Graph<String> getAllRoutes();

    int routeDuration(String startingCity, String endCity, List<String> intermediateCities) throws NoSuchRouteException;

}
