package com.example.tictactoe.models;

import javafx.stage.Stage;

/*
* Class created to represent the currently signed-in player and their details
* All attributes are static for ease of access, they also won't change throughout the session.
*/
public class CurrentPlayerModel {

    public static Boolean login;
    public static String id;
    public static Integer currentlyInvitedPlayerId;
    public static Integer opponentId;
    public static Integer gameId;
    public static String username;
    public static String score;
    public static String opponentscore;
    public static String wins;
    public static String losses;
    public static String opponentUsername;
    public static boolean playerTurn;
    public static boolean allowFire;
    public static String mySign;


    //@samboo

    static Integer opponentScore;
    static public String getOpponentUsername()
    {
        return opponentUsername;
    }
    static public int getOpponentScore()
    {
        return opponentScore;
    }
    /*public String getLogin() {
        return login;
    }*/
    public String getId() {
        return id;
    }
    public static String getLosses() {
        return losses;
    }
    public static String getScore() {
        return score;
    }
    public static String getUsername() {
        return username;
    }
    public static String getWins() {
        return wins;
    }
    public static Stage eventWindow;

    public static void resetCurrentPlayer(){
        login = false;
        id = "";
        currentlyInvitedPlayerId = null;
        opponentId = null;
        gameId = null;
        username = "";
        score = "";
        wins = "";
        losses = "";
        opponentUsername = "";
        playerTurn = false;
        allowFire = false;
        mySign = "";
        opponentScore = null;
        eventWindow = null;
    }
}
