// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:4
package controllers.javascript {

  // @LINE:4
  class ReverseContributorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def getContributions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ContributorController.getContributions",
      """
        function(orgName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/organizations/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("orgName", orgName0)) + "/contributors"})
        }
      """
    )
  
  }


}
