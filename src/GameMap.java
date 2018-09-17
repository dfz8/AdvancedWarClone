/**
 * This class is responsibile for each game level
 */
 package src;
 
 import src.assets.*;

 public class GameMap {
   private TerrainMap mTerrainMap;
   private Team teamAI;
   private Team teamUser;

   private boolean isUsersTurn;
   private int turnTimer;

   public GameMap() {
     turnTimer = 0;
   }
 }
