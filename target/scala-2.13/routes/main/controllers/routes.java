// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseContributorController ContributorController = new controllers.ReverseContributorController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseContributorController ContributorController = new controllers.javascript.ReverseContributorController(RoutesPrefix.byNamePrefix());
  }

}
