package com.example.watchlist;

import java.io.Serializable;

/**
 * Created by Tiny on 15-5-2017.
 */

public class DataObject implements Serializable{
        public String plot;
        public String title;
        public String year;
        public String directors;
        public String actors;

        public void setPlot(String newplot){

            plot = newplot;
        }

        public void setTitle(String newtitle){

        title = newtitle;

        }

        public void setYear(String newyear){

            year = newyear;
        }

        public void setDirectors(String newdirectors){

            directors = newdirectors;
        }

        public void setActors(String newactors){

            actors = newactors;
        }

        public String getPlot(){

            return plot;
        }

        public String getTitle(){

        return title;
        }

        public String getYear(){

            return year;
        }

        public String getDirectors(){

            return directors;
        }

        public String getActors(){

            return actors;
        }
}

