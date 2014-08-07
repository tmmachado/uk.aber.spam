// @SOURCE:/Users/TarcioMac/Development/PlayProjects/uk.aber.spam/conf/routes
// @HASH:e03a3112c60574d71b1dd4dda8f4a7a06eb4c740
// @DATE:Thu Aug 07 15:09:32 BST 2014


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
private[this] lazy val controllers_DotController_getJSON5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("json/dot"))))
private[this] lazy val controllers_DotController_getJSON5_invoker = createInvoker(
controllers.DotController.getJSON(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DotController", "getJSON", Nil,"GET", """""", Routes.prefix + """json/dot"""))
        

// @LINE:12
private[this] lazy val controllers_Application_jsonSummary6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("json/summary"))))
private[this] lazy val controllers_Application_jsonSummary6_invoker = createInvoker(
controllers.Application.jsonSummary(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "jsonSummary", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """json/summary"""))
        

// @LINE:13
private[this] lazy val controllers_YearTutorController_updateOutcome7_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ytList"))))
private[this] lazy val controllers_YearTutorController_updateOutcome7_invoker = createInvoker(
controllers.YearTutorController.updateOutcome(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.YearTutorController", "updateOutcome", Nil,"POST", """""", Routes.prefix + """ytList"""))
        

// @LINE:14
private[this] lazy val controllers_Application_ytList8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ytList"))))
private[this] lazy val controllers_Application_ytList8_invoker = createInvoker(
controllers.Application.ytList(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ytList", Nil,"GET", """""", Routes.prefix + """ytList"""))
        

// @LINE:15
private[this] lazy val controllers_DotController_updateOutcome9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dotList"))))
private[this] lazy val controllers_DotController_updateOutcome9_invoker = createInvoker(
controllers.DotController.updateOutcome(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DotController", "updateOutcome", Nil,"POST", """""", Routes.prefix + """dotList"""))
        

// @LINE:16
private[this] lazy val controllers_Application_dotList10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dotList"))))
private[this] lazy val controllers_Application_dotList10_invoker = createInvoker(
controllers.Application.dotList(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "dotList", Nil,"GET", """""", Routes.prefix + """dotList"""))
        

// @LINE:17
private[this] lazy val controllers_Application_summary11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("summary"))))
private[this] lazy val controllers_Application_summary11_invoker = createInvoker(
controllers.Application.summary(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "summary", Nil,"GET", """""", Routes.prefix + """summary"""))
        

// @LINE:20
private[this] lazy val controllers_Assets_at12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at12_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """studentReport""","""controllers.AdminController.arrangeMeeting()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """studentReport""","""controllers.Application.studentReport()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/admin""","""controllers.AdminController.getJSON()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/yt""","""controllers.YearTutorController.getJSON()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/dot""","""controllers.DotController.getJSON()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/summary""","""controllers.Application.jsonSummary(stud_uid:String, academic_year:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ytList""","""controllers.YearTutorController.updateOutcome()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ytList""","""controllers.Application.ytList()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dotList""","""controllers.DotController.updateOutcome()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dotList""","""controllers.Application.dotList()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """summary""","""controllers.Application.summary()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_DotController_getJSON5_route(params) => {
   call { 
        controllers_DotController_getJSON5_invoker.call(controllers.DotController.getJSON())
   }
}
        

// @LINE:12
case controllers_Application_jsonSummary6_route(params) => {
   call(params.fromQuery[String]("stud_uid", None), params.fromQuery[String]("academic_year", None)) { (stud_uid, academic_year) =>
        controllers_Application_jsonSummary6_invoker.call(controllers.Application.jsonSummary(stud_uid, academic_year))
   }
}
        

// @LINE:13
case controllers_YearTutorController_updateOutcome7_route(params) => {
   call { 
        controllers_YearTutorController_updateOutcome7_invoker.call(controllers.YearTutorController.updateOutcome())
   }
}
        

// @LINE:14
case controllers_Application_ytList8_route(params) => {
   call { 
        controllers_Application_ytList8_invoker.call(controllers.Application.ytList())
   }
}
        

// @LINE:15
case controllers_DotController_updateOutcome9_route(params) => {
   call { 
        controllers_DotController_updateOutcome9_invoker.call(controllers.DotController.updateOutcome())
   }
}
        

// @LINE:16
case controllers_Application_dotList10_route(params) => {
   call { 
        controllers_Application_dotList10_invoker.call(controllers.Application.dotList())
   }
}
        

// @LINE:17
case controllers_Application_summary11_route(params) => {
   call { 
        controllers_Application_summary11_invoker.call(controllers.Application.summary())
   }
}
        

// @LINE:20
case controllers_Assets_at12_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at12_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     