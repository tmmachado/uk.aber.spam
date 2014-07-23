// @SOURCE:/Users/TarcioMac/Development/PlayProjects/uk.aber.spam/conf/routes
// @HASH:705ee453816e7ffb130cfd210263c3d966e57628
// @DATE:Thu Jul 17 15:26:03 BST 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_AdminController_arrangeMeeting1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("studentReport"))))
private[this] lazy val controllers_AdminController_arrangeMeeting1_invoker = createInvoker(
controllers.AdminController.arrangeMeeting(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.AdminController", "arrangeMeeting", Nil,"POST", """""", Routes.prefix + """studentReport"""))
        

// @LINE:8
private[this] lazy val controllers_Application_studentReport2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("studentReport"))))
private[this] lazy val controllers_Application_studentReport2_invoker = createInvoker(
controllers.Application.studentReport(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "studentReport", Nil,"GET", """""", Routes.prefix + """studentReport"""))
        

// @LINE:9
private[this] lazy val controllers_AdminController_getJSON3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("json/admin"))))
private[this] lazy val controllers_AdminController_getJSON3_invoker = createInvoker(
controllers.AdminController.getJSON(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.AdminController", "getJSON", Nil,"GET", """""", Routes.prefix + """json/admin"""))
        

// @LINE:10
private[this] lazy val controllers_YearTutorController_getJSON4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("json/yt"))))
private[this] lazy val controllers_YearTutorController_getJSON4_invoker = createInvoker(
controllers.YearTutorController.getJSON(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.YearTutorController", "getJSON", Nil,"GET", """""", Routes.prefix + """json/yt"""))
        

// @LINE:11
private[this] lazy val controllers_YearTutorController_updateOutcome5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ytList"))))
private[this] lazy val controllers_YearTutorController_updateOutcome5_invoker = createInvoker(
controllers.YearTutorController.updateOutcome(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.YearTutorController", "updateOutcome", Nil,"POST", """""", Routes.prefix + """ytList"""))
        

// @LINE:12
private[this] lazy val controllers_Application_ytList6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ytList"))))
private[this] lazy val controllers_Application_ytList6_invoker = createInvoker(
controllers.Application.ytList(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ytList", Nil,"GET", """""", Routes.prefix + """ytList"""))
        

// @LINE:15
private[this] lazy val controllers_Assets_at7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at7_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """studentReport""","""controllers.AdminController.arrangeMeeting()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """studentReport""","""controllers.Application.studentReport()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/admin""","""controllers.AdminController.getJSON()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/yt""","""controllers.YearTutorController.getJSON()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ytList""","""controllers.YearTutorController.updateOutcome()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ytList""","""controllers.Application.ytList()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_AdminController_arrangeMeeting1_route(params) => {
   call { 
        controllers_AdminController_arrangeMeeting1_invoker.call(controllers.AdminController.arrangeMeeting())
   }
}
        

// @LINE:8
case controllers_Application_studentReport2_route(params) => {
   call { 
        controllers_Application_studentReport2_invoker.call(controllers.Application.studentReport())
   }
}
        

// @LINE:9
case controllers_AdminController_getJSON3_route(params) => {
   call { 
        controllers_AdminController_getJSON3_invoker.call(controllers.AdminController.getJSON())
   }
}
        

// @LINE:10
case controllers_YearTutorController_getJSON4_route(params) => {
   call { 
        controllers_YearTutorController_getJSON4_invoker.call(controllers.YearTutorController.getJSON())
   }
}
        

// @LINE:11
case controllers_YearTutorController_updateOutcome5_route(params) => {
   call { 
        controllers_YearTutorController_updateOutcome5_invoker.call(controllers.YearTutorController.updateOutcome())
   }
}
        

// @LINE:12
case controllers_Application_ytList6_route(params) => {
   call { 
        controllers_Application_ytList6_invoker.call(controllers.Application.ytList())
   }
}
        

// @LINE:15
case controllers_Assets_at7_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at7_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     