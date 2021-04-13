// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:4
package controllers {

  // @LINE:4
  class ReverseContributorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def getContributions(orgName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/organizations/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("orgName", orgName)) + "/contributors")
    }
  
  }


}
