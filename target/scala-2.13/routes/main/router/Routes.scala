// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:4
  ContributorController_0: controllers.ContributorController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:4
    ContributorController_0: controllers.ContributorController
  ) = this(errorHandler, ContributorController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ContributorController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/organizations/""" + "$" + """orgName<[^/]+>/contributors""", """controllers.ContributorController.getContributions(orgName:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:4
  private[this] lazy val controllers_ContributorController_getContributions0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/organizations/"), DynamicPart("orgName", """[^/]+""",true), StaticPart("/contributors")))
  )
  private[this] lazy val controllers_ContributorController_getContributions0_invoker = createInvoker(
    ContributorController_0.getContributions(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ContributorController",
      "getContributions",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/v1/organizations/""" + "$" + """orgName<[^/]+>/contributors""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:4
    case controllers_ContributorController_getContributions0_route(params@_) =>
      call(params.fromPath[String]("orgName", None)) { (orgName) =>
        controllers_ContributorController_getContributions0_invoker.call(ContributorController_0.getContributions(orgName))
      }
  }
}
